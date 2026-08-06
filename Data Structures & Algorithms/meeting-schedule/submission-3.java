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
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        List<Interval> ans = new ArrayList<>();
        for(Interval in:intervals){
            if(ans.isEmpty() || ans.get(ans.size()-1).end<=in.start) ans.add(in);
            else return false;
        }
        return true;
    }
}
