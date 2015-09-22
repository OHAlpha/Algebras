package org.oalpha.algebra;

public class SetCartesianProduct<T> extends CartesianProduct<T, T> {

	public SetCartesianProduct(SetOrderedPairClass<T> pairClass,
			ElementSet<T> set) {
		super(pairClass, set, set);
	}

}