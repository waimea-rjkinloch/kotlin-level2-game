import java.awt.Color.white
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction

/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Pinned
 * Project Author: PROJECT AUTHOR HERE
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */
val squares = mutableListOf<String>()
val blankSquare = " "
val whiteSquare = "X"
val blackSquare = "O"
var user1 = " "
var user2 = " "
var errorMove = 0
var wins = 0


fun main() {
    println("╭─────────────╮")
    println("│  Pinned \uD83D\uDCCC   │")
    println("╰─────────────╯")

    gameInstructions()
    getUsersNames()
    createSquares()
    createWhiteCounters()
    createBlackCounter()
    showSquares()
    while(true) {
        playerOneTurn()
        if (wins >= 1){
            winCondition()
        }
        playerTwoTurn()
        if (wins >= 1){
            winCondition()
        }
    }
}
fun gameInstructions() {
    println("\n"+
            "Instructions\n" +
            "\n"+
            "Game Setup\n"+
            "- A row of 16 squares, numbered 1 to 16 from left to right\n" +
            "- 5 counters (total) are placed randomly on the board - 4 white and 1 black\n" +
            "- Decide who goes first\n" +
            "\n" +
            "Gameplay\n" +
            "- Players take turns - You may not skip your turn\n" +
            "- On your turn you must do exactly one of the following:\n" +
            "    - Slide any counter (black or white) any number of squares to the left, as long as no other counter is in the way and the destination square is empty, or... \n" +
            "    - Remove the counter on square 1 (only if a counter is there)\n" +
            "\n" +
            "Win Condition\n" +
            "- The player who removes the black counter from square 1 wins\n" +
            "\n" +
            "Variant\n" +
            "- Counters can slide either left or right (but still can't jump other counters)")
}
fun createSquares() {
    while(squares.size < 16)
        squares.add(" ")
}

fun showSquares(){
        println("")
        if (squares.size == 16) {
            println("  1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16")
        }
    print("┌────")
    print("┬────".repeat(n = squares.size - 1))
    println("┐")
    for (square in squares) {
        print("│ ${square.padEnd(length = 3).padStart(length = 3)}")
    }
    println("│")

    print("└────")
    print("┴────".repeat(n = squares.size - 1))
    println("┘")
}
fun createWhiteCounters() {
    repeat(4) {
        while (true) {
            val random = (1..15).random()
            if (squares[random] == blankSquare) {
                squares[random] = whiteSquare
                break
            }
        }
    }
}

fun createBlackCounter() {
    while (true) {
        val random = (1..15).random()
        if (squares[random] == blankSquare) {
            squares[random] = blackSquare
            break
        }
    }
}
fun getUsersNames(){
    while (true) {
        println("")
        print("Player 1 whats your name? ".red())
        user1 = readln()
        if (user1.isNotBlank())break
    }
    while (true) {
        println("")
        print("Player 2 what about you? ".blue())
        user2 = readln()
        if(user2.isNotBlank())break
    }
    println("")
    println("Welcome $user1 and $user2 to Pinned \uD83D\uDCCC")
}
fun playerOneTurn() {
    errorMove = 0
    var moveCounter = 0
    var pickedCounter = 0
    while (true) {
        print("$user1 which square would you like to move? ")
        pickedCounter = readln().toInt() - 1
        if (squares[pickedCounter] == " ") {
            println("")
            println("You have made an invalid choice".red())
            println("")
            showSquares()
            continue
        } else break
    }
    while (true) {
        print("$user1 where would you like to move this counter? ")
        moveCounter = readln().toInt() - 1
        if (moveCounter < pickedCounter) {
            if (squares[moveCounter] != " ") {
                println("")
                println("You have made an invalid choice".red())
                println("")
                showSquares()
                continue
            } else break
        } else
            println("")
        println("You have made an invalid choice".red())
        println("")
        continue


    }
    if (moveCounter == 0) {
        if (squares[pickedCounter] == blackSquare) {
            squares[pickedCounter] = blankSquare
            wins ++
        } else {
            squares[pickedCounter] = blankSquare
        }
    } else {
        if (squares[pickedCounter] == whiteSquare) {
            squares[pickedCounter] = blankSquare
            squares[moveCounter] = "X"
        } else
            squares[moveCounter] = "O"
            squares[pickedCounter] = blankSquare
    }
    showSquares()
}
fun playerTwoTurn(){
    errorMove = 0
    var moveCounter = 0
    var pickedCounter = 0
    while (true) {
        print("$user1 which square would you like to move? ")
        pickedCounter = readln().toInt() - 1
        if (squares[pickedCounter] == " ") {
            println("")
            println("You have made an invalid choice".red())
            println("")
            showSquares()
            continue
        } else break
    }
    while (true) {
        print("$user1 where would you like to move this counter? ")
        moveCounter = readln().toInt() - 1
        if (moveCounter < pickedCounter) {
            if (squares[moveCounter] != " ") {
                println("")
                println("You have made an invalid choice".red())
                println("")
                showSquares()
                continue
            } else break
        } else
            println("")
        println("You have made an invalid choice".red())
        println("")
        continue


    }
    if (moveCounter == 0) {
        if (squares[pickedCounter] == blackSquare) {
            squares[pickedCounter] = blankSquare
            wins ++
        } else {
            squares[pickedCounter] = blankSquare
        }
    } else {
        if (squares[pickedCounter] == whiteSquare) {
            squares[pickedCounter] = blankSquare
            squares[moveCounter] = "X"
        } else
            squares[moveCounter] = "O"
        squares[pickedCounter] = blankSquare
    }
    showSquares()
}
fun winCondition(){
    println("123")
    wins = 1
}
//val place1 = squares[pickedCounter]
//val place2 = squares[moveCounter]
//
//squares[pickedCounter] = place2
//squares[moveCounter] = place1