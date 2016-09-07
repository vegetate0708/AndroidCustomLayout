package com.zxf.androidcustomlayout.Animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by Administrator on 2016/9/2.
 */
public class MyPointView1 extends View{
    private Point mPoint = new Point(100);

    public MyPointView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mPoint != null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mPoint.getRadius(),paint);
        }
        super.onDraw(canvas);
    }

    public int getPointRadius(){
        return 50;
    }

    public void setPointRadius(int radius){
        mPoint.setRadius(radius);
        invalidate();
    }
}
