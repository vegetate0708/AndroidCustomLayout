package com.zxf.androidcustomlayout.CanvasAndPaint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zxf.androidcustomlayout.CanvasAndPaint.TimeListDemo.TimeListViewActivity;
import com.zxf.androidcustomlayout.R;

/**
 * Created by Administrator on 2016/8/1.
 */
public class CanvasActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        findViewById(R.id.tv_timelist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent canvas = new Intent(CanvasActivity.this, TimeListViewActivity.class);
                startActivity(canvas);
            }
        });
    }
}
