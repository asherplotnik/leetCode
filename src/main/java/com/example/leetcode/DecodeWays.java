package com.example.leetcode;

public class DecodeWays {
    public static int numDecodings(String s) {
        try {
            return inner(s,null);
        } catch (RuntimeException e) {
            return 0;
        }
    }

    private static int inner(String s, Integer inner2) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return parseOne(s.charAt(0));
        }
        if (s.length() == 2) {
            if (s.charAt(0) <= '0') {
                throw new RuntimeException("Invalid input!");
            }
            if (s.charAt(0) > '2' && s.charAt(1) == '0') {
                throw new RuntimeException("Invalid input!");
            }
            if (Integer.parseInt(s) > 26) {
                return 1;
            }
            if (s.charAt(1) == '0'){
                return 1;
            }
            return 2;
        }
        if (s.charAt(0) <= '0') {
            throw new RuntimeException("Invalid input!");
        }
        if (s.charAt(0) > '2') {
            return inner(s.substring(1), null);
        }
        if (s.charAt(1) == '0'|| (s.charAt(0) == '2' && s.charAt(1) > '6')) {
            return inner(s.substring(2), null);
        }
        if (s.charAt(2) == '0') {
            if (s.charAt(1) > '2') {
                throw new RuntimeException("Invalid input!");
            }
            if (s.length() > 3) {
                return inner(s.substring(3), null);
            }
            return 1;
        }

        int res2 = inner(s.substring(2), null);
        Integer res1 = inner2;
        if (inner2 == null) {
            res1 = inner(s.substring(1), res2);
        }

        return res1 + res2;
    }

    private static int parseOne(char digit) {
        if (digit < '1' || digit > '9') {
            throw new RuntimeException("Input must be a digit between '1' and '9'");
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(DecodeWays.numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
    }
}
