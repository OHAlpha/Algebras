package org.oalpha.algebra;

public abstract class Function<A, B> {

	private final ElementSet<A> setA;

	private final ElementSet<B> setB;

	public Function(ElementSet<A> setA, ElementSet<B> setB) {
		super();
		this.setA = setA;
		this.setB = setB;
	}

	public ElementSet<A> getSetA() {
		return setA;
	}

	public ElementSet<B> getSetB() {
		return setB;
	}

	public abstract B operate(A a);

	public abstract A operateInverse(B b);

}