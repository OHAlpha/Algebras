package org.oalpha.algebra.integer;

import org.oalpha.algebra.ElementClass;

public class IntegerClass extends ElementClass<Integer> {

	public static IntegerClass integerClass = new IntegerClass();

	private IntegerClass() {
		super();
	}

	@Override
	public IntegerElement newElement(Integer value, Object... args) {
		return new IntegerElement(value);
	}

}