package kakao2019_intern;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {


    // 1. s 문자열 List<String> 형태로 파싱
    // 2. 길이 순으로 정렬
    // 3. , 기준으로 파싱
    // 4. 순서대로 나열하기

    public int[] solution(String s) {

        List<Integer> elements = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        List<String> sorted = Arrays.stream(s.substring(2, s.length() - 2)
                .split("\\},\\{"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        for (String s1 : sorted) {
            for (String s2 : s1.split(",")) {
                elements.add(Integer.parseInt(s2));
            }
        }

        for (Integer element : elements) {
            if (set.add(element)) {
                answer.add(element);
            }
        }

        return Arrays.stream(answer.stream().toArray()).mapToInt(i -> (int) i).toArray();
    }

}
