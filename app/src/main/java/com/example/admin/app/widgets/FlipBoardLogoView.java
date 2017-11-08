package com.example.admin.app.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 红板报logo动画
 * Created by admin on 2017/11/8.
 */

public class FlipBoardLogoView extends View {


    public FlipBoardLogoView(Context context) {
        super(context);
    }

    public FlipBoardLogoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public FlipBoardLogoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
