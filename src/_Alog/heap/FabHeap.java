package _Alog.heap;

public class FabHeap {
	class FabNode{
		int key;
		int degree=0;
		FabNode left;
		FabNode right;
		FabNode parent;
		FabNode child;
		public FabNode(int key) {
			this.key = key;
			this.left=this;
			this.right=this;
			this.child=null;
			this.parent=null;
			this.degree=0;
		}
		
		
		
	}
	int size;
	FabNode minNode;
	
	
	public FabHeap() {
		this.size=0;
		minNode=null;
	}
	private void add(FabNode n,FabNode minNode){
		n.left=minNode.left;
		minNode.left.right=n;
		minNode.left=n;
		n.right=minNode;
	}
	private void add(FabNode n){
		
		if(this.minNode!=null)
			{
			add(this.minNode,n);
			if(minNode.key>n.key)minNode=n;
			}
		else minNode=n;
		size++;
		
	}
	public void insert(int key){
		
		add(new FabNode(key));
	}
	
	private void catList(FabNode a,FabNode b){
		FabNode t=a.right;
		a.right=b.right;
		b.right.left=a;
		b.right=t;
		t.left=b;
	}
	public void combine(FabHeap of){
		if(of==null)return;
		if(of.minNode==null){of=null;return;}
		if(minNode==null)minNode=of.minNode;
		else{
			catList(minNode,of.minNode);
			if(minNode.key>of.minNode.key)
				minNode=of.minNode;
		}
		size+=of.size;
		of=null;
	}
	

}
