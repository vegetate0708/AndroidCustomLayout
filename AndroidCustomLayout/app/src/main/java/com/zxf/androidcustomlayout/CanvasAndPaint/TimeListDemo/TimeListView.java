package com.zxf.androidcustomlayout.CanvasAndPaint.TimeListDemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.zxf.androidcustomlayout.R;

/**
 * Created by Administrator on 2016/11/16.
 */
public class TimeListView extends View {
    private int mMakeSize,mLineSize;
    private Drawable mStartLine;
    private Drawable mEndLine;
    private Drawable mMaker;
    private Rect bounds;

    private void init(AttributeSet attrs){
        //获取控件的属性集合
        TypedArray array=getContext().obtainStyledAttributes(attrs, R.styleable.TimeListView);
        //中心圆大小
        mMakeSize=array.getDimensionPixelSize(R.styleable.TimeListView_circle,10);
        //线段大小
        mLineSize=array.getDimensionPixelSize(R.styleable.TimeListView_lineSize,10);
        //顶部线条
        mStartLine=array.getDrawable(R.styleable.TimeListView_startLine);
        //底部线条
        mEndLine=array.getDrawable(R.styleable.TimeListView_endLine);
        //中心圆
        mMaker=array.getDrawable(R.styleable.TimeListView_maker);
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取中心圆以及距离左右的大小和
        int w=mMakeSize+getPaddingLeft()+getPaddingRight();
        int h=mMakeSize+getPaddingTop()+getPaddingBottom();
        //将这个值与测量的控件大小进行比较得出较小的那个值从而确定具体控件的大小
        int widthsize=resolveSizeAndState(w,widthMeasureSpec,0);
        int heightsize=resolveSizeAndState(h,heightMeasureSpec,0);
        //将这个值设置给控件大小
        setMeasuredDimension(widthsize,heightsize);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //获取左右上下的Padding值
        int pLeft=getPaddingLeft();
        int pRight=getPaddingRight();
        int pTop=getPaddingTop();
        int pBottom=getPaddingBottom();
        //获取控件宽高
        int width=getWidth();
        int height=getHeight();
        //中心圆圈的矩形定位
        int cWidth=width-pLeft-pRight;
        int cHeight=height-pTop-pBottom;
        if(mMaker!=null){
            int makesize=Math.min(mMakeSize,Math.min(cWidth,cHeight));
            mMaker.setBounds(pLeft,pTop,pLeft+makesize,pTop+makesize);
            bounds = mMaker.getBounds();
        }else {
            bounds=new Rect(pLeft,pTop,pLeft+cWidth,pTop+cHeight);
        }
        int lineleft=bounds.centerX()-mLineSize>>1;
        if(mStartLine!=null){
            mStartLine.setBounds(pLeft+lineleft,0,pLeft+lineleft+mLineSize,bounds.top);
        }
        if(mEndLine!=null){
            mEndLine.setBounds(pLeft+lineleft,bounds.bottom,pLeft+lineleft+mLineSize,height);
        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mStartLine!=null){
            mStartLine.draw(canvas);
        }
        if(mEndLine!=null){
            mEndLine.draw(canvas);
        }
        if(mMaker!=null){
            mMaker.draw(canvas);
        }
        super.onDraw(canvas);
    }

    public Drawable getmMaker() {
        return mMaker;
    }

    public void setmMaker(Drawable mMaker) {
        this.mMaker = mMaker;
    }

    public Drawable getmEndLine() {
        return mEndLine;
    }

    public void setmEndLine(Drawable mEndLine) {
        this.mEndLine = mEndLine;
    }

    public Drawable getmStartLine() {
        return mStartLine;
    }

    public void setmStartLine(Drawable mStartLine) {
        this.mStartLine = mStartLine;
    }

    public int getmLineSize() {
        return mLineSize;
    }

    public void setmLineSize(int mLineSize) {
        this.mLineSize = mLineSize;
    }

    public int getmMakeSize() {
        return mMakeSize;
    }

    public void setmMakeSize(int mMakeSize) {
        this.mMakeSize = mMakeSize;
    }
    public TimeListView(Context context) {
        super(context);

    }

    public TimeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TimeListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
}
