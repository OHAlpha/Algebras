package org.oalpha.algebra.rational;

import org.oalpha.algebra.RAlgebra;

public class RationalField extends RAlgebra<RationalNumber> {

	public static final RationalField rationalField = new RationalField();

	private RationalField() {
		super(RationalClass.rationalClass, RationalAdditionOperator.operator,
				RationalMultiplicationOperator.operator);
	}

	public static void main(String[] args) {
		rationalField.describe();
		System.out.println();
		rationalField.getAdditionAlgebra().describe();
		System.out.println();
		rationalField.getMultiplicationAlgebra().describe();
	}

}