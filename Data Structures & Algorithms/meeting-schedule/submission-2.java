/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator
                .comparingInt((Interval i) -> i.start)
                .thenComparingInt(i -> i.end));
        List<Interval> ans = new ArrayList<>();
        for(Interval in:intervals){
            if(ans.isEmpty() || ans.get(ans.size()-1).end<=in.start) ans.add(in);
            else return false;
        }
        return true;
    }
}
