/*************************************************************************
* Assignment 2 for CSCI 271-001 Spring 2026
*
* Author: Cyera John
* OS: Ubuntu Debian 24.04.3
* Compiler: javac 21.0.9
* Date: January 27, 2026
*
* Purpose
*
*************************************************************************/
/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Cyera John
********************************************************************/
public class Fraction { /* obtained from course notes */
/*****************************<main>****************************
* Description: the main function of the code takes in arguements.
*
* Parameters: arguements
*
* Pre: class has to be made before anything
*
* Post: main code will have finished running as long as bracket is closed.
*
* Returns: nothing it is void.
*
* Called by: n/a
* Calls: n/a
************************************************************************/
	private long num;
	private long denom;
	private long remainder;

	public Fraction (long num, long denom){ // creates fractions in a/b reduced and normalized form
		
		// this is the reduction part using the gcd, it the takes difference of num and gcd of the num & denominator to get the reduced form
		this.num = num / gcd(num, denom);
		this.denom = denom / gcd(num, denom);

		// if statement ensures denominator is positive after the reduction by flipping both signs if denom is negative
		if (this.denom < 0) {
   			this.num = -this.num;
    		this.denom = -this.denom;
		}

		
	} 
	//constructor that creates the fraction a/1
	public Fraction (long x) {
		num = x;
		denom = 1;
	}
//GCD method to normalize fractions
	public long gcd(long x, long y) { //below flips signs so it doesn't mess up the normalization if x and y are less than 0
		if (x < 0) x = -x; 
    	if (y < 0) y = -y;
		while (y != 0) {
				remainder = x % y;
				x = y;
				y = remainder;
			}
		if (x == 0) return 1; //for cases where both values are 0 if I return 1 allows for Nan to produce for task 2, return 0 crashes it
		return x;
	}
	@Override
	public String toString() {
		if (denom == 0 && num > 0) {
			return "Infinity"; 
		}
		else if (denom == 0 && num < 0) {
			return "-Infinity";
		}
		else if (denom == 1 && num > 0) {
			return num + "";
		}
		else if (denom == 0 && num == 0) {
			return "NaN";
		}
		else {
		return num + "/" + denom; //makes sure output is in proper fraction form
		}
	}
	//getter function to get numerator
	public long getNumerator(){
		return num;	
	}
	//getter function to get denominator
	public long getDenominator() {
		return denom; 
 	}

	//add function
	public Fraction add(Fraction l) {
		long top = this.num * l.denom + l.num * this.denom; //multiply num and denom by sum of new denom and num for the numerator necessary when you add fractions
		long bot = this.denom * l.denom; //create a common denominator to add fractions
		return new Fraction(top,bot); //return new fraction
	}

	public Fraction subtract(Fraction l) {
		long top = this.num * l.denom - l.num * this.denom;//multiply num and denom by sum of new denom and num for the numerator necessary when you add fractions;chicken butt
		long bot = this.denom * l.denom;
		return new Fraction(top,bot);
	}

	public Fraction multiply(Fraction l) {
		long top = this.num * l.num; //multiply num and denom by sum of new denom and num for the numerator necessary when you add fractions
		long bot = this.denom * l.denom; //create a common denominator to add fractions
		return new Fraction(top,bot); //return new fraction
	}

	public Fraction divide(Fraction l) {
		long top = this.num * l.denom; //multiply num and denom by sum of new denom and num for the numerator necessary when you add fractions
		long bot = this.denom * l.num; //create a common denominator to add fractions
		return new Fraction(top,bot); //return new fraction
	}

	public Fraction negate(Fraction l){
		return new Fraction(-num,denom);
	}

	public Fraction pow(int n){
		
		long a = 1;
		long b = 1;
		
		for (int i = 0; i < n; i++) {
        	a *= num;
        	b *= denom;
    	}
		return new Fraction(a,b);
	} 

	public static void main(String[] args) { 
		Fraction a = new Fraction(6,-24);
		Fraction b = new Fraction( 0,8 );
		System.out.println(a);
		System.out.println(b);

		Fraction c = new Fraction(8, -6);
		System.out.println(c);

		Fraction d = new Fraction(23, 0);
		System.out.println(d);

		Fraction e = new Fraction(-6, 0);
		System.out.println(e);

		Fraction f = new Fraction(7, 1);
		System.out.println(f);

		Fraction g = new Fraction(0, 0);
		System.out.println(g);

		Fraction o = new Fraction(1,2).pow(2);
		System.out.println(o);

		Fraction s = new Fraction(1,2).negate(new Fraction (1));
		System.out.println(s);

		Fraction h = new Fraction(16);
		Fraction i = new Fraction(3,5).add(new Fraction(7));
		Fraction j = new Fraction(6,7);
		Fraction results = j.multiply(h.divide(i));
		System.out.println(results);

		Fraction t = new Fraction(3,5).subtract(new Fraction(7));
		System.out.println(t);
	}
}

	 

	

