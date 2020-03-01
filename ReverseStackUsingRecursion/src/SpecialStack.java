import java.util.Stack;

public class SpecialStack extends Stack {

	static Stack<Integer> auxSt = new Stack<>();
	
	public void stack_push(int i){
		super.push(i);
		if(!auxSt.isEmpty()){
			if(i <auxSt.peek()){
				auxSt.pop();
				auxSt.push(i);
			}	
		} else{
			auxSt.push(i);
		}
	}
	
	public Integer getMin(){
		return auxSt.peek();
	}
	
	
	public static void main(String arg[]){
		SpecialStack st = new SpecialStack();
		st.stack_push(16);
		st.stack_push(15);
		st.stack_push(12);
		st.stack_push(18);
		st.stack_push(29);
		st.stack_push(13);
		int[] arr = {1,2,5,6};
		System.out.println(st.getMin());
		System.out.println(arr[0]);
		
	}
}
