package E2020_02_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2467 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		int[] arr = new int[N];
		int answer = 2000000001;
		int x = 0;
		int y = 0;
		
		for(int i = 0 ; N > i ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = N-1;
		for(int j = 0; N > j ; j++) {
			while(Math.abs(arr[j] + arr[k]) > Math.abs(arr[j] + arr[k-1]) && j!=k-1 && j!=k) k--;
				if(j==k) break;
				if( Math.abs(arr[j] + arr[k]) < Math.abs(answer)) {
					answer = arr[j] + arr[k];
					x = arr[j];
					y = arr[k];
				}
			}
		System.out.println(x +" " + y);
		}
	}
