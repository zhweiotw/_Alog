package _Alog.tree;




public class RedBlackTree<T extends Comparable<T>> {
		
	Node<T> root;
	private static boolean RED=false;
	private static boolean BLACK=true;
	class Node<T extends Comparable<T>>{
		T key;
		Node<T> left,right,parent;
		boolean color=BLACK;
		public  Node(T key){
			this.key=key;
		}
	}
	public RedBlackTree() {
		root=null;
	}
	private Node<T> parentOf(Node<T> a){
		return a==null?null:a.parent;
	}
	private boolean colorOf(Node<T> a){
		return a==null?BLACK:a.color;
	}
	private void setColor(Node<T> a,boolean c){
		if(a!=null)
		a.color=c;
	}
	private void setRed(Node<T> a){
		setColor(a,RED);
	}
	private void setBlack(Node<T> a){
		setColor(a,BLACK);
		
	}
	public void rotateLeft(Node<T> a){
		if(a==null)return;
		Node<T> y=a.right;
		a.right=y.left;
		if(a.parent==null)
			root=y;
		else if(a.parent.left==a)a.parent.left=y;
		else a.parent.right=y;
		y.left=a;
		a.parent=y;
	}
	public void rotateRight(Node<T> a){
		if(a==null) return;
		Node<T> y=a.left;
		a.right=y.left;
		if(a.parent==null)root=y;
		else if(a.parent.left==a)a.parent.left=y;
		else a.parent.right=y;
		y.left=a;
		a.parent=y;
	}
	private void fixAfterInsertion(Node<T> n){
		n.color=RED;
		while(n!=null&&n!=root&&n.parent.color==RED){
			if(n.parent==parentOf(parentOf(n)).left){
				Node<T> y=parentOf(parentOf(n)).right;
				if(y.color==RED){
					n.parent.color=BLACK;
					y.color=BLACK;
					parentOf(parentOf(n)).color=RED;
					n=parentOf(parentOf(n));
				}
				else{
					if(n==parentOf(n).right){
						n=n.parent;
						rotateLeft(n);
					}
					setBlack(n.parent);
					setRed(parentOf(parentOf(n)));
					rotateRight(parentOf(parentOf(n)));
				}
			}
			else{
				Node<T> y=parentOf(parentOf(n)).left;
				if(y.color==RED){
					setRed(parentOf(parentOf(n)));
					setBlack(n.parent);
					setBlack(y);
					n=parentOf(parentOf(n));
				}
				else{
					if(n==parentOf(n).left){
						n=parentOf(n);
						rotateRight(n);
					}
					setBlack(n.parent);
					setRed(parentOf(parentOf(n)));
					rotateLeft(parentOf(parentOf(n)));
				}
				
			}
			
		}
		
		root.color=BLACK;
		
	}
	
	public void insert(T key){
		if(root==null){root=new Node<T>(key);}
		Node<T> p,t,n;
		n=new Node<T>(key);
		t=root;
		p=null;
		int cmp;
		while(t!=null){
			p=t;
			cmp=key.compareTo(t.key);
			if(cmp<0)t=t.left;
			else if(cmp>0)t=t.right;
			else return ;
		}
		n.parent=p;
		cmp=key.compareTo(p.key);
		if(cmp<0)p.left=n;
		else p.right=n;
		n.color=RED;
		fixAfterInsertion(n);
	}
	public void remove(T key){
		Node<T> tsg,tsgf,n,delN;
		n=root;
		tsg=null;tsgf=null;delN=null;
		if(n==null)return;
		while(n!=null){
			tsgf=tsg;
			tsg=n;
			if(key.compareTo(n.key)==0)delN=n;
			if(key.compareTo(n.key)<0)n=n.left;
			else n=n.right;
		}
		if(delN!=null){
			delN.key=tsg.key;
			n=tsg.left!=null?tsg.left:tsg.right;
			if(n!=null)n.parent=tsgf;
			if(delN.key.compareTo(root.key)==0)root=n;
			else{
			if(tsgf.left==tsg)tsg.left=n;
			else tsgf.right=n;
			}
			tsg.left=tsg.right=tsg.parent=null;
			
		}
		
	}
	private void fixAfterDelection(){
		
	}
	
}
