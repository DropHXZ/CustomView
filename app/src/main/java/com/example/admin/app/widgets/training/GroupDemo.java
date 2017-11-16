package com.example.admin.app.widgets.training;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.admin.app.R;

/**
 * Created by admin on 2017/11/15.
 */

public class GroupDemo extends LinearLayout {

    public Paint mPaint = new Paint();
    public Bitmap bitmap = null;

    public GroupDemo(Context context) {
        super(context);
    }

    public GroupDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
        init();
    }

    public GroupDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.google_chrome);
    }

//    @Override
//    public void draw(Canvas canvas) {
//        super.draw(canvas);
//        dispatchDraw(canvas);
//
//        onDrawForeground(canvas);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,mPaint);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,mPaint);
    }

    /**
     * 前景
     * @param canvas
     */
    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        canvas.drawBitmap(bitmap,0,0,mPaint);
    }
}
