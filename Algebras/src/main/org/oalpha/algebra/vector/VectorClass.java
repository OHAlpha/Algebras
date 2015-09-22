package org.oalpha.algebra.vector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.oalpha.algebra.ElementClass;
import org.oalpha.algebra.RAlgebra;

public class VectorClass<T> extends ElementClass<Vector<T>> {

	private final RAlgebra<T> field;

	private final Map<Integer, VectorSpace<T>> spaces;

	public VectorClass(RAlgebra<T> field) {
		if (!field.isField())
			throw new IllegalArgumentException("algebra must be a field");
		this.field = field;
		spaces = new HashMap<>();
	}

	public RAlgebra<T> getField() {
		return field;
	}

	@Override
	public VectorElement<T> newElement(Vector<T> value, Object... args) {
		return new VectorElement<T>(getVectorSpace(value.getDimensions()),
				value);
	}

	public VectorElement<T> newElement(Collection<T> value, Object... args) {
		return new VectorElement<T>(getVectorSpace(value.size()),
				new Vector<T>(field, value));
	}

	public VectorElement<T> newElement(T[] value, Object... args) {
		return new VectorElement<T>(getVectorSpace(value.length),
				new Vector<T>(field, value));
	}

	public VectorSpace<T> getVectorSpace(int i) {
		if (spaces.containsKey(i))
			return spaces.get(i);
		else {
			VectorSpace<T> space = new VectorSpace<T>(this, i);
			spaces.put(i, space);
			return space;
		}
	}

}