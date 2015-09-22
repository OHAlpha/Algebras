package org.oalpha.algebra;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class SetBinaryOperator<T> extends BinaryOperator<T, T, T> {

	public SetBinaryOperator(ElementClass<T> elementClass) {
		super(elementClass, elementClass, elementClass);
		if (elementClass == null)
			throw new IllegalArgumentException();
	}

	public static enum OperationDirection {

		LEFT, RIGHT, BOTH;

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	public static @interface CummutativeOperator {
	}

	public boolean isCommutative() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		CummutativeOperator annotation = type
				.getAnnotation(CummutativeOperator.class);
		return annotation != null;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	public static @interface AssociativeOperator {
	}

	public boolean isAssociative() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		AssociativeOperator annotation = type
				.getAnnotation(AssociativeOperator.class);
		return annotation != null;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	@Inherited
	public static @interface UnitalOperator {
	}

	public boolean isUnital() {
		if (this instanceof UnitalBinaryOperator)
			return true;
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		UnitalOperator annotation = type.getAnnotation(UnitalOperator.class);
		return annotation != null;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	public static @interface CancellativeOperator {

		OperationDirection direction() default OperationDirection.BOTH;

	}

	public boolean isCancellative() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		CancellativeOperator annotation = type
				.getAnnotation(CancellativeOperator.class);
		return annotation != null;
	}

	public OperationDirection getCancellativeDirection() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		CancellativeOperator annotation = type
				.getAnnotation(CancellativeOperator.class);
		if (annotation != null)
			return annotation.direction();
		else
			return null;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	public static @interface DivisionOperator {

		OperationDirection direction() default OperationDirection.BOTH;

	}

	public boolean isDivision() {
		if (this instanceof DivisionBinaryOperator)
			return true;
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		DivisionOperator annotation = type
				.getAnnotation(DivisionOperator.class);
		return annotation != null;
	}

	public OperationDirection getDivisionDirection() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		DivisionOperator annotation = type
				.getAnnotation(DivisionOperator.class);
		if (annotation != null)
			return annotation.direction();
		else
			return null;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	@Inherited
	public static @interface InvertableOperator {
	}

	public boolean isInvertable() {
		if (this instanceof InvertableBinaryOperator)
			return true;
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		InvertableOperator annotation = type
				.getAnnotation(InvertableOperator.class);
		return annotation != null;
	}

	public boolean isAbelian() {
		return isUnital() && isInvertable() && isCommutative()
				&& isAssociative();
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	public static @interface DistributativeOperator {

		Class<? extends SetBinaryOperator<?>> over();

		OperationDirection direction() default OperationDirection.BOTH;

	}

	public boolean isDistributative() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		DistributativeOperator annotation = type
				.getAnnotation(DistributativeOperator.class);
		return annotation != null;
	}

	public Class<? extends SetBinaryOperator<?>> getDistributativeOver() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		DistributativeOperator annotation = type
				.getAnnotation(DistributativeOperator.class);
		if (annotation != null)
			return annotation.over();
		else
			return null;
	}

	public OperationDirection getDistributativeDirection() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetBinaryOperator> type = getClass();
		DistributativeOperator annotation = type
				.getAnnotation(DistributativeOperator.class);
		if (annotation != null)
			return annotation.direction();
		else
			return null;
	}

	public void describe() {
		System.out.println(getClass().getSimpleName() + ".isCommutative() = "
				+ isCommutative());
		System.out.println(getClass().getSimpleName() + ".isAssociative() = "
				+ isAssociative());
		System.out.println(getClass().getSimpleName() + ".isUnital() = "
				+ isUnital());
		System.out.println(getClass().getSimpleName() + ".isCancellative() = "
				+ isCancellative());
		if (isCancellative())
			System.out.println(getClass().getSimpleName()
					+ ".getCancellativeDirection() = "
					+ getCancellativeDirection());
		System.out.println(getClass().getSimpleName() + ".isDivision() = "
				+ isDivision());
		if (isDivision())
			System.out.println(getClass().getSimpleName()
					+ ".getDivisionDirection() = " + getDivisionDirection());
		System.out.println(getClass().getSimpleName() + ".isInvertable() = "
				+ isInvertable());
		System.out.println(getClass().getSimpleName() + ".isAbelian() = "
				+ isAbelian());
		System.out.println(getClass().getSimpleName()
				+ ".isDistributative() = " + isDistributative());
	}

}