package com.example.admin.app.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.app.R;
import com.example.admin.app.widgets.FlipBoardLogoView;

/**
 * Created by admin on 2017/12/6.
 */

public class MapAnimationAct2 extends AppCompatActivity {

    FlipBoardLogoView logoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_animation2);
        init();
    }

    private void init() {
        logoView = findViewById(R.id.logoView);
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(logoView, "rightDegreeY", 0, -45);
//        animator1.setDuration(1000);
//        animator1.setStartDelay(500);
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(logoView, "degreeZ", 0, 270);
//        animator2.setDuration(800);
//        animator2.setStartDelay(500);
//        ObjectAnimator animator3 = ObjectAnimator.ofFloat(logoView, "leftDegreeY", 0, 45);
//        animator1.setDuration(1000);
//        animator1.setStartDelay(500);

//        final AnimatorSet set = new AnimatorSet();
//        set.playSequentially(animator1, animator2,animator3);
//        set.start();
    }
}
