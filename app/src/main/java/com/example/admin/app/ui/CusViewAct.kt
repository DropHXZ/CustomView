package com.example.admin.app.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.admin.app.R
import kotlinx.android.synthetic.main.activity_custom_view.*
import kotlin.concurrent.thread

/**
 * Created by admin on 2017/11/8.
 */
class CusViewAct : AppCompatActivity() {

    var sum:Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)

        initClick()
    }

    private fun initClick() {
        progress_arc2.setOnClickListener {
            initArc()
        }
        sample_view.setOnClickListener {
            sample_view.progress = 80f
        }
    }

    private fun initArc() {
//        for (i in 1..100){
//            i++
//            progress_arc2.progress = 50f
//        }
        while (sum<100){
            thread { Thread.sleep(5000) }
            sum++
            progress_arc2.progress = sum
            Log.i("custom","sum=============="+sum)
        }
    }
}