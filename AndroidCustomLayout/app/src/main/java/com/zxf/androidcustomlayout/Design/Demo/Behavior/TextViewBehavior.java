package com.zxf.androidcustomlayout.Design.Demo.Behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/15.
 */
public class TextViewBehavior extends CoordinatorLayout.Behavior<View> {
    public TextViewBehavior() {
    }

    public TextViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TextView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int i=dependency.getTop()-child.getTop();
        ViewCompat.offsetTopAndBottom(child,i);
        return true;
    }
}
