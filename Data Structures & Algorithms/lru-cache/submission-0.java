class LRUCache {
    private Map<Integer, Integer> cache;
    private LinkedList<Integer> order; // keeps track of usage order
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // key not found
        }
        // Move the key to the end to mark it as recently used
        order.remove((Integer) key); // remove the first occurrence
        order.addLast(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update value and move key to end
            cache.put(key, value);
            order.remove((Integer) key);
            order.addLast(key);
        } else {
            // If capacity full, remove least recently used
            if (cache.size() == capacity) {
                int oldestKey = order.removeFirst();
                cache.remove(oldestKey);
            }
            cache.put(key, value);
            order.addLast(key);
        }
    }
}