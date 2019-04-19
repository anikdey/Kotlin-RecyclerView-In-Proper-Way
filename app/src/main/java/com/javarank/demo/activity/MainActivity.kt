package com.javarank.demo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.javarank.demo.R
import com.javarank.demo.fragments.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ListFragment.newInstance(), ListFragment.TAG).commit();
        }
    }
}