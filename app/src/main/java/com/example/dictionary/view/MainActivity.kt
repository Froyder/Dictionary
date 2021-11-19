package com.example.dictionary.view

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.R
import com.example.utils.networkStatus.viewById

class MainActivity : AppCompatActivity() {

    private val container by viewById<FrameLayout>(R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(container.id, ListFragment.newInstance()).commit()
    }
}

