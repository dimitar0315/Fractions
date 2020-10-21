package drobi.edu;

import java.security.InvalidParameterException;

public class Fraction {
	
	int numerator;
	int denominator;
	
	
	
	public Fraction(int _numerator,int _denominator, boolean bNormalize) {
		
		if(_denominator ==0) {
			throw new InvalidParameterException();			
		}
		
		numerator = _numerator;
		denominator = _denominator;
		if (bNormalize)
			simplify();
	}
	public Fraction(int _numerator,int _denominator) {
		if(_denominator ==0) {
			throw new InvalidParameterException();			
		}
		
		numerator = _numerator;
		denominator = _denominator;
		simplify();
	}
	public Fraction() {
		numerator = 0;
		denominator = 1;
	}
	public Fraction(int _numerator) {
		numerator = _numerator;
		denominator = 1;
	}
	
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	
	public void setNumerator(int _numerator, boolean bNormalize) {
		this.numerator = _numerator;
		if (bNormalize)
			simplify();
	}
	public void setNumerator(int _numerator) {
		this.numerator = _numerator;
		simplify();
	}
	public void setDenominator(int _denominator, boolean bNormalize) {
		if(_denominator ==0) {
			throw new InvalidParameterException();			
		}
		this.denominator = _denominator;
		if (bNormalize)
			simplify();
	}
	public void setDenominator(int _denominator) {
		if(_denominator ==0) {
			throw new InvalidParameterException();			
		}
		this.denominator = _denominator;
		simplify();
	}

	public void set(int _numerator,int _denominator, boolean bNormalize) {
		if(_denominator ==0) {
			throw new InvalidParameterException();			
		}
		numerator = _numerator;
		denominator = _denominator;
		if (bNormalize)
			simplify();
	}
	public void set(int _numerator,int _denominator) {
		if(_denominator ==0) {
			throw new InvalidParameterException();			
		}
		numerator = _numerator;
		denominator = _denominator;
		simplify();
	}
	
	public String toString() {
		return Integer.toString(numerator)+"/"+ Integer.toString(denominator);
	}

	//Fractiona a
	//a.add(b)
	Fraction add(Fraction b) {
		return new  Fraction( this.numerator * b.denominator + b.numerator*this.denominator, this.denominator*b.denominator);
	}
	/*
	Fraction add(Fraction b,boolean bNormalize) {
		return new  Fraction( this.numerator * b.denominator + b.numerator*this.denominator, this.denominator*b.denominator, bNormalize);
	}
	//Fractional.add(a, b)
	static Fraction add(Fraction a, Fraction b)	{
		return new  Fraction( a.numerator * b.denominator + b.numerator*a.denominator, a.denominator*b.denominator);
	}
	static Fraction add(Fraction a, Fraction b,boolean bNormalize)	{
		return new  Fraction( a.numerator * b.denominator + b.numerator*a.denominator, a.denominator*b.denominator, bNormalize);
	}
	*/
	
	
	//Fraction sub(Fraction b)
	Fraction substract(Fraction b) {
		return new  Fraction( this.numerator * b.denominator - b.numerator*this.denominator, this.denominator*b.denominator);
	}
	
	//Fraction neg()
	
	
	//Fraction mult(Fraction b)
	Fraction multiply(Fraction b) {
		return new Fraction(this.numerator*b.numerator,this.denominator*b.denominator);
	}
	
	//Fraction div(Fraction b)
	Fraction divide(Fraction b) {
		return new Fraction(this.numerator*b.denominator,this.denominator*b.numerator);
	}
	
	
	static Fraction parse(String s) {
		int divPos = s.indexOf('/');
		if(divPos==-1) {
			return new Fraction(Integer.parseInt(s),1);
		}else {
			String numer = s.substring(0, divPos);
			String domer = s.substring(divPos+1);
			return new Fraction(Integer.parseInt(numer), Integer.parseInt(domer));
		}
		
	}
	//boolean equals(Fraction b)
	//int compareTo(Fraction b)
	//staic Fraction parse(String )
	
		//conversts the number to normalized format.
		//that is, the denominator is always positive
		//and NOD(abs(nominator), denominator))==1 
	private void simplify() {
		if(denominator<0) {
			denominator = -denominator;
			numerator = -numerator;
		}
		
		int nod = NOD(Math.abs(numerator), denominator);
		
		if(nod !=1) {
			numerator /= nod;
			denominator /= nod;
		}
		
	}
	
	
	
	//calculates the common demninator of a and be, assuming they are both positve non-zero numbers.
	public static int NOD(int a, int b) {
		int c = 0;
		if(a<b) {
			c = a;
			a = b;
			b = c;
		}
		
		while(b!=0) {
			c = a%b;
			a = b; 
			b = c;
		}
		return a;
	}
	
	
	
}
