package PROGRAMMERS.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution4 {

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            List<Integer> list = new ArrayList<>();

            int start = commands[i][0];
            int end = commands[i][1];
            int K = commands[i][2];

            for (int j = start - 1; j <= end - 1; j++) {
                list.add(array[j]);
            }

            List<Integer> sorted_list = list.stream().sorted().collect(Collectors.toList());
            Integer result = sorted_list.get(K - 1);
            answer[i] = result;
        }
        return answer;
    }
}
