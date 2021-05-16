package kakao_blind;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {

    List<People> list = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {

        List<Long> answer = new ArrayList<>();

        for (String s : info) {
            String[] token = s.split(" ");
            list.add(new People(token[0], token[1], token[2], token[3], token[4]));
        }

        for (String s : query) {
            String[] split = s.split(" ");

            long count = list.stream()
                    .filter(people -> (split[0].equals("-") || people.language.equals(split[0])))
                    .filter(people -> (split[2].equals("-") || people.position.equals(split[2])))
                    .filter(people -> (split[4].equals("-") || people.year.equals(split[4])))
                    .filter(people -> (split[6].equals("-") || people.food.equals(split[6])))
                    .filter(people -> people.score >= Integer.parseInt(split[7]))
                    .count();
            answer.add(count);
        }
        return answer.stream().mapToInt(Math::toIntExact).toArray();
    }


    static class People {

        String language;
        String position;
        String year;
        String food;
        int score;

        public People(String language, String position, String year, String food, String score) {
            this.language = language;
            this.position = position;
            this.year = year;
            this.food = food;
            this.score = Integer.parseInt(score);
        }
    }

}
