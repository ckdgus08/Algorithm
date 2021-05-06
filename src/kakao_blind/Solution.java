package kakao_blind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// TODO: 2021/05/06 11:03
public class Solution {

    public int[] solution(int N, int[] stages) {

        int[] count = new int[N + 1];
        int[] total = new int[N];
        List<Stage> list = new ArrayList<>();

        for (int stage : stages) {
            count[stage - 1]++;
        }

        for (int i = 0; i <= N; i++) {
            int stage_count = count[i];
            for (int j = 0; j < i + 1; j++) {
                if (j == N) continue;
                total[j] += stage_count;
            }
        }

        for (int i = 0; i < N; i++) {
            if (total[i] == 0)
                list.add(new Stage(i, 0L));
            else {
                double result = count[i] / (double) total[i];
                list.add(new Stage(i, result));
            }
        }

        return list.stream().sorted(new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if (o1.fail > o2.fail)
                    return -1;
                if (o1.fail == o2.fail)
                    if (o1.index < o2.index)
                        return -1;
                return 1;
            }
        }).mapToInt(stage -> stage.index + 1).toArray();


    }

    class Stage {
        int index;
        double fail = 0;

        public Stage(int index, double fail) {
            this.index = index;
            this.fail = fail;
        }
    }
}
