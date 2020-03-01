import java.util.LinkedList;
import java.util.Queue;

public class StackuUsingTwoQueues {
	
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int i){
		while(!q1.isEmpty()){
			q2.add(q1.poll());
		}
		q1.add(i);
		while(!q2.isEmpty()){
			q1.add(q2.poll());
		}
		
	}
	
	public Integer pop() {
		if(!q1.isEmpty()){
		return q1.poll();
		}
		return 0;
	}
	
	public static void main(String args[]){
		
		StackuUsingTwoQueues st = new StackuUsingTwoQueues();
		st.push(1);
		st.push(2);
		st.push(3);
		
		System.out.println(st.pop()+","+st.pop()+","+st.pop());
		
	}

}
