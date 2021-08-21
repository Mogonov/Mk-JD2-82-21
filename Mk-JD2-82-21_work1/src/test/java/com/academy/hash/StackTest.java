package com.academy.hash;

import com.homework.home.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {
    @Test
    public void NumberFormatExceptionTest() {
        String expected = "name: java.lang.NumberFormatException\n" +
                "class: com.homework.home.Stack\n" +
                "line: 11\n";

        Assertions.assertEquals(expected, Stack.extract(0));
    }
    @Test
    public void NullPointerExceptionTest() {
        String expected = "name: java.lang.NullPointerException\n" +
                "class: com.homework.home.Stack\n" +
                "line: 9\n";

        Assertions.assertEquals(expected, Stack.extract(1));
    }
}
