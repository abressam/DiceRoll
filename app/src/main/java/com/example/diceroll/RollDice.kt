package com.example.diceroll

class RollDice (private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

