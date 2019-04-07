## Java高并发

#### 并行和并发
- 并行是多核的概念
- 并发是单核时间片轮询的概念

#### Java Thread
- 基于OS线程实现，数量映射为1:1

#### 同步
- 任务发起方和执行方在同一线程中完成

#### 异步
- 任务发起方和执行方在不同线程中完成

#### 阻塞
- 阻塞调用是指调用结果返回之前，当前线程会被挂起

#### 非阻塞
- 在不能立刻得到结果之前，该函数不会阻塞当前线程，而会立刻返回

#### 协程
微线程，上下文切换代价小，本质还是单线程(Kotlin)

#### Thread
- 调用Thread构造函数后，OS线程也同步创建，只是没有启动。证据是看是否有调用native方法
- blocked状态
    - IO（文件系统）
    - 独占锁
    
#### jps

#### jstack

#### stop/resume/suspend
- Stop 释放锁，会造成数据不一致问题
- suspend 不释放锁，会造成永久阻塞问题

#### interrupt
- 要写在start之后，之前是没有效果的

#### wait/notify
- 首先要获取监视器锁
- 其次wait/notify的调用者一定要是监视器对象

#### 死锁/活锁/饥饿

#### 脏读/不可重复读/幻读
- 脏读（读取未提交数据）
- 不可重复读（前后多次读取，数据内容不一致）不可重复读是读取了其他事务更改的数据，针对update操作
- 幻读（前后多次读取，数据总量不一致）幻读是读取了其他事务新增的数据，针对insert操作

#### 内存屏障 Memory barrier
- 内存可见性

#### 锁
- ReentrantLock 相当于Synchronized
- ReentrantReadWriteLock 读锁（共享锁）/写锁（独占锁）
- StampedLock 乐观锁，有版本概念

#### yield
- 释放CPU，不释放锁

#### Sequential lock 
- StampedLock (学习下如何使用)

#### 问题
- ReadWriteLock
- StampedLock
- newCachedThreadPool