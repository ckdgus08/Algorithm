package kakao2021_intern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution3 {


    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        Stack<Node> stack = new Stack<>();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(new Node(i, true));

        int now = k;

        for (String s : cmd) {
            if (s.startsWith("Z")) {
                Node pop = stack.pop();
                pop.value = true;
                list.add(now, pop);

                if (now >= pop.index)
                    now++;
            } else if (s.startsWith("C")) {
                Node node = list.get(now);
                node.value = false;
                stack.add(node);
                list.remove(now);
                if (list.size() == now)
                    now--;
            } else if (s.startsWith("D")) {
                now += Integer.parseInt(s.substring(2));
            } else {
                now -= Integer.parseInt(s.substring(2));
            }
        }

        for (Node node : stack) {
            list.add(node);
        }

        List<Node> collect = list.stream().sorted((o1, o2) -> {
            if (o1.index < o2.index)
                return -1;
            return 1;
        }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Node node : collect) {
            if (node.value)
                sb.append("O");
            else
                sb.append("X");
        }
        return sb.toString();
    }

    class Node {
        int index;
        boolean value;

        public Node(int index, boolean value) {
            this.index = index;
            this.value = value;
        }
    }

}
