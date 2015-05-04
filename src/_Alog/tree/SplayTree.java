package _Alog.tree;

import java.util.concurrent.ConcurrentHashMap;

class Node{
	Comparable key;
	Node left,right;
	public Node(Comparable key) {
		super();
		this.key = key;
		left=right=null;
	}
	
}


public class SplayTree {

	Node root;
	public void SPlayTree(){
		root=null;
	}
	
	private static Node header=new Node(null);
	
	public void splay(Comparable key){
		Node l,xb,tr,tl;
		 l=root;
		 tl=tr=header;
		for(;;){
			if(key.compareTo(l.key)<0){
				if(l.left==null)break;
				if(key.compareTo(l.left.key)<0){
					xb=l.left;
					l.left=xb.right;
					xb.right=l;
					l=xb;
					if(l.left==null)break;
					
				}
				tr.left=l;
				tr=l;
				l=l.left;
			}
			else if(key.compareTo(l.key)>0){
				
			}
			
		}
		
		
	}
	
}
