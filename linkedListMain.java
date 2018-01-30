
public class linkedListMain {
	public static void main(String[] args)
	{
		linkedList l = new linkedList();
		l.display();
		l.append(5);
		l.display();
		l.push(1);
		l.display();
		l.insertAtIndex(2,1);
		l.display();
		l.insertAtIndex(9,0);
		l.insertAtIndex(7,5);
		l.insertAtIndex(4,3);
		l.display();
		l.insertAtIndex(3,4);
		l.display();
		l.insertAtIndex(7,0);
		l.insertAtIndex(7,1);
		l.display();
	}
}
