package org.oalpha.algebra.natural;
import org.oalpha.algebra.ElementClass;

public class NaturalClass extends ElementClass<Integer> {

	public static NaturalClass naturalClass = new NaturalClass();

	private NaturalClass() {
		super();
	}

	@Override
	public NaturalElement newElement(Integer value, Object... args) {
		return new NaturalElement(value);
	}

}