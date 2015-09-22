package org.oalpha.algebra.vector;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

import org.oalpha.algebra.DivisionBinaryOperator;
import org.oalpha.algebra.InvertableBinaryOperator;
import org.oalpha.algebra.RAlgebra;
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
public class VectorAdditionOperator<T> extends SetBinaryOperator<Vector<T>>
		implements UnitalBinaryOperator<Vector<T>>,
		DivisionBinaryOperator<Vector<T>>, InvertableBinaryOperator<Vector<T>> {

	private VectorAdditionOperator(VectorSpace<T> space) {
		super(space);
	}

	@Override
	public VectorSpace<T> getInputElementClassA() {
		return (VectorSpace<T>) super.getInputElementClassA();
	}

	@Override
	public VectorSpace<T> getInputElementClassB() {
		return (VectorSpace<T>) super.getInputElementClassA();
	}

	@Override
	public VectorSpace<T> getOutputElementClass() {
		return (VectorSpace<T>) super.getInputElementClassA();
	}

	public RAlgebra<T> getField() {
		return getOutputElementClass().getElementClass().getField();
	}

	public int getDimensions() {
		return getOutputElementClass().getDimensions();
	}

	@Override
	public Vector<T> operate(Vector<T> a, Vector<T> b) {
		return a.sum(b);
	}

	@Override
	public Vector<T> getIdentity() {
		return new Vector<T>(getField(), getDimensions());
	}

	@Override
	public Vector<T> divideLeft(Vector<T> dividend, Vector<T> divisor) {
		return divide(dividend, divisor);
	}

	@Override
	public Vector<T> divideRight(Vector<T> dividend, Vector<T> divisor) {
		return divide(dividend, divisor);
	}

	@Override
	public Vector<T> divide(Vector<T> dividend, Vector<T> divisor) {
		return dividend.difference(divisor);
	}

	public Vector<T> getInverse(Vector<T> value) {
		return value.negation();
	}

	public SetBinaryOperator<Vector<T>> createLeftDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetBinaryOperator<Vector<T>> createRightDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetBinaryOperator<Vector<T>> createDivisionOperator() {
		return new DivisionBinaryOperator.DivideOperator<>(this);
	}

	public SetUnaryOperator<Vector<T>> createInverseOperator() {
		return new InvertableBinaryOperator.InverseOperator<>(this);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		VectorAdditionOperator<Double> operator = new VectorAdditionOperator<Double>(
				null);
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
					ClassLoader loader = VectorAdditionOperator.class
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