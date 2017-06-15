package com.example.vivi.allcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import static com.example.vivi.allcontrols.R.id.li;

/**
 * Created by vivi on 17-6-14.
 */

public class SlidingPaneLayoutt extends AppCompatActivity{
    private ListView li1;
    private SwipeRefreshLayout refresh;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slidingpanelayout);
        li1=(ListView) findViewById(R.id.lv_sliding);
        li1.setAdapter(new adapter());
        refresh= (SwipeRefreshLayout) findViewById(R.id.refresh);
        refresh.setProgressBackgroundColorSchemeResource(R.color.colorref);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler han=new Handler();
                han.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.setRefreshing(false);
                        Intent intent2=new Intent(SlidingPaneLayoutt.this,FragmentTabHostt.class);
                        startActivity(intent2);
                    }
                },1000);

            }
        });
    }
    public class adapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v ;
            if(position==0)
            {
                v=View.inflate(SlidingPaneLayoutt.this,R.layout.activity_main,null);
            }
            else
            {
                v=View.inflate(SlidingPaneLayoutt.this,R.layout.fragemnt1,null);
            }

            return v;
        }
    }
}
