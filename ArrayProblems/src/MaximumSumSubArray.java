import java.util.Scanner;

// Kadane's algorithm
public class MaximumSumSubArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the array size"); //5
	    int arrSize = sc.nextInt();
	    int[] arr = new int[arrSize];
	    System.out.println("Enter the array elements"); //{1,2,3,7,5}
	    for(int i=0; i<arrSize; i++){
	        arr[i] = sc.nextInt();
	    }
	    
	    int max_sum_ending_here = 0;
	    int max_sum_so_far =Integer.MIN_VALUE;
	    for(int i=0; i<arrSize;i++){
	    	max_sum_ending_here = max_sum_ending_here + arr[i];
	    	if(max_sum_ending_here<0)
	    		max_sum_ending_here=0;
	    	 if(max_sum_so_far < max_sum_ending_here)
	    		max_sum_so_far = max_sum_ending_here;
	    	
	    }
	    System.out.println("Maximum sum of a contiguous sub-array is : "+ max_sum_so_far);
	}

}
