package com.example.admin.app.widgets.training;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.admin.app.R;

/**
 * 移动-动画
 * Created by admin on 2017/11/17.
 */

public class TransXDemoView extends View {

    Bitmap bitmap = null;
    Paint mPaint = new Paint();
    int x = 0;
    float r = 0;
    ObjectAnimator animator;

    ObjectAnimator rotate = ObjectAnimator.ofFloat(this,"rotate",360);

    public TransXDemoView(Context context) {
        this(context,null);
    }

    public TransXDemoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TransXDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.google_chrome);
        bitmap = zoomPng(bitmap,300);

        rotate.setDuration(2000);
        rotate.setRepeatCount(ValueAnimator.INFINITE);
        rotate.setRepeatMode(ValueAnimator.REVERSE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    public void onClick(int trans){
        if (animator == null) {
            animator = ObjectAnimator.ofInt(this,"transX",0,trans);
            animator.setDuration(2000);
            animator.setInterpolator(new LinearInterpolator());
            animator.setRepeatCount(ValueAnimator.INFINITE);
            animator.setRepeatMode(ValueAnimator.REVERSE);
            animator.start();
        }
    }

    @SuppressWarnings("unused")
    public void setTransX(int x){
        this.x = x;
        invalidate();
    }

    public void setRotate(float rotate){
        this.r = rotate;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();

        canvas.translate(x,0);
//        canvas.rotate(r);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        canvas.restore();

    }

    public Bitmap zoomPng(Bitmap bitmap, float newWidth) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        float scaleW = width / newWidth;
        float scaleH = height / newWidth;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleW, scaleH);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return newBitmap;
    }

}
