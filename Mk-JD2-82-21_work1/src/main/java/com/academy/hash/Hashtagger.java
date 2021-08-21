package com.academy.hash;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hashtagger {

    public static String changeFourthAndSeventhSymbolToHashtag(String text) {
        StringBuilder sb = new StringBuilder(text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            sb.setCharAt(start + 3, '#');
            if (matcher.group().length() >= 7) {
                sb.setCharAt(start + 6, '#');
            }

        }
        return sb.toString();
    }
}

