package com.zxf.androidcustomlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zxf.androidcustomlayout.Animation.Demo.CircleDemo.CircleActivity;
import com.zxf.androidcustomlayout.Animator.Demo.ShowAndHideDemo2Activity;
import com.zxf.androidcustomlayout.Animator.Demo.ShowAndHideMenoActivity;

/**
 * Created by Administrator on 2016/9/5.
 */
public class GotoDemoActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gotodemo);
        findViewById(R.id.bt_gotodemo_caidandemo).setOnClickListener(this);
        findViewById(R.id.bt_gotodemo_circleDemo).setOnClickListener(this);
        findViewById(R.id.bt_gotodemo_caidandemo2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_gotodemo_caidandemo:
                Intent caidandemo= new Intent(GotoDemoActivity.this, ShowAndHideMenoActivity.class);
                startActivity(caidandemo);
                break;
            case R.id.bt_gotodemo_circleDemo:
                Intent circledemo= new Intent(GotoDemoActivity.this, CircleActivity.class);
                startActivity(circledemo);
                break;
            case R.id.bt_gotodemo_caidandemo2:
                Intent showandhidedemo= new Intent(GotoDemoActivity.this, ShowAndHideDemo2Activity.class);
                startActivity(showandhidedemo);
                break;
        }
    }
}
