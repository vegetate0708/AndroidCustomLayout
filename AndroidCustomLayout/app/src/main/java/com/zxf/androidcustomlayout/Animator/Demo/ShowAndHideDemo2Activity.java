package com.zxf.androidcustomlayout.Animator.Demo;

import android.app.Activity;
import android.os.Bundle;

import com.zxf.androidcustomlayout.R;

/**
 * Created by Administrator on 2016/9/23.
 */
public class ShowAndHideDemo2Activity extends Activity {

    private ShowAndHideView showAndHideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showandhidedemo2);
        showAndHideView = (ShowAndHideView) findViewById(R.id.showandhide_my);
    }
}
