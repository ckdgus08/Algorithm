package E2020_02_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15683_1 {

	/*
	 * 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다.
	 *  둘째 줄에는 A1, A2, ..., AN이 주어진다. 
	 *  (1 ≤ Ai ≤ 100) 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 
	 *  차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다. 
	 *  출력
	 *  첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다. 
	 *  최댓값과 최솟값이 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 
	 *  또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.
	 */

	static int N, min, max, d, q, g, n;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		str = br.readLine();
		for (int i = 0; N > i; ++i) {
			st = new StringTokenizer(str, " ");
				arr[i] = Integer.parseInt(st.nextToken());
			}
		
		str = br.readLine();
		for(int i = 0; 4 > i ; ++i) {
			st = new StringTokenizer(str, " ");
			d =  Integer.parseInt(st.nextToken());
			q =  Integer.parseInt(st.nextToken());
			g =  Integer.parseInt(st.nextToken());
			n =  Integer.parseInt(st.nextToken());
		} // 입력

	}
	
	public static void calculate() {
		
		
		arr[]
	}
	
	public static void makePermutation(int N, int current, int[] temp, boolean[] visited) {
	
		if(current == N) {
			for(int i = 0 ; N > i ; ++i) {
				
			}
			return;
		} 
		for (int i = 0; N > i; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[current] = (int) list.get(i);
				makePermutation(N, current + 1, temp, visited);
				visited[i] = false;
			}
		}
			
		}
		
		
	}
	
	// 2
	// 5 6					30
	// 0 0 1 0				30
	
	
	
	
	
	
	
}
