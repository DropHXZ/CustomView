package com.example.admin.app.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.admin.app.R
import kotlinx.android.synthetic.main.activity_translation.*

/**
 * Created by admin on 2017/11/17.
 */
class TranslationAct :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translation)

        initClick()
    }

    private fun initClick() {
        trans.setOnClickListener {
            trans.onClick(300)
        }
    }
}