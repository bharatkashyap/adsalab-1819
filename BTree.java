
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

	public void print()
	{
		System.out.println("\nIn-order traversal :");
		inOrderPrint(root);
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

	public void insert(int d)
	{
		root = BSTInsert(d, root);
	}

	public BTreeNode BSTInsert (int d, BTreeNode t)
	{
		if(t == null)
			t = new BTreeNode(d);

		else if(d > t.data)
			t.right = BSTInsert(d, t.right);

		else if(d < t.data)
			t.left = BSTInsert(d, t.left);

		return t;
	}


	public boolean search(int d)
	{
		if(BSTSearch(d, root) != null)
			return true;

		return false;
	}


	public BTreeNode BSTSearch(int d, BTreeNode t)
	{
		if(t == null || t.data == d)
			return t;

		if(d > t.data)
			return BSTSearch(d, t.right);

		return BSTSearch(d, t.left);
	}

	public int computeHT(BTreeNode t)
	{
		int height, lHeight, rHeight;
		if(t.left == null && t.right == null)
		{
			height = 0;
			return height;
		}

		else
		{

			lHeight = (t.left != null) ? computeHT(t.left) : 0;
			rHeight = (t.right != null) ? computeHT(t.right) : 0;

			height = (rHeight > lHeight) ? rHeight + 1 : lHeight + 1;
			return height;
		}
	}

	public BTreeNode findMin(BTreeNode t)
	{
		if(t == null)
			return t;

		while(t.left != null)
			t = t.left;

		return t;
	}


	public void delete(int d)
	{
		root = BSTDelete(d, root);
	}

	public BTreeNode BSTDelete(int d, BTreeNode t)
	{
		if(t ==  null || search(d) == false)
			return null;

		else
		{
			if(d > t.data)
				t.right = BSTDelete(d, t.right);

			else if(d < t.data)
				t.left = BSTDelete(d, t.left);

			else if(d == t.data)
			{
					if(t.left == null)
						return t.right;
					else if(t.right == null)
						return t.left; // Takes care of one child AND no children cases simultaneously.

					// Two children
					t.data = findMin(t.right).data;
					t.right = BSTDelete(t.data, t.right);
			}
		}

		return t;

	}


}
