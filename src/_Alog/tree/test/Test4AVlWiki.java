package _Alog.tree.test;

import _Alog.tree.WIkIAVLTree;

public class Test4AVlWiki {

	
	public static void main(String[] args) {
		int ks[] ={8,6,2,5,16,48,7,4,11,89,54,13,19,1,17};
		WIkIAVLTree avl=new WIkIAVLTree();
		for(int i : ks){
			avl.insert(i);
		}
		avl.printValues();
		System.out.println();
		avl.printBfs();
		System.out.println();
		System.out.println(avl.hight(avl.root));
		avl.delete(89);
		avl.printValues();System.out.println();avl.printBfs();
	}
}
