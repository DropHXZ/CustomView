package com.example.admin.app.widgets.training;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.app.R;

/**
 * Created by admin on 2017/11/27.
 */

public class MatrixView extends View {

    private Paint paint = new Paint();
    private Bitmap bitmap = null;

    public MatrixView(Context context) {
        this(context, null);
    }

    public MatrixView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setAntiAlias(true);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

//        float src[] = {bitmapWidth / 2, bitmapHeight / 2, bitmapWidth, 0};
        float src[] = {0, 0, 0, bitmapHeight, bitmapWidth, bitmapHeight, bitmapWidth, 0};
//        float dst[] = {bitmapWidth / 2, bitmapHeight / 2, bitmapWidth / 2 + bitmapHeight / 2, bitmapHeight / 2 + bitmapWidth / 2};
        float dst[] = {50, 0, 0, bitmapHeight / 2, bitmapWidth / 2, bitmapHeight / 2, bitmapWidth - 50, 0};

        canvas.save();
        Matrix matrix = new Matrix();
//        matrix.setRotate(45,bitmapWidth/2,bitmapHeight/2);
        //这个方法主要是利用确定矩形4个顶点，根据4个顶点坐标的变化来对bitmap进行变换
        matrix.setPolyToPoly(src, 0, dst, 0, 4);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, 0, 50, paint);
        canvas.restore();
    }
}
