class Solution {
    public boolean overlap(int[] interval1, int[] interval2) {
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];
        if (e2 < s1 || e1 < s2)
            return false;
        return true;
    }

    public int[] merge(int[] interval1, int[] interval2) {
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];
        return new int[] { Math.min(s1, s2), Math.max(e1, e2) };
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i=1;i<n;i++){
            if(!overlap(intervals[i],intervals[i-1])){
                list.add(intervals[i-1]);
            }
            else{
                intervals[i]=merge(intervals[i],intervals[i-1]);
            }
        }
        list.add(intervals[n-1]);
        int[][] arr = new int[list.size()][2];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = list.get(j);
        }
        return arr;
    }
}