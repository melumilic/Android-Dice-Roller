package com.example.diceroller

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

        val rollButton: Button = findViewById(R.id.rollDiceButton)
        rollButton.setOnClickListener { rollDice(6) }
        val rollButton2: Button = findViewById(R.id.rollDiceButton1)
        rollButton2.setOnClickListener { rollDice(20) }
        // Do a dice roll when the app starts
        rollDice(6)
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(numSides: Int) {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(numSides)
        val diceRoll = dice.roll()
        if(numSides==6){
            val diceImage:ImageView = findViewById<ImageView>(R.id.diceImageView)
            val drawableResource = when(diceRoll){
                1-> R.drawable.dice_1
                2-> R.drawable.dice_2
                3-> R.drawable.dice_3
                4-> R.drawable.dice_4
                5-> R.drawable.dice_5
                else-> R.drawable.dice_6
            }
            // Update the ImageView with the correct drawable resource ID
            diceImage.setImageResource(drawableResource)

            // Update the ImageView with the correct drawable resource ID
            diceImage.contentDescription = diceRoll.toString()
        }
        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.diceResultText)
        resultTextView.text = diceRoll.toString()
    }

}

class Dice(private val numSides: Int) {
    fun roll(): Int = (1..numSides).random()
}