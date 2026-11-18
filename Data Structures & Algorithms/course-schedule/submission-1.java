class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // Khan's algorithm
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        int[] indegree=new int[n];
        for(int[] p:prerequisites) {
            list.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i]==0) q.add(i);

        int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;
            for(int i:list.get(node)){
                indegree[i]--;
                if(indegree[i]==0) q.add(i);
            }
        }
        return cnt==n;
        
    }
}
