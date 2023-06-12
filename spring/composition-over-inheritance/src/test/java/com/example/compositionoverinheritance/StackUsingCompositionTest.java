package com.example.compositionoverinheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackUsingCompositionTest {
	@Test
	void stackPointer_isCorrect_whenPushMany() {
		StackUsingComposition<String> stack = new StackUsingComposition<>();
		stack.push("1");
		assertEquals(1, stack.stackPointer);
	}

	@Test
	void stackPointer_isCorrect_whenPush() {
		StackUsingComposition<String> stack = new StackUsingComposition<>();
		stack.pushMany(new String[]{"1", "2"});
		assertEquals(2, stack.stackPointer);
	}

	@Test
	void stackPointer_isCorrect_whenPop() {
		StackUsingComposition<String> stack = new StackUsingComposition<>();
		stack.push("1");
		stack.pop();
		assertEquals(0, stack.stackPointer);
	}

	/*
	 * using composition, we encapsulated data structure,
	 * so we have only methods that we implemented in subclass (stack.clear() is not there)
	 */
}