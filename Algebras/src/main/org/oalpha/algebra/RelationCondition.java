package org.oalpha.algebra;

public abstract class RelationCondition<A, B> extends
		Condition<OrderedPair<A, B>> {

	public RelationCondition(OrderedPairClass<A, B> elementClass) {
		super(elementClass);
	}

	@Override
	public boolean test(OrderedPair<A, B> value) {
		return test(value.getA(), value.getB());
	}

	public abstract boolean test(A a, B b);

}