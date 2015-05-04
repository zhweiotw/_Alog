package _Alog.tree;

public class WIkIAVLTree {
	public	Node root;
	class Node{
		int key;
		int bf;
		Node left,right,parent;
		public Node(int key, Node parent) {
			super();
			this.key = key;
			this.parent = parent;
		}
		
	}
	public int hight(Node n){
		if(n==null)return 0;
		return Math.max(hight(n.left), hight(n.right))+1;
	}
	public void setBF(Node... nodes){
		for(Node n:nodes){
			n.bf=hight(n.right)-hight(n.left);
		}
		
	}
	private Node rotateLeft(Node a){
		Node b=a.right;
		b.parent=a.parent;
		a.right=b.left;
		if(a.right!=null)a.right.parent=a;
		b.left=a;
		a.parent=b;
		if(b.parent!=null){
			if(b.parent.right==a){
				b.parent.right=b;
			}else b.parent.left=b;
		}
		setBF(a,b);
		return b;
	}
	
	private Node rotateRight(Node a){
		Node b=a.left;
		b.parent=a.parent;
		a.left=b.right;
		if(b.right!=null)b.right.parent=a;
		b.right=a;
		a.parent=b;
		if(b.parent!=null){
			if(b.parent.left==a)b.parent.left=b;
			else b.parent.right=b;
		}
		
		setBF(a,b);
		return b;
	}
	
	private Node rotateLeftRight(Node a){
		rotateLeft(a.left);
		return rotateRight(a);
	}
	
	private Node rotateRightLeft(Node a){
		rotateRight(a.right);
		return rotateLeft(a);
	}
	
	
	private Node rebalance(Node a){
		setBF(a);
		
		if(a.bf==-2){
			if(hight(a.left.left)>=hight(a.left.right))a=rotateRight(a);
			else a=rotateLeftRight(a);
		}
		else if(a.bf==2){
			if(hight(a.right.right)>=hight(a.right.left))a=rotateLeft(a);
			else a=rotateRightLeft(a);
		}
		if(a.parent!=null){
			rebalance(a.parent);
		}else root=a;
		
		return a;
		
	}
	public boolean insert(int k){
		if(root==null){
			root=new Node(k,null);
			return true;
		}
		Node tmp=root;
		Node p=null;
		while(tmp!=null){
			p=tmp;
			if(k<tmp.key)tmp=tmp.left;
			else if(k>tmp.key) tmp=tmp.right;
			else return false;
		}
		if(k<p.key)p.left=new Node(k,p);
		else p.right=new Node(k,p);
		rebalance(p);
		return true;
	}
	private void printValues(Node n){
		if(n==null)return;
		printValues(n.left);
		System.out.print(n.key+",");
		printValues(n.right);
		
		
	}
	
	public void delete(int key){
		Node n=root;
		Node delN=null;
		Node tsg=null;
		Node tsgf=null;
		while(n!=null){
			tsgf=tsg;
			tsg=n;
			if(key==n.key)delN=n;
			n=key>=n.key?n.right:n.left;
		}
			if(delN!=null){
				delN.key=tsg.key;
				n=tsg.left!=null?tsg.left:tsg.right;
				if(n!=null)n.parent=tsgf;
				if(root.key==delN.key)root=n;
				
				else{
					if(tsgf.left==tsg)tsgf.left=n;else tsgf.right=n;
					rebalance(tsgf);
					}
			}
		
		
		
		
		
	}
	
	private void printBfs(Node n){
		if(n==null)return;
		printBfs(n.left);
		System.out.print("<"+n.bf+">");
		printBfs(n.right);
	}
	
public void printValues(){
	printValues(root);
}

public void printBfs(){
	setBF(root);
	printBfs(root);
}


}
