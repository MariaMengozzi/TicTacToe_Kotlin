import kotlin.math.pow

class Board (private val n: Int){
    private val empty = "___" //it is a string. a variable used to print a character
    private var moveCount = 0
    var isGameOver = false
    private var board = Array(n){Array(n){empty} } //bi-dimensional array in which the inner represents the columns

    //functions
    private fun resetBoard(){
        board = Array(n){Array(n){empty} }
    }


    fun resetGame(){
        resetBoard()
        isGameOver = false
        moveCount = 0
    }

    fun placePiece(x: Int, y:Int, move: String){
        if(!isGameOver
            && isPositionValid(x, y)
            && board[x][y] == empty){
            moveCount += 1
            board [x][y] = move
            printBoard()
            isGameOver = isWinningMove(x, y, move) || isDraw()
            if (isGameOver && !isDraw()){
                println("$move is the Winner!")
            } else if (isDraw()){
                println("Draw!")
            }
        }
    }

    fun printBoard(){
        board.forEach { row ->
            row.forEach { element ->
                if (element == empty)
                    print("|$element|")
                else
                    print("| $element |")
            }
            println()
        }
        println()
    }

    private fun isPositionValid(x:Int, y: Int): Boolean{
        return ((x in 0 until n) && (y in 0 until n))
    }

    private fun isWinningMove(x: Int, y:Int, move: String): Boolean{
        //check the row
        for (i in 0 until n){
            if (board[x][i] != move)
                break
            if (i == n-1) {
                return true
            }
        }

        //check the col
        for (i in 0 until n){
            if (board[i][y] != move)
                break
            if (i == n-1) {
                return true
            }
        }

        //check the diagonal \
        for (i in 0 until n){
            if (board[i][i] != move)
                break
            if (i == n-1) {
                return true
            }
        }

        //check the diagonal /
        for (i in 0 until n){
            if (board[i][(n-1)-i] != move)
                break
            if (i == n-1) {
                return true
            }
        }

        return false
    }

    private fun isDraw():Boolean {
        return (moveCount == (n.toDouble().pow(2) - 1).toInt())
    }


}