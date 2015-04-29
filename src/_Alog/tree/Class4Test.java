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
	System.out.println(bst.preccessor(bst.getMroot().right));
	
}
}
