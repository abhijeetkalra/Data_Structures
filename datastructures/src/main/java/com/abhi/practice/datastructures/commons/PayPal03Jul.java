/*
		1
       / \
        
      2   3
      
     /\    \
      
    4<->5<--->7 
    
    
class Node {
      int val;
      Node left;
      Node right;
  }
    
    
 void traverse(Node root) {
     if(root == null){
         return;
     }
     System.out.println(root.val);
     
     if(root.left != null && root.right != null){
         if(root.left.left == root.right || root.left.right == root.right){
            root.left.left = null;
            root.left.right = null; 
            root.right.left = null;
            root.right.right = null;
         }
     }
     
     if(root.left != null){
         traverse(root.left);
     }
     if(root.right != null){
         traverse(root.right);
     }
     
     
 }
 
         1
       / \
        
      2   3
      /\
     6  9      8     11
      
     /\           /\        / \
      
    4<->5------ 17  13    12-->7 
 
 void traverse2(Node root) {
     if(root == null){
         return;
     }
     System.out.println(root.val);
     List<Node> parents = new ArrayList<>();
     if(root.left != null){
         parents.add(root.left);
     }
     if(root.right != null){
         parents.add(root.right);
     }
     List<Node> childNodes = new ArrayList<>();
     for(Node n : parents){
         if(n.left != null){
             childNodes.add(n.left);
         }
         if(n.right != null){
             childNodes.add(n.right);
         }
     }
     for(Node n:parents){
         if(childNodes.contains(n.left.left)){
            n.left.left = null;
         }
         if(childNodes.contains(n.left.right)){
            n.left.right = null;
         }
         if(childNodes.contains(n.right.left)){
            n.right.left = null;
         }
         if(childNodes.contains(n.right.right)){
            n.right.right = null;
         }
     }
     for(Node n : parents){
         traverse2(n);
     }
     
 }
 
 
 
 search a key in Array is that is sorted and rotated
 
 Input: [4,5,6,7,0,1,2] , target = 6
 
 output: 2
 
 int sol(int[] arr, int target){
     boolean flag = false;
     int count = 0;
     for(int i=0;i<arr.length;i++){
         if(arr[i] == target){
             flag = true;
         }
         if(arr[i]< target){
             count++;
         }
     }
     if(flag){
         return count+1;
     }
     return -1;
 }

*/