package org.oalpha.algebra.whole;

import org.oalpha.algebra.RAlgebra;

public class WholeAlgebra extends RAlgebra<Integer> {

	public static final WholeAlgebra wholeAlgebra = new WholeAlgebra();

	private WholeAlgebra() {
		super(WholeClass.wholeClass, WholeAdditionOperator.operator,
				WholeMultiplicationOperator.operator);
	}

	public static void main(String[] args) {
		wholeAlgebra.describe();
		System.out.println();
		wholeAlgebra.getAdditionAlgebra().describe();
		System.out.println();
		wholeAlgebra.getMultiplicationAlgebra().describe();
	}

}