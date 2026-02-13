class DetectSquares {
    List<int[]> points;
    HashMap<String,Integer> frequency;

    public DetectSquares() {
        points = new ArrayList<>();
        frequency = new HashMap<>();
    }
    
    public void add(int[] point) {
        String newPoint = point[0]+","+point[1];
        points.add(point);
        if(frequency.containsKey(newPoint)){
            frequency.put(newPoint,frequency.get(newPoint)+1);
        }
        else{
            frequency.put(newPoint,1);
        }
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int totalNumberOfWays=0;
        for(int[] pnt : points){
            int px = pnt[0];
            int py = pnt[1];
            if(Math.abs(x-px)!=Math.abs(y-py) || px==x || py==y){
                continue;
            }
            String topLeft = px+","+y;
            String bottomRight = x+","+py;
            if(frequency.containsKey(topLeft) && frequency.containsKey(bottomRight)){
                totalNumberOfWays+=frequency.get(topLeft)*frequency.get(bottomRight);
            }
        }
        return totalNumberOfWays;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */