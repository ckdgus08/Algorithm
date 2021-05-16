package PROGRAMMERS.level1;

public class Solution {

    public boolean solution(int x) {

        String str = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        if (x % sum == 0)
            return true;
        else
            return false;

    }
}
