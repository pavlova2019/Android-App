package com.alexandrapavlova.mydumbapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexandrapavlova.mydumbapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //supportFragmentManager.beginTransaction().replace(, R.layout.activity_main)
    }

}