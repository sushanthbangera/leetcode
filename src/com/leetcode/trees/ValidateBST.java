package com.leetcode.trees;

/*
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBST {

	public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
    
    private boolean validateBST(TreeNode root, Integer max, Integer min) {

        if (root == null) {
            return true;
        }
       
        // Value of root shouln't be grater than max value or less than min Value
        if (max != null && root.val >= max || min != null && root.val <= min) {
            return false;
        }
      
        /* 
         * For left node max Value would be root value and min is the current minimum
         * For right node, max value is the current max value and min is the root value 
         */
        return validateBST(root.left, root.val, min)
                && validateBST(root.right, max, root.val);
    }
}
