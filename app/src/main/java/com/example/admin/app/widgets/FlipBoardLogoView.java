package com.example.admin.app.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.app.R;

/**
 * 红板报logo动画
 * Created by admin on 2017/11/8.
 */

public class FlipBoardLogoView extends View {

    //首次折叠的一半
    private float rightDegreeY;
    //对应首次折叠的另一半
    private float leftDegreeY;
    //Z轴方向折叠，实现翻转的效果
    private float degreeZ;

    private Paint paint;
    private Bitmap bitmap;
    private Camera camera;

    private ObjectAnimator animator1;
    private ObjectAnimator animator2;
    private ObjectAnimator animator3;

    public FlipBoardLogoView(Context context) {
        this(context, null);
    }

    public FlipBoardLogoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlipBoardLogoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.google_map);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        camera = new Camera();
        initAnimation();
    }

    private void initAnimation() {
        animator1 = ObjectAnimator.ofFloat(this, "rightDegreeY", 0, -45);
        animator1.setDuration(1000);
        animator1.setStartDelay(500);
        animator2 = ObjectAnimator.ofFloat(this, "degreeZ", 0, 270);
        animator2.setDuration(800);
        animator2.setStartDelay(500);
        animator3 = ObjectAnimator.ofFloat(this, "leftDegreeY", 0, 45);
        animator3.setDuration(1000);
        animator3.setStartDelay(500);
        final AnimatorSet set = new AnimatorSet();
        set.playSequentially(animator1, animator2,animator3);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //动画结束后
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int mWidth = bitmap.getWidth();
        int mHeight = bitmap.getHeight();
        int mCenterX = getWidth() / 2;
        int mCenterY = getHeight() / 2;
        int x = mCenterX - mWidth / 2;
        int y = mCenterY - mHeight / 2;

        canvas.save();
        camera.save();
        canvas.translate(mCenterX, mCenterY);
        canvas.rotate(-degreeZ);
        camera.rotateY(rightDegreeY);
        camera.applyToCanvas(canvas);
        canvas.clipRect(0, -mCenterY, mCenterX, mCenterY);
        canvas.rotate(degreeZ);
        canvas.translate(-mCenterX, -mCenterY);
        camera.restore();
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

        canvas.save();
        camera.save();
        canvas.translate(mCenterX, mCenterY);
        canvas.rotate(-degreeZ);
        camera.rotateY(leftDegreeY);
        camera.applyToCanvas(canvas);
        canvas.clipRect(-mCenterX, -mCenterY, 0, 0 + y);
        canvas.rotate(degreeZ);
        canvas.translate(-mCenterX, -mCenterY);
        camera.restore();
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

    }

    @SuppressWarnings("unused")
    public void setRightDegreeY(float degreeY) {
        this.rightDegreeY = degreeY;
        invalidate();
    }

    @SuppressWarnings("unused")
    public void setDegreeZ(float degreeZ) {
        this.degreeZ = degreeZ;
        invalidate();
    }

    @SuppressWarnings("unused")
    public void setLeftDegreeY(float degreeY) {
        this.leftDegreeY = degreeY;
        invalidate();
    }
}
