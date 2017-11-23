import javax.swing.text.html.HTML;
import java.util.*;

public class HtmlValidator
{
	Queue<HtmlTag> q;

	public HtmlValidator()
	{
		q = new LinkedList<HtmlTag>();
	}

	public HtmlValidator (Queue<HtmlTag> tags)
	{
	    if (tags != null) {
	        q = new LinkedList<HtmlTag>(tags);
        }
      	else {
	        throw new IllegalArgumentException();
        }
	}

	public void addTag (HtmlTag tag)
	{
		if(tag != null) {
		    q.add(tag);
		}
        else
        {
            throw new IllegalArgumentException();
        }
	}

    public Queue<HtmlTag> getTags() {
	    Queue<HtmlTag> copyOfQueue = new LinkedList<>(q);
	    return copyOfQueue;
    }

    public void removeAll (String e) {
	    while (!e.isEmpty()) {
        }
    }
}
