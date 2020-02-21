package E2020_02_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P_FileIO {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList<Integer>();

		list.add(3);
		list.add(10);
		list.add(1);
		list.add(4);
		
		Collections.sort(list,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2) {
					return -1;
				}
				return 0;
			}
		} 
	 );
		
		for(int i =  0 ; list.size() > i ; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
