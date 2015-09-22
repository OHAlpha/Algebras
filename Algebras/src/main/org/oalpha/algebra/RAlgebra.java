package org.oalpha.algebra;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.oalpha.algebra.SetBinaryOperator.OperationDirection;

public class RAlgebra<T> extends Algebra<T> {

	private final SetBinaryOperator<T> addition;

	private final SetBinaryOperator<T> multiplication;

	@SuppressWarnings("unchecked")
	public RAlgebra(ElementSet<T> elementSet, SetBinaryOperator<T> addition,
			SetBinaryOperator<T> multiplication) {
		super(elementSet, null, new SetBinaryOperator[] { addition,
				multiplication });
		this.addition = addition;
		this.multiplication = multiplication;
	}

	public SetBinaryOperator<T> getAddition() {
		return addition;
	}

	public GAlgebra<T> getAdditionAlgebra() {
		return new GAlgebra<T>(getElementClass(), addition);
	}

	public SetBinaryOperator<T> getMultiplication() {
		return multiplication;
	}

	public GAlgebra<T> getMultiplicationAlgebra() {
		return new GAlgebra<T>(getElementClass(), multiplication);
	}

	public boolean isNearRing() {
		return addition.isUnital()
				&& addition.isInvertable()
				&& addition.isAssociative()
				&& multiplication.isAssociative()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.RIGHT
				|| multiplication.getDistributativeDirection() == OperationDirection.BOTH;
	}

	public boolean isSemiRing() {
		return addition.isUnital()
				&& addition.isAssociative()
				&& addition.isCommutative()
				&& multiplication.isUnital()
				&& multiplication.isAssociative()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.BOTH
				&& isAnnhiliativeAlgebra();
	}

	public boolean isCommutativeSemiRing() {
		return addition.isUnital()
				&& addition.isAssociative()
				&& addition.isCommutative()
				&& multiplication.isUnital()
				&& multiplication.isAssociative()
				&& multiplication.isCommutative()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.BOTH
				&& isAnnhiliativeAlgebra();
	}

	public boolean isPsuedoRing() {
		return addition.isAbelian()
				&& multiplication.isAssociative()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.BOTH;
	}

	public boolean isRing() {
		return addition.isAbelian()
				&& multiplication.isUnital()
				&& multiplication.isAssociative()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.BOTH;
	}

	public boolean isCommutativeRing() {
		return addition.isAbelian()
				&& multiplication.isUnital()
				&& multiplication.isAssociative()
				&& multiplication.isCommutative()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.BOTH;
	}

	public boolean isDomain() {
		return addition.isAbelian()
				&& multiplication.isUnital()
				&& multiplication.isAssociative()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.BOTH
				&& isDivisionAlgebra();
	}

	public boolean isIntegralDomain() {
		return addition.isAbelian()
				&& multiplication.isUnital()
				&& multiplication.isAssociative()
				&& multiplication.isCommutative()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.BOTH
				&& isDivisionAlgebra();
	}

	public boolean isField() {
		return addition.isAbelian()
				&& multiplication.isAbelian()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver())
				&& multiplication.getDistributativeDirection() == OperationDirection.BOTH;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	public static @interface AnnhiliativeAlgebra {
	}

	public boolean isAnnhiliativeAlgebra() {
		if (addition.isInvertable()
				&& addition.getClass().equals(
						multiplication.getDistributativeOver()))
			return true;
		@SuppressWarnings("rawtypes")
		Class<? extends RAlgebra> type = getClass();
		AnnhiliativeAlgebra annotation = type
				.getAnnotation(AnnhiliativeAlgebra.class);
		return annotation != null;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	public static @interface DivisionAlgebra {
	}

	public boolean isDivisionAlgebra() {
		if (isAnnhiliativeAlgebra() && multiplication.isInvertable())
			return true;
		@SuppressWarnings("rawtypes")
		Class<? extends RAlgebra> type = getClass();
		DivisionAlgebra annotation = type.getAnnotation(DivisionAlgebra.class);
		return annotation != null;
	}

	public void describe() {
		System.out.println(getClass().getSimpleName() + ".isNearRing() = "
				+ isNearRing());
		System.out.println(getClass().getSimpleName() + ".isSemiRing() = "
				+ isSemiRing());
		System.out.println(getClass().getSimpleName()
				+ ".isCommutativeSemiRing() = " + isCommutativeSemiRing());
		System.out.println(getClass().getSimpleName() + ".isPsuedoRing() = "
				+ isPsuedoRing());
		System.out.println(getClass().getSimpleName() + ".isRing() = "
				+ isRing());
		System.out.println(getClass().getSimpleName()
				+ ".isCommutativeRing() = " + isCommutativeRing());
		System.out.println(getClass().getSimpleName() + ".isDomain() = "
				+ isDomain());
		System.out.println(getClass().getSimpleName()
				+ ".isIntegralDomain() = " + isIntegralDomain());
		System.out.println(getClass().getSimpleName() + ".isField() = "
				+ isField());
		System.out.println(getClass().getSimpleName()
				+ ".isAnnhiliativeAlgebra() = " + isAnnhiliativeAlgebra());
		System.out.println(getClass().getSimpleName()
				+ ".isDivisionAlgebra() = " + isDivisionAlgebra());
	}

}