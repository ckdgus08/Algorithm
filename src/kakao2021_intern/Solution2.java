package kakao2021_intern;

public class Solution2 {

    public int[] solution(String[][] places) {

        int[] answer = {1, 1, 1, 1, 1};
        int[] dx_1 = {0, 0, 1, -1};   // 가로세로 1
        int[] dy_1 = {1, -1, 0, 0};   // 가로세로 1

        int[] dx_3 = {1, 1, -1, -1};   // 대각선1
        int[] dy_3 = {-1, 1, 1, -1};   // 대각선1

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    char point = places[i][j].charAt(k);
                    if (point == 'P') {
                        for (int l = 0; l < 4; l++) {
                            //가로 세로방향 1
                            int next_x = j + dx_1[l];
                            int next_y = k + dy_1[l];
                            if (next_x < 0 || next_x >= 5 || next_y < 0 || next_y >= 5) continue;
                            char next_point = places[i][next_x].charAt(next_y);
                            if (next_point == 'P') {
                                answer[i] = 0;
                            }
                        }

                        for (int l = 0; l < 4; l++) {
                            //가로 세로방향 2
                            int next2_x = j + dx_1[l] * 2;
                            int next2_y = k + dy_1[l] * 2;

                            int next_x = j + dx_1[l];
                            int next_y = k + dy_1[l];
                            if (next2_x < 0 || next2_x >= 5 || next2_y < 0 || next2_y >= 5) continue;
                            if (next_x < 0 || next_x >= 5 || next_y < 0 || next_y >= 5) continue;
                            char next2_point = places[i][next2_x].charAt(next2_y);
                            char next_point = places[i][next_x].charAt(next_y);
                            if (next2_point == 'P') {
                                if (next_point != 'X') {
                                    answer[i] = 0;
                                }
                            }
                        }

                        for (int l = 0; l < 4; l++) {
                            //대각선
                            int next_x = j + dx_3[l];
                            int next_y = k + dy_3[l];

                            int temp_x1 = j + dx_3[l];
                            int temp_y1 = k;

                            int temp_x2 = j;
                            int temp_y2 = k + dy_3[l];

                            if (next_x < 0 || next_x >= 5 || next_y < 0 || next_y >= 5) continue;
                            if (temp_x1 < 0 || temp_x1 >= 5 || temp_y1 < 0 || temp_y1 >= 5) continue;
                            if (temp_x2 < 0 || temp_x2 >= 5 || temp_y2 < 0 || temp_y2 >= 5) continue;
                            char next_point = places[i][next_x].charAt(next_y);
                            char temp_point1 = places[i][temp_x1].charAt(temp_y1);
                            char temp_point2 = places[i][temp_x2].charAt(temp_y2);
                            if (next_point == 'P') {
                                if (temp_point1 != 'X' || temp_point2 != 'X') {
                                    answer[i] = 0;
                                }
                            }
                        }

                    }
                }
            }
        }
        return answer;
    }
}
