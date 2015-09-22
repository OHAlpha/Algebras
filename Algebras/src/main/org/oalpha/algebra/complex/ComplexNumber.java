package org.oalpha.algebra.complex;

public interface ComplexNumber {

	Double real();

	Double imaginary();

	Double modulus();

	Double argument();

	void negate();

	void reciprocate();

	void add(ComplexNumber num);

	void subtract(ComplexNumber num);

	void multiply(ComplexNumber num);

	void divide(ComplexNumber num);

	void exponentiate(ComplexNumber num);

	ComplexNumber negation();

	ComplexNumber reciprocal();

	ComplexNumber sum(ComplexNumber num);

	ComplexNumber difference(ComplexNumber num);

	ComplexNumber product(ComplexNumber num);

	ComplexNumber quotient(ComplexNumber num);

	ComplexNumber power(ComplexNumber num);

}