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
	    if (tags != null)
	    {
	        q = new LinkedList<HtmlTag>(tags);
        }
      	else
      	{
	        throw new IllegalArgumentException();
        }
	}

	public void addTag (HtmlTag tag)
	{
		if(tag != null)
		    q.add(tag);
        else
            throw new IllegalArgumentException();
	}

    public Queue<HtmlTag> getTags()
    {
	    Queue<HtmlTag> copyOfQueue = new LinkedList<>(q);
	    return copyOfQueue;
    }

    public void removeAll (String e)
    {
		Queue<HtmlTag> backup = new LinkedList<HtmlTag>();
        while (!q.isEmpty())
	    {
	    	HtmlTag element = q.remove();
			if (element.getElement() != e)
			{
				backup.add(element);
			}
        }
        while (!backup.isEmpty())
        {
        	q.add(backup.remove());
        }
    }

    public void validate() {
        Stack<HtmlTag> validate = new Stack<HtmlTag>();
        Queue<HtmlTag> backup = new LinkedList<HtmlTag>(q);
        System.out.println(backup);
        int i = 1;
        String x = "";

        while(!q.isEmpty()) {
            HtmlTag element = q.remove();
            if (element.isOpenTag() == true) {
                validate.push(element);
                int z = 0;
                while (z < i) {
                    x = "\t" + x ;
                    z++;
                }
                System.out.println(x + element);
            }
        }
    }
}
