package com.example.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.FrameFragmentAdapter;
import com.example.base.BaseFragment;
import com.example.kuangjia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaorenFragment extends BaseFragment {
    private ListView mListview;
    private FrameFragmentAdapter adapter;
    private static final String TAG =LaorenFragment.class.getSimpleName() ;
    private  String[]  datas;

    @Override
    protected View initView(){
        Log.e(TAG,"老人页面初始化");
        View view=View.inflate(mContext,R.layout.fragment_laoren,null);
        mListview=(ListView)view.findViewById(R.id.listview);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data=datas[i];
                Toast.makeText(mContext,"data=="+data,Toast.LENGTH_SHORT).show();
            }
        });
     return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG,"老人界面数据被初始化");
        datas=new String[]{"OKHttp", "xUtils3","Retrofit2","Fresco","Glide","greenDao","RxJava","volley","Gson",
                "FastJson","picasso","evenBus","jcvideoplayer","pulltorefresh",
                "Expandablelistview","UniversalVideoView","....."};
        adapter=new FrameFragmentAdapter(mContext,datas);
        mListview.setAdapter(adapter);
    }

}
