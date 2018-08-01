import java.util.Scanner;

public class BTreeMain {

	public static void main(String[] args)
	{
		BTree T = new BTree();
		/**
		 * Menu driven program for BST Insertion, Deletion etc
		 */
		String userInput = null; 
		mainMenu: while(userInput != "3") {
			System.out.print("\nWhat do you want to do today?\n 1. Insert \n 2. Delete \n 3. Quit \n-----------\n");
			Scanner sc = new Scanner(System.in);
			userInput = sc.next();
			switch(userInput) {
			case "1":
				System.out.print("\nEnter the number to be inserted : ");
				int i = sc.nextInt();
				T.insert(i);
				T.prettyPreOrderPrint();
				T.prettyInOrderPrint();
				T.prettyPostOrderPrint();
				break;
			case "2":
				System.out.print("\nEnter the number to be deleted : ");
				int d = sc.nextInt();
				T.delete(d);
				T.prettyPreOrderPrint();
				T.prettyInOrderPrint();
				T.prettyPostOrderPrint();
				break;
			case "3":
				break mainMenu;
			}
		}
	}
}
