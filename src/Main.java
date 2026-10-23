public class Main {

    public static void main(String[] args) {

        // Test 1: Basic operations
        System.out.println("Test 1:");

        LRUCache cache1 = new LRUCache(2);

        cache1.put(1, 100);
        cache1.put(2, 200);

        System.out.println(cache1.get(1)); // 100

        cache1.put(3, 300);

        System.out.println(cache1.get(2)); // -1
        System.out.println(cache1.get(3)); // 300


        // Test 2: Updating an existing key
        System.out.println("\nTest 2:");

        LRUCache cache2 = new LRUCache(2);

        cache2.put(1, 100);
        cache2.put(2, 200);

        cache2.put(1, 999);

        System.out.println(cache2.get(1)); // 999


        // Test 3: Accessing an item changes its priority
        System.out.println("\nTest 3:");

        LRUCache cache3 = new LRUCache(2);

        cache3.put(1, 100);
        cache3.put(2, 200);

        // Make key 1 recently used
        cache3.get(1);

        // This should remove key 2
        cache3.put(3, 300);

        System.out.println(cache3.get(1)); // 100
        System.out.println(cache3.get(2)); // -1
        System.out.println(cache3.get(3)); // 300


        // Test 4: Missing key
        System.out.println("\nTest 4:");

        LRUCache cache4 = new LRUCache(2);

        System.out.println(cache4.get(99)); // -1



System.out.println("\n===== EVENT SCHEDULER TESTS =====");

// Test 1: No overlap
int[][] events1 = {
    {9, 10},
    {10, 11},
    {11, 12}
};

System.out.println(
    "Can attend all: " + EventScheduler.canAttendAll(events1)
);

System.out.println(
    "Minimum rooms: " + EventScheduler.minRoomsRequired(events1)
);


// Test 2: Overlapping events
int[][] events2 = {
    {9, 11},
    {10, 12}
};

System.out.println(
    "Can attend all: " + EventScheduler.canAttendAll(events2)
);

System.out.println(
    "Minimum rooms: " + EventScheduler.minRoomsRequired(events2)
);


// Test 3: Multiple overlapping events
int[][] events3 = {
    {9, 12},
    {10, 11},
    {11, 13}
};

System.out.println(
    "Can attend all: " + EventScheduler.canAttendAll(events3)
);

System.out.println(
    "Minimum rooms: " + EventScheduler.minRoomsRequired(events3)
);

    }
}