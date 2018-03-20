
public class dLinkedListMain {
	public static void main(String[] args)
	{
		dLinkedList l = new dLinkedList();
		l.append(1);
		l.append(2);
		l.append(3);
		l.display();
		l.delete(1);
		l.delete(3);
		l.display();
		l.delete(2);
		l.display();
		l.append(1);
		l.append(2);
		l.append(4);
		l.display();
		l.sortedInsert(3);
		l.display();
		l.sortedInsert(5);
		l.display();
		l.sortedInsert(0);
		l.display();
	}
}
