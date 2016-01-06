package com.dyzs.testringringview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by maidou on 2015/12/30.
 * Rain rain go away.Little Johnny wants to play
 * Rain rain go away,come again some other day,Rain rain go away
 *
 */
public class RingRingViewVer1 extends View {
    private int mRingColor;
    private int mTextColor;
    private float mRingRadius;
    private float mTextSize = 5f;
    private String mText = "100";
    private Paint mPaint;
    private Path mPath;


    private Paint mArcPaint;
    private Paint mTextPaint;
    public RingRingViewVer1(Context context) {
        this(context, null);
    }

    public RingRingViewVer1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RingRingViewVer1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRingColor = Color.MAGENTA;

        mRingColor = getRingColor();

        mRingRadius = 10f;

        mRingRadius = getRingRadius();


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(mRingColor);
        mPaint.setAntiAlias(true);


        //设置文字的画笔
        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setStrokeWidth((float) (0.025 * mRingColor));
        mTextPaint.setTextSize(mRingColor/2);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        // 设置外环的圆
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(mRingColor);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((float) (0.075 * mRingRadius));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();


        canvas.drawCircle(150f, 150f, 100f, mPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(150f, 150f, 90f, mPaint);

//        canvas.restore();

    }


    private void drawRing(Canvas canvas, Rect rect) {
        mPaint.setColor(mRingColor);
        canvas.drawCircle(rect.centerX(), rect.centerY(), mRingRadius, mPaint);
        mPaint.setColor(mRingColor);
        canvas.drawCircle(rect.centerX(), rect.centerY(), mRingRadius - 10, mPaint);
    }

    /**
     * getter and setter
     */
    public int getRingColor() {
        return mRingColor;
    }

    /**
     * 设置16进制的颜色值
     * @param color color
     */
    public void setRingColor(@ColorInt int color) {
        this.mRingColor = color;
    }

    /**
     * 获取 Color.xml 中的资源
     * @param resId
     * @deprecated
     */
    public void setRingColorRes(@ColorRes int resId) {
        this.mRingColor = resId;
    }

    public float getRingRadius() {
        return mRingRadius;
    }

    public void setRingRadius(float radius) {
        this.mRingRadius = radius;
    }

    public float getTextSize() {
        return mTextSize;
    }

    public void setTextSize(float textSize) {
        this.mTextSize = textSize;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }
}
