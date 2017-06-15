package com.example.vivi.allcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by vivi on 17-6-14.
 */

public class DrawerLayoutt extends AppCompatActivity {
    private ListView li;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        li= (ListView) findViewById(R.id.left_drawer);
        li.setAdapter(new adapter());
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent2=new Intent(DrawerLayoutt.this,SlidingPaneLayoutt.class);
                    startActivity(intent2);
                }
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
                v=View.inflate(DrawerLayoutt.this,R.layout.activity_main,null);
            }
            else
            {
                v=View.inflate(DrawerLayoutt.this,R.layout.fragemnt1,null);
            }

            return v;
        }
    }


}
