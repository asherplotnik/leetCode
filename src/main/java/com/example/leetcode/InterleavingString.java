package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Map<String,Boolean> dp = new HashMap<>();
        return innerIsInterleave(s1,s2,s3,dp);
    }
    private static boolean innerIsInterleave(String s1, String s2, String s3, Map<String, Boolean> dp) {
        var str = s3 + "-" +s1 + "-" +s2;
        if (dp.get(str) != null) {
            return dp.get(str);
        }
        int index1 = 0;
        int index2 = 0;
        var len = s3.length();
        if (len == 134 ) {
            len = 134;
        }
        for (int i = 0; i < s3.length(); i++) {
            if (index1 >= s1.length()) {
                if (checkLast(s2,s3,index2,i)){
                    index2++;
                    continue;
                } else {
                    dp.put(str, false);
                    return false;
                }
            }
            char a1 = s1.charAt(index1);
            if (index2 >= s2.length()) {
                if (checkLast(s1,s3,index1,i)) {
                    index1++;
                    continue;
                } else {
                    dp.put(str, false);
                    return false;
                }
            }
            char a2 = s2.charAt(index2);
            char a3 = s3.charAt(i);
            if (a1 != a3 && a2 != a3) {
                dp.put(str, false);
                return false;
            }
            if (a1 == a3 && a2 != a3) {
                index1++;
                continue;
            }
            if (a2 == a3 && a1 != a3) {
                index2++;
                continue;
            }
            if (i == s3.length() - 2 && index1 == s1.length()-1 && index2 == s2.length()-1) {
                dp.put(str, true);
                return true;
            }
            if (index1 < s1.length() - 1) {
                boolean firstTry = innerIsInterleave(s1.substring(index1 + 1), s2.substring(index2), s3.substring(i + 1),dp);
                if (firstTry) {
                    dp.put(str, true);
                    return true;
                }
            }
            if (index2 < s2.length() - 1) {
                var res = innerIsInterleave(s1.substring(index1), s2.substring(index2 + 1), s3.substring(i + 1),dp);
                dp.put(str, res);
                return res;
            } else {
                dp.put(str, false);
                return false;
            }

        }
        dp.put(str, true);
        return true;
    }

    private static boolean checkLast(String s, String s3, int index, int i) {
        if (index >= s.length()) {
          return false;
        }
        return s.charAt(index) == s3.charAt(i);
    }


    public static void main(String[] args) {
        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
//        String s1 = "aabaac";
//        String s2 = "aadaaeaaf";
//        String s3 = "aadaaeaabaafaac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
