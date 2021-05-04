package DfsBfs;

import java.util.*;

public class Solution {

    Queue<Integer> queue = new LinkedList<>();
    int answer = 0;

    public int solution(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (queue.isEmpty()) {
                queue.add(number);
                queue.add(-number);
            } else {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Integer integer = queue.poll();
                    queue.add(integer + number);
                    queue.add(integer - number);
                }
            }
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (queue.poll() == target)
                answer++;
        }
        return answer;
    }

}