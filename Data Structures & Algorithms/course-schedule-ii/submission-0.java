class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        int[] indegree=new int[n];
        for(int[] p:pre){
            list.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i]==0) q.add(i);

        int finish=0;
        int[] op=new int[n];
        while(!q.isEmpty()){
            int node=q.poll();
            op[n-finish-1]=node;
            finish++;
            for(int i:list.get(node)){
                indegree[i]--;
                if(indegree[i]==0) q.offer(i);
            }
        }

        if(finish!=n) return new int[0];
        return op;

    }
}
