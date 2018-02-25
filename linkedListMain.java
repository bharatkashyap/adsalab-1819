
public class linkedListMain {
	public static void main(String[] args)
	{
		linkedList l = new linkedList();
		l.display();
		l.append(1);
		l.display();
		l.append(2);
		l.display();
		l.append(3);
		l.display();
		l.append(4);
		l.display();
		l.insertAtIndex(5,1);
		l.insertAtIndex(5,5);
		l.insertAtIndex(5,0);
		l.display();
		l.swapFirstAndLast();
		l.display();
		l.delete(4);
		l.delete(1);
		l.display();
		l.swapFirstAndLast();
		l.display();
		l.delete(5);
		l.swapFirstAndLast();
		l.display();

	}
}
