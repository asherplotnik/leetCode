package com.example.leetcode;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        if (Objects.nonNull(root.left)) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if (Objects.nonNull(root.right)) {
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(7))
                ),
                new TreeNode(3,
                        null,
                        new TreeNode(8,
                                new TreeNode(9),
                                null)
                ));
        System.out.println(inorderTraversal(root));
    }
}
