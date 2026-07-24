class Solution {
    public int[][] merge(int[][] intervals1) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals1,(a,b)->Integer.compare(a[0],b[0]));
        
        for(int[] intervals:intervals1){
            if(list.isEmpty() || list.get(list.size()-1)[1]<intervals[0]) {
                list.add(intervals);
            }else{
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],intervals[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
