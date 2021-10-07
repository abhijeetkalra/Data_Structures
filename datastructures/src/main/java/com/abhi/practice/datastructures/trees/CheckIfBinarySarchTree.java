package com.abhi.practice.datastructures.trees;

public class CheckIfBinarySarchTree {
	
	
	public static boolean isBST(BinaryTreeNode root)
    {
        // code here.
        if(root==null) return true;
        
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    
    public static boolean isBSTRec(BinaryTreeNode root, int min, int max){
        
        if(root==null) return true;
        
        if(root.data < min || root.data > max) return false;
        
        return isBSTRec(root.left, min, root.data -1) && isBSTRec(root.right, root.data+1, max);
        
        
    }

}
