package com.academy.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HashtaggerTest {
    @Test
    public void Test(){
        var expectedResult = "Кол#ун нес#т бог#ты#я.";
        var actualResult = Hashtagger.changeFourthAndSeventhSymbolToHashtag("Колдун несёт богатыря.");
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
