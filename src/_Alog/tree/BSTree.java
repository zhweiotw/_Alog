package _Alog.tree;

public class BSTree<T extends Comparable<T>> {
	private BSNode<T> mroot;
	
	public BSTree(BSTree<T>.BSNode<T> mroot) {
		super();
		this.mroot = mroot;
	}
	public BSNode<T> getMroot() {
		return mroot;
	}
	public void setMroot(BSNode<T> mroot) {
		this.mroot = mroot;
	}
	
	public BSTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public class BSNode<T extends Comparable<T>> {
		 T key;
		BSNode<T> left;
		 BSNode<T> right;
		 BSNode<T> parent;
		public BSNode(T key, BSNode<T> left, BSNode<T> right, BSNode<T> parent) {
			super();
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		

	}
	
	public void insert(BSTree<T> bst,BSNode<T> n){
		int cmp;
		BSNode<T> pre=null;
		BSNode<T> curn=bst.mroot;
		while(curn!=null){
			pre=curn;
			cmp=n.key.compareTo(curn.key);
			if(cmp<0)
				curn=curn.left;
			else curn=curn.right;
			
		}
		n.parent=pre;
		if(pre==null){
			bst.mroot=n;
		}
		else{
			cmp=n.key.compareTo(pre.key);
			if(cmp<0)pre.left=n;
			else pre.right=n;
		}
		
	}
	public BSNode<T> search(BSNode<T> curn,T key){
		while(curn!=null){
			int cmp=key.compareTo(curn.key);
			if(cmp<0)curn=curn.left;
			else if(cmp>0 )curn=curn.right;
			else return curn;
		}
		
		return null;
	}
	public BSNode<T> search(T key){
		return search(this.mroot,key);
	}
	
	public void insert(T key){
		if(key!=null)
		insert(this,new BSNode(key,null,null,null));
	}
	private BSNode<T> max(BSNode<T> curn){
		while(curn.right!=null){
			curn=curn.right;
		}
		
		return curn;
		
	}
	public T max(){
		return this.mroot==null?null:max(this.mroot).key;
	}
	private BSNode<T> min(BSNode<T> curn){
		
		while(curn.left!=null){
			curn=curn.left;
		}
		return curn;
	}
	public T min(){
		return this.mroot==null?null:min(this.mroot).key;
	}
	public T preccessor(BSNode<T> curn){
		
		if(curn.left!=null)
		return max(curn.left).key;
		BSNode<T> parent=curn.parent;
		while(parent!=null&&parent.left==curn){
			curn=parent;
			parent=parent.parent;
		}
		return parent.key;
	}
	public T successor(BSNode<T> curn){
		if(curn==null)return null;
		if(curn.right!=null){
			return min(curn.right).key;
		}
		BSNode<T> p=curn.parent;
		while(p!=null&&p.right==curn){
			curn=p;
			p=p.parent;
		}
		return p.key;
		 
	}

}

