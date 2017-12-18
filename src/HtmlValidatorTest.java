// This testing program stub creates a queue of HTML tags 
// in a valid sequence.
// You may use this as a starting point for being a client of your
// HtmlValidator object
import java.util.*;

public class HtmlValidatorTest {
	public static void main(String[] args) {
		// <b>Hi</b><br/>
		// A Queue of tags you may modify and pass to your HtmlValidator object
		Queue<HtmlTag> tags = new LinkedList<HtmlTag>();

		tags.add(new HtmlTag("html", false));


		HtmlValidator test = new HtmlValidator(tags);
//		test.removeAll("p");
		test.validate();
		// Your code here
	}
}