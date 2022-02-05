package com.example.diceroll

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DiceFragment : Fragment(R.layout.dice_fragment) {

    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rollButton = view.findViewById<Button>(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {

        val dice = RollDice(6)

        val diceRoll = dice.roll()

        val diceImage = view?.findViewById<ImageView>(R.id.dice_image)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1 // If the user rolls a 1, then display the dice_1 image.
            2 -> R.drawable.dice_2 // If the user rolls a 2, then display the dice_2 image.
            3 -> R.drawable.dice_3 // ...
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage?.setImageResource(drawableResource)

        diceImage?.contentDescription = diceRoll.toString()
    }
}