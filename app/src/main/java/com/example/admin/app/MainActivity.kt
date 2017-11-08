package com.example.admin.app

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.admin.app.ui.CusViewAct
import com.example.admin.app.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btn_01.setOnClickListener {
            val inn = Intent(this,CusViewAct::class.java)
            startActivity(inn)
        }

    }
}
