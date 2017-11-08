package com.example.admin.app.widgets.training;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.app.R;

/**
 * Created by admin on 2017/11/8.
 */

public class CameraView extends View {

    private Paint mPaint = new Paint();
    private Bitmap mBitmap;

    public CameraView(Context context) {
        super(context);
    }

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        init();
    }

    public CameraView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.google_map);
        mBitmap = zoomPng(mBitmap, 300);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        
        Camera camera = new Camera();
        camera.save();
        camera.rotateX(45);
        canvas.translate(100, 0);
        camera.applyToCanvas(canvas);
        canvas.translate(-100, 0);
        camera.restore();

        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
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
