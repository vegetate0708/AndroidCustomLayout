package com.zxf.androidcustomlayout.CanvasAndPaint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zxf.androidcustomlayout.CanvasAndPaint.Img.GifView;
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
       GifView gif= (GifView) findViewById(R.id.gif);
       gif.setUrl("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1487212376&di=4f8a5e5c79d5963be3da32e7c3601f30&src=http://ww1.sinaimg.cn/large/85cccab3tw1esjl5yblhvg20dc0861kx.jpg");
       gif.setPlaying(true);
    }
}
