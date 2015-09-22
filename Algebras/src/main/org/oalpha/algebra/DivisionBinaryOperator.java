package org.oalpha.algebra;

public interface DivisionBinaryOperator<T> {
	
	public abstract T divideLeft(T dividend, T divisor);
	
	public abstract T divideRight(T dividend, T divisor);
	
	public abstract T divide(T dividend, T divisor);
	
	SetBinaryOperator<T> createLeftDivisionOperator();
	
	SetBinaryOperator<T> createRightDivisionOperator();
	
	SetBinaryOperator<T> createDivisionOperator();
	
	public static class LeftDivideOperator<T> extends SetBinaryOperator<T> {
		
		private final SetBinaryOperator<T> operator;

		public LeftDivideOperator(SetBinaryOperator<T> operator) {
			super(operator.getOutputElementClass());
			this.operator = operator;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T operate(T a, T b) {
			return ((DivisionBinaryOperator<T>)operator).divideLeft(a, b);
		}
		
	}
	
	public static class RightDivideOperator<T> extends SetBinaryOperator<T> {
		
		private final SetBinaryOperator<T> operator;

		public RightDivideOperator(SetBinaryOperator<T> operator) {
			super(operator.getOutputElementClass());
			this.operator = operator;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T operate(T a, T b) {
			return ((DivisionBinaryOperator<T>)operator).divideRight(a, b);
		}
		
	}
	
	public static class DivideOperator<T> extends SetBinaryOperator<T> {
		
		private final SetBinaryOperator<T> operator;

		public DivideOperator(SetBinaryOperator<T> operator) {
			super(operator.getOutputElementClass());
			this.operator = operator;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T operate(T a, T b) {
			return ((DivisionBinaryOperator<T>)operator).divide(a, b);
		}
		
	}

}