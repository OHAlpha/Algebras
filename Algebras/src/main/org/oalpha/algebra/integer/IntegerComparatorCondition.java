package org.oalpha.algebra.integer;

import org.oalpha.algebra.Condition;

public class IntegerComparatorCondition extends Condition<Integer> {

	private final Integer branch;

	private final boolean acceptsGreater, acceptsEquals;

	public IntegerComparatorCondition(Integer branch, boolean acceptsGreater,
			boolean acceptsEquals) {
		super(IntegerClass.integerClass);
		this.branch = branch;
		this.acceptsGreater = acceptsGreater;
		this.acceptsEquals = acceptsEquals;
	}

	@Override
	public boolean test(Integer value) {
		return acceptsEquals ? value == branch
				: acceptsGreater ? value > branch : value < branch;
	}

	public Integer getBranch() {
		return branch;
	}

	public boolean isAcceptsGreater() {
		return acceptsGreater;
	}

	public boolean isAcceptsEquals() {
		return acceptsEquals;
	}

}