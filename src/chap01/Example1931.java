package chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example1931 {

	public void main(String[] args) throws IOException {
	
	input();
	
	}
	
	public void input() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String first = br.readLine();
		
		StringTokenizer st = new StringTokenizer(first, " _");
		
		String N = st.nextToken();
		String M = st.nextToken();
		String V = st.nextToken();
		
	}

	public void output() {
		
	}
}
