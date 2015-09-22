package org.oalpha.algebra.rational;

import java.util.Comparator;
import java.util.Random;

public class RationalNumber implements Comparable<RationalNumber> {

	private static int gcd(int a, int b) {
		int c = a % b;
		if (c == 0)
			return b < 0 ? -b : b;
		else
			return gcd(b, c);
	}

	public static RationalNumber zero() {
		return new RationalNumber();
	}

	public static RationalNumber one() {
		return new RationalNumber(1, 0);
	}

	public static final Comparator<RationalNumber> comparator = new Comparator<RationalNumber>() {

		public int compare(RationalNumber a, RationalNumber b) {
			return a.compareTo(b);
		}

	};

	public static void main(String[] args) {
		Random r = new Random();
		int a, b, c;
		for (int i = 0; i < 10; i++) {
			a = -r.nextInt(100) * 15;
			b = r.nextInt(100) * 15;
			c = gcd(a, b);
			System.out.println("gcd(" + a + "," + b + ") = " + c);
		}
	}

	private int numerator, denominator;

	public RationalNumber() {
		this(0, 1);
	}

	public RationalNumber(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public RationalNumber(RationalNumber num) {
		this(num.numerator, num.denominator);
	}

	public RationalNumber clone() {
		return new RationalNumber(this);
	}

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
		if (denominator == 0)
			throw new IllegalArgumentException("denominator cannot be zero");
		this.denominator = denominator;
	}

	public boolean isNormalized() {
		int f = (denominator < 0 ? -1 : 1) * gcd(numerator, denominator);
		return f == 1;
	}

	public void normalize() {
		int f = (denominator < 0 ? -1 : 1) * gcd(numerator, denominator);
		numerator /= f;
		denominator /= f;
	}

	public RationalNumber normalized() {
		RationalNumber num = clone();
		num.normalize();
		return num;
	}

	public int hashCode() {
		return isNormalized() ? numerator ^ denominator : normalized()
				.hashCode();
	}

	public boolean equals(Object o) {
		return o instanceof RationalNumber ? equals((RationalNumber) o) : false;
	}

	public boolean equals(RationalNumber o) {
		int f1 = (denominator < 0 ? -1 : 1) * gcd(numerator, denominator);
		int f2 = (o.denominator < 0 ? -1 : 1) * gcd(o.numerator, o.denominator);
		return numerator / f1 == o.numerator / f2
				&& denominator / f1 == o.denominator / f2;
	}

	@Override
	public int compareTo(RationalNumber arg0) {
		return Double.compare(doubleValue(), arg0.doubleValue());
	}

	public byte byteValue() {
		return (byte) doubleValue();
	}

	public double doubleValue() {
		return 1d * numerator / denominator;
	}

	public float floatValue() {
		return (float) doubleValue();
	}

	public int intValue() {
		return (int) doubleValue();
	}

	public long longValue() {
		return (long) doubleValue();
	}

	public short shortValue() {
		return (short) doubleValue();
	}

	public void negate() {
		numerator *= -1;
	}

	public void reciprocate() {
		int t = numerator;
		numerator = denominator;
		denominator = t;
	}

	public void add(RationalNumber num) {
		numerator = numerator * num.denominator + num.numerator * denominator;
		denominator *= num.denominator;
		normalize();
	}

	public void subtract(RationalNumber num) {
		numerator = numerator * num.denominator - num.numerator * denominator;
		denominator *= num.denominator;
		normalize();
	}

	public void multiply(RationalNumber num) {
		numerator *= num.numerator;
		denominator *= num.denominator;
		normalize();
	}

	public void divide(RationalNumber num) {
		numerator *= num.denominator;
		denominator *= num.numerator;
		normalize();
	}

	public RationalNumber negation() {
		RationalNumber out = clone();
		out.negate();
		return out;
	}

	public RationalNumber reciprocal() {
		RationalNumber out = clone();
		out.reciprocate();
		return out;
	}

	public RationalNumber sum(RationalNumber num) {
		RationalNumber out = clone();
		out.add(num);
		return out;
	}

	public RationalNumber difference(RationalNumber num) {
		RationalNumber out = clone();
		out.subtract(num);
		return out;
	}

	public RationalNumber product(RationalNumber num) {
		RationalNumber out = clone();
		out.multiply(num);
		return out;
	}

	public RationalNumber quotient(RationalNumber num) {
		RationalNumber out = clone();
		out.divide(num);
		return out;
	}

}