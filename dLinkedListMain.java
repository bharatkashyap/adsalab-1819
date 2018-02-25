
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
	}
}
