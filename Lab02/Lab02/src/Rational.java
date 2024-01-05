
public class Rational {
   // Generate numerator and denominator variables
   private int numerator;
   private int denominator;

   // Generate Getters and Setters for each variable
   public int getNumerator() {
      return numerator;
   }

   public void setNumerator(int numerator) {
      this.numerator = numerator;
   }

   public int getDenominator() {
      return denominator;
   }

   public void setDenominator(int denominator) {
      this.denominator = denominator;
   }

   // Convert to floating-point format
   public void fpRepresentation() {
      System.out.printf("%.2f\n", (double) numerator / denominator);
   }

   // Convert to a string representation of a Rational number in the form a / b
   @Override
   public String toString() {
      // System.out.printf("Rational number (%d, %d) = ", numerator, denominator);
      if (denominator == 0)
         return String.format("It cannot be divided by zero! So it doesn't exist.");
      else
         return String.format("%d / %d", numerator, denominator);
   }

   // Provide a no-argument constructor with default values in case no initializers
   // are provided
   public Rational() {
      numerator = 0;
      denominator = 1;
   }

   // Put into numerator, denominator variables in order of received arguments
   public Rational(int a, int b) {
      numerator = a;
      denominator = b;
      if (denominator != 0)
         reduce();
   }

   // Add two Rational numbers
   public Rational add(Rational other) {
      System.out.printf("(%d/%d) + (%d/%d) = ", this.numerator, this.denominator, other.numerator, other.denominator);
      int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
      int newDenominator = this.denominator * other.denominator;
      return new Rational(newNumerator, newDenominator);
   }

   // Subtract two Rational numbers
   public Rational sub(Rational other) {
      System.out.printf("(%d/%d) - (%d/%d) = ", this.numerator, this.denominator, other.numerator, other.denominator);
      int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
      int newDenominator = this.denominator * other.denominator;
      return new Rational(newNumerator, newDenominator);
   }

   // Multiply two Rational numbers
   public Rational multiply(Rational other) {
      System.out.printf("(%d/%d) * (%d/%d) = ", this.numerator, this.denominator, other.numerator, other.denominator);
      int newNumerator = this.numerator * other.numerator;
      int newDenominator = this.denominator * other.denominator;
      return new Rational(newNumerator, newDenominator);
   }

   // Divide two Rational numbers
   public Rational divide(Rational other) {
      System.out.printf("(%d/%d) / (%d/%d) = ", this.numerator, this.denominator, other.numerator, other.denominator);
      int newNumerator = this.numerator * other.denominator;
      int newDenominator = this.denominator * other.numerator;
      return new Rational(newNumerator, newDenominator);
   }

   // Convert fractions to reduced form
   private void reduce() {
      int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
      numerator /= gcd;
      denominator /= gcd;
   }

   // Greatest Common Divisor
   private int gcd(int a, int b) {
      if (b != 0)
         return gcd(b, a % b);
      else
         return a;
   }
}