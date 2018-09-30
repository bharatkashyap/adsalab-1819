class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

class AVLTree {

    Node root;

    // Helper function to get the height of the node
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // Helper function to return the greater of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Helper function that rotates tree right on being passed its root 
    Node rightRotate(Node y) {
        Node x = y.left;
        Node beta = x.right;

        // Right rotation
        x.right = y;
        y.left = beta;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // New root
        return x;
    }

    // Helper function that rotates tree left on being passed its root
    Node leftRotate(Node x) {
        Node y = x.right;
        Node alpha = y.left;

        // Left rotation
        y.left = x;
        x.right = alpha;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // New root
        return y;
    }

    // Helper function that returns balance factor of a node
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {

        // 1. BST Insertion
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys should terminate insertion
            return node;

        // 2. Update height
        node.height = 1 + max(height(node.left),
                              height(node.right));

        // 3. Check to see if the tree remains balanced
        int balance = getBalance(node);

        // 4. Tree is imbalanced
        //  4.1 Left Left insertion
        if (balance > 1 && key < node.left.key)
            // Fixed by rotating tree rooted at imbalanced node right
            return rightRotate(node);


        //  4.2 Right Right insertion
        if (balance < -1 && key > node.right.key)
            // Fixed by rotating tree rooted at imbalanced node left
            return leftRotate(node);

        //  4.3 Left Right insertion
        if (balance > 1 && key > node.left.key) {
            /**
             * Fixed by left rotating on subtree rooted at left child of imbalanced node, 
             * followed by right rotating on imbalanced node
             */

            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //  4.4 Right Left insertion
        if (balance < -1 && key < node.right.key) {
            /** 
             * Fixed by right rotating on subtree rooted at right child of imbalanced node, 
             * followed by left rotating on imbalanced node 
             */

            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return pointer to node 
        return node;
    }

    /**
     * Helper function to return the node with 
     * minimum key value found in that tree, given its root.
     */
   Node minValueNode(Node node)
   {
       Node current = node;

       // Find left-most non-null node
       while (current.left != null)
          current = current.left;

       return current;
   }

   Node delete(Node root, int key)
   {
       // 1. BST Deletion
       if (root == null)
           return root;

       if (key < root.key)
           root.left = delete(root.left, key);

       else if (key > root.key)
           root.right = delete(root.right, key);

       else
       {
           if ((root.left == null) || (root.right == null))
           {
               Node temp = null;
               temp = (root.right == temp) ? root.left : root.right;

               // Node to be deleted is a leaf node
               if (temp == null)
               {
                   temp = root;
                   root = null;
               }
               // Node to be deleted has one child
               else   
                  // Replace node to be deleted with its child
                   root = temp; 
                                
           }
           // Node to be deleted has two children
           else
           {
              // Get the inorder successor
               Node temp = minValueNode(root.right);

               // Copy the inorder successor's key to the node to be deleted
               root.key = temp.key;

               // Delete the inorder successor
               root.right = delete(root.right, temp.key);
           }
       }

       // Tree had one only node before deletion
       if (root == null)
           return root;

       // 2. Update height
       root.height = max(height(root.left), height(root.right)) + 1;

       
       // 3. Check to see if tree remains balanced
       int balance = getBalance(root);

       // 4. Tree is imbalanced
       //   4.1 Left Left case
       if (balance > 1 && getBalance(root.left) >= 0)
           return rightRotate(root);

       //   4.2 Right Right case
       if (balance < -1 && getBalance(root.right) <= 0)
           return leftRotate(root);

       //   4.3 Left Right case
       if (balance > 1 && getBalance(root.left) < 0)
       {
           root.left = leftRotate(root.left);
           return rightRotate(root);
       }

      //    4.4 Right Left case
       if (balance < -1 && getBalance(root.right) > 0)
       {
           root.right = rightRotate(root.right);
           return leftRotate(root);
       }

       return root;
   }

    void preOrderPrint(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderPrint(node.left);
            preOrderPrint(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
               20
              /  \
            10   30
           /    /  \
          5    25  40

        */
        System.out.println("\nPreorder traversal" +
                        " of constructed tree is : ");
        tree.preOrderPrint(tree.root);

        tree.root = tree.delete(tree.root, 25);
        /* The modified AVL Tree would be
               20
              /  \
            10   30
           /       \
          5        40
        */
        System.out.println("\nPreorder traversal" +
                        " of modified tree is : ");
        tree.preOrderPrint(tree.root);
    }
}
