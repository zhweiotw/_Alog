package _Alog.heap;


public class MaxHeap<T extends Comparable<T>> {
	
	T [] pq;
	int N;
	@SuppressWarnings("unchecked")
	public MaxHeap(int capatity){
		pq=(T[]) new Comparable[capatity+1];
	}
	
	private boolean less(int i1,int i2){
		return pq[i1].compareTo(pq[i2])<=0;
	}
	private void exec(T t1,T t2){
		T n=t1;
		t1=t2;t2=n;
	}
	private void sink(int c){
		if(c>pq.length)return;
		int cm;
		while(c<pq.length){
			cm=less(2*c,2*c+1)?2*c+1:2*c;
			if(!less(cm,c)){
				exec(pq[cm],pq[c]);
				c=cm;
			}
			else break;
		}
	}
	
	private void swin(int c){
		int p;
		while(c>0){
			p=(c-1)/2;
			if(less(p,c)){
				exec(pq[p],pq[c]);
				p=(p-1)/2;
			}else break;
		}
		
	}

}
