class TimeMap {

    class Pair {
        String value;
        int timestamp;
    }

    HashMap<String, ArrayList<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<String, ArrayList<Pair>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair>());
        }

        ArrayList<Pair> arr = map.get(key);
        Pair pair = new Pair();
        pair.timestamp = timestamp;
        pair.value = value;
        arr.add(pair);
    }
    
   public String get(String key, int timestamp) {
    if (!map.containsKey(key)) return "";

    ArrayList<Pair> pairs = map.get(key);
    int left = 0, right = pairs.size() - 1;
    String res = "";

    while (left <= right) {
        int mid = left + (right - left) / 2;
        Pair pair = pairs.get(mid);

        if (pair.timestamp <= timestamp) {
            res = pair.value;   // store candidate
            left = mid + 1;     // try to find a better (later) one
        } else {
            right = mid - 1;
        }
    }

    return res;
}
}
