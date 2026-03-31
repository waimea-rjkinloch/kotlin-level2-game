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
fun main() {
    println("╭─────────────╮")
    println("│  Pinned \uD83D\uDCCC   │")
    println("╰─────────────╯")

    gameInstructions()
    createSquares()
    showSquares()
    createWhiteCounters()
    createBlackCounter()
    getUsersNames()
    while ()
    mainGameLoop()

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
        squares.add("-")
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
        print("│ ${square.padEnd(length = 3)}")
    }
    println("│")

    print("└────")
    print("┴────".repeat(n = squares.size - 1))
    println("┘")
}
fun createWhiteCounters() {
    repeat(4)  {
        var randomSpace = (1..15)
        val whiteCounter = "O"

        }
    }

fun createBlackCounter() {

}
fun getUsersNames(){
    var user1: String
    while (true) {
        print("Player 1 whats your name? ")
        user1 = readln()
        if (user1.isNotBlank())break
    }
    var user2: String
    while (true) {
        print("Player 2 what about you? ")
        user2 = readln()
        if(user2.isNotBlank())break
    }
    println("Welcome $user1 and $user2 to Pinned \uD83D\uDCCC")
}
fun mainGameLoop(){

}