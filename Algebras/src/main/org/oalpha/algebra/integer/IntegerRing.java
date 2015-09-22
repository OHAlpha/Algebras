package org.oalpha.algebra.integer;

import org.oalpha.algebra.RAlgebra;

public class IntegerRing extends RAlgebra<Integer> {

	public static final IntegerRing integerRing = new IntegerRing();

	private IntegerRing() {
		super(IntegerClass.integerClass, IntegerAdditionOperator.operator,
				IntegerMultiplicationOperator.operator);
	}

	public static void main(String[] args) {
		integerRing.describe();
		System.out.println();
		integerRing.getAdditionAlgebra().describe();
		System.out.println();
		integerRing.getMultiplicationAlgebra().describe();
	}

}