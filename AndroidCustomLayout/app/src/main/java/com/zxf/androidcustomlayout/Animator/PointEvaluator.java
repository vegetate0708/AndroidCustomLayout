package com.zxf.androidcustomlayout.Animator;

import android.animation.TypeEvaluator;

/**
 * Created by Administrator on 2016/9/1.
 */
public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end  = endValue.getRadius();
        int curValue = (int)(start + fraction * (end - start));
        return new Point(curValue);
    }
}
