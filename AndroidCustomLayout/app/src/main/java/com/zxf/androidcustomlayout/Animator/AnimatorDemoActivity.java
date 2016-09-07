package com.zxf.androidcustomlayout.Animator;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxf.androidcustomlayout.R;


/**
 * Created by Administrator on 2016/9/1.
 */
public class AnimatorDemoActivity extends Activity implements View.OnClickListener {

    private TextView tv;
    private ValueAnimator animator;
    private MyPointView myPointView;
    private MyPointView1 pointView1;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatordemo);
        tv = (TextView) findViewById(R.id.tv_animatordemo);
        findViewById(R.id.bt_animator_execute).setOnClickListener(this);
        findViewById(R.id.bt_animator_cancle).setOnClickListener(this);
        findViewById(R.id.bt_animator_checkbac).setOnClickListener(this);
        findViewById(R.id.bt_animator_checktext).setOnClickListener(this);
        findViewById(R.id.bt_animator_checkCircle).setOnClickListener(this);
        findViewById(R.id.bt_animator_objectAlphe).setOnClickListener(this);
        findViewById(R.id.bt_animator_checkCircleObject).setOnClickListener(this);
        findViewById(R.id.bt_animator_checkTVColorObject).setOnClickListener(this);
        findViewById(R.id.bt_animator_PropertyValues_checkColorAndRotation).setOnClickListener(this);
        findViewById(R.id.bt_animator_PropertyValues_keyframe).setOnClickListener(this);
        myPointView = (MyPointView) findViewById(R.id.mypointview_animatordemo);
        pointView1 = (MyPointView1) findViewById(R.id.mypointview1_animatordemo);
        iv= (ImageView) findViewById(R.id.iv_animator);
    }

    private ValueAnimator doRepeatAnim(){
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(), curValue, tv.getRight(), curValue + tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("qijian", "animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("qijian", "animation end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("qijian", "animation cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("qijian", "animation repeat");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new MyInterpolator());
        animator.setEvaluator(new MyEvaluator());
        animator.setDuration(1000);
        animator.start();
        return animator;
    }

    private void setBackColor(){
        ValueAnimator animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(3000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                tv.setBackgroundColor(curValue);

            }
        });

        animator.start();
    }
    private void setText(){
        ValueAnimator animator = ValueAnimator.ofObject(new CharecterEvaluator(),new Character('A'),new Character('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (char)animation.getAnimatedValue();
                tv.setText(String.valueOf(text));
            }
        });
        animator.setDuration(10000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatMode(ValueAnimator.INFINITE);
        animator.start();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_animator_execute:
                animator = doRepeatAnim();
                ValueAnimator animator1=animator.clone();
                break;
            case R.id.bt_animator_cancle:
                if (animator!=null){
                    animator.cancel();
                    animator.removeAllListeners();
                }
                break;
            case R.id.bt_animator_checkbac:
                setBackColor();
                break;
            case R.id.bt_animator_checktext:
                setText();
                break;
            case R.id.bt_animator_checkCircle:
                myPointView.doPointAnim();
                break;
            case R.id.bt_animator_objectAlphe:
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "alpha", 1, 0, 1);
                animator.setDuration(2000);
                animator.start();
                break;
            case R.id.bt_animator_checkCircleObject:
                ObjectAnimator objectCircle = ObjectAnimator.ofInt(pointView1,"pointRadius",100);
                objectCircle.setDuration(2000);
                objectCircle.start();
                break;
            case R.id.bt_animator_checkTVColorObject:
                ObjectAnimator animatorobjectcolor = ObjectAnimator.ofInt(tv, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
                animatorobjectcolor.setDuration(8000);
                animatorobjectcolor.setEvaluator(new ArgbEvaluator());
                animatorobjectcolor.start();
                ObjectAnimator animatorscale = ObjectAnimator.ofFloat(tv, "scaleY", 0, 3, 1);
                animatorscale.setDuration(2000);
                animatorscale.start();
                break;
            case R.id.bt_animator_PropertyValues_checkColorAndRotation:
                PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
                PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
                ObjectAnimator animator_pro = ObjectAnimator.ofPropertyValuesHolder(tv, rotationHolder, colorHolder);
                animator_pro.setDuration(2000);
                animator_pro.setInterpolator(new AccelerateInterpolator());
                animator_pro.setRepeatMode(ValueAnimator.INFINITE);
                animator_pro.start();
                break;
            case R.id.bt_animator_PropertyValues_keyframe:
                Keyframe frame0 = Keyframe.ofFloat(0f, 0);
                Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
                Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
                Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
                Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
                Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
                Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
                Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
                Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
                Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
                Keyframe frame10 = Keyframe.ofFloat(1, 0);
                PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("rotation",frame0,frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9,frame10);

                Animator animator_frame = ObjectAnimator.ofPropertyValuesHolder(iv,frameHolder);
                animator_frame.setDuration(1000);
                animator_frame.start();
                break;
        }
    }
}
