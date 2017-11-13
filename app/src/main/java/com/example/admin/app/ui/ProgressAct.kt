package com.example.admin.app.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.admin.app.R
import kotlinx.android.synthetic.main.activity_progress.*

/**
 * Created by admin on 2017/11/13.
 */
class ProgressAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        initClick()
    }

    private fun initClick() {
        btn_01.setOnClickListener {

        }
        btn_02.setOnClickListener {

        }
        btn_03.setOnClickListener {

        }
        btn_04.setOnClickListener {

        }

    }
}