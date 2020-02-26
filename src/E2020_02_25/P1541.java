package E2020_02_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1541 {

	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		result = 0;

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, "- ");

		str = st.nextToken();
		StringTokenizer st1 = new StringTokenizer(str, "+ ");
		while (st1.hasMoreTokens()) {
			int ele = Integer.parseInt(st1.nextToken());
			result += ele;
		}
		
		while (st.hasMoreTokens()) {
			str = st.nextToken();
			st1 = new StringTokenizer(str, "+ ");
			while (st1.hasMoreTokens()) {
				int ele1 = Integer.parseInt(st1.nextToken());
				result -= ele1;
			}

		}
		System.out.print(result);
	}

}
