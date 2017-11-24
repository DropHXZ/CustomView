package com.example.admin.app.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.admin.app.R
import kotlinx.android.synthetic.main.activity_progress.*
import android.animation.ValueAnimator
import android.util.Log


/**
 * Created by admin on 2017/11/13.
 */
class ProgressAct : AppCompatActivity() {

    var str: String = "kotlin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        initClick()
    }

    private fun initClick() {
        btn_01.setOnClickListener {
            progress_arc.setArc(50f)
        }
        btn_02.setOnClickListener {

        }
        btn_03.setOnClickListener {
            progress_arc.resetArc()
        }
        btn_04.setOnClickListener {

        }

    }
}