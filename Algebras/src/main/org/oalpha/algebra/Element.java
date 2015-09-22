package org.oalpha.algebra;

public interface Element<T> {
	
	ElementClass<T> getElementClass();
	
	T getValue();
	
	void setValue(T value, Object... args);

}