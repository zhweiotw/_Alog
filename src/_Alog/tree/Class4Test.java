package _Alog.tree;

public class Class4Test {
public static void main(String[] args) {
	BSTree<Integer> bst=new BSTree<Integer>();
	bst.insert(5);
	bst.insert(9);
	bst.insert(12);
	bst.insert(8);
	bst.insert(2);
	System.out.println(bst.max());
	System.out.println(bst.remove2(bst.search(8)).key);
	bst.insert(6);
	System.out.println();
	
}
}
