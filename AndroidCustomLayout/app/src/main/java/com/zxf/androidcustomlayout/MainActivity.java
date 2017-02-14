package com.zxf.androidcustomlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zxf.androidcustomlayout.Animation.AnimationDemoActivity;
import com.zxf.androidcustomlayout.Animator.AnimatorDemoActivity;
import com.zxf.androidcustomlayout.CanvasAndPaint.CanvasActivity;
import com.zxf.androidcustomlayout.Listview.ExpandListViewActivity;
import com.zxf.androidcustomlayout.ScollerView.LockDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_lockdemo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LockDemo.class);
                startActivity(intent);

            }
        });
        bt_animation = (Button) findViewById(R.id.bt_main_animation);
        bt_animation.setOnClickListener(this);
        findViewById(R.id.bt_main_canvasandpaint).setOnClickListener(this);
        findViewById(R.id.bt_main_animator).setOnClickListener(this);
        findViewById(R.id.bt_main_gotoDemo).setOnClickListener(this);
        findViewById(R.id.bt_main_expandlistview).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_main_animation:
                Intent intent = new Intent(MainActivity.this, AnimationDemoActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_main_canvasandpaint:
                Intent canvas = new Intent(MainActivity.this, CanvasActivity.class);
                startActivity(canvas);
                break;
            case R.id.bt_main_animator:
                Intent animator= new Intent(MainActivity.this, AnimatorDemoActivity.class);
                startActivity(animator);
                break;
            case R.id.bt_main_gotoDemo:
                Intent gotodemo= new Intent(MainActivity.this, GotoDemoActivity.class);
                startActivity(gotodemo);
                break;
            case R.id.bt_main_expandlistview:
                Intent expandlistview= new Intent(MainActivity.this, ExpandListViewActivity.class);
                startActivity(expandlistview);
                break;
        }
    }
}
