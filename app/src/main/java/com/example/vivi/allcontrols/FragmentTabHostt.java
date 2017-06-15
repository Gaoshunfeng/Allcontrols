package com.example.vivi.allcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.example.vivi.allcontrols.fragment.*;

/**
 * Created by vivi on 17-6-14.
 */

public class FragmentTabHostt extends AppCompatActivity {
    private FragmentTabHost fragmentTabHost;
    private String texts[] = { "首页", "消息", "好友", "广场"};
    private int imageButton[] = { R.drawable.email,
            R.drawable.settings, R.drawable.user,R.drawable.write };
    private Class fragmentArray[] = {fragment1.class,fragment2.class,fragment3.class,fragment4.class};
    private SwipeRefreshLayout fresh2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmenttabhost);
        fresh2=(SwipeRefreshLayout)findViewById(R.id.refresh2);

        fresh2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler han=new Handler();
                han.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fresh2.setRefreshing(false);
                        Intent intent=new Intent(FragmentTabHostt.this,ViewpageAndpagetabstrip.class);
                        startActivity(intent);
                    }
                },700);
            }
        });

        //实例化tabhost
        fragmentTabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.maincontent);
        for(int i=0;i<texts.length;i++)
        {
            TabSpec spec=fragmentTabHost.newTabSpec(texts[i]).setIndicator(getView(i));
            fragmentTabHost.addTab(spec,fragmentArray[i],null);
            //设置背景
            // fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.bt_selector);
        }
    }
    private View getView(int i) {
                //取得布局实例
                 View view=View.inflate(FragmentTabHostt.this, R.layout.tabbuttom, null);

                //取得布局对象
                 ImageView imageView=(ImageView) view.findViewById(R.id.image);
                 TextView textView=(TextView) view.findViewById(R.id.text);

                 //设置图标
                 imageView.setImageResource(imageButton[i]);
                 //设置标题
                 textView.setText(texts[i]);
                 return view;
             }
}
