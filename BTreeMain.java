
public class BTreeMain {

	public static void main(String[] args)
	{
		BTree T = new BTree();
		T.insert(5);
		T.insert(4);
		T.insert(6);
		//T.root = new BTreeNode(5);
			
		System.out.print("\nPre Order Traversal : \n");
		T.preOrderPrint(T.root);
		System.out.print("\nPost Order Traversal : \n");
		T.postOrderPrint(T.root);
		System.out.print("\nIn Order Traversal : \n");
		T.inOrderPrint(T.root);
	}
}
