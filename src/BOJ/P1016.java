package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1016 {

    static long min;
    static long max;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        min = Long.parseLong(split[0]);
        max = Long.parseLong(split[1]);
        arr = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = min + (pow - (min % pow)) % pow;

            for (long j = start; j <= max; j += pow) {
                arr[(int) (j - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i])
                count++;
        }

        System.out.print(count);
    }
}
