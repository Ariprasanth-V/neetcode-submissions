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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);
        while(!queue.isEmpty()){
            int length=queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<length;i++){
                TreeNode node=queue.poll();
                if(node!=null){
                    res.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(res.size()>0) list.add(new ArrayList<>(res));
        }
        return list;
    }
}
