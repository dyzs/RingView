package com.dyzs.testringringview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by maidou on 2015/12/30.
 * Rain rain go away.Little Johnny wants to play
 * Rain rain go away,come again some other day,Rain rain go away
 */
public class RingRingViewVer2 extends View {
    private Paint mPaint;               // 画笔
    private int mRingColor;             // 环形颜色
    private int mTextColor;             // 进度数字颜色
    private float mTextSize;            // 进度数字字体大小

    private int mCenterW;               // 宽度的中心点
    private int mCenterH;               // 高度的中心点
    private float mRingWidth;           // 圆环的宽度
    private float mRingRadius;          // 环形半径
    private int mMaxProgress;           // 最大进度
    private int mProgress;              // 当前进度

    private boolean isDrawRingProgress; // 圆环是否绘制进度

    private int mStyle;                 // 设置环形的画笔样式
    public static final int STROKE = 0; //
    public static final int FILL = 1;


    public RingRingViewVer2(Context context) {
        this(context, null);
    }

    public RingRingViewVer2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RingRingViewVer2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mRingColor = Color.BLUE;
        mTextColor = Color.BLUE;
        mTextSize = context.getResources().getDimension(R.dimen.ringview_textsize);
        mRingWidth = 10f;
        mMaxProgress = 100;
        mStyle = 0;
        isDrawRingProgress = true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mCenterW = getWidth() / 2;
        mRingRadius = getRingRadius();
        // 中间的进度百分比，先转换成float在进行除法运算，不然都为0
        int percent = (int)(((float)mProgress / (float)mMaxProgress) * 100);

        drawText(canvas,percent);

        drawRing(canvas);

    }

    /**
     * 绘制文本进度
     * @param canvas
     */
    private void drawText(Canvas canvas, int percent) {
        mPaint.setStrokeWidth(0);
        mPaint.setColor(mTextColor);
        mPaint.setTextSize(mTextSize);
//        mPaint.setTypeface(Typeface.DEFAULT_BOLD);          // 设置字体
        mPaint.setTypeface(Typeface.MONOSPACE);          // 设置字体
        float textWidth = mPaint.measureText(percent + ""); // %测量字体宽度，我们需要根据字体的宽度设置在圆环中间
        if (percent != 0) { // && mStyle == STROKE
            canvas.drawText(
                    percent + "",               // 绘制的文本
                    mCenterW - textWidth / 2,   // 文本的X轴减去文字宽度的一半开始，达到X轴的居中效果
                    mCenterW + mTextSize / 2,   // 文本的Y轴，从左下角开始
                    mPaint
                    );
        }
    }




    /**
     * 画出圆环
     * @param canvas
     */
    private void drawRing(Canvas canvas) {

        mPaint.setStrokeWidth(mRingWidth);
        mPaint.setColor(mRingColor);
        RectF oval = new RectF(             // 用于定义圆弧的形状和大小界限
                mCenterW - mRingRadius,     // left
                mCenterW - mRingRadius,     // top
                mCenterW + mRingRadius,     // right
                mCenterW + mRingRadius);    // bottom

        switch (mStyle) {
            case STROKE:    // 圆环
                mPaint.setStyle(Paint.Style.STROKE);
                if (isDrawRingProgress) {
                    canvas.drawArc(oval, -90, 360 * mProgress / mMaxProgress, false, mPaint);
                } else {
                    canvas.drawArc(oval, 0, 360, false, mPaint);
                }
                break;
            case FILL:      // 扇形
                mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (mProgress != 0) {
                    canvas.drawArc(oval, -90, 360 * mProgress / mMaxProgress, true, mPaint);
                }
                break;
        }
//        drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
//        oval :指定圆弧的外轮廓矩形区域。
//        startAngle: 圆弧起始角度，单位为度，起始点为0度为right。
//        sweepAngle: 圆弧扫过的角度，顺时针方向，单位为度。
//        useCenter: 如果为True时，在绘制圆弧时将圆心包括在内，通常用来绘制扇形。
//        paint: 绘制圆弧的画板属性，如颜色，是否填充等。
    }


    public synchronized int getMaxProgress() {
        return mMaxProgress;
    }
    // 设置最大进度
    public synchronized void setMaxProgress(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("max progress must be more than zero");
        }
        this.mMaxProgress = max;
    }


    public synchronized void setProgress(int progress) {
        if (progress < 0) {
            throw new IllegalArgumentException("progress must be more than zero");
        }
        if (progress > mMaxProgress) {
            progress = mMaxProgress;
        }
        this.mProgress = progress;
        postInvalidate();
    }

    /**
     * 获取圆环颜色
     * @return
     */
    public int getRingColor() {
        return mRingColor;
    }

    /**
     * 设置圆环颜色
     * @param mRingColor
     */
    public void setRingColor(int mRingColor) {
        this.mRingColor = mRingColor;
    }

    /**
     * 设置文本颜色
     * @param textColor
     */
    public void setTextColor(int textColor) {
        this.mTextColor = textColor;
    }

    public synchronized void setTextSize(float textSize) {
        this.mTextSize = textSize;
    }

    public void setRingWidth(float width) {
        this.mRingWidth = width;
    }

    public void setRingRadius(float radius) {
        this.mRingRadius = radius;
    }

    /**
     * 校验半径的逻辑
     * @return
     */
    public float getRingRadius() {
        if (mRingRadius > (mCenterW - mRingWidth/2)) {
            mRingRadius = mCenterW - mRingWidth/2;
        }
        if (mRingRadius < 0.0f) {
            mRingRadius = mCenterW - mRingWidth/2;
        }
        return mCenterW - mRingWidth / 2;        // 圆环的半径等于宽度的一半减去环宽的一半
    }

    public void setIsDrawRingProgress(boolean b) {
        this.isDrawRingProgress = b;
    }

    public void setStyle(int style) {
        this.mStyle = style;
    }
}
