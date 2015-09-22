package org.oalpha.algebra.complex;

import org.oalpha.algebra.Element;
import org.oalpha.algebra.ElementClass;

public class RealClass extends ElementClass<Double> {

	public static RealClass realClass = new RealClass();

	private RealClass() {
		super();
	}

	@Override
	public Element<Double> newElement(Double value, Object... args) {
		return new RealElement(value);
	}

}