package Utils;

import java.util.ArrayList;
import java.util.List;

public class 순열 {

    // 중복 X, 순서가 있음.
    // N개 중에 R개 나열
    // ex :
    // 4개 중에 3개 나열
    // 123 124 132 134 142 143
    // 213 214

    List<String> list = new ArrayList<>();

    List<String> perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < r; i++) {
                temp.append(output[i]);
            }
            list.add(temp.toString());
            return list;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
        return list;
    }
}
