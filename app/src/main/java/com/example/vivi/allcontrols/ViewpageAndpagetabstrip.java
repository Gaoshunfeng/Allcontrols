package com.example.vivi.allcontrols;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vivi on 17-6-15.
 */

public class ViewpageAndpagetabstrip extends AppCompatActivity {
    private ViewPager viewpage;
    private List<String> titlelist;
    private List<View> viewlist;
    private  View view1,view2,view3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpageandpagetabstrip);
        titlelist=new ArrayList<String>();
        titlelist.add("111111111");
        titlelist.add("22222222");
        titlelist.add("3333333333");
        view1=getLayoutInflater().inflate(R.layout.view1,null);
        view2=getLayoutInflater().inflate(R.layout.view2,null);
        view3=getLayoutInflater().inflate(R.layout.view3,null);
        viewlist=new ArrayList<View>();
        viewlist.add(view1);
        viewlist.add(view2);
        viewlist.add(view3);
        viewpage=(ViewPager)findViewById(R.id.viewpager);

        PagerAdapter adapter=new PagerAdapter() {
            @Override
            public int getCount() {
                return viewlist.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
               container.removeView(viewlist.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewlist.get(position));
                return viewlist.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titlelist.get(position);
            }
        };
        viewpage.setAdapter(adapter);
    }
}
