package com.example.compositionoverinheritance;

import java.util.ArrayList;

public class StackUsingComposition<E> {
	ArrayList<E> items = new ArrayList<>();
	int stackPointer = 0;

	public void push(E item) {
		items.add(stackPointer++, item);
	}

	public void pushMany(E[] items) {
		for(E item : items) {
			push(item);
		}
	}

	public E pop() {
		return items.remove(--stackPointer);
	}
}
