package org.oalpha.algebra;

public abstract class OrderedPairClass<A, B> extends ElementClass<OrderedPair<A, B>> {
	
	private final ElementClass<A> classA;
	
	private final ElementClass<B> classB;

	public OrderedPairClass(ElementClass<A> classA, ElementClass<B> classB) {
		super();
		this.classA = classA;
		this.classB = classB;
	}

	public ElementClass<A> getClassA() {
		return classA;
	}

	public ElementClass<B> getClassB() {
		return classB;
	}

}