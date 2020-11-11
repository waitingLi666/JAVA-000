###1.思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？  
*完整代码查看：*  
- 方法一：
```

```


###2.把多线程和并发相关知识带你梳理一遍，画一个脑图  
锁机制类Locks : Lock, Condition, ReadWriteLock
原子操作类Atomic : AtomicInteger
线程池相关类Executer : Future, Callable, Executor
信号量三组工具类Tools : CountDownLatch, CyclicBarrier, Semaphore
并发集合类Collections : CopyOnWriteArrayList, ConcurrentMap

1）锁：
Lock----void lock();void lockInterruptibly() throws InterruptedException;boolean tryLock();boolean tryLock(long time, TimeUnit unit) throws InterruptedException;void unlock();Condition newCondition();

Condition----void awaitUninterruptibly();long awaitNanos(long nanosTimeout) throws InterruptedException;boolean await(long time, TimeUnit unit) throws InterruptedException;boolean awaitUntil(Date deadline) throws InterruptedException;void signal();void signalAll();

ReadWriteLock----Lock readLock();Lock writeLock();

最佳实践
1. 永远只在更新对象的成员变量时加锁
2. 永远只在访问可变的成员变量时加锁
3. 永远不在调用其他对象的方法时加锁

2）原子类：
atomic
底层实现原理
volatile修饰value+CAS

3）工具类：
Semaphore
CountDownLatch----CountDownLatch(int count);void await() throws InterruptedException;boolean await(long timeout, TimeUnit unit) throws InterruptedException;void countDown();long getCount()
CyclicBarrier----CyclicBarrier(int parties, Runnable barrierAction);CyclicBarrier(int parties);int await() throws InterruptedException, BrokenBarrierException;int await(long timeout, TimeUnit unit)throws InterruptedException,BrokenBarrierException,TimeoutException;void reset()

4)线程
启动方式：Thread和Runnable
状态：初始化NEW,运行RUNNABLE，运行中(RUNNING),就绪(READY),等待(WAITING),超时等待(TIMED_WAITING)，阻塞(BLOCKED)，终止(TERMINATED)
状态改变操作：Thread.sleep(long millis)，Thread.yield(),t,join/t.join(long millis),obj.wait(),obj.notify()
性质：原子性，可见性，有序性
synchronized
volatile
final

线程池：
 Excutor: 执行者– 顶层接口
ExcutorService: 接口API
ThreadFactory: 线程工厂
Excutors: 工具类

参数
拒绝策略
1. ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException
异常。
2. ThreadPoolExecutor.DiscardPolicy：丢弃任务，但是不抛出异常。
3. ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新提
交被拒绝的任务
4. ThreadPoolExecutor.CallerRunsPolicy：由调用线程（提交任务的线程）处理该任
务

创建线程池方法：
1. newSingleThreadExecutor
创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任
务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务
的执行顺序按照任务的提交顺序执行。
2.newFixedThreadPool
创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线
程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充
一个新线程。
3. newCachedThreadPool
创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添
加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者
说JVM）能够创建的最大线程大小。
4.newScheduledThreadPool
创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。

相关接口、类
Callable,
Future
