package com.example.compositionoverinheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackUsingInheritanceTest {
	@Test
	void stackPointer_isCorrect_whenPushMany() {
		StackUsingInheritance<String> stack = new StackUsingInheritance<>();
		stack.push("1");
		assertEquals(1, stack.stackPointer);
	}

	@Test
	void stackPointer_isCorrect_whenPush() {
		StackUsingInheritance<String> stack = new StackUsingInheritance<>();
		stack.pushMany(new String[]{"1", "2"});
		assertEquals(2, stack.stackPointer);
	}

	@Test
	void stackPointer_isCorrect_whenPop() {
		StackUsingInheritance<String> stack = new StackUsingInheritance<>();
		stack.push("1");
		stack.pop();
		assertEquals(0, stack.stackPointer);
	}

	/*
	 * problem : clear() method from superclass does not update stackPointer
	 * 1/2 solution : override every method from superclass
	 * 			problem : when adding a method in superclass we should not forget to override it in subclass
	 * 			solution : use interface inheritance (it imposes us to implement every method)
	 *
	 * implementation inheritance is not always good (superclass should be created & designed to be inherited)
	 * interface inheritance is safer
	 * or rather use composition (see example)
	 */
	@Test
	void stackPointer_isNotCorrect_whenClear_becauseClearIsNotBeingOverridden() {
		StackUsingInheritance<String> stack = new StackUsingInheritance<>();
		stack.push("1");
		stack.push("2");
		stack.clear();
		assertEquals(2, stack.stackPointer);
	}
}