import java.util.Scanner

//tutorial: https://www.youtube.com/watch?v=BZrLS8zzbqA

private var board = Board(0)
private const val player1 = "X"
private const val player2 = "O"
private var currentPlayer = ""
private var answer = ""

fun main(){
    println("Please enter size of your board: ")
    val scanner = Scanner(System.`in`)
    val size = Integer.parseInt(scanner.nextLine())

    board = Board(size)
    board.printBoard()

    while(!board.isGameOver){
        takeTurns()
        println("$currentPlayer's turn")
        println("Enter row number: ")
        val row = Integer.parseInt(scanner.nextLine())
        println("Enter column number: ")
        val col = Integer.parseInt(scanner.nextLine())

        board.placePiece(row-1, col-1, currentPlayer)
        if (board.isGameOver){
            println("Do you want to play again? (Type y or n)")
            answer = scanner.nextLine()
            if(isPlayingAgain(answer)){
                board.resetGame()
                answer = ""
            }
        }

    }


}
fun takeTurns() {
    currentPlayer = if (player1 == currentPlayer) {
        player2
    } else {
        player1
    }
}

fun isPlayingAgain(answer: String): Boolean{
    return answer.equals("y", ignoreCase = true)
            || answer.equals("yes", ignoreCase = true)
}