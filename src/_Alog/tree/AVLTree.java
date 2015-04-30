package _Alog.tree;

public class AVLTree<T extends Comparable<T>> {
	private AVLNode<T> mroot; 
	class AVLNode<T extends Comparable<T>>{
		T key;
		int hight;
		AVLNode<T> left;
		AVLNode<T> right;
	}
	
	private int hight(AVLNode<T> curn){
		return curn==null?0:curn.hight;
	}
	public int getHight(){
		return hight(this.mroot);
	}
	private int max(int a,int b){
		return a>b?a:b;
	}
	
	private AVLNode<T> LLRotation(AVLNode<T> k2){
		AVLNode<T> k1=null;
		k1=k2.left;
		k2.left=k1.right;
		k1.right=k2;
		k2.hight=max(hight(k2.left),hight(k2.right))+1;
		k1.hight=max(hight(k1.left),k2.hight)+1;
		return k1;
	}
	private AVLNode<T> RRRotation(AVLNode<T> k1){
		AVLNode<T> k2=null;
		k2=k1.right;
		k1.right=k2.left;
		k2.left=k1;
		k1.hight=max(hight(k1.left),hight(k1.right))+1;
		k2.hight=max(k1.hight,hight(k2.right))+1;
		return k2;
	}
	private AVLNode<T> RLRotation(AVLNode<T> k3){
		k3.left=RRRotation(k3.left);
		return LLRotation(k3);
	}
	private AVLNode<T> LRRotation(AVLNode<T> k1){
		k1.right=LLRotation(k1.right);
		return RRRotation(k1);
	}
	private void insert(AVLTree<T> avlt,AVLNode<T> curn){
		int cmp=0;
		AVLNode<T> pre=avlt.mroot;
		AVLNode<T> parent=null;
		while(pre!=null){
			cmp=curn.key.compareTo(pre.key);
			parent=pre;
			parent.hight++;
			if(cmp<0)pre=pre.left;
			else pre=pre.right;
		}
		
		
		if(parent==null){avlt.mroot=curn;return;}
		
		cmp=curn.key.compareTo(parent.key);
		if(cmp<0){
			parent.left=curn;
			
		}

		
		
	}
	
	
}
