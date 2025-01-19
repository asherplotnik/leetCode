package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        dp.put(2, 2);
        dp.put(3, 5);
        return generatedTrees(0, n, dp);
    }

    public static int generatedTrees(int s, int n, Map<Integer, Integer> dp) {
        if (s == n ) {
            return 0;
        }
        if (n - s == 1) {
            return 1;
        }
        int count = 0;
        for (int i = s; i < n; i++) {
            Integer leftList = dp.get(i - s);
            Integer rightList = dp.get(n - 1 - i);
            if (leftList == null) {
                leftList = generatedTrees(s, i , dp);
            }
            if (rightList == null) {
                rightList = generatedTrees(i , n - 1, dp);
            }
            count = count + insertFromBothLists(leftList, rightList);
        }
        dp.putIfAbsent(n-s, count);
        return count;
    }

    private static int insertFromBothLists(int leftList, int rightList) {
        if (leftList == 0 ) {
            return rightList;
        }
        if (rightList == 0) {
            return leftList;
        }
       return rightList * leftList;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
