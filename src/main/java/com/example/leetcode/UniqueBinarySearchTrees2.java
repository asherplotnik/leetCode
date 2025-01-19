package com.example.leetcode;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearchTrees2 {
    //succeeded by my self but differently. similar to UniqueBinarySearchTrees.


    public static List<TreeNode> generateTrees(int n) {
        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        dp.put(0, null);
        return generatedTrees(1, n, dp);
    }

    public static List<TreeNode> generatedTrees(int s, int n, Map<Integer, List<TreeNode>> dp) {
        List<TreeNode> list = new ArrayList<>();
        if (s > n ) {
            list.add(null);
            return list;
        }

        for (int i = s; i <= n; i++) {
            List<TreeNode> leftList = dp.get(i-1-s);
            List<TreeNode> rightList = dp.get(n-(i+1));
            if (leftList == null) {
                leftList = generatedTrees(s, i - 1, dp);
            }
            if (rightList == null) {
                rightList = generatedTrees(i + 1, n, dp);
            }
            insertFromBothLists(i, leftList, rightList, list);
        }
        dp.putIfAbsent(n-s, list);
        return list;
    }

    private static void insertFromBothLists(int i, List<TreeNode> leftList, List<TreeNode> rightList, List<TreeNode> list) {
        for (TreeNode leftNode : leftList) {
            for (TreeNode rightNode : rightList) {
                TreeNode current = new TreeNode(i);
                current.left = leftNode;
                current.right = rightNode;
                list.add(current);
            }
        }
    }


    public static void main(String[] args) {
        generateTrees(3).forEach(System.out::println);
    }
}
