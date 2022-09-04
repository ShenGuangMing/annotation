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