package E2020_02_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2798  {
	
	static int N,M,result,diff;
	static int[] arr = new int[100];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");
		
		for(int i = 0 ; N > i ; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		result = 0;
		diff = 300000;
		
		for(int i = 0; N > i ; ++i) 
			for(int j = i+1 ; N > j ; ++j)
				for( int k = j+1 ; N > k ; ++k) {
					if( M >= (arr[i]+arr[j]+arr[k]) && diff >= M- (arr[i]+arr[j]+arr[k])) {
						diff = M-(arr[i]+arr[j]+arr[k]);
						result = arr[i]+arr[j]+arr[k];
					} 
				}
		System.out.println(result);
		
	}

}
