package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button =
            findViewById(R.id.button) // find the Button by calling findViewById
        rollButton.setOnClickListener { rollDice() }
        // setOnClickListener is used to made an event when the button is clicked
        // inside setOnClick Listener is called the function rollDice() when the button is clicked
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6) // created a 6 sides dice
        val diceRoll = dice.roll()
        // roll the dice calling the roll() method and save the result in the diceRoll variable
        val diceImage: ImageView = findViewById(R.id.imageView)
        // find ImageView by calling findViewById
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1) // If the user rolls a 1, then display the dice_1 image.
            2 -> diceImage.setImageResource(R.drawable.dice_2) // If the user rolls a 2, then display the dice_2 image.
            3 -> diceImage.setImageResource(R.drawable.dice_3) // ...
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

    }

    class Dice(private val numSides: Int) { // numSides is only accessible within the Dice class
        fun roll(): Int { // since the only code that will be using the numSides is inside the Dices, it's okay to make this argument private
            return (1..numSides).random()
        }
    }
}