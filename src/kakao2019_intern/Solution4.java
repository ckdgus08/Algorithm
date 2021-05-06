package kakao2019_intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {

    // TODO: 2021/05/06 17:00

    Map<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {

        List<Long> answer = new ArrayList<>();

        for (long room : room_number) {
            answer.add(findNextRoom(room));
        }

        return answer.stream().mapToLong(l -> l).toArray();
    }

    long findNextRoom(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }

        long next = map.get(room);
        long nextRoom = findNextRoom(next);
        map.put(room, nextRoom);
        return nextRoom;
    }
}
