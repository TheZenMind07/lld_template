# LLD Interview Topics

## Pending Topics

| # | Topic | Status | Why it's important | Core concepts |
|---|---|---|---|---|
| 1 | Splitwise | Pending | One of the most common LLD interview questions. | OOP, SOLID, Strategy, Factory, Balance Management |
| 2 | Concurrent LRU Cache | Pending | Tests concurrency and data structures. | HashMap, Doubly Linked List, Thread Safety, Locks |
| 3 | Task Scheduler / Job Scheduler | Pending | Common backend system design problem. | Priority Queue, Worker Threads, Retry, Scheduling |
| 4 | Multi-directory File System | Pending | Excellent for object modeling. | Composite Pattern, Trees, Permissions, Recursive Operations |
| 5 | Circuit Breaker | Pending | Standard resiliency component. | State Pattern, Failure Handling, Thread Safety |
| 6 | Concurrent Logger System | Pending | Practical concurrency problem. | Producer-Consumer, Blocking Queue, Async Processing |
| 7 | Rate Limiter | Pending | Frequently asked in backend interviews. | Token Bucket, Sliding Window, Strategy Pattern, Concurrency |
| 8 | Delivery Cost Tracking System  | Pending | Progressive LLD with analytics. | Object Modeling, State Management, Time-based Analytics, Efficient Indexing |
| 9 | Expense Rule Evaluation Engine | Pending | Enterprise rule engine design. | Strategy, Composite, Rule Engine, Open/Closed Principle |


## Data Structures

 * HashMap - get set remove keySet values entries getOrDefault
 * HashSet - contains add remove size
 * ArrayList - add get remove set size
 * LinkedList - depends on which interface is implemented - pollFirst, pollLast, peekFirst, peekLast, offer, remove, size
 * TreeMap 
    ```aiignore
    firstKey() / lastKey()
    firstEntry() / lastEntry()
    floorKey(K key) - Returns the greatest key ≤ given key.
    ceilingKey(K key) - Returns the least key ≥ given key.
    higherKey(K key) - Returns the least key strictly > given key.
    lowerKey(K key) - Returns the greatest key strictly < given key.
   
    // Navigable Map variant allows you to toggle boundary inclusivity (inclusive, inclusive)
    NavigableMap<Integer, String> customSubMap = map.subMap(20, true, 40, true);
    ```
 * TreeSet
    ```aiignore
    first() / last()
    floor(K key) - Returns the greatest key ≤ given key.
    ceiling(K key) - Returns the least key ≥ given key.
    higher(K key) - Returns the least key strictly > given key.
    lower(K key) - Returns the greatest key strictly < given key.
   
    // Navigable Map variant allows you to toggle boundary inclusivity (inclusive, inclusive)
    NavigableSet<Integer> customSubMap = map.subSet(20, 40);
    ```
 * ReentractLock
   ```
   lock() - Acquires the lock. Blocks if unavailable.
   unlock() - finally 
   tryLock() - Acquires the lock only if it is free at invocation time.
   tryLock(time, unit) 
   lockInterruptibly()
     ```
   
* ReadWriteLock
    ```aiignore
    import java.util.HashMap;
    import java.util.Map;
    import java.util.concurrent.locks.ReadWriteLock;
    import java.util.concurrent.locks.ReentrantReadWriteLock;
    
    public class ThreadSafeCache {
        private final Map<String, String> map = new HashMap<>();
        private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    
        // 1. Read operation: Multiple threads can call this at the exact same time
        public String get(String key) {
            rwLock.readLock().lock();
            try {
                return map.get(key);
            } finally {
                rwLock.readLock().unlock();
            }
        }
    
        // 2. Write operation: Exclusive access. Blocks all readers and other writers
        public void put(String key, String value) {
            rwLock.writeLock().lock();
            try {
                map.put(key, value);
            } finally {
                rwLock.writeLock().unlock();
            }
        }
    }
    
    ```
* Semaphores 

    ```aiignore
    class FizzBuzzPrinter {
    private final Semaphore fizzSem = new Semaphore(0);
    private final Semaphore buzzSem = new Semaphore(0);
    private final Semaphore numberSem = new Semaphore(1); // Numbers start first

        public void printNumber(int num) {
            numberSem.acquire();
            System.out.print(num);
            fizzSem.release(); // Hand over control to Fizz
        }
    
        public void printFizz() {
            fizzSem.acquire();
            System.out.print("Fizz");
            buzzSem.release(); // Hand over control to Buzz
        }
    }
    ```
* Concurrent HashMap 

    ```
    map.putIfAbsent("A", 10);              // Inserts "A"=10 if missing; returns null
    map.replace("A", 10, 20);              // Updates "A" to 20 ONLY if currently 10; returns true
    map.replace("A", 30);                  // Forces "A" to 30 ONLY if "A" already exists; returns 20
    map.remove("A", 30);                   // Deletes "A" ONLY if currently mapped to 30; returns true
    map.computeIfAbsent("B", k -> 5);      // Computes/inserts "B"=5 if missing; returns 5
    map.computeIfPresent("B", (k, v) -> v + 2); // Updates "B" to 7 because it exists; returns 7
    map.compute("B", (k, v) -> v == null ? 1 : v + 1); // Increments if present, sets 1 if missing; returns 8
    map.merge("B", 1, Integer::sum);       // Adds 1 to "B" if present, inserts 1 if missing; returns 9
    ```
  
* CopyOnArrayList
   ```
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    list.add("Alpha");                     // Clones array, appends "Alpha", updates reference; returns true
    list.add(1, "Beta");                   // Clones array, inserts "Beta" at index 1; shifts elements
    list.addIfAbsent("Alpha");             // Clones and adds ONLY if element isn't there; returns false
    list.addAllAbsent(Arrays.asList("X")); // Bulk adds only the elements missing from the list
    list.set(0, "Omega");                  // Clones array, replaces index 0 with "Omega"; returns old value
    list.remove(0);                        // Clones array, removes index 0; returns removed element
    list.remove("Omega");                  // Clones array, removes first match of object; returns boolean

   ```
  
* ExecutorService 

  ```aiignore
    // Fixed Pool: Keeps exactly 3 threads alive. Best for predictable loads.
    ExecutorService fixedPool = Executors.newFixedThreadPool(3);
    
    // Cached Pool: Creates new threads as needed, reuses old ones. Tears down idle threads after 60s.
    ExecutorService cachedPool = Executors.newCachedThreadPool();
    
    // Single Thread Executor: Runs exactly 1 thread. Guarantees tasks execute sequentially in order.
    ExecutorService singlePool = Executors.newSingleThreadExecutor();
    
    // Scheduled Pool: Allows tasks to run periodically or after a delay.
    ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
    
    // 1. execute: Fires and forgets a Runnable task. Returns nothing.
    executor.execute(() -> System.out.println("Task running"));
    
    // 2. submit (Runnable): Submits a task. Returns a Future<?> used to check if it finished.
    Future<?> futureRunnable = executor.submit(() -> System.out.println("Done"));
    
    // 3. submit (Callable): Submits a task that returns a result. Returns a Future<T>.
    Future<Integer> futureCallable = executor.submit(() -> { return 42; });
    
    // 4. invokeAll: Executes a collection of Callables. Blocks until ALL tasks are completely done.
    List<Future<Integer>> futures = executor.invokeAll(Arrays.asList(() -> 1, () -> 2));
    
    // 5. invokeAny: Executes a collection of Callables. Blocks until ONE completes successfully, cancels others.
    Integer fastestResult = executor.invokeAny(Arrays.asList(() -> 1, () -> 2));

  ```
  
