package org.oalpha.algebra.rational;

import org.oalpha.algebra.ElementClass;

public class RationalClass extends ElementClass<RationalNumber> {

	public static RationalClass rationalClass = new RationalClass();

	private RationalClass() {
		super();
	}

	@Override
	public RationalElement newElement(RationalNumber value, Object... args) {
		return new RationalElement(value);
	}

}