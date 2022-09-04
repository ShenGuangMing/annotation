# 1.什么是注解
## 1.1Annotation是JDK5.0开始引入的新技术
## 1.2Annotation的作用
- 不是程序本身，但可以程序做出解释。(**这一点**和注释(comment)没什么区别)
- 可以被其他程序(比如:编辑器，反射)读取
## 1.3Annotation的格式
- 注解是以"@注解名“在代码中存在的，还可以添加一些数值，例如@Value(value="test")
## 1.4Annotation在那些地方使用
- package
- class
- method
- field
# 2.元注解
## 2.1什么是元注解
> 元注解的作用就是负责注解其他注解,Java定义了4个标准的meta
-annotation类型,他们被用来
提供对其他annotation类型作说明．
## 2.2有哪些元注解
- @Target
> 用于描述注解的使用范围(ElementType 枚举类型)
> - TYPE
> - METHOD
> - PARAMETER
> - CONSTRUCTOR
> - LOCAL_VARIABLE
> - ANNOTATION_TYPE
> - PACKAGE...
- @Retention
> 表示要在什么级别保留该注释信息，用于描述注解的生命周期(Retention 枚举类型)
> - SOURCE 源码级别
> - CLASS 字节码文件级别
> - RUNTIME 运行级别
- @Document
> 说明注解被包含在javadoc中
- @Inherited
> 说明子类可以继承父类中的该注解

# 3.演示
## 3.1
```java

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestAnnotation1 {
    //不给参数就会报错
    @MyAnnotation0(name = "sgm")
    public void test0() {

    }
}
//作用于方法和构造器上
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
//运行时有效
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation0 {
    /*
    1.注解的参数的构成: 参数类型  参数名 ()
    2.注解的参数名不是value，且没事设置默认值的情况下，在使用注解的时候就必须要给该参数赋值(除了设有默认值)
    3.
     */
    String name();
}
```
## 3.2
```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestAnnotation1 {
    @MyAnnotation0(
            name = "sgm", // name不给参数就会报错
            //id 有默认参数，不给参数不会报错
            age = 5 //age 有默认参数，可以自定义参数
    )
    public void test0() {

    }
}
//作用于方法和构造器上
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
//运行时有效
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation0 {
    /*
    1.注解的参数的构成: 参数类型  参数名 ()
    2.注解的参数名不是value，且没事设置默认值的情况下，在使用注解的时候就必须要给该参数赋值(除了设有默认值)
     */
    String name();
    int id() default -1;
    int age() default 18;
}
```
