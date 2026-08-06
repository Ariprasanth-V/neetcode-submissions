
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        // Sort by start time
        intervals.sort((a, b) -> a.start - b.start);

        // Min-heap to track earliest ending meeting
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Interval in : intervals) {
            if (!heap.isEmpty() && heap.peek() <= in.start) {
                heap.poll(); // reuse room
            }
            heap.add(in.end);
        }

        return heap.size();
    }
}
