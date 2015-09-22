package org.oalpha.algebra.whole;

import org.oalpha.algebra.ElementClass;

public class WholeClass extends ElementClass<Integer> {

	public static WholeClass wholeClass = new WholeClass();

	private WholeClass() {
		super();
	}

	@Override
	public WholeElement newElement(Integer value, Object... args) {
		return new WholeElement(value);
	}

}