import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringBoldExample {

	public static void main(String args[]) {
		Pattern pattern = Pattern.compile("\"[0-9a-zA-Z\\s !@#$%^&*(),.?:{}|<>-]+\"");
		String text = "Upon 30 days advance notice , Customer may \"1234\" the price of \"mark-up\" inventoried Products that are based on Cost and include the Mark-Up once per calendar year (each, an "
				+ "\"Audit\"" + ").";
		Matcher matcher = pattern.matcher(text);
		int count = 0;
		while (matcher.find()) {
			System.out.println("Found: " + matcher.group());
			count++;
		}
		String arg[] = new String[(text.split("\"[a-zA-Z\\s]+\"")).length + count];
	}

}
