import java.util.ArrayList;
import java.util.List;

public class StringSplit {

	
	public static void main (String[] args){
		String ex = "123ABC";
		
		String[] tokens= ex.split(",");
		
		System.out.println(ex.toLowerCase());
		
		List<String > abc = new ArrayList<>();
		
		for(String x: abc){
			System.out.println("entered");
		}
	}
}
