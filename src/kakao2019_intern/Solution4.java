package kakao2019_intern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution4 {

    // TODO: 2021/05/06 17:00


    public long[] solution(long k, long[] room_number) {

        Set<Long> set = new HashSet<>();
        List<Long> list = new ArrayList<>();

        for (long l : room_number) {
            if (set.add(l)) {
                list.add(l);
            } else {
                for (long i = l + 1L; i <= k; i++) {
                    if (set.add(i)) {
                        list.add(i);
                        break;
                    }
                }
            }
        }
        return list.stream().mapToLong(l -> l).toArray();
    }
}
