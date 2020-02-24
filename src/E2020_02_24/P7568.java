package E2020_02_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7568 {

	static int N;
	static int[] num;
	static int[] h;
	static int[] w;
	static int rank;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		N = Integer.parseInt(str);

		num = new int[N];
		h = new int[N];
		w = new int[N];
		rank = 1;
		for (int i = 0; N > i; ++i) {
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			num[i] = i;
			w[i] = Integer.parseInt(st.nextToken());
			h[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0 ; w.length > i ; ++i) {
			for (int j = 0 ; w.length > j; ++j) {
				if (w[i] < w[j]) {
					if (h[i] < h[j]) {
						rank++;
					}
				}
			}
			System.out.print(rank + " ");
			rank = 1;
		}
	}
}
