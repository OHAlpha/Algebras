package org.oalpha.algebra.vector;

import java.util.Collection;
import java.util.Iterator;

import org.oalpha.algebra.DivisionBinaryOperator;
import org.oalpha.algebra.InvertableBinaryOperator;
import org.oalpha.algebra.RAlgebra;
import org.oalpha.algebra.UnitalBinaryOperator;

public class Vector<T> {

	private class E<U> {
		public U u;

		public E(U t) {
			super();
			this.u = t;
		}
	}

	private final RAlgebra<T> field;

	private final E<T>[] array;

	@SuppressWarnings("unchecked")
	public Vector(RAlgebra<T> field, int dimensions) {
		if (field == null)
			throw new NullPointerException();
		if (!field.isField())
			throw new IllegalArgumentException("algebra must be a field");
		if (dimensions < 1)
			throw new IllegalArgumentException("dimensions must be positive");
		this.field = field;
		array = new E[dimensions];
		for (int i = 0; i < dimensions; i++)
			array[i] = new E<T>(((UnitalBinaryOperator<T>) field).getIdentity());
	}

	@SuppressWarnings("unchecked")
	public Vector(Vector<T> vec) {
		if (vec == null)
			throw new NullPointerException();
		this.field = vec.field;
		array = new E[vec.getDimensions()];
		for (int i = 0; i < array.length; i++)
			array[i] = new E<T>(vec.getAt(i));
	}

	@SuppressWarnings("unchecked")
	public Vector(RAlgebra<T> field, T[] arr) {
		if (field == null || arr == null)
			throw new NullPointerException();
		if (!field.isField())
			throw new IllegalArgumentException("algebra must be a field");
		if (arr.length < 1)
			throw new IllegalArgumentException("dimensions must be positive");
		this.field = field;
		array = new E[arr.length];
		for (int i = 0; i < arr.length; i++)
			array[i] = new E<T>(
					arr[i] == null ? ((UnitalBinaryOperator<T>) field)
							.getIdentity() : arr[i]);
	}

	@SuppressWarnings("unchecked")
	public Vector(RAlgebra<T> field, Collection<? extends T> col) {
		if (field == null || col == null)
			throw new NullPointerException();
		if (!field.isField())
			throw new IllegalArgumentException("algebra must be a field");
		if (col.size() < 1)
			throw new IllegalArgumentException("dimensions must be positive");
		this.field = field;
		array = new E[col.size()];
		int i = 0;
		for (Iterator<? extends T> it = col.iterator(); it.hasNext(); i++) {
			T t = it.next();
			array[i] = new E<T>(
					t == null ? ((UnitalBinaryOperator<T>) field).getIdentity()
							: t);
		}
	}

	public Vector<T> clone() {
		return new Vector<T>(this);
	}

	public int getDimensions() {
		return array.length;
	}

	public Object[] toArray() {
		return toArray(new Object[array.length]);
	}

	@SuppressWarnings("unchecked")
	public <U> U[] toArray(U[] arr) {
		for (int i = 0; i < array.length; i++)
			arr[i] = (U) array[i].u;
		return arr;
	}

	public T getAt(int i) {
		return array[i].u;
	}

	public void setAt(T t, int i) {
		array[i].u = t;
	}

	@SuppressWarnings("unchecked")
	public void negate() {
		for (int i = 0; i < array.length; i++)
			array[i].u = ((InvertableBinaryOperator<T>) field)
					.getInverse(array[i].u);
	}

	public void add(Vector<T> vec) {
		for (int i = 0; i < array.length; i++)
			array[i].u = field.getAddition()
					.operate(array[i].u, vec.array[i].u);
	}

	@SuppressWarnings("unchecked")
	public void subtract(Vector<T> vec) {
		for (int i = 0; i < array.length; i++)
			array[i].u = ((DivisionBinaryOperator<T>) field.getAddition())
					.divide(array[i].u, vec.array[i].u);
	}

	public Vector<T> negation() {
		Vector<T> out = clone();
		out.negate();
		return out;
	}

	public Vector<T> sum(Vector<T> vec) {
		Vector<T> out = clone();
		out.add(vec);
		return out;
	}

	public Vector<T> difference(Vector<T> vec) {
		Vector<T> out = clone();
		out.subtract(vec);
		return out;
	}

	@SuppressWarnings("unchecked")
	public T dot(Vector<T> vec) {
		T dot = ((UnitalBinaryOperator<T>) field).getIdentity();
		for (int i = 0; i < array.length; i++)
			dot = field.getAddition().operate(
					dot,
					field.getMultiplication().operate(array[i].u,
							vec.array[i].u));
		return dot;
	}

}