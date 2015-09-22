package org.oalpha.algebra;

public class GAlgebra<T> extends Algebra<T> {

	private final SetBinaryOperator<T> operator;

	@SuppressWarnings("unchecked")
	public GAlgebra(ElementSet<T> elementSet, SetBinaryOperator<T> operator) {
		super(elementSet, null, new SetBinaryOperator[] { operator });
		this.operator = operator;
	}

	public SetBinaryOperator<T> getOperator() {
		return operator;
	}

	public boolean isQuasiGroup() {
		return operator.isDivision();
	}

	public boolean isLoop() {
		return operator.isDivision() && operator.isUnital();
	}

	public boolean isSemiGroup() {
		return operator.isAssociative();
	}

	public boolean isMonoid() {
		return operator.isAssociative() && operator.isUnital();
	}

	public boolean isGroup() {
		return operator.isUnital() && operator.isInvertable()
				&& operator.isAssociative();
	}

	public boolean isAbelian() {
		return operator.isUnital() && operator.isInvertable()
				&& operator.isCommutative() && operator.isAssociative();
	}

	public void describe() {
		System.out.println(getClass().getSimpleName() + ".isQuasiGroup() = "
				+ isQuasiGroup());
		System.out.println(getClass().getSimpleName() + ".isLoop() = "
				+ isLoop());
		System.out.println(getClass().getSimpleName() + ".isSemiGroup() = "
				+ isSemiGroup());
		System.out.println(getClass().getSimpleName() + ".isMonoid() = "
				+ isMonoid());
		System.out.println(getClass().getSimpleName() + ".isGroup() = "
				+ isGroup());
		System.out.println(getClass().getSimpleName() + ".isAbelian() = "
				+ isAbelian());
	}

}