package kakao2019_intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

    // TODO: 2021/05/06 14:54

    public int solution(String[] user_id, String[] banned_id) {

        Map<String, List<String>> map = new HashMap<>();
        List<String> answer_list = new ArrayList<>();

        for (String banned_element : banned_id) {
            List<String> list = new ArrayList<>();
            for (String user : user_id) {
                if (is_collect(user, banned_element)) {
                    list.add(user);
                }
                map.put(banned_element, list);
            }
        }

        int size = 0;
        for (String key : map.keySet()) {
            size += map.get(key).size();
        }




    }

    boolean is_collect(String user_id, String banned_id) {
        return user_id.matches(banned_id.replaceAll("[*]", "."));
    }

}
