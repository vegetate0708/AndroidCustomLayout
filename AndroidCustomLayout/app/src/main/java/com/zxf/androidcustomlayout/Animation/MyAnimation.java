package com.zxf.androidcustomlayout.Animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2016/7/21.
 */
public class MyAnimation extends Animation {
   private float centreX;
   private float centreY;
   private int duration;
   private Camera camera=new Camera();
   public MyAnimation(float x,float y,int duration) {
       this.centreX=x;
       this.centreY=y;
       this.duration=duration;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(duration);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
   protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        camera.save();
        //根据interpolatedTime时间来控制X、Y、Z上的偏移
        camera.translate(100.0f - 100.0f * interpolatedTime, 100.0f * interpolatedTime - 100.0f, 80.0f - 80.0f * interpolatedTime);
        //根据时间在X、Y轴上旋转不同的角度
        camera.rotateX(360 * interpolatedTime);
        camera.rotateY(360 * interpolatedTime);
        //根据变换的程度Transformation获取矩阵对象matrix
        Matrix matrix=t.getMatrix();
        camera.getMatrix(matrix);
        matrix.preTranslate(-centreX,-centreY);
        matrix.preTranslate(centreX,centreY);
        camera.restore();
    }
}
