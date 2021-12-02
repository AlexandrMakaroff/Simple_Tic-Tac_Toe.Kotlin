package tictactoe

import java.lang.NumberFormatException

fun analysis(data: MutableList<Char>, c: Char): Int {
    if (data[0] == c && data[1] == c && data[2] == c ||
        data[3] == c && data[4] == c && data[5] == c ||
        data[6] == c && data[7] == c && data[8] == c ||
        data[0] == c && data[3] == c && data[6] == c ||
        data[1] == c && data[4] == c && data[7] == c ||
        data[2] == c && data[5] == c && data[8] == c ||
        data[0] == c && data[4] == c && data[8] == c ||
        data[6] == c && data[4] == c && data[2] == c) {
        println("$c wins")
        return 1
    }
    for (i in data) {
        if (i == '_') return 0
    }
    println("Draw")
    return 1
}

fun draw(input: MutableList<Char>) {
    println("---------")
    println("| ${input[0]} ${input[1]} ${input[2]} |")
    println("| ${input[3]} ${input[4]} ${input[5]} |")
    println("| ${input[6]} ${input[7]} ${input[8]} |")
    println("---------")
}

fun main() {
    val input = "_________".toMutableList()
    var numOfMovies = 0

    draw(input)
    while (true) {
        print("Enter the coordinates: ")
        try {
            val motion = readLine()!!.split(" ").map { it.toInt() }
            val i = (motion[0] - 1) * 3 + (motion[1] - 1)

            if (motion[0] !in 1..3 || motion[1] !in 1..3) {
                println("Coordinates should be from 1 to 3!")
            } else if (input[i] != '_') {
                println("This cell is occupied! Choose another one!")
            } else {
                numOfMovies++
                input[i] = if (numOfMovies % 2 == 0) 'O' else 'X'
                draw(input)
                if (analysis(input, input[i]) == 1) break
            }
        } catch (e: Exception) {
            println("You should enter numbers!")
        }
    }
}