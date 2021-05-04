package kakao2020_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution2 {

    List<Character> operator = new ArrayList<>();
    List<Long> number = new ArrayList<>();

    List<Character> accepted_operator = Arrays.asList('+', '-', '*');

    public long solution(String expression) {

        parsingExpressionToList(expression);

        long l1 = Math.abs(order_operator('*', '+', '-'));
        long l2 = Math.abs(order_operator('*', '-', '+'));
        long l3 = Math.abs(order_operator('+', '*', '-'));
        long l4 = Math.abs(order_operator('+', '-', '*'));
        long l5 = Math.abs(order_operator('-', '+', '*'));
        long l6 = Math.abs(order_operator('-', '*', '+'));

        return Math.max(Math.max(Math.max(l3, l4), Math.max(l1, l2)), Math.max(l5, l6));
    }

    private long order_operator(char first, char second, char third) {
        List<Character> temp_operator = operator.stream().collect(Collectors.toList());
        List<Long> temp_number = number.stream().collect(Collectors.toList());

        while (temp_operator.contains(first)) {
            for (int i = 0; i < temp_operator.size(); i++) {
                if (temp_operator.get(i) == first) {
                    long temp;
                    if (first == '*')
                        temp = temp_number.get(i) * temp_number.get(i + 1);
                    else if (first == '+')
                        temp = temp_number.get(i) + temp_number.get(i + 1);
                    else
                        temp = temp_number.get(i) - temp_number.get(i + 1);
                    temp_operator.remove(i);

                    temp_number.remove(i);
                    temp_number.remove(i);

                    temp_number.add(i, temp);
                    break;
                }
            }
        }
        while (temp_operator.contains(second)) {
            for (int i = 0; i < temp_operator.size(); i++) {
                if (temp_operator.get(i) == second) {
                    long temp;
                    if (second == '*')
                        temp = temp_number.get(i) * temp_number.get(i + 1);
                    else if (second == '+')
                        temp = temp_number.get(i) + temp_number.get(i + 1);
                    else
                        temp = temp_number.get(i) - temp_number.get(i + 1);
                    temp_operator.remove(i);

                    temp_number.remove(i);
                    temp_number.remove(i);

                    temp_number.add(i, temp);
                    break;
                }
            }
        }
        while (temp_operator.contains(third)) {
            for (int i = 0; i < temp_operator.size(); i++) {
                if (temp_operator.get(i) == third) {
                    long temp;
                    if (third == '*')
                        temp = temp_number.get(i) * temp_number.get(i + 1);
                    else if (third == '+')
                        temp = temp_number.get(i) + temp_number.get(i + 1);
                    else
                        temp = temp_number.get(i) - temp_number.get(i + 1);
                    temp_operator.remove(i);

                    temp_number.remove(i);
                    temp_number.remove(i);

                    temp_number.add(i, temp);
                    break;
                }
            }
        }

        return temp_number.get(0);
    }

    private void parsingExpressionToList(String expression) {
        int now = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (accepted_operator.contains(expression.charAt(i))) {
                operator.add(expression.charAt(i));
                number.add(Long.parseLong(expression.substring(now, i)));
                now = i + 1;
            }
        }
        number.add(Long.parseLong(expression.substring(now, expression.length())));
    }
}