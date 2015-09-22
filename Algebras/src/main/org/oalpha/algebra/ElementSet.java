package org.oalpha.algebra;

public class ElementSet<T> {

	private final Condition<T>[] conditions;

	private ElementClass<T> elementClass;

	@SuppressWarnings("unchecked")
	protected ElementSet(Condition<T>[] conditions) {
		super();
		if (conditions != null) {
			this.conditions = (Condition<T>[]) new Condition<?>[conditions.length];
			System.arraycopy(conditions, 0, this.conditions, 0,
					conditions.length);
		} else
			this.conditions = (Condition<T>[]) new Condition<?>[0];
	}

	@SuppressWarnings("unchecked")
	public ElementSet(ElementClass<T> elementClass, Condition<T>[] conditions) {
		super();
		if (elementClass == null)
			throw new IllegalArgumentException();
		this.elementClass = elementClass;
		if (conditions != null) {
			this.conditions = (Condition<T>[]) new Condition<?>[conditions.length];
			System.arraycopy(conditions, 0, this.conditions, 0,
					conditions.length);
		} else
			this.conditions = (Condition<T>[]) new Condition<?>[0];
	}

	public Condition<T>[] getConditions() {
		@SuppressWarnings("unchecked")
		Condition<T>[] conditions = (Condition<T>[]) new Condition<?>[this.conditions.length];
		System.arraycopy(this.conditions, 0, conditions, 0, conditions.length);
		return conditions;
	}

	public int getNumConditions() {
		return conditions.length;
	}

	public Condition<T> getCondition(int i) {
		return conditions[i];
	}

	public boolean belongs(T value) {
		for (Condition<T> condition : conditions)
			if (!condition.test(value))
				return false;
		return true;
	}

	public ElementClass<T> getElementClass() {
		return elementClass;
	}

	protected void setElementClass(ElementClass<T> elementClass) {
		if (elementClass == null)
			throw new IllegalArgumentException();
		this.elementClass = elementClass;
	}

}