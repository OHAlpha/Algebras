package org.oalpha.algebra.vector;

import java.util.Collection;

import org.oalpha.algebra.ElementClass;

public class VectorSpace<T> extends ElementClass<Vector<T>> {

	private final VectorClass<T> vectorClass;

	private final int dimensions;

	public VectorSpace(VectorClass<T> vectorClass, int dimensions) {
		super();
		this.vectorClass = vectorClass;
		this.dimensions = dimensions;
	}

	@Override
	public VectorClass<T> getElementClass() {
		return (VectorClass<T>) super.getElementClass();
	}

	public int getDimensions() {
		return dimensions;
	}

	@Override
	public VectorElement<T> newElement(Vector<T> value, Object... args) {
		return new VectorElement<T>(this, value);
	}

	public VectorElement<T> newElement(Collection<T> value, Object... args) {
		return new VectorElement<T>(this, new Vector<T>(vectorClass.getField(),
				value));
	}

	public VectorElement<T> newElement(T[] value, Object... args) {
		return new VectorElement<T>(this, new Vector<T>(vectorClass.getField(),
				value));
	}

}