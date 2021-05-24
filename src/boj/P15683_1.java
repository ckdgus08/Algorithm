//package E2020_02_22;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class P15683_1 {
//
//	/*
//	 * ù° �ٿ� ���� ���� N(2 �� N �� 11)�� �־�����.
//	 *  ��° �ٿ��� A1, A2, ..., AN�� �־�����.
//	 *  (1 �� Ai �� 100) ��° �ٿ��� ���� N-1�� 4���� ������ �־����µ�,
//	 *  ���ʴ�� ����(+)�� ����, ����(-)�� ����, ����(��)�� ����, ������(��)�� �����̴�.
//	 *  ���
//	 *  ù° �ٿ� ���� �� �ִ� ���� ����� �ִ���, ��° �ٿ��� �ּڰ��� ����Ѵ�.
//	 *  �ִ񰪰� �ּڰ��� �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ���� ����� ������ �Է¸� �־�����.
//	 *  ����, �տ������� ������� ��, �߰��� ���Ǵ� ���� ����� �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ����.
//	 */
//
//	static int N, min, max, d, q, g, n;
//	static int[] arr;
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		String str = br.readLine();
//
//		StringTokenizer st = new StringTokenizer(str, " ");
//
//		N = Integer.parseInt(st.nextToken());
//		arr = new int[N];
//
//		str = br.readLine();
//		for (int i = 0; N > i; ++i) {
//			st = new StringTokenizer(str, " ");
//				arr[i] = Integer.parseInt(st.nextToken());
//			}
//
//		str = br.readLine();
//		for(int i = 0; 4 > i ; ++i) {
//			st = new StringTokenizer(str, " ");
//			d =  Integer.parseInt(st.nextToken());
//			q =  Integer.parseInt(st.nextToken());
//			g =  Integer.parseInt(st.nextToken());
//			n =  Integer.parseInt(st.nextToken());
//		} // �Է�
//
//	}
//
//	public static void calculate() {
//
//
//		arr[]
//	}
//
//	public static void makePermutation(int N, int current, int[] temp, boolean[] visited) {
//
//		if(current == N) {
//			for(int i = 0 ; N > i ; ++i) {
//
//			}
//			return;
//		}
//		for (int i = 0; N > i; i++) {
//			if (!visited[i]) {
//				visited[i] = true;
//				temp[current] = (int) list.get(i);
//				makePermutation(N, current + 1, temp, visited);
//				visited[i] = false;
//			}
//		}
//
//		}
//
//
//	}
//
//	// 2
//	// 5 6					30
//	// 0 0 1 0				30
//
//
//
//
//
//
//
//}
