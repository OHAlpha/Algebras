package org.oalpha.algebra;

import org.oalpha.algebra.SetUnaryOperator.InvertableOperator;

public interface InvertableUnaryOperator<T> {

	T operateInverse(T value);

	SetUnaryOperator<T> createInverseOperator();

	@InvertableOperator
	public static class InverseUnaryOperator<T> extends SetUnaryOperator<T>
			implements InvertableUnaryOperator<T> {

		private final SetUnaryOperator<T> operator;

		public InverseUnaryOperator(SetUnaryOperator<T> operator) {
			super(operator.getOutputElementClass());
			if (!(operator instanceof InvertableUnaryOperator))
				throw new IllegalArgumentException();
			this.operator = operator;
		}

		@Override
		public T operateInverse(T value) {
			return operator.operate(value);
		}

		@Override
		public SetUnaryOperator<T> createInverseOperator() {
			return operator;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T operate(T value) {
			return ((InvertableUnaryOperator<T>) operator)
					.operateInverse(value);
		}

	}

}