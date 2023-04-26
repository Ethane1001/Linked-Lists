import java.io.*;
import java.util.*;

public class LinkedList
{
	private Node head;  // pointer to the front (first) element of the list

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// COPY ALL NODES FROM OTHER LIST INTO THIS LIST. WHEN COMPLETED THIS LIST IDENTICAL TO OTHER
	public LinkedList( LinkedList other )
	{
		head = other.head; // YOU ABSOLUTELY MUST CHANGE THIS. THIS IS A SHALLOW COPY :(
	}

	// LOAD LINKED LIST FROM INCOMING FILE

	public LinkedList( String fileName ) throws Exception
	{
		BufferedReader infile = new BufferedReader( new FileReader( fileName ) );
		while ( infile.ready() )
			insertAtTail( infile.readLine() );
		infile.close();
	}

	//-------------------------------------------------------------

	// inserts new elem at front of list - pushing old elements back one place

	public void insertAtFront(String data)
	{
		head = new Node(data,head);
	}

	// we use toString as our print

	public String toString()
	{
		String toString = "";

		for (Node curr = head; curr != null; curr = curr.getNext())
		{
			toString += curr.getData();		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.getNext() != null)
				toString += " -> ";
		}

		return toString + "\n";
	}

	// ########################## Y O U   W R I T E    T H E S E    M E T H O D S ########################

	// TACK A NEW NODE (CABOOSE) ONTO THE END OF THE LIST
	public void insertAtTail(String data)
	{
		if (head == null) {
			// IF THERE ARE NO NODES IN LIST, TACK THIS ONE RIGHT ONTO THE HEAD
			head = new Node(data, null);
		} else {
			// ELSE GET A REF TO THE VERY LAST NODE AND HANG IT OFF THE LAST NODE'S NEXT REF
			Node curr = head;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(new Node(data, null));
		}
	}

	// OF COURSE MORE EFFICIENT TO KEEP INTERNAL COUNTER BUT YOU COMPUTE IT DYNAMICALLY WITH A TRAVERSAL LOOP
	public int size()
	{
		int size = 0;
		for (Node curr = head; curr != null; curr = curr.getNext()) {
			++size;
		}
		return size;
	}

	// MUST CALL SEARCH AND IF SEARCH RETURNS NULL, THIS METHOD RETURNS FALSE, OTHERWISE RETURN TRUE
	public boolean contains( String key )
	{
		return search(key) != null;
	}

	// TRAVERSE LIST FRONT TO BACK LOOKING FOR THIS DATA VALUE.
	// RETURN REF TO THE FIRST NODE THAT CONTAINS THIS KEY. DO -NOT- RETURN REF TO KEY INSIDE NODE
	// RETURN NULL IF NOT FOUND
	public Node search( String key )
	{
		for (Node curr = head; curr != null; curr = curr.getNext()) {
			if (curr.getData().equals(key)) {
				return curr;
			}
		}
		return null;
	}
}
