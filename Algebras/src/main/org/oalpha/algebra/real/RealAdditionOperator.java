package org.oalpha.algebra.real;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

import org.oalpha.algebra.DivisionBinaryOperator;
import org.oalpha.algebra.InvertableBinaryOperator;
import org.oalpha.algebra.SetBinaryOperator;
import org.oalpha.algebra.SetBinaryOperator.AssociativeOperator;
import org.oalpha.algebra.SetBinaryOperator.CancellativeOperator;
import org.oalpha.algebra.SetBinaryOperator.CummutativeOperator;
import org.oalpha.algebra.SetBinaryOperator.DivisionOperator;
import org.oalpha.algebra.SetBinaryOperator.InvertableOperator;
import org.oalpha.algebra.SetBinaryOperator.OperationDirection;
import org.oalpha.algebra.SetBinaryOperator.UnitalOperator;
import org.oalpha.algebra.SetUnaryOperator;
import org.oalpha.algebra.UnitalBinaryOperator;

@CummutativeOperator
@AssociativeOperator
@UnitalOperator
@CancellativeOperator(direction = OperationDirection.BOTH)
@DivisionOperator(direction = OperationDirection.BOTH)
@InvertableOperator
public class RealAdditionOperator extends SetBinaryOperator<Double> implements
		UnitalBinaryOperator<Double>, DivisionBinaryOperator<Double>,
		InvertableBinaryOperator<Double> {

	public static final RealAdditionOperator operator = new RealAdditionOperator();

	private RealAdditionOperator() {
		super(RealClass.realClass);
	}

	@Override
	public Double operate(Double a, Double b) {
		return a + b;
	}

	@Override
	public Double getIdentity() {
		return 0d;
	}

	@Override
	public Double divideLeft(Double dividend, Double divisor) {
		return divide(dividend, divisor);
	}

	@Override
	public Double divideRight(Double dividend, Double divisor) {
		return divide(dividend, divisor);
	}

	@Override
	public Double divide(Double dividend, Double divisor) {
		return dividend - divisor;
	}

	public Double getInverse(Double value) {
		return -value;
	}

	public SetBinaryOperator<Double> createLeftDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetBinaryOperator<Double> createRightDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetBinaryOperator<Double> createDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetUnaryOperator<Double> createInverseOperator() {
		return new InvertableBinaryOperator.InverseOperator<>(this);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		operator.describe();
		if (false) {
			System.out.println();
			Annotation[] as = operator.getClass().getAnnotations();
			for (Annotation a : as)
				System.out.println("\t" + a.annotationType().getName());
			AnnotatedType[] ais = operator.getClass().getAnnotatedInterfaces();
			System.out.println();
			for (AnnotatedType ai : ais) {
				System.out.println("\t"
						+ ai.getType().getTypeName().split("<")[0]);
				try {
					ClassLoader loader = RealAdditionOperator.class
							.getClassLoader();
					String typeName = ai.getType().getTypeName().split("<")[0];
					Class<?> type = loader.loadClass(typeName);
					for (Annotation a : type.getAnnotations())
						System.out.println("\t\t"
								+ a.annotationType().getName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

}