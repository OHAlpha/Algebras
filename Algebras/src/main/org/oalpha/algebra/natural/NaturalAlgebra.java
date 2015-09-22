package org.oalpha.algebra.natural;

import org.oalpha.algebra.RAlgebra;

public class NaturalAlgebra extends RAlgebra<Integer> {

	public static final NaturalAlgebra naturalAlgebra = new NaturalAlgebra();

	private NaturalAlgebra() {
		super(NaturalClass.naturalClass, NaturalAdditionOperator.operator,
				NaturalMultiplicationOperator.operator);
	}

	public static void main(String[] args) {
		naturalAlgebra.describe();
		System.out.println();
		naturalAlgebra.getAdditionAlgebra().describe();
		System.out.println();
		naturalAlgebra.getMultiplicationAlgebra().describe();
	}

}