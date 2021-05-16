package PROGRAMMERS.sort;


import java.util.Arrays;

public class Solution3 {

    public int solution(int[] citations) {

        int[] sorted = Arrays.stream(citations).sorted().toArray();

        int index = sorted.length;
        for (int i : sorted) {
            if (i >= index)
                return i;
            index--;
        }
        return -1;
    }

}
