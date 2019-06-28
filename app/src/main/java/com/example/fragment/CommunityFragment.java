package com.example.fragment;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.base.BaseFragment;
import com.example.kuangjia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends BaseFragment {

    private TextView textView;
    private static final String TAG = CommunityFragment.class.getSimpleName() ;

    @Override
    protected View initView(){
        Log.e(TAG,"社区页面初始化");
        textView=new TextView(mContext);
        textView.setTextSize(24);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }


    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG,"社区界面数据被初始化");
        textView.setText("社区界面");
    }

}
