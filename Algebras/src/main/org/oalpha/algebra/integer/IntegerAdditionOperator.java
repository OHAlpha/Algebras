package org.oalpha.algebra.integer;

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
public class IntegerAdditionOperator extends SetBinaryOperator<Integer> implements
		UnitalBinaryOperator<Integer>, DivisionBinaryOperator<Integer>,
		InvertableBinaryOperator<Integer> {

	public static final IntegerAdditionOperator operator = new IntegerAdditionOperator();

	private IntegerAdditionOperator() {
		super(IntegerClass.integerClass);
	}

	@Override
	public Integer operate(Integer a, Integer b) {
		return a + b;
	}

	@Override
	public Integer getIdentity() {
		return 0;
	}

	@Override
	public Integer divideLeft(Integer dividend, Integer divisor) {
		return divide(dividend, divisor);
	}

	@Override
	public Integer divideRight(Integer dividend, Integer divisor) {
		return divide(dividend, divisor);
	}

	@Override
	public Integer divide(Integer dividend, Integer divisor) {
		return dividend - divisor;
	}

	public Integer getInverse(Integer value) {
		return -value;
	}

	public SetBinaryOperator<Integer> createLeftDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetBinaryOperator<Integer> createRightDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetBinaryOperator<Integer> createDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetUnaryOperator<Integer> createInverseOperator() {
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
					ClassLoader loader = IntegerAdditionOperator.class
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