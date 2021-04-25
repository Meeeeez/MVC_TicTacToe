package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.view.*


class MainActivity : AppCompatActivity() {

    val model = TicTacToeModel()
    var xWinCounter = 1
    var oWinCounter = 1
    var counterIsLocked = false


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view)

        field1.setOnClickListener {
            model.pressButtonAt(0, 0)
            field1.text = model.stringForButtonAt(0, 0)
            checkForPlayer()
            checkForState()
        }

        field2.setOnClickListener {
            model.pressButtonAt(0, 1)
            field2.text = model.stringForButtonAt(0, 1)
            checkForPlayer()
            checkForState()
        }

        field3.setOnClickListener {
            model.pressButtonAt(0, 2)
            field3.text = model.stringForButtonAt(0, 2)
            checkForPlayer()
            checkForState()
        }
        field4.setOnClickListener {
            model.pressButtonAt(1, 0)
            field4.text = model.stringForButtonAt(1, 0)
            checkForPlayer()
            checkForState()
        }

        field5.setOnClickListener {
            model.pressButtonAt(1, 1)
            field5.text = model.stringForButtonAt(1, 1)
            checkForPlayer()
            checkForState()
        }

        field6.setOnClickListener {
            model.pressButtonAt(1, 2)
            field6.text = model.stringForButtonAt(1, 2)
            checkForPlayer()
            checkForState()
        }

        field7.setOnClickListener {
            model.pressButtonAt(2, 0)
            field7.text = model.stringForButtonAt(2, 0)
            checkForPlayer()
            checkForState()
        }

        field8.setOnClickListener {
            model.pressButtonAt(2, 1)
            field8.text = model.stringForButtonAt(2, 1)
            checkForPlayer()
            checkForState()
        }

        field9.setOnClickListener {
            model.pressButtonAt(2, 2)
            field9.text = model.stringForButtonAt(2, 2)
            checkForPlayer()
            checkForState()
        }

        restartGameBtn.setOnClickListener {
            model.resetGame()

            field1.text = ""
            field2.text = ""
            field3.text = ""
            field4.text = ""
            field5.text = ""
            field6.text = ""
            field7.text = ""
            field8.text = ""
            field9.text = ""
            counterIsLocked = false
        }
    }

    @SuppressLint("SetTextI18n")
    fun checkForPlayer(){
        if(model.gameState.toString() == "X_TURN"){
            helpField.text = "X's turn"
        }else if(model.gameState.toString() == "O_TURN"){
            helpField.text = "O's turn"
        }
    }

    @SuppressLint("SetTextI18n")
    fun checkForState(){
        if (model.gameState.toString() == "X_WINS") {
            helpField.text = "X wins"
            Toast.makeText(this, "Press 'Restart' to play again", Toast.LENGTH_SHORT).show()
            if(!counterIsLocked){
                xWins.text = "X Wins: ${xWinCounter++}"
                counterIsLocked = true
            }
        }else if(model.gameState.toString() == "O_WINS") {
            helpField.text = "O wins"
            Toast.makeText(this, "Press 'Restart' to play again", Toast.LENGTH_SHORT).show()
            if (!counterIsLocked){
                oWins.text = "O Wins: ${oWinCounter++}"
                counterIsLocked = true
            }
        }else if(model.gameState.toString() == "TIE_GAME"){
            helpField.text = "Tie"
            Toast.makeText(this, "Press 'Restart' to play again", Toast.LENGTH_SHORT).show()
        }
    }
}
