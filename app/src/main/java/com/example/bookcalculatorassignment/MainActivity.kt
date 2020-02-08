package com.example.bookcalculatorassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    private var number1: Long = 0
    private var number2: Long = 0
    private var isSecondNum: Boolean = false
    private var stringNumber = ""
    private var result: Long = 0
    private lateinit var operation: (Long, Long) -> Long

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onButtonClick(v: View){
        val button = v as Button
        val bText = button.text.toString()

        stringNumber += bText
        textView.text = stringNumber

        val value: Long = stringNumber.toLong()
        if(!isSecondNum) {
            number1 = value
        } else {
            number2 = value
        }
    }
    fun equalsOnClick(v: View){
        result = operation(number1, number2)
        textView.text = result.toString()
        stringNumber = ""
        number1 = 0
        number2 = 0
        isSecondNum = false
    }
    fun operatorButtonClick(v: View){
        when(v.id){
            plusButton.id -> {
                operation = { a, b -> a + b }
                stringNumber = "+"
            }
            minusButton.id -> {
                operation = { a, b -> a - b }
                stringNumber = "-"
            }
            timesButton.id -> {
                operation = { a, b -> a * b }
                stringNumber = "*"
            }
            divideButton.id -> {
                operation = { a, b -> a / b }
                stringNumber = "/"
            }
        }
        isSecondNum = true
        textView.text = stringNumber
        stringNumber = ""
    }
    fun clearButton(v: View){
        number1 = 0
        number2 = 0
        stringNumber = ""
        textView.text = ""

    }
}
