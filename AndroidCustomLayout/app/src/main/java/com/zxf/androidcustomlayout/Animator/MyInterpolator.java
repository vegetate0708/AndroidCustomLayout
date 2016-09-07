package com.zxf.androidcustomlayout.Animator;

import android.animation.TimeInterpolator;

/**
 * Created by Administrator on 2016/9/1.
 */
public class MyInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
