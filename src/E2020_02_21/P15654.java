package E2020_02_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P15654 {
	
	static int N,M,count;
	static ArrayList list = new ArrayList<Integer>();
	static boolean[] check;
	static String result = "";


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		st = new StringTokenizer(str, " ");

		for(int i = 0; N > i ; ++i) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		count = 0;
		
		check = new boolean[8];
		
		make();
		 
		}
	
	public static void make() {
		for(int i = 0 ; N > i ; ++i) {
			check[i]= true;
			result += list.get(i);
			++count;
			while(count != M) {
				if(i!=N-1) {
				check[i+1] = true;
				result += list.get(i+1);
				++count;
				}
			}
			count = 0 ;
			check[i] = false;
			check[i+1] = false;
			System.out.println(result);
			result = "";
		}
	}
	

		
	}

