package com.homework.home;

import java.util.HashMap;

public class Stack {
    public static String extract(int count) {
        try {
            if (count > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (Stack.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String clname = element.getClassName();
                    int number = element.getLineNumber();
                    return String.format(
                            "name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d\n",
                            name, clname, number);

                }
            }
        }
        return "";
    }
}






