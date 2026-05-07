import java.awt.Color.white
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction
/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Pinned
 * Project Author: Robbie Kinloch
 * GitHub Repo: https://github.com/waimea-rjkinloch/kotlin-level2-game
 * ---------------------------------------------------------------------
 * Notes:
 * =====================================================================
 */
//list of global variables
val squares = mutableListOf<String>()
val blankSquare = " "
val whiteSquare = "X"
val blackSquare = "O"
var user1 = " "
var user2 = " "
var errorMove = 0
var userOneWins = 0
var userTwoWins = 0
//start of process but not actual game(beginning)
fun main() {
    println("╭─────────────╮")
    println("│  Pinned 📌  │")
    println("╰─────────────╯")
    gameInstructions()
    getUsersNames()
}
//beginning of the actual game process
fun startOfGame(){
    squares.clear()
    createSquares()
    createWhiteCounters()
    createBlackCounter()
    showSquares()
    //Main game loop
    while(true) {
        playerOneTurn()
        if (userOneWins >= 1){
            println("$user1, congratulations you've won!")
            userOneWins = 0

            println("would you like to play again? Y/N ")
            var restartYN = readln()

            when (restartYN) {
                "Y", "y" -> startOfGame()
                "N", "n" -> kotlin.system.exitProcess(0)
            }
        }

        playerTwoTurn()
        if (userTwoWins >= 1){
            println("$user2, congratulations you've won!")
            userTwoWins = 0

            print("would you like to play again? Y/N ")
            var restartYN = readln()

            when (restartYN) {
                "Y", "y" -> startOfGame()
                "N", "n" -> kotlin.system.exitProcess(0)
            }
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
//creating the board
fun createSquares() {
    while(squares.size < 16)
        squares.add(" ")
}
//showing the board
fun showSquares(){
    println("")
    if (squares.size == 16) {
        println("  1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16")
    }
    print("┌────")
    print("┬────".repeat(squares.size - 1))
    println("┐")

    for (square in squares) {
        print("│ ${square.padEnd(3).padStart(3)}")
    }
    println("│")

    print("└────")
    print("┴────".repeat(squares.size - 1))
    println("┘")
}
//creating white counters
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
//creating black counters
fun createBlackCounter() {
    while (true) {
        val random = (1..15).random()
        if (squares[random] == blankSquare) {
            squares[random] = blackSquare
            break
        }
    }
}
//getting each users name
fun getUsersNames(){
    while (true) {
        println("")
        print("Player 1 whats your name? ".blue())
        user1 = readln()
        if (user1.isNotBlank())break
    }
    while (true) {
        println("")
        print("Player 2 what about you? ".green())
        user2 = readln()
        if(user2.isNotBlank())break
    }
    println("")
    println("Welcome $user1 and $user2 to Pinned 📌")
    startOfGame()
}
//user ones turn
fun playerOneTurn() {
    errorMove = 0
    var moveCounter = 0
    var pickedCounter = 0
    //asking which counter user one would like to pick
    while (true) {
        print("$user1 which square would you like to move? ")
        pickedCounter = readln().toInt() - 1

        if (squares[pickedCounter] == " ") {
            println("")
            println("You have made an invalid choice, you can only pick counters".red())
            println("")
            println("Try again")
            showSquares()
            continue
        }
        break
    }

    // Remove counter on square one and allowing for win
    if (pickedCounter == 0) {
        if (squares[pickedCounter] == blackSquare) {
            userOneWins++
        }
        squares[pickedCounter] = blankSquare
        showSquares()
        return
    }
    //asking where user one would like to move their selected counter
    while (true) {
        var counterBlocked = false

        print("$user1 where would you like to move this counter? ")
        moveCounter = readln().toInt() - 1
        //preventing the counter from going right
        if (moveCounter >= pickedCounter) {
            println("")
            println("You have made an invalid choice, You must move left".red())
            println("")
            println("Try again")
            showSquares()
            continue
        }
        //only allowing counters to be moved onto blank squares
        if (squares[moveCounter] != " ") {
            println("")
            println("You have made an invalid choice, That square is not empty".red())
            println("")
            println("Try again")
            showSquares()
            continue
        }
        //not allowing counter to jump over other counters
        for (i in (moveCounter + 1) until pickedCounter) {
            if (squares[i] == "X" || squares[i] == "O") {
                counterBlocked = true
            }
        }

        if (counterBlocked) {
            println("")
            println("You have made an invalid choice, You cannot jump over counters".red())
            println("")
            println("Try again")
            showSquares()
            continue
        }
        //actually moving the counters
        val counter = squares[pickedCounter]
        squares[pickedCounter] = blankSquare
        squares[moveCounter] = counter

        break
    }

    showSquares()
}
//repeat of user one but slightly modified to suit user two
fun playerTwoTurn(){
    errorMove = 0
    var moveCounter = 0
    var pickedCounter = 0

    while (true) {
        print("$user2 which square would you like to move? ")
        pickedCounter = readln().toInt() - 1

        if (squares[pickedCounter] == " ") {
            println("")
            println("You have made an invalid choice, you must pick a white or black counter".red())
            println("")
            showSquares()
            continue
        }
        break
    }

    // REMOVE
    if (pickedCounter == 0) {
        if (squares[pickedCounter] == blackSquare) {
            userTwoWins++
        }
        squares[pickedCounter] = blankSquare
        showSquares()
        return
    }

    while (true) {
        var counterBlocked = false

        print("$user2 where would you like to move this counter? ")
        moveCounter = readln().toInt() - 1

        if (moveCounter >= pickedCounter) {
            println("You have made an invalid choice, You must move left".red())
            continue
        }

        if (squares[moveCounter] != " ") {
            println("You have made an invalid choice, That square is not empty".red())
            continue
        }

        for (i in (moveCounter + 1) until pickedCounter) {
            if (squares[i] == "X" || squares[i] == "O") {
                counterBlocked = true
            }
        }

        if (counterBlocked) {
            println("You have made an invalid choice, You cannot jump over counters".red())
            continue
        }

        val piece = squares[pickedCounter]
        squares[pickedCounter] = blankSquare
        squares[moveCounter] = piece

        break
    }

    showSquares()
}