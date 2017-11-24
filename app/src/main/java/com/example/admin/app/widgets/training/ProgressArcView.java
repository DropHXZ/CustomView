package com.example.admin.app.widgets.training;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * 进度条
 * Created by admin on 2017/11/16.
 */

public class ProgressArcView extends View {

    Paint mPaint = new Paint();
    Paint cPaint = new Paint();
    ObjectAnimator animator;
    float raseup = 1;
    private float currentARC = 150;

    public ProgressArcView(Context context) {
        this(context,null);
    }

    public ProgressArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ProgressArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.GRAY);

        cPaint.setStyle(Paint.Style.STROKE);
        cPaint.setStrokeCap(Paint.Cap.ROUND);
        cPaint.setAntiAlias(true);
        cPaint.setStrokeWidth(20);
        cPaint.setColor(Color.RED);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setArc(float arc){
        if (animator == null) {
            animator = ObjectAnimator.ofFloat(this,"raseup",currentARC,arc*240/100);
        }
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(3000);
        animator.start();
    }

    /**
     * 重置，回复初始状态
     */
    public void resetArc(){
        currentARC = 150;
        if (animator == null) {
            animator = ObjectAnimator.ofFloat(this,"raseup",currentARC,1*240/100);
        }
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(3000);
        animator.start();
    }

    @SuppressWarnings("unused")
    public void setRaseup(float raseup){
        this.raseup = raseup;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth()/2-100,getHeight()/2);
        //描绘背景颜色
        canvas.drawArc(0,0,220,220,150,240,false,mPaint);
        //绘制进度弧形
        canvas.drawArc(0,0,220,220,currentARC,raseup,false,cPaint);
        Log.i("custom","raseup============="+raseup);
    }
}
