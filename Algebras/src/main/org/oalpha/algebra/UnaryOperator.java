package org.oalpha.algebra;

public abstract class UnaryOperator<A, B> {

	private final ElementClass<A> inputElementClass;

	private final ElementClass<B> outputElementClass;

	public UnaryOperator(ElementClass<A> inputElementClass,
			ElementClass<B> outputElementClass) {
		super();
		if (inputElementClass == null)
			throw new IllegalArgumentException();
		if (outputElementClass == null)
			throw new IllegalArgumentException();
		this.inputElementClass = inputElementClass;
		this.outputElementClass = outputElementClass;
	}

	public ElementClass<A> getInputElementClass() {
		return inputElementClass;
	}

	public ElementClass<B> getOutputElementClass() {
		return outputElementClass;
	}

	public abstract B operate(A value);

	public static @interface CummutativeOperator {

	}

	public static @interface AssociativeOperator {

	}

	public static @interface AbelianOperator {

	}

	public static @interface DistributativeOperator {

	}

}