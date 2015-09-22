package org.oalpha.algebra;

public abstract class ElementClass<T> extends ElementSet<T> {

	public ElementClass() {
		super(null);
		setElementClass(this);
	}

	public abstract Element<T> newElement(T value, Object... args);

}