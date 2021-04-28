package com.example.tictactoe

import android.annotation.SuppressLint

class TicTacToeModel {

    var xWinCounter = 0
    var oWinCounter = 0
    var counterIsLocked = false

    private var board: Array<Array<Mark>> = Array(NUM_ROWS) { Array(NUM_COL) { Mark.MARK_NONE } }
    var gameState: GameState = GameState.X_TURN

    companion object {
        val NUM_ROWS = 3
        val NUM_COL = 3
    }

    enum class Mark {
        MARK_NONE,
        MARK_X,
        MARK_O
    }

    enum class GameState {
        X_TURN,
        O_TURN,
        X_WINS,
        O_WINS,
        TIE_GAME
    }

    init {
        resetGame()
    }

    fun resetGame() {
        board = Array(NUM_ROWS) { Array(NUM_COL) { Mark.MARK_NONE } }
        gameState = GameState.X_TURN
    }

    fun stringForButtonAt(row: Int, col: Int): String {
        if (row in 0 until NUM_ROWS && col in 0 until NUM_COL) {
            if (board[row][col] == Mark.MARK_X) {
                return "X"
            }
            if (board[row][col] == Mark.MARK_O) {
                return "O"
            }
        }
        return ""
    }

    fun pressButtonAt(row: Int, col: Int) {
        if (row !in 0 until NUM_ROWS || col !in 0 until NUM_COL || board[row][col] != Mark.MARK_NONE) {
            return
        }

        if (gameState == GameState.X_TURN) {
            board[row][col] = Mark.MARK_X
            gameState = GameState.O_TURN
            checkForWin()
        } else if (gameState == GameState.O_TURN) {
            board[row][col] = Mark.MARK_O
            gameState = GameState.X_TURN
            checkForWin()
        }
    }

    fun checkForWin() {
        if (gameState != GameState.X_TURN && gameState != GameState.O_TURN) {
            return
        }

        if (didPieceWin(Mark.MARK_X)) {
            gameState = GameState.X_WINS
        } else if (didPieceWin(Mark.MARK_O)) {
            gameState = GameState.O_WINS
        } else if (isBoardFull()) {
            gameState = GameState.TIE_GAME
        }
    }

    fun didPieceWin(mark: Mark): Boolean {
        for (row in 0 until NUM_ROWS) {
            var winHere = true
            for (col in 0 until NUM_COL) {
                if (board[row][col] != mark) {
                    winHere = false
                }
            }
            if (winHere) {
                return true
            }
        }

        for (col in 0 until NUM_COL) {
            var winHere = true

            for (row in 0 until NUM_ROWS) {
                if (board[row][col] != mark) {
                    winHere = false
                }
            }
            if (winHere) {
                return true
            }
        }

        //check main diagonal
        var winHere = true
        for (row in 0 until NUM_ROWS) {
            if (board[row][row] != mark) {
                winHere = false
            }
        }
        if (winHere) {
            return true
        }

        //check other diagnonal
        winHere = true
        for (row in 0 until NUM_ROWS) {
            if (board[row][NUM_ROWS - row - 1] != mark) {
                winHere = false
            }
        }
        if (winHere) {
            return true
        }

        return false
    }

    private fun isBoardFull(): Boolean{
        for (row in 0 until NUM_ROWS){
            for (col in 0 until NUM_COL){
                if(board[row][col] == Mark.MARK_NONE){
                    return false
                }
            }
        }
        return true
    }

    @SuppressLint("SetTextI18n")
    fun checkForState(): Array<String>{
        if (gameState.toString() == "X_WINS") {
            if(!counterIsLocked){
                counterIsLocked = true
                xWinCounter++
                return arrayOf(gameState.toString(), xWinCounter.toString())
            }
        }else if(gameState.toString() == "O_WINS") {
            if (!counterIsLocked){
                counterIsLocked = true
                oWinCounter++
                return arrayOf(gameState.toString(), oWinCounter.toString())
            }
        }else if(gameState.toString() == "TIE_GAME"){
            return arrayOf(gameState.toString(), "")
        }
        println("xWIn $xWinCounter")
        println("oWIn $oWinCounter")
        return arrayOf("")
    }
}