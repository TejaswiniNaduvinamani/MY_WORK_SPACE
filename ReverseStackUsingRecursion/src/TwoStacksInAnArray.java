
public class TwoStacksInAnArray {
	
	int n;
	int arr[];
	int top1, top2;
	int size;
	
	
	public TwoStacksInAnArray(int i) {
		this.n = i;
		this.arr = new int[i];
		top1 = -1;
		top2 = i;
		size = i;
	}
	
	
	public void push1(int i){
		
		if(top1 < top2-1) {
			top1++;
			arr[top1] = i;
			
		}
		
	}
	
	public void push2(int i){
		
		if(top2-1 > top1) {
			arr[top2-1] = i;
			top2--;
		}
		
	}
	
	public Integer pop1(){
		
		if(top1 >=0){
			return arr[0];
		}
		return 0;
	}
	
	public Integer pop2(){
		
		if(top2 < n){
			return arr[arr.length-1];
		}
		
		return 0;
	}
	
	public static void main(String args[]){
		TwoStacksInAnArray st = new TwoStacksInAnArray(5);
		st.push1(1);
		st.push1(2);
		st.push1(3);
		st.push2(4);
		st.push2(5);
		st.push2(6);
		for(int i=0; i<5; i++)
		System.out.println(st.arr[i]);
		
		System.out.println("Pop element from stack 1: " + st.pop1());
		System.out.println("Pop element from stack 2: " + st.pop2());
	}
	
	

}
