package org.oalpha.algebra;

public class Relation<A, B> extends ElementSet<OrderedPair<A, B>> {

	public Relation(CartesianProduct<A, B> superSet,
			RelationCondition<A, B>[] conditions) {
		super(superSet.getElementClass(), conditions);
	}

	public boolean related(A a, B b) {
		for (RelationCondition<A, B> condition : getConditions())
			if (!condition.test(a, b))
				return false;
		return true;
	}

	@Override
	public RelationCondition<A, B>[] getConditions() {
		@SuppressWarnings("unchecked")
		RelationCondition<A, B>[] out = new RelationCondition[getNumConditions()];
		Condition<OrderedPair<A, B>>[] cs = super.getConditions();
		System.arraycopy(cs, 0, out, 0, out.length);
		return out;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RelationCondition<A, B> getCondition(int i) {
		return (RelationCondition<A, B>) super.getCondition(i);
	}

}