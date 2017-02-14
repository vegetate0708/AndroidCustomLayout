package com.zxf.androidcustomlayout.Animator.Demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/9/22.
 */
public class ShowAndHideView extends ViewGroup implements View.OnClickListener{
    private static int TOP_LEFT=0;
    private static int TOP_RIGHT=1;
    private static int BOTTOM_LEFT=2;
    private static int BOTTOM_RIGHT=3;
    int[] a= new int[2];
    int style;//显示位置风格
    int x,y;
    boolean isShow=false;//是否展开
    public ShowAndHideView(Context context) {
        super(context);
    }
    private void getStyle(){
        this.getLocationOnScreen(a);
        x=a[0];
        y=a[1];
        if(x<100&&y<100)
           style=TOP_LEFT;
        if(x<100&&y>100)
            style=BOTTOM_LEFT;
        if(x>100&&y<100)
            style=TOP_RIGHT;
        if(x>100&&y>100)
            style=BOTTOM_RIGHT;
        Log.i("位于屏幕的位置",x+"::::"+y);
    }
    public ShowAndHideView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShowAndHideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("按下","按下位置"+ev.getX());
                break;
            case MotionEvent.ACTION_UP:
                Log.i("松开","松开位置"+ev.getX());
                break;

        }
        return true;
    }

    @Override
    protected void onFinishInflate() {
        getStyle();
        super.onFinishInflate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;


        }
        return super.onTouchEvent(event);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i("布局的位置",l+"::::"+t+"::::"+r+"::::"+b);
    }

    @Override
    public void onClick(View v) {

    }
}
