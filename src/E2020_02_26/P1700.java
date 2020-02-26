package E2020_02_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1700 {

	static int N, K, count, min, change, temp ,temp1;
	static int[] arr, con, number, last;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		str = br.readLine();
		st = new StringTokenizer(str, " ");
		arr = new int[K];
		con = new int[N];
		number = new int[K + 1];
		last = new int[K+1];
		min = 0;
		temp1 = N;
		change = 0;
		for (int i = 0; K > i; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			number[arr[i]]++;
		}
		
		a:
		for (int i = 0; K > i; ++i) {	// 콘센트에서 빈 곳에 꼽기 + 이미 있으면 넘기기
			for (int j = 0; N > j; ++j) {
				if(con[N-1]!=0) break a;
				if (con[j] == 0) {
					con[j] = arr[i];
					number[arr[i]]--;
					break;
				} else if(con[j] == arr[i]) {
					number[arr[i]]--;
					temp1++;
					break;
				}
			}
		}
		
		for (int i = temp1 ; K > i; ++i) {
			for (int j = 0; N > j; ++j) {
				if (con[j] == arr[i]) {
					temp = 0;
					min = 0;
					for( int q = 0 ; K >= q ; ++q) {
						last[q] = 0;
					}
					number[arr[i]]--;
					break;
				} else {
					++temp;
				}
			}
			if (temp > 0) {
				getlast(i);
				for (int j = 0; N > j; ++j) {
					if (number[con[j]] == 0) {
						change = j;
						break;
					} else {
						if( min <= last[con[j]] ) {
							min = last[con[j]];
							change = j;
						}
						
					}
				}

				con[change] = arr[i];
				count++;
				number[arr[i]]--;
				min = 0;
				
				for( int q = 0 ; K >= q ; ++q) {
					last[q] = 0;
				}

			}
		}
		System.out.print(count);
	}
	
	public static void getlast(int a) {
		
		for(int i=a; K>i;++i) {
			if(last[arr[i]] == 0) {
			last[arr[i]] = i;
			}
		}
		
	}

}
