package org.oalpha.algebra.real;

import org.oalpha.algebra.Element;
import org.oalpha.algebra.ElementClass;

public class RealElement implements Element<Double> {

	private double value;

	public RealElement(double value) {
		super();
		this.value = value;
	}

	@Override
	public ElementClass<Double> getElementClass() {
		return RealClass.realClass;
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public void setValue(Double value, Object... args) {
		if (value.isInfinite() || value.isNaN())
			throw new IllegalArgumentException();
		this.value = value;
	}

}