package PROGRAMMERS.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {

    public String solution(int[] numbers) {
        String answer = "";

        List<String> collect = Arrays.stream(numbers)
                .mapToObj(number -> String.valueOf(number))
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.toList());

        for (String s : collect) {
            answer += s;
        }

        while (answer.length() != 1 && answer.charAt(0) == '0')
            answer = answer.substring(1);

        return answer;
    }

}
