import java.util.Stack;

public class SortStackUsingRecursion {

	public static void sortStack(Stack<Integer> st1, Stack<Integer> st2) {
		while (!st1.isEmpty()) {

			if (st1.isEmpty()) {
				return;
			} else {
				if (st2.isEmpty() || st2.peek() <= st1.peek()) {
					st2.push(st1.pop());
				} else {
					int temp = st2.pop();
					sortStack(st1, st2);
					st2.push(temp);
					return;
				}
			}
		}

	}
	
	public static void insertStack(Stack<Integer> st, Integer x){
		if(st.isEmpty() || x > st.peek()){
			st.push(x);
			return;
		}
			int s = st.pop();
			insertStack(st, s);
			st.push(s);
		
	}
	
	public static void sortedStack(Stack<Integer> st){
		
		if(!st.isEmpty()){
			int temp = st.pop();
			sortedStack(st);
			insertStack(st, temp);
		}
		
	}

	public static void main(String[] args) {
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		st1.push(9);
		st1.push(7);
		st1.push(8);
		st1.push(4);
		sortStack(st1, st2);
		System.out.println(st2);
//		sortedStack(st1);
//
//		System.out.println(st1);
		
	}

}
