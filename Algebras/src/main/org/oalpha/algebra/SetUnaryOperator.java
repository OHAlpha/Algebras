package org.oalpha.algebra;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class SetUnaryOperator<T> extends UnaryOperator<T, T> {

	public SetUnaryOperator(ElementClass<T> elementClass) {
		super(elementClass, elementClass);
		if (elementClass == null)
			throw new IllegalArgumentException();
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	@Inherited
	public static @interface InvertableOperator {
	}

	public boolean isInvertable() {
		if (this instanceof InvertableUnaryOperator)
			return true;
		@SuppressWarnings("rawtypes")
		Class<? extends SetUnaryOperator> type = getClass();
		InvertableOperator annotation = type.getAnnotation(InvertableOperator.class);
		return annotation != null;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Target(ElementType.TYPE)
	@Inherited
	public static @interface SelfInvertableOperator {
	}

	public boolean isSelfInvertable() {
		@SuppressWarnings("rawtypes")
		Class<? extends SetUnaryOperator> type = getClass();
		SelfInvertableOperator annotation = type.getAnnotation(SelfInvertableOperator.class);
		return annotation != null;
	}

}