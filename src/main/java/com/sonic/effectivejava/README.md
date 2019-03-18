## 原则

#### 用静态工厂方法代替构造器
- 当有很多个重载构造函数的时候，区分困难，如果使用静态方法定义，则意义明确，方便使用
- 返回类型是接口，方便扩展
- 对象复用 public static Boolean valueOf(boolean b)

#### 当遇到超过4个构造参数时，使用Builder模式
- 当构造函数参数很多时，容易赋值错误，很难被察觉，如果使用Builder模式，则意义清晰

#### 单例
- 公共静态域 public static final Elvis INSTANCE = new Elvis();
<br/>反序列化，如果要实现获得相同的单例对象，需要重写readResolve();
- 静态工厂
<br/>反序列化，如果要实现获得相同的单例对象，需要重写readResolve();
- 枚举
<br/>自带单例反序列化
    
#### 工具类要使用私有构造器
```java
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }

    // Remainder omitted
}
```

#### 优先考虑依赖注入来引用资源
<br/>把引用的资源通过构造函数传入

#### 避免创建不必要的对象
对象可以复用尽可能复用，节省空间又提升性能。

#### 消除过期对象引用
- 把对象引用设置为null
```text
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; // Eliminate obsolete reference
//        return result;
//    }
```
- 一个对象的finalize()方法只会被调用一次, System.gc();一定会调用一次finalize方法，但是未必会触发真正的GC

