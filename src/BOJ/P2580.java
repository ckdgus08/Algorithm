package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2580 {

    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < 9; j++)
                board[i][j] = Integer.parseInt(split[j]);
        }

        for (int i = 0; i < args.length; i++) {

        }

        go(0, 0);


    }

    static void go(int row, int col) {

        if (col == 9) {
            go(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++)
                if (check(row, col, i)) {
                    board[row][col] = i;
                    go(row, col + 1);
                }

            board[row][col] = 0;
            return;
        }
        go(row, col + 1);
    }

    static boolean check(int row, int col, int value) {

        for (int i = 0; i < 9; i++)
            if (board[row][i] == value)
                return false;

        for (int i = 0; i < 9; i++)
            if (board[i][col] == value)
                return false;

        int new_row = (row / 3) * 3;
        int new_col = (col / 3) * 3;

        for (int i = new_row; i < new_row + 3; i++)
            for (int j = new_col; j < new_col + 3; j++)
                if (board[new_row][new_col] == value)
                    return false;
        return true;
    }


}
