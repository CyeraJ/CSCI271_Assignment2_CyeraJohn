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
	@Override //course notes
	public String toString() { //method to output strings based on certain cases
		if (denom == 0 && num > 0) { // outputs infinity
			return "Infinity"; 
		}
		else if (denom == 0 && num < 0) { //outputs -infinity
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
		return num;	//returns given numerator
	}
	//getter function to get denominator
	public long getDenominator() {
		return denom; //returns given denominator
 	}

	//add method
	public Fraction add(Fraction l) {
		long top = this.num * l.denom + l.num * this.denom; //multiply num and denom by sum of new denom and num for the numerator necessary when you add fractions
		long bot = this.denom * l.denom; //create a common denominator to add fractions
		return new Fraction(top,bot); //return new fraction
	}
	//subtract method
	public Fraction subtract(Fraction l) {
		long top = this.num * l.denom - l.num * this.denom;//multiply num and denom by difference of new denom and num for the numerator necessary when you subtract fractions;
		long bot = this.denom * l.denom; //create a common denominator to subtract fractions
		return new Fraction(top,bot); //returns new fraction
	}
	//multiplication method
	public Fraction multiply(Fraction l) {
		long top = this.num * l.num; //multiply original num by given numerator
		long bot = this.denom * l.denom; //multiply original denom by given denominator
		return new Fraction(top,bot); //return new fraction
	}
	//division method
	public Fraction divide(Fraction l) {
		long top = this.num * l.denom; //multiply original num by given denom
		long bot = this.denom * l.num; //multiply original denom by given num
		return new Fraction(top,bot); //return new fraction
	}
	//negate method
	public Fraction negate(Fraction l){
		return new Fraction(-num,denom); //returns the same fraction but the negation of it like 1/2 would become -1/2
	}
	//power method
	public Fraction pow(int n){
		//initialize both a and b
		long a = 1; 
		long b = 1;
		//for loop to keep multiplying both numerator and denominator n (given) times 
		for (int i = 0; i < n; i++) {
        	a *= num; 
        	b *= denom;
    	}
		return new Fraction(a,b); //returns new fraction raised to the nth power
	} 
	//main method
	public static void main(String[] args) { 
		Fraction a = new Fraction(6,-24); //for task 1 this outputs fractions reduced and normalized given the above constructor is correct 
		Fraction b = new Fraction( 0,8 ); //same as above, should return a reduce & normalized fraction
		System.out.println(a); //prints a fraction
		System.out.println(b); //prints b fraction

		Fraction c = new Fraction(8, -6); //for task 2 fraction should produce a negative fraction
		System.out.println(c); // prints results

		Fraction d = new Fraction(23, 0); //for task 2 fraction should produce the infinity output due to a regular numerator and 0 denom
		System.out.println(d); // prints results

		Fraction e = new Fraction(-6, 0); //for task 2 fraction should produce the -infinity output due to a - numerator and a 0 denom
		System.out.println(e); // prints results

		Fraction f = new Fraction(7, 1); //for task 2 fraction should produce a whole number output due to a 1 in the denom
		System.out.println(f); // prints results

		Fraction g = new Fraction(0, 0); //for task 2 fraction should produce the NaN output due to a 0/0
		System.out.println(g); // prints results

		Fraction o = new Fraction(1,2).pow(2); //for task 3 should produce a fraction raised to the given power
		System.out.println(o); // prints results

		Fraction s = new Fraction(1,2).negate(new Fraction (1)); //for task 3 should produce a fraction negated
		System.out.println(s); // prints results

		Fraction h = new Fraction(16); //creates a fraction out of a whole number
		Fraction i = new Fraction(3,5).add(new Fraction(7)); //creates a fraction and adds a whole number to it
		Fraction j = new Fraction(6,7); //new fraction
		Fraction results = j.multiply(h.divide(i)); //multiplies new fraction j by h/i
		System.out.println(results); //prints the results of that multiplication

		Fraction t = new Fraction(3,5).subtract(new Fraction(7)); //for task 3 should take fraction and subtract whole number from it
		System.out.println(t); // prints results
	}
}

	 

	

