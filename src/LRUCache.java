import java.util.HashMap;

class Node {
    int key;
    int value;

    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private final int capacity;
    private final HashMap<Integer, Node> cache;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (cache.containsKey(key)) {
            Node node = cache.get(key);

            node.value = value;

            remove(node);
            insertAtFront(node);

            return;
        }

        // New key
        Node newNode = new Node(key, value);

        cache.put(key, newNode);
        insertAtFront(newNode);

        // Capacity exceeded
        if (cache.size() > capacity) {
            Node lruNode = tail.prev;

            remove(lruNode);
            cache.remove(lruNode.key);
        }
    }
}