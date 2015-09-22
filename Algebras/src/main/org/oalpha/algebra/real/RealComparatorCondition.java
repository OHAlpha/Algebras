package org.oalpha.algebra.real;

import org.oalpha.algebra.Condition;

public class RealComparatorCondition extends Condition<Double> {

	private final double branch;

	private final boolean acceptsGreater, acceptsEquals;

	public RealComparatorCondition(double branch, boolean acceptsGreater,
			boolean acceptsEquals) {
		super(RealClass.realClass);
		this.branch = branch;
		this.acceptsGreater = acceptsGreater;
		this.acceptsEquals = acceptsEquals;
	}

	@Override
	public boolean test(Double value) {
		return acceptsEquals ? value == branch
				: acceptsGreater ? value > branch : value < branch;
	}

	public double getBranch() {
		return branch;
	}

	public boolean isAcceptsGreater() {
		return acceptsGreater;
	}

	public boolean isAcceptsEquals() {
		return acceptsEquals;
	}

}