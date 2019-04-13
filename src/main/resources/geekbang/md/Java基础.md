## Java基础

1. NoClassDeFoundError  
<br/>你如果编译了一个类B，在类A中调用，编译完成以后，你又删除掉B，运行A的时候那么就会出现这个错误（这就是缺少JAR包的情况），还有的情况可能是Classpath路径更改了也会造成这个问题。

2. ClassNotFoundException  
<br/>当应用程序试图使用以下方法通过字符串名加载类时，但是没有找到具有指定名称的类的定义。   
    - Class 类中的 forName 方法
    - ClassLoader 类中的 findSystemClass 方法
    - ClassLoader 类中的 loadClass 方法

3. RuntimeException  
    - IllegalArgumentException
    - IllegalMonitorStateException
    - NullPointerException
    - IndexOutOfBoundsException
    - UnsupportedOperationException
    - SecurityException
    - IllegalThreadStateException

4. Checked Exception  
    - IOException
    - InterruptedException

5. Error   
    - AssertionError
    - OutOfMemoryError
    - StackOverflowError

6. 枚举
    - final class
    - 继承java.lang.Enum，所以不能再继承别的类
    - 私有构造
    - 可以实现别的接口

7. 类加载器
    1. Bootstrap类加载器 
        - JRE/lib/rt.jar (getClassLoader()返回null)
    2. Extension类加载器 
        - JRE/lib/ext或者java.ext.dirs指向的目录
    3. Application类加载器 (getClassLoader()返回sun.misc.Launcher$AppClassLoader@18b4aac2) 
        - CLASSPATH环境变量, 由-classpath或-cp选项定义,或者是JAR中的Manifest的classpath属性定义
        
8. 反射
- Class
    - class.getDeclaredField("value"); 获取所有 field 包括private
    - class.getField("value"); 获取public field
- Field
    - field.get(Object obj)，意思是获取obj的Field的值。如果Field是static，则obj传null，如果不是，则传实例对象

9. 集合
- List
    - ArrayList
    - LinkedList
    - Collections.synchronizedList
    - Vector 所有方法加了synchronized, iterate遍历是fail-fast
    - CopyOnWriteArrayList (JUC) iterate遍历是弱一致性实现
    
- Set
    - HashSet
    - TreeSet
    - Collections.synchronizedSet
    - CopyOnWriteArraySet (JUC)
    - ConcurrentSkipListSet (JUC)
    
- Map
    - HashMap （key/value都可以为null，数组+红黑树，阈值到8）
    - TreeMap
    - Collections.synchronizedMap
    - ConcurrentHashMap (JUC) （key/value都不能为null， 数组+红黑树，阈值到8，写加锁，内存占用小，O(1)）
    - ConcurrentSkipListMap(JUC) （写不加锁，内存占用大，空间换时间,O(logn)）
    - Hashtable （key/value都不能为null, 数组+链表）
    
- Queue
    - LinkedTransferQueue (相比LinkedBlockingQueue性能更好)
    - BlockingQueue
        - LinkedBlockingQueue
        - PriorityBlockingQueue  

10. 并发
- Lock
    - CountDownLatch (countDown -1, 减到0返回，后续在进入的线程不再减，await不再阻塞)
    - Semaphore (acquire -1, 可以一直减，如果信号量是负值，则阻塞。release +1, 唤醒一个)
    - CyclicBarrier (await -1, 当减到0后，会重置为初始值，也就是如果继续减，最终不是初始值得倍数就会阻塞)

- Thread

- Future
    - cancel(true)才有实际中断的意义，cancel(false)只是修改Future标志位而已。
