class Solution {
    public boolean overlap(int[] interval1, int[] interval2) {
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];
        if (s2 > e1 || e2 < s1)
            return false;
        return true;
    }

    public int[] mergeIntervals(int[] interval1, int[] interval2) {
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];
        return new int[] { Math.min(s1, s2), Math.max(e1, e2) };
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> li = new ArrayList<>();
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (!overlap(intervals[i], intervals[i - 1])) {
                li.add(intervals[i - 1]);
            } else {
                intervals[i] = mergeIntervals(intervals[i - 1], intervals[i]);
            }
        }
        li.add(intervals[n - 1]);
        int[][] res = new int[li.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = li.get(i)[0];
            res[i][1] = li.get(i)[1];
        }
        return res;
    }
}