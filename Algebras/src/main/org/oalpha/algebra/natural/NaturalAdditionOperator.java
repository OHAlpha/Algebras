package org.oalpha.algebra.natural;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

import org.oalpha.algebra.SetBinaryOperator;
import org.oalpha.algebra.SetBinaryOperator.AssociativeOperator;
import org.oalpha.algebra.SetBinaryOperator.CancellativeOperator;
import org.oalpha.algebra.SetBinaryOperator.CummutativeOperator;
import org.oalpha.algebra.SetBinaryOperator.OperationDirection;

@CummutativeOperator
@AssociativeOperator
@CancellativeOperator(direction = OperationDirection.BOTH)
public class NaturalAdditionOperator extends SetBinaryOperator<Integer> {

	public static final NaturalAdditionOperator operator = new NaturalAdditionOperator();

	private NaturalAdditionOperator() {
		super(NaturalClass.naturalClass);
	}

	@Override
	public Integer operate(Integer a, Integer b) {
		return a + b;
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
					ClassLoader loader = NaturalAdditionOperator.class
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