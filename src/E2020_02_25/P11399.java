package E2020_02_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399 {

	static int N, result, time;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = 0;
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		for (int i = 0; N > i; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; N > i; ++i) {
			int j = i;
			time = arr[j];
			while (j != 0) {
				j--;
				time += arr[j];
			}
			result = result + time;
		}
		System.out.print(result);

	}
}
