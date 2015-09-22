package org.oalpha.algebra.whole;

import org.oalpha.algebra.Element;
import org.oalpha.algebra.ElementClass;

public class WholeElement implements Element<Integer> {

	private Integer value;

	public WholeElement(Integer value) {
		super();
		this.value = value;
	}

	@Override
	public ElementClass<Integer> getElementClass() {
		return WholeClass.wholeClass;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(Integer value, Object... args) {
		if (value < 0)
			throw new IllegalArgumentException();
		this.value = value;
	}

}