package com.example.leetcode;

import model.TreeNode;

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return allLeafsSmaller(root.val, root.left) && allLeafsBigger(root.val,root.right);
    }

    private static boolean allLeafsSmaller(int val, TreeNode left) {
        if (left == null) {
            return true;
        }
        if (left.val >= val) {
            return false;
        } else {
            return allLeafsSmaller(val, left.left) && allLeafsSmaller(val, left.right) && allLeafsSmaller(left.val, left.left) && allLeafsBigger(left.val, left.right);
        }
    }

    private static boolean allLeafsBigger(int val, TreeNode right) {
        if (right == null) {
            return true;
        }
        if (right.val <= val) {
            return false;
        } else {
            return allLeafsBigger(val, right.right) && allLeafsBigger(val, right.left) && allLeafsBigger(right.val, right.right) && allLeafsSmaller(right.val, right.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        TreeNode root = new TreeNode(0, null, new TreeNode(1));
//        TreeNode root = new TreeNode(45, new TreeNode(42, null, new TreeNode(44, new TreeNode(43, new TreeNode(41),null),null)), null);
        System.out.println(isValidBST(root));
    }
}
