
public class BTreeMain {

	public static void main(String[] args)
	{
		BTree T = new BTree();
		T.root = T.BSTInsert(5, T.root);
		//T.root = new BTreeNode(5);
			
		System.out.print("\nPre Order Traversal : \n");
		T.preOrderPrint(T.root);
		System.out.print("\nPost Order Traversal : \n");
		T.postOrderPrint(T.root);
		System.out.print("\nPost Order Traversal : \n");
		T.inOrderPrint(T.root);
	}
}
