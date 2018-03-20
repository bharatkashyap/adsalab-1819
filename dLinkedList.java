
public class dLinkedList {
	dLinkedListNode head;
	int length;
	
	public dLinkedList()
	{
		length = 0;
	}


	public void append(int d)
	{
		dLinkedListNode newNode = new dLinkedListNode(d);
		dLinkedListNode iterator = head;
		
		if(iterator == null)
		{
			head = newNode;
			length += 1;
			return;
		}


		while(iterator.next != null)
		{
			iterator = iterator.next;
		}
		
		newNode.prev = iterator;
		iterator.next = newNode;
		
		length += 1;
	}
	
	public void delete(int d)
	{
		dLinkedListNode iterator = head;
		int found = 0;

		if(length == 1)
		{
			head = null;
			length--;
			System.out.print("Linked list deleted.\n");
		}
		else
		{
			while(iterator != null)
			{
				if(iterator.data == d && iterator == head)
				{
					head = iterator.next;
					head.prev = null;
					length--;
					found++;
					
				}
				else if(iterator.data == d && iterator != head)
				{
					iterator.prev.next = iterator.next;
					length--;
					found++;
				}
				
				iterator = iterator.next;	
			}
			if(found == 0)
			{
				System.out.print("Element not found in the linked list!\n");
			}
		}
	}
	
	public void display()
	{
		dLinkedListNode iterator = head;
		
		while(iterator != null)
		{
			if(iterator.next == null)
				System.out.print(iterator.data + "\n");
			else
				System.out.print(iterator.data + " <-> ");
			
			iterator = iterator.next;
		}	
		
	}
	
	public void sortedInsert(int d)
	{
		dLinkedListNode newNode = new dLinkedListNode(d);
		dLinkedListNode iterator = head;
		
		if(iterator == null)
			head = newNode;
		
		else
		{
			if(newNode.data < head.data)
			{
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			}
			
			else
			{
				while(iterator.next != null && iterator.next.data < newNode.data)
				{
					iterator = iterator.next;
				}
				
				newNode.prev = iterator;
				newNode.next = iterator.next;
				iterator.next = newNode;
			}
		}
			
	}

	
}
