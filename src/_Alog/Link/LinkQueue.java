package _Alog.Link;

public class LinkQueue {
	
	int N;
	QNode head;
	QNode tail;
	class QNode{
		
		QNode next;
		int key;
		public QNode(int key){
			this.key=key;
			next=null;
		}
	}		
public  LinkQueue(){
	this.N=0;
	this.head=null;
	this.tail=null;
}
public int size(){
	return N;
}
public boolean insert(int key){
	if(head==null){
		tail=head=new QNode(key);N=1;return true;
		}
		tail.next=new QNode(key);
		tail=tail.next;
		N++;
	return false;
}
	public int pop(){
		int key=head.key;
		head=head.next;
		N--;
		return key;
	}
	
}
