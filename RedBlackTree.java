import java.util.Scanner;

class Node {
    public static final int BLACK = 0, RED = 1;
    int key;
    int colour = BLACK;
    Node left = null, right = null, parent = null;

    Node(int key) {
        this.key = key;
        this.colour = BLACK;
    }

}

public class RedBlackTree {
        
    Node root;

    Node insert(Node node, int key) {

        // 1. BST Insertion
        if (node == null) { 
            Node temp new Node(key);
            temp.colour = RED;
            return temp;
        }
        
        if (key < node.key)
            node.left = insert(node.left, key);
        else if(key > node.key)
            node.right = insert(node.right, key);

        // Duplicate key terminates insertion
        else 
            return node;

        insertFix(node);
        }
    }

    //Takes as argument the newly inserted node
    void insertFix(Node node) {
        Node uncle;
        while(node.parent == RED) {
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != null && uncle.colour == RED) {
                    node.parent.colour = BLACK;
                    uncle.colour = BLACK;
                    node.parent.parent.colour = RED;
                    node = node.parent.parent;        
                }
                if (node == node.parent.right) {
                    // Rotate left on parent
                    node.parent = leftRotate(node.parent)
            }
                node.parent.colour = BLACK;
                node.parent.parent.colour = RED;
                node.parent.parent = rotateRight(node.parent.parent);
            } 
        else {
            uncle = node.parent.parent.left;
            if (uncle != null && uncle.colour == RED) {
                    node.parent.colour = BLACK;
                    uncle.colour = BLACK;
                    node.parent.parent.colour = RED;
                    node.parent.parent = insertFix(node.parent.parent);
                }
                if (node == node.parent.left) {
                    // Rotate right on parent
                    node.parent = rotateRight(node.parent);
                }
                node.parent.colour = BLACK;
                node.parent.parent.colour = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.parent.parent);
            }
        }
        root.colour = BLACK;
    }

    void rotateLeft(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {//Need to rotate root
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {//Need to rotate root
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }

    //Deletes whole tree
    void deleteTree(){
        root = nil;
    }

    //Deletion Code .

    //This operation doesn't care about the new Node's connections
    //with previous node's left and right. The caller has to take care
    //of that.
    void transplant(Node target, Node with){
          if(target.parent == nil){
              root = with;
          }else if(target == target.parent.left){
              target.parent.left = with;
          }else
              target.parent.right = with;
          with.parent = target.parent;
    }

    boolean delete(Node z){
        if((z = findNode(z, root))==null)return false;
        Node x;
        Node y = z; // temporary reference y
        int y_original_colour = y.colour;

        if(z.left == nil){
            x = z.right;
            transplant(z, z.right);
        }else if(z.right == nil){
            x = z.left;
            transplant(z, z.left);
        }else{
            y = treeMinimum(z.right);
            y_original_colour = y.colour;
            x = y.right;
            if(y.parent == z)
                x.parent = y;
            else{
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.colour = z.colour;
        }
        if(y_original_colour==BLACK)
            deleteFixup(x);
        return true;
    }

    void deleteFixup(Node x){
        while(x!=root && x.colour == BLACK){
            if(x == x.parent.left){
                Node w = x.parent.right;
                if(w.colour == RED){
                    w.colour = BLACK;
                    x.parent.colour = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if(w.left.colour == BLACK && w.right.colour == BLACK){
                    w.colour = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.right.colour == BLACK){
                    w.left.colour = BLACK;
                    w.colour = RED;
                    rotateRight(w);
                    w = x.parent.right;
                }
                if(w.right.colour == RED){
                    w.colour = x.parent.colour;
                    x.parent.colour = BLACK;
                    w.right.colour = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            }else{
                Node w = x.parent.left;
                if(w.colour == RED){
                    w.colour = BLACK;
                    x.parent.colour = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if(w.right.colour == BLACK && w.left.colour == BLACK){
                    w.colour = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.left.colour == BLACK){
                    w.right.colour = BLACK;
                    w.colour = RED;
                    rotateLeft(w);
                    w = x.parent.left;
                }
                if(w.left.colour == RED){
                    w.colour = x.parent.colour;
                    x.parent.colour = BLACK;
                    w.left.colour = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.colour = BLACK;
    }

    Node treeMinimum(Node subTreeRoot){
        while(subTreeRoot.left!=nil){
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
    }

    public void consoleUI() {
        Scanner scan = new Scanner(System.in);
        menu: while (true) {
            System.out.println("\n1.- Add items\n"
                    + "2.- Delete items\n"
                    + "3.- Check items\n"
                    + "4.- Print tree\n"
                    + "5.- Delete tree\n"
                    + "6.- Exit\n");
            int choice = scan.nextInt();

            int item;
            Node node;
            switch (choice) {
                case 1:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new Node(item);
                        insert(node);
                        item = scan.nextInt();
                    }
                    printTree(root);
                    break;
                case 2:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new Node(item);
                        System.out.print("\nDeleting item " + item);
                        if (delete(node)) {
                            System.out.print(": deleted!");
                        } else {
                            System.out.print(": does not exist!");
                        }
                        item = scan.nextInt();
                    }
                    System.out.println();
                    printTree(root);
                    break;
                case 3:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new Node(item);
                        System.out.println((findNode(node, root) != null) ? "found" : "not found");
                        item = scan.nextInt();
                    }
                    break;
                case 4:
                    printTree(root);
                    break;
                case 5:
                    deleteTree();
                    System.out.println("Tree deleted!");
                    break;
                case 6:
                    break menu;
            }
        }
    }
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.consoleUI();
    }
}
