// This testing program stub creates a queue of HTML tags 
// in a valid sequence.
// You may use this as a starting point for being a client of your
// HtmlValidator object
import java.util.*;

public class HtmlValidatorTest {
    //	public static void main(String[] args) {
//		// <b>Hi</b><br/>
//		// A Queue of tags you may modify and pass to your HtmlValidator object
//		Queue<HtmlTag> tags = new LinkedList<HtmlTag>();
//
//		tags.add(new HtmlTag("html", false));
//
//
//		HtmlValidator test = new HtmlValidator(tags);
////		test.removeAll("p");
//		test.validate();
//		// Your code here
//	}
    
    public static void main(String[] args) {
        run("<body> <p> <i> </i> </p> </body>", "<body> <p> <i> </i> </p> </body>", "b");

        run("<b> </b> <b> </b>", "", "b");

        run("", "", "b");
    }

    public static void run(String t, String e, String r) {
        Queue<HtmlTag> tags = HtmlTag.tokenize(t);
        Queue<HtmlTag> expected = HtmlTag.tokenize(e);

        HtmlValidator h = new HtmlValidator(tags);

        try {
            h.removeAll(r);
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught Illegal Argument.");
        }

        Queue<HtmlTag> result = h.getTags();

        boolean valid = true;

        int size = expected.size();

        for (int i = 0; i < size; i++) {
            HtmlTag cure = expected.poll();
            HtmlTag curt = result.poll();
            if (!cure.equals(curt))
                valid = false;
            result.offer(curt);
            expected.offer(cure);
        }

        if (h.getTags().size() != expected.size())
            valid = false;


        if (valid)
            System.out.println("Test Passed");
        else {
            System.out.println("Test Failed");
            System.out.println("  Result: " + result);
            System.out.println("Expected: " + expected);
        }
        System.out.println("");

    }
}