package E2020_02_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BFS1 {

	/*
	 * 4 6 101111 101010 101011 111011
	 */

	static int[] arr;
	static int[][] con;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sen = br.readLine();
		StringTokenizer st = new StringTokenizer(sen, " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N * M+1];
		con = new int[N * M+1][N*M+1];

		// arr 배열에 NODE 순서 붙히기 1 2 3 4 - - - M
		// M+1 M+2 M+3 --- 2M
		// - - - - - N*M
		for (int n = 1; N >= n; n++) {
			String aaa = br.readLine();
			for (int m = 1; M >= m; m++) {
				arr[(n - 1) * M + m] = Integer.parseInt(aaa.substring(m - 1, m));
			}
		}
		
		// 인접행렬 만들기
		for (int j = 1; N - 1 >= j; j++) {
			for (int i = 1; M - 1 >= i; i++) {
				if(arr[j*(N-1)+i] == 1 )
					if(arr[j*(N-1)+i+1] == 1) {
					con[j*(N-1)+i][j*(N-1)+i+1] = 1;
				}
				if(arr[j*(N-1)+i] == 1 ) 
					if(arr[(j+1)*(N-1)+i] == 1) {
					con[j*(N-1)+i][(j+1)*(N-1)+i] = 1;
				}
			}
		}
		
		for (int j = 1; N*M-1  >= j; j++) {
			for (int i = 1; N*M-1  >= i; i++) {
				
				System.out.print(con[j][i]);
			}
			System.out.println(" ");
		}

	}

	public void bfs() {

	}

}
