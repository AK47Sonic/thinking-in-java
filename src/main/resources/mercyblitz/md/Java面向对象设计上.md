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
    
3. 内置类（类的成员）
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
