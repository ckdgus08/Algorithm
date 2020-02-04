package chap01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10989 {
	public static void main(String[] args) throws IOException {

		BufferedReader be = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(be.readLine());
		int[] temp = new int[10001];
		for (int i = 0; i < number; i++) {
			temp[Integer.parseInt(be.readLine())]++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; 10000 > i; i++) {
			if (temp[i] != 0) {
				for (int j = 0; j < temp[i]; j++) {
					bw.write(Integer.toString(i) + "\n");
				}
			}

		}

		bw.close();
		be.close();
	}

}
