class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> list = new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            if(!doesOverlap(intervals[i],intervals[i-1])){
                list.add(intervals[i-1]);
            }
            else{
                intervals[i]=merge(intervals[i-1],intervals[i]);
            }
        }

        list.add(intervals[intervals.length-1]);

        int[][] arr = new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }

        return arr;
        
    }

    public int[] merge(int[] interval1, int[] interval2){
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];

        return new int[]{Math.min(s1,s2),Math.max(e1,e2)};
    }

    public boolean doesOverlap(int[] interval1, int[] interval2){
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];

        if(e1<s2 || e2<s1)return false;
        return true;
    }
}