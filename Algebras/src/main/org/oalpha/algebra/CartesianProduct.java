package org.oalpha.algebra;

public class CartesianProduct<A, B> extends
		ElementSet<OrderedPair<A, B>> {

	private static class InclusionCondition<A, B> extends
			Condition<OrderedPair<A, B>> {

		private CartesianProduct<A, B> product;

		public InclusionCondition(ElementClass<OrderedPair<A, B>> elementClass) {
			super(elementClass);
		}

		public void setProduct(CartesianProduct<A, B> product) {
			this.product = product;
		}

		@Override
		public boolean test(OrderedPair<A, B> value) {
			return product.getSetA().belongs(value.getA())
					&& product.getSetB().belongs(value.getB());
		}

	};

	private final OrderedPairClass<A, B> pairClass;

	private final ElementSet<A> setA;

	private final ElementSet<B> setB;

	private final InclusionCondition<A, B> inclusionCondition;

	@SuppressWarnings("unchecked")
	public CartesianProduct(OrderedPairClass<A, B> pairClass,
			ElementSet<A> setA, ElementSet<B> setB) {
		super(pairClass, new Condition[] { new InclusionCondition<A, B>(
				pairClass) });
		this.pairClass = pairClass;
		this.setA = setA;
		this.setB = setB;
		inclusionCondition = (InclusionCondition<A, B>) getCondition(0);
		inclusionCondition.setProduct(this);
	}

	public ElementClass<A> getClassA() {
		return pairClass.getClassA();
	}

	public ElementClass<B> getClassB() {
		return pairClass.getClassB();
	}

	public ElementSet<A> getSetA() {
		return setA;
	}

	public ElementSet<B> getSetB() {
		return setB;
	}

}