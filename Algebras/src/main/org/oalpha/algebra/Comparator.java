package org.oalpha.algebra;

public abstract class Comparator<T> {

	private final ElementClass<T> elementClass;

	public Comparator(ElementClass<T> elementClass) {
		super();
		if (elementClass == null)
			throw new IllegalArgumentException();
		this.elementClass = elementClass;
	}

	public ElementClass<T> getElementClass() {
		return elementClass;
	}
	
	public abstract int compare(T a, T b);

}