package com.zxf.androidcustomlayout.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.zxf.androidcustomlayout.R;

/**
 * Created by Administrator on 2016/5/1.
 */
public class AnimationDemoActivity extends Activity implements View.OnClickListener {

    private TextView tv;
    //缩放动画
    private Button bt_scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animationdemo);
        tv = (TextView) findViewById(R.id.tv_animationDemo);
        bt_scale = (Button) findViewById(R.id.bt_animation_scale);
        bt_scale.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_animation_scale:
                Animation scale= AnimationUtils.loadAnimation(this,R.anim.scaleanim);
                tv.startAnimation(scale);
                break;

        }
    }
}
