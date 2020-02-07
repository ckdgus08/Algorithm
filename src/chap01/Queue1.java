package chap01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue1 {

	public static void main(String[] agrs) {
		Queue q = new LinkedList();
		Stack s = new Stack();
	
		
		s.push("1");
		s.push("2");
		s.push("3");
		
		q.offer("0");
		q.offer("1");
		q.offer("3");
		
	}

}
