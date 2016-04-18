package com.zxf.androidcustomlayout.ScollerView;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zxf.androidcustomlayout.R;

/**
 * Created by Administrator on 2016/4/12.
 */
public class MyLockView extends ScrollView{
    ;
    private View viewCentre;
    private Rect rect;
    private int moveY=0;
    private onStateChangeListener state;
    private ImageView imageViewup;
    private ImageView imageViewupbig;
    private ImageView imageViewdown;
    private ImageView imageViewdownbig;
    private ImageView iv_lock;
    private ImageView iv_unlock;
    private TextView text_up;
    private TextView text_upbig;
    private int mpreY=0;
   private RelativeLayout iv_centre;
    public interface onStateChangeListener{
        public abstract void onState(int i);
    }
    public MyLockView(Context context,AttributeSet attrs) {
        super(context,attrs);
    }
    public void setStateChangeListener(onStateChangeListener stateChangeListener) {
        this.state = stateChangeListener;
    }

    @Override
    protected void onFinishInflate() {
        viewCentre = getChildAt(0);
        imageViewup = (ImageView) viewCentre.findViewById(R.id.iv_up);
        imageViewupbig = (ImageView) viewCentre.findViewById(R.id.iv_upbig);
        imageViewdown = (ImageView) viewCentre.findViewById(R.id.iv_down);
        imageViewdownbig = (ImageView) viewCentre.findViewById(R.id.iv_downbig);
        iv_lock= (ImageView) viewCentre.findViewById(R.id.iv_lock);
        iv_unlock= (ImageView) viewCentre.findViewById(R.id.iv_unlock);
        iv_centre = (RelativeLayout) findViewById(R.id.fl_lockdemo);
        text_up= (TextView) viewCentre.findViewById(R.id.tv_lock);
        text_upbig= (TextView) viewCentre.findViewById(R.id.tv_lockbig);
        super.onFinishInflate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float y=ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (viewCentre != null) {
                    rect = new Rect(viewCentre.getLeft(), viewCentre.getTop(),
                            viewCentre.getRight(), viewCentre.getBottom());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int delta = (int)((y - mpreY) * 0.25);
                if (delta>0) {
                    viewCentre.layout(viewCentre.getLeft(),
                            viewCentre.getTop() + delta, viewCentre.getRight(),
                            viewCentre.getBottom() + delta);
                    moveY+=delta;
                    if(moveY>100){
                        state.onState(1);
                        iv_centre.setAlpha((float) 0.2);
                        imageViewup.setVisibility(INVISIBLE);
                        imageViewupbig.setVisibility(VISIBLE);
                        iv_unlock.setVisibility(VISIBLE);
                        text_up.setVisibility(INVISIBLE);
                        text_upbig.setVisibility(VISIBLE);
                    }else {
                        imageViewup.setVisibility(VISIBLE);
                        imageViewupbig.setVisibility(INVISIBLE);
                        text_up.setVisibility(VISIBLE);
                        text_upbig.setVisibility(INVISIBLE);
                    }
                }
                else if(delta<0){
                    viewCentre.layout(viewCentre.getLeft(), viewCentre.getTop() + delta, viewCentre.getRight(), viewCentre.getBottom() + delta);
                    moveY+=delta;
                    if(moveY<-100) {
                        state.onState(0);
                        iv_centre.setAlpha((float) 0.2);
                        imageViewdown.setVisibility(INVISIBLE);
                        imageViewdownbig.setVisibility(VISIBLE);
                        iv_lock.setVisibility(VISIBLE);
                    }else {
                        imageViewdown.setVisibility(VISIBLE);
                        imageViewdownbig.setVisibility(INVISIBLE);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                int curTop = viewCentre.getTop();
                viewCentre.layout(rect.left, rect.top, rect.right, rect.bottom);
                TranslateAnimation animation = new TranslateAnimation(0, 0, curTop - rect.top, 0);
                animation.setDuration(200);
                viewCentre.startAnimation(animation);
                state.onState(2);
                iv_centre.setAlpha((float) 1.0);
                imageViewup.setVisibility(VISIBLE);
                imageViewupbig.setVisibility(INVISIBLE);
                text_up.setVisibility(VISIBLE);
                text_upbig.setVisibility(INVISIBLE);
                imageViewdown.setVisibility(VISIBLE);
                imageViewdownbig.setVisibility(INVISIBLE);
                iv_lock.setVisibility(INVISIBLE);
                iv_unlock.setVisibility(INVISIBLE);
                moveY=0;
                break;
        }
        mpreY = (int)y;
        return super.onTouchEvent(ev);
    }

}
