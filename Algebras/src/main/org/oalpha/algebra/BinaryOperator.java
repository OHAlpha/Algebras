package org.oalpha.algebra;

public abstract class BinaryOperator<A, B, C> {

	private final ElementClass<A> inputElementClassA;

	private final ElementClass<B> inputElementClassB;

	private final ElementClass<C> outputElementClass;

	public BinaryOperator(ElementClass<A> inputElementClassA,
			ElementClass<B> inputElementClassB,
			ElementClass<C> outputElementClass) {
		super();
		if (inputElementClassA == null)
			throw new IllegalArgumentException();
		if (inputElementClassB == null)
			throw new IllegalArgumentException();
		if (outputElementClass == null)
			throw new IllegalArgumentException();
		this.inputElementClassA = inputElementClassA;
		this.inputElementClassB = inputElementClassB;
		this.outputElementClass = outputElementClass;
	}

	public ElementClass<A> getInputElementClassA() {
		return inputElementClassA;
	}

	public ElementClass<B> getInputElementClassB() {
		return inputElementClassB;
	}

	public ElementClass<C> getOutputElementClass() {
		return outputElementClass;
	}

	public abstract C operate(A a, B b);

}