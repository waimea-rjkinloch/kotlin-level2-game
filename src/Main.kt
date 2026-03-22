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

    createSquares()
    showSquares()
    createCounters()
    showCounters()
}

fun createSquares() {
    while(squares.size < 16)
        squares.add("")
}

fun showSquares(){
        println("")
        if (squares.size == 16) {
            println("   1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16")
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
fun createCounters() {
    val whiteCounters = "⚪"
    val blackCounter = "⚫"
    repeat(4){
        
    }
}
fun showCounters() {

}