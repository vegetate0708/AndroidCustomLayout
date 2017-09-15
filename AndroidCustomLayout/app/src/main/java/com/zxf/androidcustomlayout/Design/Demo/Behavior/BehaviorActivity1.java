package com.zxf.androidcustomlayout.Design.Demo.Behavior;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.view.View;

import com.zxf.androidcustomlayout.R;

/**
 * Created by Administrator on 2017/5/15.
 */
public class BehaviorActivity1 extends Activity {
    private SwipeDismissBehavior swipeDismissBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_behavior1);
//        final TextView depentent = (TextView) findViewById(R.id.depentent);
//        depentent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewCompat.offsetTopAndBottom(v, 5);
//            }
//        });
        setContentView(R.layout.activity_behavior2);
        swipeDismissBehavior = new SwipeDismissBehavior();
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
        swipeDismissBehavior.setListener(onDismissListener);
        CoordinatorLayout.LayoutParams coordinatorParams = (CoordinatorLayout.LayoutParams) findViewById(R.id.textview).getLayoutParams();
        coordinatorParams.setBehavior(swipeDismissBehavior);

        swipeDismissBehavior.setDragDismissDistance(0.5F);
        swipeDismissBehavior.setStartAlphaSwipeDistance(0F);
        swipeDismissBehavior.setEndAlphaSwipeDistance(0.5F);
        swipeDismissBehavior.setSensitivity(0);
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
    }

    private SwipeDismissBehavior.OnDismissListener onDismissListener = new SwipeDismissBehavior.OnDismissListener() {
        @Override
        public void onDismiss(View view) {
        }

        @Override
        public void onDragStateChanged(int state) {
        }
    };
}
