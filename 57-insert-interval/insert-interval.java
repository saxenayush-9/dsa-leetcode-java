class Solution {
    public boolean overlap(int[] interval1 , int[] interval2){
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];
        if(s2>e1 || e2<s1)return false;
        return true;
    }
    public int[] merge(int[] interval1, int[] interval2){
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];
        return new int[]{Math.min(s1,s2),Math.max(e1,e2)};
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> li = new ArrayList<>();
        int i=0;
        while(i<n && intervals[i][1]<newInterval[0]){
            li.add(intervals[i]);
            i++;
        }
        while(i<n && overlap(intervals[i],newInterval)){
            newInterval=merge(intervals[i],newInterval);
            i++;
        }
        li.add(newInterval);
        while(i<n){
            li.add(intervals[i]);
            i++;
        }
        int[][] res = new int[li.size()][2];
        for(int j=0;j<res.length;j++){
            res[j][0]=li.get(j)[0];
            res[j][1]=li.get(j)[1];
        }
        return res;
    }
}