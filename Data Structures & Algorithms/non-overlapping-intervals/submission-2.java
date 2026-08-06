class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        for(int[] inter:intervals){
            if(list.isEmpty() || list.get(list.size()-1)[1]<=inter[0]) list.add(inter);
            
        }
        return intervals.length-list.size();
    }
}
