package org.moss.charactersheet.util;

public interface Adder<T extends Number> {
	T zero();
	T add(T lhs, T rhs);
}
