package kakao2019_intern;

import java.util.ArrayList;
import java.util.List;

class Solution {


    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] depth_array = new int[board[0].length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < depth_array.length; i++) {
            depth_array[i] = -1;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (depth_array[j] == -1 && board[i][j] != 0)
                    depth_array[j] = i;
            }
        }

        for (int move_line : moves) {
            int depth = depth_array[move_line - 1];
            if (depth == -1 || depth == board.length) continue;
            int doll = board[depth][move_line - 1];
            if (doll != 0) {
                depth_array[move_line - 1]++;
                list.add(doll);
            }
        }

        int index = 0;
        while (true) {
            if (list.size() == 0 || index == list.size() - 1) break;
            if (list.get(index) == list.get(index + 1)) {
                list.remove(index);
                list.remove(index);
                answer = answer + 2;
                index = 0;
                continue;
            }
            index++;
        }

        return answer;
    }
}