package drobi.edu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String s1 = s.next();
		String s2 = s.next();
		
		s.close();
		
		Fraction f1 = Fraction.parse(s1);
		Fraction f2 = Fraction.parse(s2);
		
		System.out.println("a+b="+f1.add(f2).toString());
		System.out.println("a-b="+f1.substract(f2).toString());
		System.out.println("a*b="+f1.multiply(f2).toString());
		System.out.println("a/b="+f1.divide(f2).toString());
		
		

	}

}
