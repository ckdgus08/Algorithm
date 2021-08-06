package PROGRAMMERS.level1

class Solution크레인인형뽑기게임 {

    lateinit var board: Array<IntArray>

    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        this.board = board

        val pickedBlocks = moves
            .map { number -> pick(number - 1) }
            .filter { number -> number != 0 }
            .toMutableList()

        var result = 0
        for (block in pickedBlocks.indices) {
            var tempBlockIndex = 0
            for (index in 1 until pickedBlocks.size) {
                if (pickedBlocks[index] == 0)
                    continue
                if (pickedBlocks[index] == pickedBlocks[tempBlockIndex]) {
                    pickedBlocks[tempBlockIndex] = 0
                    pickedBlocks[index] = 0
                    result += 2
                    break
                }
                tempBlockIndex = index
            }
        }

        return result
    }

    private fun pick(position: Int): Int {

        var tempBlock = 0

        for (xLineIndex in board.indices) {
            if (board[xLineIndex][position] != 0) {
                tempBlock = board[xLineIndex][position]
                board[xLineIndex][position] = 0
                return tempBlock
            }
        }
        return tempBlock
    }
}