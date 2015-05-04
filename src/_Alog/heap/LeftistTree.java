package _Alog.heap;

public class LeftistTree <T extends Comparable<T>>{
		HeapNode<T> root;
		public LeftistTree() {
			this.root = null;
		}

		class HeapNode<T extends Comparable<T>>{
			T key;
			int npl;
			HeapNode<T> left;
			HeapNode<T> right;
			public HeapNode(T key) {
				this.key = key;
			}
			
		}
		
		
		
		private HeapNode<T> merge(HeapNode<T> h1,HeapNode<T> h2){
			
			if(h1==null)return h2;
			if(h2==null)return h1;
			
			
			if(h1.key.compareTo(h2.key)>0){
				HeapNode<T> temp=h1;
				h1=h2;
				h2=temp;
			}
			h1.right=merge(h1.right,h2);
			
			if(h1.left==null||h1.left.npl<h2.npl){
				HeapNode<T> temp=h1.left;
				h1.left=h2;
				h2=temp;
			}
			
			h1.npl=h1.left==null?0:h1.left.npl+1;
			
			return h1;
			
		}
		public void merge(LeftistTree<T> ol){
			root=merge(root,ol.root);
		}
		public T remove(){
			
			if(root==null)return null;
			
			T key=root.key;
			
			root=merge(root.left,root.right);
			return key;
			
		}
		public void insert(T key){
			root=merge(root,new HeapNode<T>(key));
		}
		
}
