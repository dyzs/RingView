package com.dyzs.testringringview;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by maidou on 2015/12/31.
 */
public class CloudTagAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    private int mCurTimeMillis = -100;
    private int mPosition = 4;
    public CloudTagAdapter(Context context, ArrayList<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        int color = mList.get(position).hashCode() | 0xFF000000;
        if (convertView == null) {
            mCurTimeMillis += 100;
            mPosition += 1;
            convertView = View.inflate(mContext, R.layout.item_cloud_tag, null);
            // 得到 RingView 对象
            RingRingViewVer2 ll_ring = (RingRingViewVer2) convertView.findViewById(R.id.ll_cloud_tag_ring);

            ll_ring.setTextColor(color);
            ll_ring.setRingColor(color);
//            ll_ring.setTextSize(DensityUtils.sp2px(mContext, 40f));
            ll_ring.setTextSize(mContext.getResources().getDimension(R.dimen.ringview_textsize));
            ll_ring.setRingWidth(3f);
            ll_ring.setIsDrawRingProgress(false);


            viewHolder = new ViewHolder();
            viewHolder.ll_cloud_tag_ring = ll_ring;
            viewHolder.tv_cloud_tag_name = (TextView) convertView.findViewById(R.id.tv_cloud_tag_name);
            convertView.setTag(viewHolder);
        } else {
            mCurTimeMillis = 100;
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.ll_cloud_tag_ring.setProgress(new Random().nextInt(100) + 1);// 设置当前进度
        viewHolder.tv_cloud_tag_name.setText(mList.get(position));
        viewHolder.tv_cloud_tag_name.setTextColor(mList.get(position).hashCode() | 0xFF000000);


//        final RingRingViewVer2 rrrr = ((RingRingViewVer2)(viewHolder.ll_cloud_tag_ring.getChildAt(0)));
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(200);
//                int progress = 0;
//                int random = new Random().nextInt(100);
//                while (progress < random) {
//                    progress += 1;
//                    rrrr.setProgress(progress);
//                    SystemClock.sleep(40);
//                }
//            }
//        }).start();
        actAnimation(convertView);
        System.out.println("curTimeMill:" + mCurTimeMillis);
        return convertView;
    }

    static class ViewHolder{
        TextView tv_cloud_tag_name;
        RingRingViewVer2 ll_cloud_tag_ring;
    }

    public static RingRingViewVer2 getRingView(Context context,int color) {
        RingRingViewVer2 rrv = new RingRingViewVer2(context);
        rrv.setTextColor(color);
        rrv.setRingColor(color);
        rrv.setTextSize(DensityUtils.px2sp(context, 120));
        rrv.setRingWidth(3f);
        rrv.setIsDrawRingProgress(false);
        return rrv;
    }

    private void actAnimation(View convertView) {
        ViewHelper.setScaleX(convertView, 0.0f);    // 初始缩放为0.1f
        ViewHelper.setScaleY(convertView, 0.0f);    // 初始缩放为0.1f
        ViewHelper.setAlpha(convertView, 0.0f);     // 初始透明为0.1f
        // 执行 0.2 秒从 0.1f 透明度到完全显示
        ViewPropertyAnimator.animate(convertView).setInterpolator(new OvershootInterpolator(2)).alpha(1f).setDuration(700).setStartDelay(mCurTimeMillis);
        // 执行 0.2 秒动画插入器
        ViewPropertyAnimator.animate(convertView).setInterpolator(new OvershootInterpolator(2)).scaleX(1f).setDuration(700).setStartDelay(mCurTimeMillis);
        ViewPropertyAnimator.animate(convertView).setInterpolator(new OvershootInterpolator(2)).scaleY(1f).setDuration(700).setStartDelay(mCurTimeMillis);
//        ViewHelper.setScaleX(convertView, 0.5f);    // 初始缩放为0.5f
//        ViewHelper.setScaleY(convertView, 0.5f);    // 初始缩放为0.5f
//        ViewHelper.setAlpha(convertView, 0.5f);
//        // 执行 0.3 秒动画插入器
//        ViewPropertyAnimator.animate(convertView).setInterpolator(new OvershootInterpolator(2)).alpha(1f).setDuration(600).setStartDelay(mCurTimeMillis + 100);
//        ViewPropertyAnimator.animate(convertView).setInterpolator(new OvershootInterpolator(2)).scaleX(1f).setDuration(600).setStartDelay(mCurTimeMillis + 100);
//        ViewPropertyAnimator.animate(convertView).setInterpolator(new OvershootInterpolator(2)).scaleY(1f).setDuration(600).setStartDelay(mCurTimeMillis + 100);
    }
}
