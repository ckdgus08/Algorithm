package kakao_blind;

import java.util.Arrays;

public class Solution2 {
    public int solution(String dartResult) {

        int[] point = new int[3];

        int index = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            String str = dartResult.substring(i, i + 1);
            if (str.matches("[0-9]")) {
                index++;
                point[index] = Integer.parseInt(str);
                str = dartResult.substring(i + 1, i + 2);
                if (str.equals("0")) {
                    point[index] = 10;
                    i++;
                }
            } else if (dartResult.charAt(i) == 'D') {
                point[index] *= point[index];
            } else if (dartResult.charAt(i) == 'T') {
                point[index] *= point[index] * point[index];
            } else if (dartResult.charAt(i) == '*') {
                if (index != 0)
                    point[index - 1] *= 2;
                point[index] *= 2;
            } else if (dartResult.charAt(i) == '#') {
                point[index] *= -1;
            }
        }

        return Arrays.stream(point).sum();
    }
}
