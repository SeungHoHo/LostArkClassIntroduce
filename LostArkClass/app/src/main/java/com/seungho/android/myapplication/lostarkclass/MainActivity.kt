package com.seungho.android.myapplication.lostarkclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil.setContentView
import com.seungho.android.myapplication.lostarkclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}