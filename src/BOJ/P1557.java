package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1557 {

    static long K, low, high;
    static int[] mobius;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        low = 0;
        high = 2000000000;
        mobius = new int[200001];

        mobius[1] = 1;
        for (int i = 1; i <= 200000; i++)
            if (mobius[i] != 0)
                for (int j = 2 * i; j <= 200000; j += i)
                    mobius[j] -= mobius[i];

        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (squareNoNo(mid) < K)
                low = mid;
            else high = mid;
        }

        System.out.print(high);
    }

    static long squareNoNo(long n) {
        long k = 0;
        for (int i = 1; i * i <= n; ++i)
            k += (mobius[i] * (n / (i * i)));
        return k;
    }
}
