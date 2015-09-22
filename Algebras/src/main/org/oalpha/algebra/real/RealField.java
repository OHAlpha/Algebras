package org.oalpha.algebra.real;

import org.oalpha.algebra.RAlgebra;

public class RealField extends RAlgebra<Double> {

	public static final RealField realField = new RealField();

	private RealField() {
		super(RealClass.realClass, RealAdditionOperator.operator,
				RealMultiplicationOperator.operator);
	}

	public static void main(String[] args) {
		realField.describe();
		System.out.println();
		realField.getAdditionAlgebra().describe();
		System.out.println();
		realField.getMultiplicationAlgebra().describe();
	}

}