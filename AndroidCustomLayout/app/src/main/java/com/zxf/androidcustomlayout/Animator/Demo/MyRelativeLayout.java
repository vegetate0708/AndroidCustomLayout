package com.zxf.androidcustomlayout.Animator.Demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/9/23.
 */
public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getChildAt(0).dispatchTouchEvent(ev);
        Log.i("MyRelativeLayout","布局事件dispatch");
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("MyRelativeLayout","布局事件onIntercept");

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("MyRelativeLayout","布局事件touch");
        return super.onTouchEvent(event);
    }
}
