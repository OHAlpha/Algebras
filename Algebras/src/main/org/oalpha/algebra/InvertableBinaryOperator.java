package org.oalpha.algebra;

import org.oalpha.algebra.SetUnaryOperator.InvertableOperator;
import org.oalpha.algebra.SetUnaryOperator.SelfInvertableOperator;

public interface InvertableBinaryOperator<T> {
	
	T getInverse(T value);

	SetUnaryOperator<T> createInverseOperator();

	@InvertableOperator
	@SelfInvertableOperator
	public static class InverseOperator<T> extends SetUnaryOperator<T>
			implements InvertableUnaryOperator<T> {

		private final SetBinaryOperator<T> operator;

		public InverseOperator(SetBinaryOperator<T> operator) {
			super(operator.getOutputElementClass());
			if (!(operator instanceof InvertableBinaryOperator))
				throw new IllegalArgumentException();
			this.operator = operator;
		}

		@Override
		public T operateInverse(T value) {
			return operate(value);
		}

		@Override
		public SetUnaryOperator<T> createInverseOperator() {
			return this;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T operate(T value) {
			return ((InvertableBinaryOperator<T>) operator)
					.getInverse(value);
		}

	}

}