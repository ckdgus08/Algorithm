package PROGRAMMERS.level2;

public class Solution {

    public int solution(int n, int a, int b) {

        boolean temp_a;
        boolean temp_b;
        // right == true, left == false

        int answer = 0;
        int temp = n;
        while (temp != 1) {
            temp = temp / 2;
            answer++;
        }

        while (n != 1) {

            if (a > n / 2)
                temp_a = true;
            else
                temp_a = false;

            if (b > n / 2)
                temp_b = true;
            else
                temp_b = false;

            if (temp_a != temp_b) {
                break;
            } else if (temp_a) {
                int temp_value = n / 2;
                n = n / 2;
                a = a - temp_value;
                b = b - temp_value;
            } else n /= 2;
            answer--;
        }
        return answer;
    }
}
