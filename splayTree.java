
public class splayTree<Value extends Comparable<Value>>  {

    //root of the tree
    private Node root;   

    // Node of the tree
    private class Node {        
        private Value value;        // value of the node
        private Node left, right;   // left and right sub-trees

        public Node(Value value) {
            this.value = value;
        }
    }
    // Helper function to check if tree contains a particular value
    public boolean contains(Value value) {
        return get(value) != null;
    }

    // return value associated with the given key
    // if no such value, return null
    public Value get(Value value) {
        // Bring node associated with this "value" to the top of three using splay
        root = splay(root, value);
        int cmp = value.compareTo(root.value);
        if (cmp == 0) return root.value;
        else          return null;
    }    

    /** Function to insert value into  splay tree
    */
    public void insert(Value value) {
        // No root exists
        if (root == null) {
            root = new Node(value);
            return;
        }
        root = splay(root, value);
        int cmpr = value.compareTo(root.value);
        
        // Insert new node at root
        if (cmpr < 0) {
            Node n = new Node(value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Insert new node at root
        else if (cmpr > 0) {
            Node n = new Node(value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        // Duplicate value
        else {
            root.value = value;
        }

    }
   
    /** Function to delete node from splay tree
    */
    public void remove(Value value) {
        if (root == null) return; // empty tree
        
        root = splay(root, value);

        int cmpr = value.compareTo(root.value);
        
        if (cmpr == 0) {
            if (root.left == null) {
                root = root.right;
            } 
            else {
                Node x = root.right;
                root = root.left;
                splay(root, value);
                root.right = x;
            }
        }

        // else: it wasn't in the tree to remove. Do nothing.
    }
    
    
   /*
    * Splay tree function.
    * 
    *   Function to 'splay' a certain node  in the tree rooted at Node x. If a node with that value exists,
    *   it is splayed to the root of the tree. 
    *   If it does not, the last node along the search path for the 
    *   value is splayed to the root.
    *
    */
    private Node splay(Node x, Value value) {
        if (x == null) return null;

        int cmpr1 = value.compareTo(x.value);

        if (cmpr1 < 0) {
            //no key in the tree, so return
            if (x.left == null) {
                return x;
            }
            int cmpr2 = value.compareTo(x.left.value);
            if (cmpr2 < 0) {
                x.left.left = splay(x.left.left, value);
                x = rotateRight(x);
            }
            else if (cmpr2 > 0) {
                x.left.right = splay(x.left.right, value);
                if (x.left.right != null)
                    x.left = rotateLeft(x.left);
            }
            
            if (x.left == null) return x;
            else                return rotateRight(x);
        }

        else if (cmpr1 > 0) { 
            // similar to earlier case, return
            if (x.right == null) {
                return x;
            }

            int cmpr2 = value.compareTo(x.right.value);
            if (cmpr2 < 0) {
                x.right.left  = splay(x.right.left, value);
                if (x.right.left != null)
                    x.right = rotateRight(x.right);
            }
            else if (cmpr2 > 0) {
                x.right.right = splay(x.right.right, value);
                x = rotateLeft(x);
            }
            
            if (x.right == null) return x;
            else                 return rotateLeft(x);
        }

        else return x;
    }


    // height of tree (1-node tree has height 0)
    public int height() { return height(root); }

    private int height(Node h) {
        if (h == null) return -1;
        return 1 + Math.max(height(h.left), height(h.right));
    }

    
    public int size() {
        return size(root);
    }
    
    private int size(Node s) {
        if (s == null) return 0;
        else return 1 + size(s.left) + size(s.right);
    }
    
    // right rotate
    private Node rotateRight(Node r) {
        Node x = r.left;
        r.left = x.right;
        x.right = r;
        return x;
    }

    // left rotate
    private Node rotateLeft(Node l) {
        Node x = l.right;
        l.right = x.left;
        x.left = l;
        return x;
    }

    // test client
    public static void main(String[] args) {
        splayTree<Integer> intTree = new splayTree<Integer>();
        intTree.insert(5);
        intTree.insert(9);
        intTree.insert(13);
        intTree.insert(11);
        intTree.insert(1);
        System.out.println(intTree.get(9));
        System.out.println(intTree.get(4));
        
        splayTree<String> stringTree = new splayTree<String>();
        stringTree.insert("India");
        stringTree.insert("Japan");
        stringTree.insert("Canada");
        stringTree.insert("Mauritania");
        stringTree.insert("Singapore");
        System.out.println("The size 0 is: " + stringTree.size());
        stringTree.remove("Singapore");
        System.out.println("The size 1 is: " + stringTree.size());
        stringTree.remove("India");
        System.out.println("The size 2 is: " + stringTree.size());
        stringTree.remove("United States of America");
        System.out.println(stringTree.get("Mauritania"));
        System.out.println(stringTree.get("Malta"));
    }

}