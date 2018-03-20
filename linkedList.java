import java.util.*;

public class linkedList{
	linkedListNode head;
	int length;

	public linkedList()
	{
		length = 0;
	}
	
	public linkedList(linkedList l)
	{
		
		linkedListNode iterator = l.head;
		while(iterator != null)
		{
			this.append(iterator.data);
			iterator = iterator.next;
		}
		
	}
	public void append(int d)
	{
		linkedListNode newNode = new linkedListNode(d);
		linkedListNode iterator;
		
		iterator = head;

		if(iterator == null)
		{
			head = newNode;
			length += 1;
			return;
		}

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
	
	public void delete(int d)
	{
		linkedListNode iterator = head;
		int found = 0;

		if(length == 1)
		{
			length--;
			head = null;
			System.out.print("Linked list deleted.");
		}
		else
		{
			while(iterator.next != null)
			{		
				if(iterator.data == d && iterator == head)
				{
					head = iterator.next;
					length--;
					found++;
				}

				else if(iterator.next.data == d)
				{
					iterator.next = iterator.next.next;
					length--;
					found++;
					continue;
				}
				
				iterator = iterator.next;	
			}

			if(found == 0)
			{
				System.out.print("Element not found in the linked list!\n");
			}
		}
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

	public void swapFirstAndLast()
	{
		linkedListNode iterator;
		linkedListNode second, secondLast;

		iterator = head;
		second = head.next;

		if(length == 1)
		{
			System.out.print("Linked list contains only one element!");
			return;
		}

		else if(length == 2)
		{
			linkedListNode temp = head;
			head = head.next;
			head.next = temp;
			temp.next = null;
		}

		else
		{
			while(iterator != null)
			{
				if(iterator.next != null)
				{
					if(iterator == head)
					{
						iterator = iterator.next;
						head.next =  null;
						continue;
					}

					if(iterator.next.next == null)
					{
						secondLast = iterator;
						iterator = iterator.next;
						secondLast.next = head;
						continue;
					}
				}

				else if(iterator.next == null)
				{
					iterator.next = second;
					head = iterator;
					return;
				}
			iterator = iterator.next;
			
			}
		}
	
	}
	
	
	public void recursiveReverse(linkedListNode start)
	{	
		linkedListNode first, rest;
		
		if(start == null)
			return; // List is empty 
		
		if(start.next == null)
			return; // List contains only one element
		
		else
		{
			first = start;
			rest = start.next;
			head = rest;
		}
	
		recursiveReverse(rest); // Reverse rest of the linked list
		first.next.next = first; // Reverse first pointer link
		first.next = null; //Point original first element to null
		
	}

}
