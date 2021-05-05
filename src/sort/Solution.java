package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {


    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int temp = splitAndSort(array, commands[i][0], commands[i][1], commands[i][2]);
            answer[i] = temp;
        }

        return answer;
    }

    public int splitAndSort(int[] array, int start, int end, int index) {

        List<Integer> list = new ArrayList<>();

        for (int i = start - 1; i < end; i++) {
            list.add(array[i]);
        }

        return list.stream().sorted().collect(Collectors.toList()).get(index - 1);
    }
}
