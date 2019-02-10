## Java面向对象设计

1. 命名规则
    - 类名
        - 名词
        - （形容词）+ 名词
        - 名词 + 名词
    - 接口/抽象类
        - 名词
        - 形容词（*able）

2. 可访问性
    - public //能修饰在最外层类上
    - (default) //能修饰在最外层类上
    - protected //不修饰在最外层类上
    - private //不能修饰在最外层类上
    
3. 内置类（相当于类的成员，所以private无效）
    1. 被编译成一个完全独立的.class文件，名称为OuterClass$InnerClass.class的形式
    2. 分类 [Demo](../../../java/com/sonic/basic/InnerClassTest.java)
        - 静态内部类
            - 被编译成一个完全独立的.class文件，名称为OuterClass$InnerClass.class的形式
            - 只可以访问外部类的静态成员和静态方法，包括了私有的静态成员和方法
            - 静态内部类可以定义静态和非静态成员
            - 访问方式
                - 外部类访问内部类 `new InnerClass();`
                - 外部类之外创建内部类 `new OuterClass.InnerClass();`
                - 内部类访问外部类的成员 `Outerclass.member`
                
        - 成员内部类
            - 它可以访问它的外部类的所有成员变量和方法，不管是静态的还是非静态的都可以
            - 成员内部类不可以定义静态属性和静态方法
            - 访问方式
                - 外部类访问内部类 `this.new InnerClass();`
                - 外部类之外创建内部类 `(new Outerclass()).new Innerclass();`
                - 内部类访问外部类的成员 `Outerclass.this.member`

    3. 使用场景
    - 临时数据存储,不希望外面可以访问 `ThreadLocal.ThreadLocalMap`
    - 特殊用途的API `Collections.UnmodifiableCollection`
    - Builder模式 `Stream.Builder`
    
4. String
    - 类定义为final，就是不希望子类可以覆盖它原有的行为。如果class上不定义final，所有的方法上就要定义final，非常麻烦。
    - String的不变性体现在`private final char value[];`
    - [String可以通过反射修改](../../../java/com/sonic/lang/StringChangeTest.java)
    
5. 具体类的命名模式
    - 前缀：`Default`,`Generic`,`Common`,`Basic`
    - 后缀：`impl`
    
6. 抽象类的命名模式
    - Abstract + 名词
    - Base + 名词
    
7. 枚举 （TimeUnit）[Demo](../../../java/com/sonic/lang/WorkDayTest.java)
    - 枚举其实就是一个final class
    - 成员为public static final
    - 继承于java.lang.Enum
    - values()方法是Java编译器做的字节码提升（生成了这个方法）
    - 默认就是private 构造器
    - 不能继承和被继承，但可以实现接口
    - 枚举打破了final类里面不能用抽象方法的规则，每个成员变量在定义时可以实现抽象方法。(`TimeUnit.excessNanos`)


    

