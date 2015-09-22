package org.oalpha.algebra.natural;

import org.oalpha.algebra.Element;
import org.oalpha.algebra.ElementClass;

public class NaturalElement implements Element<Integer> {

	private Integer value;

	public NaturalElement(Integer value) {
		super();
		this.value = value;
	}

	@Override
	public ElementClass<Integer> getElementClass() {
		return NaturalClass.naturalClass;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(Integer value, Object... args) {
		if (value < 1)
			throw new IllegalArgumentException();
		this.value = value;
	}

}