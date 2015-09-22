package org.oalpha.algebra;

public class Algebra<T> {

	private final ElementSet<T> elementSet;

	private final SetUnaryOperator<T>[] unaryOperators;

	private final SetBinaryOperator<T>[] binaryOperators;

	@SuppressWarnings("unchecked")
	public Algebra(ElementSet<T> elementSet,
			SetUnaryOperator<T>[] unaryOperators,
			SetBinaryOperator<T>[] binaryOperators) {
		super();
		if (elementSet == null)
			throw new IllegalArgumentException();
		this.elementSet = elementSet;
		this.unaryOperators = (SetUnaryOperator<T>[]) new SetUnaryOperator<?>[unaryOperators == null ? 0
				: unaryOperators.length];
		for (int i = 0; i < this.unaryOperators.length; i++) {
			if (unaryOperators[i] == null)
				throw new IllegalArgumentException();
			if (unaryOperators[i].getOutputElementClass() != elementSet
					.getElementClass())
				throw new IllegalArgumentException();
			this.unaryOperators[i] = unaryOperators[i];
		}
		this.binaryOperators = (SetBinaryOperator<T>[]) new SetBinaryOperator<?>[binaryOperators == null ? 0
				: binaryOperators.length];
		for (int i = 0; i < this.binaryOperators.length; i++) {
			if (binaryOperators[i] == null)
				throw new IllegalArgumentException();
			if (binaryOperators[i].getOutputElementClass() != elementSet
					.getElementClass())
				throw new IllegalArgumentException();
			this.binaryOperators[i] = binaryOperators[i];
		}
	}

	public ElementClass<T> getElementClass() {
		return elementSet.getElementClass();
	}

	public ElementSet<T> getElementSet() {
		return elementSet;
	}

	public SetUnaryOperator<T>[] getUnaryOperators() {
		@SuppressWarnings("unchecked")
		SetUnaryOperator<T>[] out = new SetUnaryOperator[unaryOperators.length];
		System.arraycopy(unaryOperators, 0, out, 0, unaryOperators.length);
		return unaryOperators;
	}

	public SetUnaryOperator<T> getUnaryOperator(int i) {
		return unaryOperators[i];
	}

	public int getNumUnaryOperators() {
		return unaryOperators.length;
	}

	public SetBinaryOperator<T>[] getBinaryOperators() {
		@SuppressWarnings("unchecked")
		SetBinaryOperator<T>[] out = new SetBinaryOperator[binaryOperators.length];
		System.arraycopy(binaryOperators, 0, out, 0, binaryOperators.length);
		return binaryOperators;
	}

	public SetBinaryOperator<T> getBinaryOperator(int i) {
		return binaryOperators[i];
	}

	public int getNumBinaryOperators() {
		return binaryOperators.length;
	}

}