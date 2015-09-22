package org.oalpha.algebra;

public class OrderedPair<A, B> {

	private A a;

	private B b;

	public OrderedPair() {
	}

	public OrderedPair(A a, B b) {
		super();
		this.a = a;
		this.b = b;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

}