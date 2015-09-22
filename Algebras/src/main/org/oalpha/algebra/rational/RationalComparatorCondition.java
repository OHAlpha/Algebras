package org.oalpha.algebra.rational;

import org.oalpha.algebra.Condition;

public class RationalComparatorCondition extends Condition<RationalNumber> {

	private final RationalNumber branch;

	private final boolean acceptsGreater, acceptsEquals;

	public RationalComparatorCondition(RationalNumber branch,
			boolean acceptsGreater, boolean acceptsEquals) {
		super(RationalClass.rationalClass);
		this.branch = branch;
		this.acceptsGreater = acceptsGreater;
		this.acceptsEquals = acceptsEquals;
	}

	@Override
	public boolean test(RationalNumber value) {
		return acceptsEquals ? value.equals(branch) : acceptsGreater ? value
				.compareTo(branch) > 0 : value.compareTo(branch) < 0;
	}

	public RationalNumber getBranch() {
		return branch;
	}

	public boolean isAcceptsGreater() {
		return acceptsGreater;
	}

	public boolean isAcceptsEquals() {
		return acceptsEquals;
	}

}