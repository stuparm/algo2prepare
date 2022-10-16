package com.algo2prepare;

import com.algo2prepare.util.Tree;

public class TreeSample {

    public static void main(String[] args) {
        TreeNode root = Tree.ints(TreeNode.class,"[3,9,20,null,null,15,7]");
        Tree.print(root);
        //           3
        //       ┌───┴───┐
        //       9      20
        //             ┌─┴─┐
        //            15   7

        TreeNode gen1 = Tree.generate(TreeNode.class, 4);
        Tree.print(gen1);
        //                  39
        //           ┌───────┴───────┐
        //           9              44
        //       ┌───┴───┐       ┌───┴───┐
        //       5      82      49      24
        //     ┌─┘     ┌─┴─┐     └─┐     └─┐
        //    48       3  82       3       6

        TreeNode gen2 = Tree.generateComplete(TreeNode.class, 4);
        Tree.print(gen2);
        //                  95
        //           ┌───────┴───────┐
        //          10              17
        //       ┌───┴───┐       ┌───┴───┐
        //      59      66      77      37
        //     ┌─┴─┐   ┌─┴─┐   ┌─┴─┐   ┌─┴─┐
        //    25  78  18  21   5  55  65  22

        // other methods:
        // NodeChar root1 = Tree.chars(NodeChar.class, "[a,b,c,d,null]");
        // NodeChar root2 = Tree.chars(NodeChar.class, "['a','b','c','d',null]");

        // NodeString root3 = Tree.string(NodeString.class, "[\"ab\",\"bc\",\"cd\"]");
        // NodeString root4 = Tree.string(NodeString.class, "[ab,bc,cd]");

    }

    /**
     * https://leetcode.com/problems/balanced-binary-tree/
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
