package _Alog.tree;

public class BSTree<T extends Comparable<T>> {
	private BSNode<T> mroot;

	public class BSNode<T extends Comparable<T>> {
		private T key;
		private BSNode<T> left;
		private BSNode<T> right;
		private BSNode<T> parent;
		public BSNode(T key, BSNode<T> left, BSNode<T> right, BSNode<T> parent) {
			super();
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		

	}
	
	public void insert(BSNode<T> mroot,BSNode<T> n){
		
	}
	

}
