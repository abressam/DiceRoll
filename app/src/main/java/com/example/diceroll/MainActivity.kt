package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button) // find the Button by calling findViewById
        rollButton.setOnClickListener { // setOnClickListener is used to made an event when the button is clicked
            rollDice() // call the function rollDice when the button is clicked
        }
    }

    private fun rollDice() {
        val dice = Dice(6) // created a 6 sides dice
        val diceRoll = dice.roll() // roll the dice calling the roll() method and save the result in the diceRoll variable
        val resultTextView: TextView = findViewById(R.id.textView) // find TextView by calling findViewById
        resultTextView.text = diceRoll.toString() // diceRoll is a number and TextView uses text, so need to convert diceRoll into a string
    }

    class Dice(private val numSides: Int) { // numSides is only accessible within the Dice class
        fun roll(): Int { // since the only code that will be using the numSides is inside the Dices, it's okay to make this argument private
            return (1..numSides).random()
        }
    }
}