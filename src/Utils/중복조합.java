package Utils;

import java.util.ArrayList;
import java.util.List;

public class 중복조합 {

    // N개 중에 순서 상관없이 R개
    // 12 13 14 23 24 34
    List<String> list = new ArrayList<>();

    List<String> perm(int[] arr, int[] output, int start, int n, int r, int cnt) {
        if (cnt == r) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                temp.append(output[i]);
            }
            list.add(temp.toString());
            return list;
        }
        for (int i = start - 1; i < n; i++) {
            output[cnt] = arr[i];
            perm(arr, output, i + 1, n, r, cnt + 1);
        }
        return list;
    }
}
