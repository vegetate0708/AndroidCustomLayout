package com.zxf.androidcustomlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zxf.androidcustomlayout.Animation.AnimationDemoActivity;
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_main_animation:
                Intent intent = new Intent(MainActivity.this, AnimationDemoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
