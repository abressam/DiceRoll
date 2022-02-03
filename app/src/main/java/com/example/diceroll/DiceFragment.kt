package com.example.diceroll

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView

/**
 * This fragment allows the user to roll a dice and view the result
 * on the screen.
 */
class DiceFragment : Fragment(R.layout.dice_fragment) {

    //private lateinit var viewModel: DiceViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // find the Button in the layout
        val rollButton = view.findViewById<Button>(R.id.roll_button)

        /**
         * "setOnClickListener" is used to make an event when the button is clicked
         * Inside the "setOnClickListener" is called the function rollDice() when the button is clicked
         */
        rollButton.setOnClickListener { rollDice() }

        // Do a roll dice when the app starts
        rollDice()
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiceViewModel::class.java)
        TODO: Use the ViewModel
    }*/

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6) // created a 6 sides dice

        // roll the dice calling the roll() method and save the result in the diceRoll variable
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage = view?.findViewById<ImageView>(R.id.dice_image)

        /**
         * Determine which drawable resource ID to use based on the dice roll
         * Create a drawableResource variable to store the resource ID to use.
         * "when" can return a value. In this case, the expression returns the correct resource ID,
         * which will be stored in the drawableResources variable.
         */
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

        // Update the content description
        diceImage?.contentDescription = diceRoll.toString() // Text description of what is show in the ImageView
    }

    /**
     * "numSides" is only accessible within the Dice class.
     * Since the only code that will be using the numSides is inside the Dices, it's okay to make this argument private.
     */

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}