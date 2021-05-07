package kakao_blind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution3 {

    Map<String, String> map = new HashMap<>();
    List<String> uid = new ArrayList<>();
    List<String> word = new ArrayList<>();
    List<String> answer = new ArrayList<>();

    public String[] solution(String[] record) {

        for (String r : record) {
            String[] token = r.split("[ ]");
            if (token[0].equals("Enter")) {
                map.put(token[1], token[2]);
                uid.add(token[1]);
                word.add("님이 들어왔습니다.");
            }

            if (token[0].equals("Leave")) {
                uid.add(token[1]);
                word.add("님이 나갔습니다.");
            }

            if (token[0].equals("Change")) {
                map.put(token[1], token[2]);
            }

        }

        List<String> replace_uid = uid.stream().map(str -> map.get(str)).collect(Collectors.toList());

        for (int i = 0; i < replace_uid.size(); i++) {
            answer.add(replace_uid.get(i) + word.get(i));
        }

        return answer.stream().toArray(String[]::new);
    }

}
