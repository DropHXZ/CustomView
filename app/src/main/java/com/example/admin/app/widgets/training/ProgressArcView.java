package com.example.admin.app.widgets.training;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by admin on 2017/11/16.
 */

public class ProgressArcView extends View {

    Paint mPaint = new Paint();

    public ProgressArcView(Context context) {
        super(context);
    }

    public ProgressArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
        canvas.translate(20,20);
        canvas.drawArc(0,0,150,150,150,240,false,mPaint);
    }
}
