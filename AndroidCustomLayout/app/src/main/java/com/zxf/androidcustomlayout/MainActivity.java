package com.zxf.androidcustomlayout;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zxf.androidcustomlayout.Animation.AnimationDemoActivity;
import com.zxf.androidcustomlayout.Animator.AnimatorDemoActivity;
import com.zxf.androidcustomlayout.CanvasAndPaint.CanvasActivity;
import com.zxf.androidcustomlayout.Design.Demo.BehaviorAcitvityMain;
import com.zxf.androidcustomlayout.Listview.ExpandListViewActivity;
import com.zxf.androidcustomlayout.ScollerView.GestureDetectorDemo;
import com.zxf.androidcustomlayout.ScollerView.LockDemo;
import com.zxf.androidcustomlayout.ScollerView.NestedScroll.Nested1.NestedDemo1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_animation;
    String[] s=new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };
    public void startPermissionsActivity(String[] strings) {
        PermissionsActivity.startActivityForResult(this, REQUEST_CODE, strings);
    }
    public PermissionsChecker mPermissionsChecker; // 权限检测器
    private static final int REQUEST_CODE = 0; // 请求码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPermissionsChecker = new PermissionsChecker(this);
        if (mPermissionsChecker.lacksPermissions(s)){
            startPermissionsActivity(s);
        }
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
            findViewById(R.id.bt_main_gesturedetector).setOnClickListener(this);
            findViewById(R.id.bt_main_NestScrollDemo).setOnClickListener(this);
            findViewById(R.id.bt_main_DesignDemo).setOnClickListener(this);
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
            case R.id.bt_main_gesturedetector:
                Intent gesturedetector= new Intent(MainActivity.this, GestureDetectorDemo.class);
                startActivity(gesturedetector);
                break;
            case R.id.bt_main_NestScrollDemo:
                Intent nested= new Intent(MainActivity.this, NestedDemo1.class);
                startActivity(nested);
                break;
            case R.id.bt_main_DesignDemo:
                Intent behavior1= new Intent(MainActivity.this, BehaviorAcitvityMain.class);
                startActivity(behavior1);
                break;
        }
    }
}
