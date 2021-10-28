package com.example.dictionary.view

import android.os.Bundle
import com.example.dictionary.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, ListFragment.newInstance()).commit()
    }
}

