package com.dyzs.testringringview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Context mContext;
    private RingRingViewVer2 rrv;
    private int progress = 0;
    private ArrayList<String> mTagsList;
    private CloudTagAdapter mAdapter;
    private GridView mContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext = this;
        setContentView(R.layout.activity_main);

        mContainer = (GridView) findViewById(R.id.gv_cloud_tag_container);
        mTagsList = new ArrayList<>();
        addData2List();
        mAdapter = new CloudTagAdapter(this, mTagsList);
        mContainer.setAdapter(mAdapter);
//        String x = "pppwefwfsdf";
//        int color = x.hashCode();
//        rrv = new RingRingViewVer2(mContext);
//        rrv.setRingColor(Color.BLUE);
//        ((LinearLayout) findViewById(R.id.ll_act_ringring)).addView(rrv);
//        rrv.setProgress(30);
//        rrv.setTextSize(DensityUtil.px2dip(mContext, 100));
//        rrv.setTextColor(color);
//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progress = 0;
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        while (progress < 100) {
//                            progress += 1;
//                            rrv.setProgress(progress);
//                            try {
//                                Thread.sleep(20);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }).start();
//            }
//        });
    }
    private void addData2List() {
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
        mTagsList.add("生活");
        mTagsList.add("工作");
        mTagsList.add("饮食");
        mTagsList.add("啦啦1231232312326546地方的法规啦");
        mTagsList.add("么么哒哒哒哒打");
        mTagsList.add("旅游");
        mTagsList.add("足球");
        mTagsList.add("篮球");
        mTagsList.add("动漫");
        mTagsList.add("芈月传");
        mTagsList.add("晨跑锻炼");
        mTagsList.add("吃大餐");
        mTagsList.add("牛排自助");
        mTagsList.add("火影忍者");
        mTagsList.add("时崎狂三");
        mTagsList.add("伊卡洛斯");
        mTagsList.add("Android Studio");
    }
}
