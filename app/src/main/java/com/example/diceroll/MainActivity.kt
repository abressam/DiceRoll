package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"
        }
    }

    class Dice(private val numSides: Int) { // numSides is only accessible within the Dice class
        fun roll(): Int { // since the only code that will be using the numSides is inside the Dices, it's okay to make this argument private
            return (1..numSides).random()
        }
    }
}