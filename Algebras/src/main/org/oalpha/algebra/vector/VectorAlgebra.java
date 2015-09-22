package org.oalpha.algebra.vector;

import org.oalpha.algebra.Algebra;
import org.oalpha.algebra.SetBinaryOperator;
import org.oalpha.algebra.SetUnaryOperator;

public class VectorAlgebra<T> extends Algebra<Vector<T>> {

	private VectorAlgebra(VectorSpace<T> space) {
		super(space, new SetUnaryOperator[0], new SetBinaryOperator[] {});
	}

	public static void main(String[] args) {
		realField.describe();
		System.out.println();
		realField.getAdditionAlgebra().describe();
		System.out.println();
		realField.getMultiplicationAlgebra().describe();
	}

}