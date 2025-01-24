package model;

import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String left = Objects.isNull(this.left) ? "null" : this.left.toString();
        String right = Objects.isNull(this.right) ? "null" : this.right.toString();
        if (this.left == null && this.right == null) {
            return "new TreeNode("+this.val+");";
        }
        return "new TreeNode("+this.val+","+left+","+right+");";

    }
}
