package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P18808 {

    static int N;
    static int M;
    static int K;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);
        board = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            String sticker_info = br.readLine();
            String[] split1 = sticker_info.split(" ");
            int x = Integer.parseInt(split1[0]);
            int y = Integer.parseInt(split1[1]);

            boolean[][] temp = new boolean[x][y];

            for (int j = 0; j < x; j++) {
                String[] split2 = br.readLine().split(" ");
                for (int k = 0; k < y; k++) {
                    if (split2[k].equals("1"))
                        temp[j][k] = true;
                }
            }

            for (int q = 0; q <= 270; q = q + 90) {
                boolean[][] rotation = rotation(temp, q);
                int[] ints = canAttached(rotation);
                if (ints[0] != -1 && ints[1] != -1) {
                    for (int j = ints[0]; j < ints[0] + rotation.length; j++) {
                        for (int k = ints[1]; k < ints[1] + rotation[0].length; k++) {
                            if (!board[j][k])
                                board[j][k] = rotation[j - ints[0]][k - ints[1]];
                        }
                    }
                    break;
                }
            }
        }

        int result = 0;
        for (boolean[] booleans : board) {
            for (boolean aBoolean : booleans) {
                if (aBoolean)
                    result++;
            }
        }
        System.out.println(result);
    }

    static boolean[][] rotation(boolean[][] temp, int degree) {
        if (degree == 0) return temp;
        else if (degree == 90) {
            boolean[][] new_temp = new boolean[temp[0].length][temp.length];
            for (int j = 0; j < temp[0].length; j++) {
                for (int i = temp.length - 1; i >= 0; i--) {
                    new_temp[j][temp.length - 1 - i] = temp[i][j];
                }
            }
            return new_temp;

        } else if (degree == 180) {
            boolean[][] new_temp = new boolean[temp.length][temp[0].length];

            for (int i = temp.length - 1; i >= 0; i--) {
                for (int j = temp[0].length - 1; j >= 0; j--) {
                    new_temp[temp.length - 1 - i][temp[0].length - 1 - j] = temp[i][j];
                }
            }
            return new_temp;

        } else {
            boolean[][] new_temp = new boolean[temp[0].length][temp.length];

            for (int j = temp[0].length - 1; j >= 0; j--) {
                for (int i = temp.length - 1; i >= 0; i--) {
                    new_temp[temp[0].length - 1 - j][i] = temp[i][j];
                }
            }
            return new_temp;
        }
    }

    static int[] canAttached(boolean[][] temp) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;

                next:
                for (int k = 0; k < temp.length; k++) {
                    for (int l = 0; l < temp[0].length; l++) {
                        if (i + k >= board.length || j + l >= board[0].length || board[i + k][j + l] && temp[k][l])
                            break next; // 노트북 붙음 + 스티커 있음
                        count++;
                    }
                }
                if (count == temp.length * temp[0].length) return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }
}
