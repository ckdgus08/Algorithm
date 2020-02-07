package E2020_02_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfsdfs2 {

	public static boolean[][] c;
	public static boolean[] v;
	public static String answer = "";

	public void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sen = br.readLine();
		StringTokenizer st = new StringTokenizer(sen, " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		for (int m = 0; M > m; m++) {
			String line = br.readLine();
			st = new StringTokenizer(line, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connect(a, b);
			
			bfs(V,N);
			
			System.out.println(answer);
		}

	}

	public void connect(int i, int j) {
		if (c[i][j] == false) {
			c[i][j] = true;
			c[j][i] = true;
		}
		return;
	}

	public void bfs(int start, int N) {

		Queue q = new LinkedList();

		q.add(start);
		v[start] = true;

		while (!q.isEmpty()) {
			int now = (int) q.poll();
			answer += now + " ";
			for (int i = 0; N > i; i++) {
				if (c[now][i] == true && v[i] == false) {
					q.add(i);
					v[i] = true;
				}
			}
		}
	}

}
