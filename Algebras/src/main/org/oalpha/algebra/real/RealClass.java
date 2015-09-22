package org.oalpha.algebra.real;

import org.oalpha.algebra.ElementClass;

public class RealClass extends ElementClass<Double> {

	public static RealClass realClass = new RealClass();

	private RealClass() {
		super();
	}

	@Override
	public RealElement newElement(Double value, Object... args) {
		return new RealElement(value);
	}

}