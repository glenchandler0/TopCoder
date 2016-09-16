package com.company;

//This program uses recursive tactics to see if there are any duplicate substrings within a string.

public class substringDuplicate {

    public static boolean substringDuplicate(String original) {
        String s1 = "";
        String s2 = "";
        int index = 0;
        return handler(original, s1, s2, index);
    }

    public static boolean handler(String original, String s1, String s2, int index)
    {
        if(index >= original.length())
            return s1.compareTo(s2) == 0;

        return handler(original, s1 + original.charAt(index), s2, index + 1) || handler(original, s1, s2 + original.charAt(index), index + 1);
    }
}
