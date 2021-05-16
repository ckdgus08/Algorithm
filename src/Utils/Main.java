package Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 4, 5};
        int output[] = new int[arr.length];
        boolean visited[] = new boolean[arr.length];
        int n = arr.length;
        int r = 3;

        순열 순열 = new 순열();
        List<String> perm = 순열.perm(arr, output, visited, 0, n, r);

        중복순열 중복순열 = new 중복순열();

        List<String> perm1 = 중복순열.perm(arr, output, 0, n, r);

        조합 조합 = new 조합();
        List<String> comb = 조합.comb(arr, output, visited, 0, n, r);

        중복조합 중복조합 = new 중복조합();

        중복조합.perm(arr, output, 1, n, 2, 0);

        System.out.println("perm = " + perm);

    }
}
