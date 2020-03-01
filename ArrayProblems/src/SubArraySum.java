import java.util.Scanner;

// find the continuous subarray which sums up to given number
public class SubArraySum {

	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the array size"); //5
	    int arrSize = sc.nextInt();
	    System.out.println("ENter the Sum"); // 12
	    int sum = sc.nextInt();
	    int[] arr = new int[arrSize];
	    System.out.println("Enter the array elements"); //{1,2,3,7,5}
	    for(int i=0; i<arrSize; i++){
	        arr[i] = sc.nextInt();
	    }
	    int subArraySum =0;
	    findSubArraySum(arrSize, sum, arr);
	    compute(arr, arrSize, sum);
	    
	}

	private static void findSubArraySum(int arrSize, int sum, int[] arr) {
		int subArraySum;
		for(int i =0 ; i< arrSize; i++){
	        subArraySum = arr[i];
	        int count=1;
	        while(sum > subArraySum && i!= arrSize-1){
	            subArraySum = subArraySum + arr[i+count];
	            if(subArraySum==sum){
	                System.out.println((i+1) + " " + (i+count+1));
	                return ;
	            }
	            count++;
	        }
	    
	    }
	}
	
	// efficient resolution
	public static int compute(int[]a,int n,int sum){
	    int curr=a[0],start=0,i;
	    for(i=1;i<=n;i++){
	        while(curr>sum && start<i-1){
	            curr=curr-a[start];
	            start++;
	        }
	        if(curr==sum){
	            System.out.println(start+1+" "+i);
	            return 1;
	        }
	        curr+=a[i];
	    }
	    return 0;
	}


}
