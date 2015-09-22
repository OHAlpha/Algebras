package org.oalpha.algebra.rational;

import org.oalpha.algebra.Element;
import org.oalpha.algebra.ElementClass;

public class RationalElement implements Element<RationalNumber> {

	private RationalNumber value;

	public RationalElement(RationalNumber value) {
		super();
		this.value = value;
	}

	@Override
	public ElementClass<RationalNumber> getElementClass() {
		return RationalClass.rationalClass;
	}

	@Override
	public RationalNumber getValue() {
		return value;
	}

	@Override
	public void setValue(RationalNumber value, Object... args) {
		this.value = value;
	}

}