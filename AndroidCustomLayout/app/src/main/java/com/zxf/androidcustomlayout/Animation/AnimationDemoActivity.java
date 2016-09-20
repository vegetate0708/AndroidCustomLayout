package com.zxf.androidcustomlayout.Animation;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxf.androidcustomlayout.R;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/5/1.
 */
public class AnimationDemoActivity extends Activity implements View.OnClickListener {

    private TextView tv;
    //缩放动画
    private Button bt_scale;
    private Button bt_scale_class;
    private Button bt_frame;
    private ImageView iv_frame;
    private AnimationDrawable animationDrawable;
    private boolean isstart=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animationdemo);
        tv = (TextView) findViewById(R.id.tv_animationDemo);
        bt_scale = (Button) findViewById(R.id.bt_animation_scale);
        bt_scale_class = (Button) findViewById(R.id.bt_animation_scale_1);
        bt_frame = (Button) findViewById(R.id.bt_animation_frame);
        iv_frame = (ImageView) findViewById(R.id.iv_animation_frame);
        bt_scale.setOnClickListener(this);
        bt_scale_class.setOnClickListener(this);
        bt_frame.setOnClickListener(this);
        loadBitmap();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_animation_scale:
                Animation scale= AnimationUtils.loadAnimation(this,R.anim.scaleanim);
                tv.startAnimation(scale);
                break;
            case R.id.bt_animation_scale_1:
                RotateAnimation rotateAnim = new RotateAnimation(0, -650, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnim.setDuration(3000);
                rotateAnim.setFillAfter(true);
                tv.startAnimation(rotateAnim);
                break;
            case R.id.bt_animation_frame:
                if (isstart){
                    animationDrawable.start();
                    isstart=false;
                }else{
                    animationDrawable.stop();
                    isstart=true;
                }
                break;

        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void loadBitmap(){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable=true;
        options.inInputShareable=true;
        //设置该属性可获得图片的长宽等信息，但是避免了不必要的提前加载动画
        options.inJustDecodeBounds=false;
        InputStream is=null;
        int[] raw={
                R.raw.scenery1,R.raw.scenery2,R.raw.scenery3,R.raw.scenery4,R.raw.scenery5
        };
        Bitmap[] mbitMap=new Bitmap[5];
        for(int i=0,j=0;i<5&&j<5;i++,j++){
            is=getResources().openRawResource(raw[i]);
            Bitmap bitmap =BitmapFactory.decodeStream(is, null, options);
            mbitMap[j]=bitmap;
        }

        AnimationDrawable clipDrawable= new AnimationDrawable();
        for(int i=0;i<5;i++){
            clipDrawable.addFrame(new BitmapDrawable(mbitMap[i]), 50);
        }
        clipDrawable.setOneShot(false);
        animationDrawable=clipDrawable;
        iv_frame.setBackground(animationDrawable);
    }



}
