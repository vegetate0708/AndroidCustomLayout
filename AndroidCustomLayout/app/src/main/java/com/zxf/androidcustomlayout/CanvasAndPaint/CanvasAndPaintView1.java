package com.zxf.androidcustomlayout.CanvasAndPaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/7/9.
 */
public class CanvasAndPaintView1 extends View {
    public CanvasAndPaintView1(Context context) {
        super(context);
    }

    public CanvasAndPaintView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        //设置画笔基本属性
        paint.setAntiAlias(true);//抗锯齿功能
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影

        //设置画布背景颜色
        canvas.drawRGB(255, 255,255);
        //画圆
        canvas.drawCircle(190, 200, 150, paint);
    }
}
