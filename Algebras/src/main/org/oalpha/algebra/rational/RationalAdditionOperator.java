package org.oalpha.algebra.rational;

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
public class RationalAdditionOperator extends SetBinaryOperator<RationalNumber> implements
		UnitalBinaryOperator<RationalNumber>, DivisionBinaryOperator<RationalNumber>,
		InvertableBinaryOperator<RationalNumber> {

	public static final RationalAdditionOperator operator = new RationalAdditionOperator();

	private RationalAdditionOperator() {
		super(RationalClass.rationalClass);
	}

	@Override
	public RationalNumber operate(RationalNumber a, RationalNumber b) {
		return a.sum(b);
	}

	@Override
	public RationalNumber getIdentity() {
		return RationalNumber.zero();
	}

	@Override
	public RationalNumber divideLeft(RationalNumber dividend, RationalNumber divisor) {
		return divide(dividend, divisor);
	}

	@Override
	public RationalNumber divideRight(RationalNumber dividend, RationalNumber divisor) {
		return divide(dividend, divisor);
	}

	@Override
	public RationalNumber divide(RationalNumber dividend, RationalNumber divisor) {
		return dividend.difference(divisor);
	}

	public RationalNumber getInverse(RationalNumber value) {
		return value.negation();
	}

	public SetBinaryOperator<RationalNumber> createLeftDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetBinaryOperator<RationalNumber> createRightDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetBinaryOperator<RationalNumber> createDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetUnaryOperator<RationalNumber> createInverseOperator() {
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
					ClassLoader loader = RationalAdditionOperator.class
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