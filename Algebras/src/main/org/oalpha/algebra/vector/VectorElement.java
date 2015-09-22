package org.oalpha.algebra.vector;

import org.oalpha.algebra.Element;

public class VectorElement<T> implements Element<Vector<T>> {

	private final VectorSpace<T> space;

	private Vector<T> value;

	public VectorElement(VectorSpace<T> space, Vector<T> value) {
		super();
		this.space = space;
		this.value = value;
	}

	@Override
	public VectorClass<T> getElementClass() {
		return space.getElementClass();
	}

	@Override
	public Vector<T> getValue() {
		return value;
	}

	@Override
	public void setValue(Vector<T> value, Object... args) {
		if (value.getDimensions() != space.getDimensions())
			throw new IllegalArgumentException();
		this.value = value;
	}

}
