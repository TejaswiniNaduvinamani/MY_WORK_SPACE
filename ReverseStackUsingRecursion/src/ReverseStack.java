import java.util.Stack;

public class ReverseStack {
	
	static Stack<Character> st = new Stack<>();
	
	static void insertAtBottom(char x){
		
		if(st.isEmpty()){
			st.push(x);
		} else {
			
			 // All items are held in Function 
            // Call Stack until we reach end 
            // of the stack. When the stack becomes 
            // empty, the st.size() becomes 0, the 
            // above if part is executed and  
            // the item is inserted at the bottom
			
			char a = st.peek();
			st.pop();
			insertAtBottom(x);
			
			// push allthe items held  
            // in Function Call Stack 
            // once the item is inserted  
            // at the bottom
			st.push(a);
			
		}
		
	}
	
	static void reverse(){
		
		if(st.size() > 0) 
        { 
              
            // Hold all items in Function 
            // Call Stack until we 
            // reach end of the stack  
            char x = st.peek(); 
            st.pop(); 
            reverse(); 
              
            // Insert all the items held  
            // in Function Call Stack 
            // one by one from the bottom 
            // to top. Every item is 
            // inserted at the bottom  
            insertAtBottom(x); 
        } 
		
	}
	
	public static void main(String[] args)  
    { 
          
        // push elements into 
        // the stack 
        st.push('1'); 
        st.push('2'); 
        st.push('3'); 
        st.push('4'); 
          
        System.out.println("Original Stack"); 
          
        System.out.println(st); 
          
        // function to reverse  
        // the stack 
        reverse(); 
          
        System.out.println("Reversed Stack"); 
          
        System.out.println(st); 
    } 

}
