package E2020_02_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {
	
	static int N,K,result;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i = 0 ; N > i ; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = N - 1 ; 0 <= i ; --i ) {
			while( K >= arr[i]) {
				K = K - arr[i];
				++result;
			}
		}
		System.out.print(result);
		
	}

}
