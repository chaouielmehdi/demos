package com.example.compositionoverinheritance;

import java.util.ArrayList;

class StackUsingInheritance<E> extends ArrayList<E> {
	int stackPointer = 0;

	public void push(E item) {
		add(stackPointer++, item);
	}

	public void pushMany(E[] items) {
		for(E item : items) {
			push(item);
		}
	}

	public E pop() {
		return remove(--stackPointer);
	}
}
