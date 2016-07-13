import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\@(\\w+)");
		Matcher m = pattern.matcher("asdf @tag1 @tag2 pouo");
		while (m.find()) {
			System.out.println(m.group(1));
		}
	}

}