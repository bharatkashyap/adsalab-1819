import java.util.Scanner;

class Node {
    static final int BLACK = 0, RED = 1;
    int key;
    int colour = BLACK;
    Node left = null, right = null, parent = null;

    Node(int key) {
        this.key = key;
        this.colour = BLACK;
    }

}

public class RedBlackTree {
    static final int BLACK = 0, RED = 1;
    Node root;

    void preOrderPrint(Node node) {
        if(node != null) {
            System.out.print(node.key + " : " + colorify(node.colour));
            preOrderPrint(node.left);
            preOrderPrint(node.right);
        }
    }

    String colorify(int code) {
        return code == 0 ? " BLACK " : " RED "; 
    }

    void insert(int key) {
        Node node = new Node(key);
        Node x, y;
        x = root;
        y = null;
        while (x != null) {
            y = x;
            if(node.key < x.key)
                x = x.left;
            else
                x = x.right;
        }
        node.parent = y;
        if(y == null)
        root = node;
        else if(node.key < y.key)
            y.left = node;
        else 
            y.right = node;
        node.colour = RED;
        insertFix(node);
    }

    //Takes as argument the newly inserted node
    void insertFix(Node node) {
        Node uncle;
        main: while(node.parent != null && node.parent.colour == RED) {
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != null && uncle.colour == RED) {
                    node.parent.colour = BLACK;
                    uncle.colour = BLACK;
                    node.parent.parent.colour = RED;
                    node = node.parent.parent;  
                    continue main;      
                }
                else if (node == node.parent.right) {
                    // Rotate left on parent
                    leftRotate(node.parent);
                }
                node.parent.colour = BLACK;
                node.parent.parent.colour = RED;
                rightRotate(node.parent.parent);
            } 
            else {
                uncle = node.parent.parent.left;
                if (uncle != null && uncle.colour == RED) {
                        node.parent.colour = BLACK;
                        uncle.colour = BLACK;
                        node.parent.parent.colour = RED;
                        node = node.parent.parent;
                        continue main;
                }
                else if (node == node.parent.left) {
                    // Rotate right on parent
                    rightRotate(node.parent);
                }
                node.parent.colour = BLACK;
                node.parent.parent.colour = RED;
                leftRotate(node.parent.parent);
            }
        }
        root.colour = BLACK;
    }

    // Helper function to rotate subtree left on being passed its root
    void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) 
            y.left.parent = x;
        y.parent = x.parent;
        if(x.parent == null) 
            // Rotation on root
            root = y;
        else if(x == x.parent.left)
            x.parent.left = y;
        else 
            x.parent.right = y;

        //Rotation
        y.left = x;
        x.parent = y;
    }

    void rightRotate(Node x) {
        Node y = x.left;
        y.right = x.left;
        if(y.right != null)
            y.right.parent = x;
        y.parent = x.parent;

        if(x.parent == null)
            //Rotation on root
            root = y;
        else if(x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;

        //Rotation
        y.right = x;
        x.parent = y;
    }

    // Utility function to delete the tree by setting root to null
    void deleteTree() {
        root = null;
    }

    /*
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

    */

    
    public static void main(String[] args) {
        RedBlackTree T = new RedBlackTree();
        T.insert(1);
        T.insert(4);
        T.insert(5);
        T.insert(6);
        System.out.print("\nPreorder traversal of constructed tree is: ");
        T.preOrderPrint(T.root);
    }
}
