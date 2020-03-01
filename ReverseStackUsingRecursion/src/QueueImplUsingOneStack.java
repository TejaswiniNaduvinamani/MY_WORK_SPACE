import java.util.Stack;

public class QueueImplUsingOneStack {

	static class Queue { 
        Stack<Integer> stack1; 
    } 
	
	
	static void stack_push(Stack<Integer> s1, int x){
		s1.push(x);
	}
	
	static int stack_pop(Stack<Integer> s1){
		if (s1 == null) { 
            System.out.println("Stack Underflow"); 
            System.exit(0); 
        } 
		return s1.pop();
	}
	
	static void enQueue(Queue q, int x){
		stack_push(q.stack1, x);
	}
	
	static int deQueue(Queue q){
		int x, res =0;
		if(q.stack1.isEmpty()){
			System.out.println("Q is Empty"); 
            System.exit(0);
		}
		else if (q.stack1.size() == 1) { 
            return stack_pop(q.stack1); 
        } 
		else{
			x = stack_pop(q.stack1);
			res= deQueue(q);
			stack_push(q.stack1, x); 
            return res; 
		}
		return 0;
	}
	
	 public static void main(String[] args) 
	    { 
	        /* Create a queue with items 1 2 3*/
	        Queue q = new Queue(); 
	        q.stack1 = new Stack<>(); 
	  
	        enQueue(q, 1); 
	        enQueue(q, 2); 
	        enQueue(q, 3); 
	  
	        /* Dequeue items */
	        System.out.print(deQueue(q) + " "); 
	        System.out.print(deQueue(q) + " "); 
	        System.out.print(deQueue(q) + " "); 
	    } 
}
