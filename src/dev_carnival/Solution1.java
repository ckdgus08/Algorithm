package dev_carnival;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, " ");

        List<People> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] split = br.readLine().split(" ");

        int index = 1;

        for (int i = k - 1; i < N; i++) {
            int max = Integer.parseInt(split[i]);
            list.add(new People(i + 1, index++, max));
        }

        for (int i = 0; i < k - 1; i++) {
            int max = Integer.parseInt(split[i]);
            list.add(new People(i + 1, index++, max));
        }

        List<People> collect = list.stream().sorted((o1, o2) -> {
            if (o1.max < o2.max) {
                return -1;
            } else if (o1.max == o2.max) {
                if (o1.temp_index < o2.temp_index)
                    return -1;
            }
            return 1;
        }).collect(Collectors.toList());

        for (People people : collect) {
            System.out.print(people.index + " ");
        }
    }

    static class People {
        int index;
        int temp_index;
        int max;

        public People(int index, int temp_index, int max) {
            this.index = index;
            this.temp_index = temp_index;
            this.max = max;
        }
    }
}
