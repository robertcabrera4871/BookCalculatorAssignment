package com.example.bookcalculatorassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onButtonClick(v: View){
        val button = v as Button
        val bText = button.text.toString()
        val value = bText.toInt()
        total += value
        textView.text = total.toString()
    }
}
