package com.example.admin.app.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.app.R
import kotlinx.android.synthetic.main.activity_panel.*

class PanelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)
        init()
    }

    private fun init() {
        panelView.setPercent(90)
    }
}
