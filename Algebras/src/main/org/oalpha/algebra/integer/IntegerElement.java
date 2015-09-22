package org.oalpha.algebra.integer;

import org.oalpha.algebra.Element;
import org.oalpha.algebra.ElementClass;

public class IntegerElement implements Element<Integer> {

	private Integer value;

	public IntegerElement(Integer value) {
		super();
		this.value = value;
	}

	@Override
	public ElementClass<Integer> getElementClass() {
		return IntegerClass.integerClass;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(Integer value, Object... args) {
		this.value = value;
	}

}