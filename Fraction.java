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
//instead of using numerator, u always use getNumerator() instead do this for extra credit :-D
	public Fraction (long num, long denom){ /*constuctor*/
		if ( num < 0 ) {
			num = -num; // to avoid sign problems
		}
		if (num == 0) { //if numerator is 0 then the fraction will have a 0/1
			num = 0;
			denom = 1;
		}
		if (denom < 0) { // for fractions denominators have to be positive so this ensures that
			num = -num;
			denom = -denom;
		}
		this.num = num;
		this.denom = denom;

		setfraction(num,denom);
	} 
	//constructor that creates the fraction a/1
	public Fraction (long x) {
		num = x;
		denom = 1;
	}
//GCD method
	public long gcd(long x, long y) {

		while (y != 0) {
				remainder = x % y;
				x = y;
				y = remainder;
			}
		return x;
	}
//setter method to reduce fraction
	public void setfraction(long num, long denom) {
		
		this.num = num / gcd(num, denom);
		this.denom = denom / gcd(num, denom);
	}

	public String toString() {
		return num + "/" + denom;
	}
	//getter function to get numerator
	public long getNumerator(){
		return num;	
	}
	//getter function to get denominator
	public long getDenominator() {
		return denom; 
 	}

	public static void main(String[] args) { 
		Fraction a = new Fraction(6,-24);
		System.out.println(a);
	} 
}

	 

	

