package org.oalpha.algebra;

public abstract class Condition<T> {

	private final ElementClass<T> elementClass;

	public Condition(ElementClass<T> elementClass) {
		super();
		if (elementClass == null)
			throw new IllegalArgumentException();
		this.elementClass = elementClass;
	}

	public ElementClass<T> getElementClass() {
		return elementClass;
	}

	public abstract boolean test(T value);

}