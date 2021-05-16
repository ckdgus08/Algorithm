package Utils;

import java.util.ArrayList;
import java.util.List;

public class 조합 {

    // N개 중에 순서 상관없이 R개
    // 12 13 14 23 24 34
    List<String> list = new ArrayList<>();

    List<String> comb(int[] arr, int[] output, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    temp.append(arr[i]);
                }
            }
            list.add(temp.toString());
            return list;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(arr, output, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
        return list;
    }
}