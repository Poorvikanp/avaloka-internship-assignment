# Avaloka Assignment

Java implementation of the **LRU Cache** and **Event Scheduler** problems for the Avaloka internship assignment.

## 📁 Project Structure

```text
avaloka-internship-assignment/
│
├── src/
│   ├── LRUCache.java
│   ├── EventScheduler.java
│   └── Main.java
│
└── README.md
```

## 🧩 Problem 1 — LRU Cache

### Approach

The LRU Cache is implemented using:

- **HashMap** for O(1) average-time lookup of cache entries.
- **Doubly Linked List** to maintain the order of recently used entries.

The most recently used item is kept near the head, while the least recently used item is kept near the tail.

When an item is accessed or updated, it is moved to the front. When the cache exceeds its capacity, the least recently used item is removed.

### Complexity

| Operation | Time | Space |
|---|---|---|
| `get()` | O(1) average | O(capacity) |
| `put()` | O(1) average | O(capacity) |

---

## 📅 Problem 2 — Event Scheduler

The scheduler provides two operations:

### `canAttendAll()`

Events are sorted by their start time. Consecutive events are then checked for overlap.

If:

```text
previousEnd > currentStart
```

the events overlap.

If:

```text
previousEnd == currentStart
```

the events are considered non-overlapping.

### `minRoomsRequired()`

Events are sorted by start time and a Java `PriorityQueue` is used as a min-heap containing the current meeting end times.

The earliest ending meeting is checked for every new event. If its end time is less than or equal to the current start time, its room can be reused. Otherwise, another room is required.

### Complexity

| Function | Time | Space |
|---|---|---|
| `canAttendAll()` | O(n log n) | O(n) |
| `minRoomsRequired()` | O(n log n) | O(n) |

---

## 🧪 Testing

The implementation was tested with:

### LRU Cache

- Basic insertion and retrieval
- Updating an existing key
- LRU eviction
- Accessing an item and changing its priority
- Missing key lookup

### Event Scheduler

- Non-overlapping events
- Adjacent events
- Overlapping events
- Multiple overlapping events
- Minimum room calculation

## ▶️ How to Run

Make sure Java is installed.

Compile:

```bash
javac src/*.java
```

Run:

```bash
java -cp src Main
```

### Windows PowerShell

```powershell
javac src\*.java
java -cp src Main
```

## 🔍 Key Design Decisions

### HashMap + Doubly Linked List

The HashMap provides fast lookup, while the Doubly Linked List maintains LRU ordering. Using both structures allows `get()` and `put()` to operate in O(1) average time.

### PriorityQueue for Room Allocation

A min-heap keeps track of the earliest room availability, allowing rooms to be reused efficiently.

## 🔮 Future Improvements

The Event Scheduler can be extended to assign specific room names such as:

```text
Room A
Room B
Room C
```

by storing both the room identifier and its next available time in the PriorityQueue.

The LRU Cache can also be made thread-safe by synchronizing cache operations or using `ReentrantLock`.

