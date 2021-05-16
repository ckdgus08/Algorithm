package Utils;

import java.util.ArrayList;
import java.util.List;

public class 중복순열 {

    // 중복 허락, 순서가 있음.
    // N개 중에 R개 나열
    // ex :
    // 4개 중에 3개 나열
    // 111, 112, 113, 114 ...
    // 222, 221, 223, 224 ...

    List<String> list = new ArrayList<>();

    List<String> perm(int[] arr, int[] output, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < r; i++) {
                temp.append(output[i]);
            }
            list.add(temp.toString());
            return list;
        }
        for (int i = 0; i < n; i++) {
            output[depth] = arr[i];
            perm(arr, output, depth + 1, n, r);
        }
        return list;
    }
}
