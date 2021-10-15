package fop.w8iter;

import java.util.Iterator;
import java.util.Scanner;

public class Tester 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Type password length:");
		int pl = scan.nextInt();
		PasswordIterator iter = new PasswordIterator(pl);
		while (iter.hasNext()) 
			System.out.println(iter.next());
	}
}
