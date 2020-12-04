package fop.w8iter;

public class Tester {

	public static void main(String[] args) {
		PasswordIterator iter = new PasswordIterator(5);
		while(iter.hasNext())
			System.out.println(iter.next());
		// TODO Auto-generated method stub

	}

}
