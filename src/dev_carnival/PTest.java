package dev_carnival;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class PTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int N, K, index = 0, min = Integer.MAX_VALUE, result = 0;
        StringTokenizer st = new StringTokenizer(input, " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            array[i] = temp;
            if (temp < min) {
                min = temp;
                index = i;
            }
        }

        int left_count = index;
        int right_count = N - (index + 1);

        result += left_count / (K - 1);
        result += right_count / (K - 1);

        int temp_div = left_count % (K - 1) + right_count % (K - 1);

        if (temp_div == 0) {

        } else if (temp_div <= K - 1) {
            result++;
        } else {
            result += 2;
        }

        System.out.println(result);
    }
}