package com.zxf.androidcustomlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_gotodemo_caidandemo:
                Intent caidandemo= new Intent(GotoDemoActivity.this, ShowAndHideMenoActivity.class);
                startActivity(caidandemo);
                break;
        }
    }
}
