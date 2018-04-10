
public class BTree 
{
	
	BTreeNode root;
	
	public BTree()
	{
		root = null;
	}
	
	
	
	public void preOrderPrint(BTreeNode t)
	{
		if(t == null)
		{
			return;
		}
		else if(t != null)
		{
			System.out.print(t.data + " -> ");
			preOrderPrint(t.left);
			preOrderPrint(t.right);
		}
	}
	
	public void postOrderPrint(BTreeNode t)
	{
		if(t == null)
			return;
		else
		{
			postOrderPrint(t.left);
			postOrderPrint(t.right);
			System.out.print(t.data + " -> ");
		}
	}
	
	public void inOrderPrint(BTreeNode t)
	{
		if(t == null)
			return;
		else
		{
			inOrderPrint(t.left);
			System.out.print(t.data + " -> ");
			inOrderPrint(t.right);
		}
		
	}
	
	public BTreeNode BSTInsert (int d, BTreeNode t)
	{
		if(t == null)
			t = new BTreeNode(d);
		
		if(d > t.data)
			t.left = BSTInsert(d, t.right);
		
		else if(d < t.data)
			t.right = BSTInsert(d, t.left);
			
		return t;
	}
}

