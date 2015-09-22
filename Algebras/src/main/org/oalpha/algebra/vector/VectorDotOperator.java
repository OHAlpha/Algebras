package org.oalpha.algebra.vector;

import org.oalpha.algebra.BinaryOperator;
import org.oalpha.algebra.RAlgebra;
import org.oalpha.algebra.SetBinaryOperator.CummutativeOperator;

@CummutativeOperator
public class VectorDotOperator<T> extends
		BinaryOperator<Vector<T>, Vector<T>, T> {

	private VectorDotOperator(VectorSpace<T> space) {
		super(space, space, space.getElementClass().getField()
				.getElementClass());
	}

	@Override
	public VectorSpace<T> getInputElementClassA() {
		return (VectorSpace<T>) super.getInputElementClassA();
	}

	@Override
	public VectorSpace<T> getInputElementClassB() {
		return (VectorSpace<T>) super.getInputElementClassA();
	}

	public RAlgebra<T> getField() {
		return getInputElementClassA().getElementClass().getField();
	}

	public int getDimensions() {
		return getInputElementClassA().getDimensions();
	}

	@Override
	public T operate(Vector<T> a, Vector<T> b) {
		return a.dot(b);
	}

}