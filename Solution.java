import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    public static class BSTNode {
    BSTNode left;
    BSTNode right;
    int data;
  
    
    public BSTNode(int d)
    {
        left = null;
        right = null;
        data = d;
    } 
}

public static class BSTree {
    BSTNode root;
    
    public BSTree()
    {
        root = null;
    }
    
    public BSTNode BSTInsert(int d, BSTNode r)
    {
        if(r == null)
        {
            r = new BSTNode(d);
            return r;
        }
        
        if(r.left == null && r.right == null)
        {
            if(d > r.data)
                r.right = new BSTNode(d);
            else if(d < r.data)
                r.left = new BSTNode(d);
            return r;
        }
        else
        {
            BSTNode iter = r;
            while(iter != null)
            {
               if(d > iter.data)
                 {
                  if(iter.right == null)
                  {
                     iter.right = new BSTNode(d);
                     return r; 
                  }
                  else
                      iter = iter.right;
                 } 
               else if(d < iter.data)
                 {
                   if(iter.left == null)
                   {
                      iter.left = new BSTNode(d);
                       return r;
                   }
                   else 
                      iter = iter.left;
                 } 
            }
        
        }
        return r;
    }
    
    public void print()
    {
        System.out.print("In-order traversal on Binary Search Tree : \n");
        inOrderPrint(root);
    }
    
    public void inOrderPrint(BSTNode r)
    {
        if(r == null)
            return;
        inOrderPrint(r.left);
        System.out.print(" " + r.data + " ");
        inOrderPrint(r.right);
    }

    public int computeHt(BSTNode r)
    {
      int lHeight, rHeight, height;
      if(r.left == null && r.right == null)
      {
        height = 0;
        return 0;
      }

      else
      {
        lHeight = (r.left != null) ? computeHt(r.left) : 0;
        rHeight = (r.right != null) ? computeHt(r.right) : 0;
        height = (lHeight > rHeight) ? lHeight + 1 : rHeight + 1;
        return height;
      }
    }

    public int findShallowestLeafLevel(BSTNode r)
    {
      int lCount = 1;

      if(r.left == null && r.right == null)
        return 1;

      int lHeight = r.left != null ? computeHt(r.left) : Integer.MAX_VALUE;
      int rHeight = r.right != null ? computeHt(r.right) : Integer.MAX_VALUE;

      if(lHeight < rHeight || lHeight == rHeight)
      {
        lCount += findShallowestLeafLevel(r.left);
      }
      else
        lCount += findShallowestLeafLevel(r.right);

      return lCount;

    }

    
   public int shallowestLeavesSum(BSTNode r, int level)
    {
          int sum = 0;

          if(r.left == null && r.right == null && level == findShallowestLeafLevel(root))
            return r.data;

          if(r.right != null)
            sum += shallowestLeavesSum(r.right, level+1); 

          if(r.left != null)
            sum += shallowestLeavesSum(r.left, level+1);
          
          return sum;
          
    } 

    
}


    public static void main(String args[] ) throws Exception {
        
        BSTree T = new BSTree();
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        while(t != -1)
        {
           T.root = T.BSTInsert(t, T.root);
           t = sc.nextInt();
        }        

        //System.out.print(T.findShallowestLeafLevel(T.root));
        System.out.print(T.shallowestLeavesSum(T.root, 1));
   }
}