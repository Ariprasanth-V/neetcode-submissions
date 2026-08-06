class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        Collections.sort(list,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> ans = new ArrayList<>();
        for(int[] inter:list){
            if(ans.isEmpty() || ans.get(ans.size()-1)[1]<inter[0]) ans.add(inter);
            else ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],inter[1]);
        }
        return ans.toArray(new int[ans.size()][]);

    }
}
