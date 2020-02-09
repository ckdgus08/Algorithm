package E2020_02_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {

	static int N;
	static int M;
	static int[] arr;
	static boolean[][] con ;
	static boolean[] visited ;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fir = br.readLine();

		StringTokenizer st = new StringTokenizer(fir, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N*M+1];
		con = new boolean[N*M+1][N*M+1];
		visited = new boolean[N*M+1];

		for (int n = 0; N > n; n++) {
			String sen = br.readLine();
			for (int m = 0; M > m; m++) {
				String se = sen.substring(m, m + 1);
				if (se.equals("1"))
					arr[M*n+m] = M*n+m;
			}
		}

		for (int n = 0; N > n; n++) {
			for (int m = 0; M > m; m++) {
				if (m == M - 1)
					break;
				if (n == N - 1)
					break;
				if (arr[M*n+m] != 0 && arr[M*n+m+1] != 0) {
					con[M*n+m][M*n+m+1] = true;
				}
				if (arr[M*n+m] != 0 && arr[M*(n+1)+m] != 0) {
					con[M*n+m][M*(n+1)+m] = true;
				}
			}
		}
		
		bfs(0);

	}

	public static void bfs(int start) {

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(arr[start]);
		visited[start] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			count = +1;
			if(now == N*M-1) {
				break;
				}
			else {
				for(int i = 1 ; N*M >= i;i++) {
					if (con[now][i] == true && visited[i] != true) {
						q.add(arr[i]);
						visited[i] = true;
					}
			}
			
			}

		}
		System.out.println(count);
		

	}

}
