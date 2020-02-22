package E2020_02_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P15654 {

	static int N, M;
	static ArrayList list = new ArrayList<Integer>();
	static boolean[] visited;
	static int[] temp;
	static String result = "";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		str = br.readLine();
		st = new StringTokenizer(str, " ");

		for (int i = 0; N > i; ++i) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		visited = new boolean[8];
		temp = new int[M];

		makePermutation(M, 0, temp, visited);

	}

	public static void makePermutation(int M, int current, int temp[], boolean visited[]) {
		if (current == M) {
			for (int i = 0; M > i; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println("");
			return;
		}
		for (int i = 0; N > i; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[current] = (int) list.get(i);
				makePermutation(M, current + 1, temp, visited);
				visited[i] = false;
			}
		}
	}
}
