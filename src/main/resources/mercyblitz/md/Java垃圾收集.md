## Java 垃圾收集

1. 串行垃圾收集器、并行垃圾收集器、G1、CMS (old区) 选择
    - 串行垃圾收集器：单核，内存小，不在意停顿时间
    - 并行垃圾收集器：高吞吐，停顿可容忍
    - CMS： 低吞吐，低延迟，响应快，无压缩，在意停顿
    - G1：低吞吐，低延迟，响应快，压缩，在意停顿，推荐16G内存以上使用，按Region回收，会有空间浪费

2. 垃圾收集参数集合
    - -XX:+PrintFlagsFinal
    
3. 搭配  
    New         Old  
    SerialGC    SerialGC  
    ParallelGC  SerialGC  
    ParallelGC  ParallelNew  
    ParallelGC  CMS  
    G1          G1  
    
4. Reference
    - SoftReference
    - WeakReference
    - FinalReference java内部使用，构造函数为私有，不能调用
    - PhantomReference
    
5. Reference Queue 保留即将消亡的对象
    