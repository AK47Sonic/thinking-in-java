## Java基础

1. NoClassDeFoundError  
你如果编译了一个类B，在类A中调用，编译完成以后，你又删除掉B，运行A的时候那么就会出现这个错误（这就是缺少JAR包的情况），还有的情况可能是Classpath路径更改了也会造成这个问题。

2. ClassNotFoundException  
当应用程序试图使用以下方法通过字符串名加载类时，但是没有找到具有指定名称的类的定义。
- Class 类中的 forName 方法
- ClassLoader 类中的 findSystemClass 方法
- ClassLoader 类中的 loadClass 方法

3. RuntimeException
- IllegalArgumentException
- IllegalMonitorStateException
- NullPointerException
- IndexOutOfBoundsException

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


