package com.example.slowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.btn_listview).setOnClickListener {
            startActivity(Intent(this, SlowListActivity::class.java))
        }
        findViewById<Button>(R.id.btn_complexlayout).setOnClickListener {
            startActivity(Intent(this, ComplexLayoutActivity::class.java))
        }
    }
}