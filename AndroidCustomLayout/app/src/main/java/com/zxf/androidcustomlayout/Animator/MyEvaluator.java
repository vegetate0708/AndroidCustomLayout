package com.zxf.androidcustomlayout.Animator;

import android.animation.TypeEvaluator;

/**
 * Created by Administrator on 2016/9/1.
 */
public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int)(200+startValue+fraction*(endValue-startValue));
    }
}
