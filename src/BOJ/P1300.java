package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1300 {

    static int N, K;
    static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long low = 1;
        long high = K;

        while (low <= high) {
            long mid = (low + high) / 2;

            long count = 0;
            for (int i = 1; i <= N; i++)
                count += Math.min(N, mid / i);

            if (count >= K) {
                result = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        System.out.print(result);
    }
}
