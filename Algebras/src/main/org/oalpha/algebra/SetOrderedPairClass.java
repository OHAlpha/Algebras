package org.oalpha.algebra;

public abstract class SetOrderedPairClass<T> extends OrderedPairClass<T, T> {

	public SetOrderedPairClass(ElementClass<T> elementClass) {
		super(elementClass, elementClass);
	}

}