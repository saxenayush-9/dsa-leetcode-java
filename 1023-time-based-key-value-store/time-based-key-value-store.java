class TimeMap {
    HashMap<String, List<Integer>> hmap;
    HashMap<Integer,String> valuesMap;
    public TimeMap() {
        hmap = new HashMap<>();
        valuesMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hmap.containsKey(key)){
            hmap.get(key).add(timestamp);
        }
        else{
            List<Integer> li = new ArrayList<>();
            li.add(timestamp);
            hmap.put(key, li);
        }
        valuesMap.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!hmap.containsKey(key))return "";
        List<Integer> li = hmap.get(key);
        int nearestTimeStamp = -1;
        int low = 0,high=li.size()-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(li.get(mid)<timestamp){
                nearestTimeStamp = li.get(mid);
                low=mid+1;
            }
            else if(li.get(mid)>timestamp){
                high = mid-1;
            }
            else{
                nearestTimeStamp = li.get(mid);
                break;
            }
        }
        return valuesMap.get(nearestTimeStamp)==null? "" :  valuesMap.get(nearestTimeStamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */