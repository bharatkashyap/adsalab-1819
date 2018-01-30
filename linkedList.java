import java.util.*;

public class linkedList{
	linkedListNode head;
	int length;

	
	linkedList()
	{
		head = new linkedListNode();
		length = 1;
	}
	
	linkedList(int d)
	{
		head = new linkedListNode(d);
		length = 1;
	}
	
	public void append(int d)
	{
		linkedListNode newNode = new linkedListNode(d);
		linkedListNode iterator;
		
		iterator = head;
		while(iterator.next != null)
			iterator = iterator.next;
		
		iterator.next = newNode;
		length += 1;
	}
	
	public void push(int d)
	{
		linkedListNode newNode = new linkedListNode(d);

		newNode.next = head;
		head = newNode;
		
		length += 1;
	}
	
	public void insertAtIndex(int d, int pos)
	{
		linkedListNode  newNode = new linkedListNode(d);
		linkedListNode iterator;
		
		
		if(pos==0 || pos >= this.length)
		{
			System.out.println("Please enter a valid index.");
		}
		
		else
		{		
			int counter = 0;
			iterator = head;
			
		
			while(counter < (pos-1) )
			{
				iterator = iterator.next;
				counter++;
			}
			newNode.next = iterator.next;
			iterator.next = newNode;
		
			length += 1;
		}
	}
	
	public void display()
	{
		linkedListNode iterator;
		iterator = head;
		
		while(iterator != null)
		{
			if(iterator.next == null)
				System.out.print(iterator.data + "\n");
			
			else
				System.out.print(iterator.data + " -> ");
			
			iterator = iterator.next;
		}
		
	}
}
