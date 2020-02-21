package E2020_02_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6603 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 1;

		while (N != 0) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			N = Integer.parseInt(st.nextToken());
			arr = new int[13];
			for (int i = 0; N > i; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; N > i; ++i)
				for (int j = i + 1; N > j; ++j)
					for (int k = j + 1; N > k; ++k)
						for (int z = k + 1; N > z; ++z)
							for (int x = z + 1; N > x; ++x)
								for (int q = x + 1; N > q; ++q) {
									System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[z] + " "
											+ arr[x] + " " + arr[q]);

								}
			System.out.println(" ");
		}

	}
}
