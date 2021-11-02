package com.example.dictionary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, ListFragment.newInstance()).commit()
    }
}

