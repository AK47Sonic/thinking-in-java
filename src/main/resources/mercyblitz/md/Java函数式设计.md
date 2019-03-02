## Java函数式设计

1. 注解
    - 形容词 + 名词 `@FunctionalInterface`

2. 函数式接口类型
    - Supplier: 只出不进，作为方法/构造函数，方法返回值
        - Spring ObjectProvider
    - Consumer：只进不出，作为方法/构造函数
    - Function：有进有出，作为方法/构造函数
    - Predicate：boolean类型判断，作为方法/构造函数
        - FileFilter
        - FilenameFilter
    - Action：没进没出
        - Runnable
        
