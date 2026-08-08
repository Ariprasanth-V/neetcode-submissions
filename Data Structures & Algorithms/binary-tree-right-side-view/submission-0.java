/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root==null) return list;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            TreeNode Rnode = null;
            for(int i=0;i<len;i++){
                TreeNode node=queue.poll();
                if(node!=null){
                    Rnode=node;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(Rnode!=null) list.add(Rnode.val);
        }
        return list;
    }
}
