package com.abhi.practice.datastructures.commons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Juspay {
    public static void main(String args[] ) throws Exception {
        // Sample code to perform I/O:
        // Use either of these methods for input

        //BufferedReader
        /*
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */

        //Scanner
        Scanner s = new Scanner(System.in);
        //String name = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        
        // Write your code here
        
        Integer nodesNum = Integer.parseInt(s.nextLine());
        Integer numChild = Integer.parseInt(s.nextLine());
        Integer numOps = Integer.parseInt(s.nextLine());
        
        Queue<LockableNode> q = new LinkedList<LockableNode>();
        
    	/*
    	List<LockableNode> rootChild = new ArrayList<LockableNode>();
        for(int i=0;i<numChild;i++) {
    		String str = s.nextLine();
    		LockableNode node = new LockableNode(str, null, null);
    		q.offer(node);
    		rootChild.add(node);
    	}*/
        String rootNodeVal = s.nextLine();
        nodesNum--;
        LockableNode rootNode = new LockableNode(rootNodeVal, null, null);
        q.offer(rootNode);
        
        while(nodesNum>0) {  
        	Queue<LockableNode> q2 = new LinkedList<LockableNode>();
        	while(!q.isEmpty()) {
	        	LockableNode parent = q.poll();
	        	List<LockableNode> list = new ArrayList<LockableNode>();
	        	for(int i=0;i<numChild;i++) {
	        		String str = s.nextLine();
	        		nodesNum--;
	        		LockableNode node = new LockableNode(str, parent, null);
	        		list.add(node);
	        		q2.offer(node);
	        	}
	        	parent.setChildren(list);
	        }
	        q.addAll(q2);
        }
        
        String[] strArr;
        for(int i=0; i<numOps; i++) {
        	strArr = s.nextLine().split(" ");
        	Juspay js = new Juspay();
        	js.callOps(strArr, rootNode);
        }
        

        

    }
    
    public void callOps(String[] arr, LockableNode rootNode) {
    	switch (Integer.parseInt(arr[0])) {
		case 1:
			System.out.println(lock(arr[1], arr[2], rootNode));
			break;
		case 2:
			System.out.println(unlock(arr[1], arr[2], rootNode));
			break;
		case 3:
			System.out.println(upgrade(arr[1], arr[2], rootNode));
			break;

		default:
			break;
		}
    }
    
    
    public boolean lock(String x, String uid, LockableNode rootNode) {
    	LockableNode node = findNode(x, rootNode);
    	if(node.isLocked()) {
    		return false;
    	}
    	
    	if(node.getLockedDecendantCount()>0) {
    		return false;
    	}
    	
    	for(LockableNode ancestor = node.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
    		if(ancestor.isLocked())
    			return false;
    	}
    	
    	for(LockableNode ancestor = node.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
    		ancestor.setLockedDecendantCount(ancestor.getLockedDecendantCount()+1);
    		
    	}
    	node.setLocked(true);
    	node.setLockedBy(uid);
    	return true;	
    	
    }
    
    public boolean unlock(String x, String uid, LockableNode rootNode) {
    	LockableNode node = findNode(x, rootNode);
    	
    	if(node.isLocked() && node.getLockedBy().equals(uid)) {
    		for(LockableNode ancestor = node.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
        		ancestor.setLockedDecendantCount(ancestor.getLockedDecendantCount()-1);
        	}
    		node.setLocked(false);
    		return true;
    	}
    	return false;
    }
    
    public boolean unlock(LockableNode node, String uid) {
    	
    	if(node.isLocked() && node.getLockedBy().equals(uid)) {
    		for(LockableNode ancestor = node.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
        		ancestor.setLockedDecendantCount(ancestor.getLockedDecendantCount()-1);
        	}
    		node.setLocked(false);
    		return true;
    	}
    	return false;
    }
    
    public boolean upgrade(String x, String uid, LockableNode rootNode) {
    	LockableNode node = findNode(x, rootNode);
    	
    	Queue<LockableNode> q = new LinkedList<LockableNode>();
    	List<LockableNode> list = new ArrayList<LockableNode>();
    	q.addAll(node.getChildren());
    	while(!q.isEmpty()) {
    		LockableNode n = q.poll();
    		if(!(n.isLocked() && n.getLockedBy().equals(uid))) {
    			return false;
    		}
    		if(n.getChildren() != null)
    			list.addAll(n.getChildren());
        	if(q.isEmpty() && !list.isEmpty()) {
        		q.addAll(list);
        		list.clear();
        	}
    	}
    	
    	
    	node.setLocked(true);
    	node.setLockedBy(uid);
    	
    	//setting all child nodes as unlocked {ambiguity in question}
    	q.addAll(node.getChildren());
    	while(!q.isEmpty()) {
    		LockableNode n = q.poll();
    		unlock(n, uid);
    		if(n.getChildren() != null)
    			list.addAll(n.getChildren());
        	if(q.isEmpty() && !list.isEmpty()) {
        		q.addAll(list);
        		list.clear();
        	}
    	}
    	
    	
    	return true;
    }
    
    public LockableNode findNode(String x, LockableNode rootNode) {
    	Queue<LockableNode> q = new LinkedList<LockableNode>();
    	q.offer(rootNode);
    	List<LockableNode> list = new ArrayList<LockableNode>();
    	LockableNode res = null;
    	while(!q.isEmpty() && res == null) {
    		LockableNode node = q.poll();
    		if(node.getValue().equals(x)) {
    			res = node;
    		}
    		if(node.getChildren()!= null)
    			list.addAll(node.getChildren());    		
        	if(q.isEmpty() && !list.isEmpty()) {
        		q.addAll(list);
        		list.clear();
        	}
    	}
    	return res;
    }
}

class LockableNode {
    private String value;
    private LockableNode parent;
    private List<LockableNode> children;
    private boolean locked = false;
    private String lockedBy;
    private Integer lockedDecendantCount = 0;

    public LockableNode(String value, LockableNode parent,
     List<LockableNode> children ){
         this.value = value;
         this.parent = parent;
         this.children = children;
     }
    
    public void setChildren(List<LockableNode> list) {
    	this.children = list;
    }
    
    public List<LockableNode> getChildren(){
    	return children;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LockableNode getParent() {
		return parent;
	}

	public void setParent(LockableNode parent) {
		this.parent = parent;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getLockedBy() {
		return lockedBy;
	}

	public void setLockedBy(String lockedBy) {
		this.lockedBy = lockedBy;
	}

	public Integer getLockedDecendantCount() {
		return lockedDecendantCount;
	}

	public void setLockedDecendantCount(Integer lockedDecendantCount) {
		this.lockedDecendantCount = lockedDecendantCount;
	}
     
}