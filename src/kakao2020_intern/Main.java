package kakao2020_intern;

public class Main {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] arry = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String result = solution1.solution(arry, "right");
        System.out.println("result = " + result);
    }
}
