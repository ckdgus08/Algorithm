package E2020_02_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931 {

	static int N, count, temp;
	static int[][] start;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		start = new int[N][2];
		for (int i = 0; N > i; ++i) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");

			start[i][0] = Integer.parseInt(st.nextToken());
			start[i][1] = Integer.parseInt(st.nextToken());
		}
		Comparator<int[]> endSort = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) { // 끝나는 시간이 같을때
					return o1[0] - o2[0]; // 시작시간이 낮은 순서대로 정렬
				} else { // 끝나는 시간이 같으면
					return o1[1] - o2[1]; // 끝나는 시간 순서로 정렬
				}
			}
		};

		Arrays.sort(start, endSort);
		temp = start[0][1];
		count = 1;
		for (int i = 1; N > i; i++) {
			if (start[i][0] >= temp) {
				count++;
				temp = start[i][1];
			}
		}
		System.out.print(count);

	}

}
