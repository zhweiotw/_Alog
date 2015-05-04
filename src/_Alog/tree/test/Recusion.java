package _Alog.tree.test;

public class Recusion {
public static void main(String[] args) {
	Recusion r=new Recusion();
	System.out.println(r.jiec(5));
}
public int jiec(int c){
	return c<=1?1:c*jiec(c-1);
}

}
