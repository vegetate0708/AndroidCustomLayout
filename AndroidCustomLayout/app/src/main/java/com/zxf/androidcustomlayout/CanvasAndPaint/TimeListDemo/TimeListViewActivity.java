package com.zxf.androidcustomlayout.CanvasAndPaint.TimeListDemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zxf.androidcustomlayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
public class TimeListViewActivity extends Activity {

    private RecyclerView ry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timelist);
        ry = (RecyclerView)findViewById(R.id.recycle_timelist);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        ry.setLayoutManager(layoutManager);
        List<String> list=new ArrayList<>();
        list.add("20170108");
        list.add("20170109");
        list.add("20170110");
        list.add("20170111");
        list.add("20170112");
        list.add("20170113");
        ry.setAdapter(new TimeListAdapter(this,list));
    }
}
