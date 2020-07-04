package com.dzzdsj.demo.codeutils.JavaSE.Lambda;

import java.util.function.*;

public class LambdaDemo {
    public static void main(String[] args) {


        //自定义函数式接口
        String s = "hello world";
        MyLambdaInterface print = (str) -> System.out.println(str);
        print.doSomething(s);

        /**预定义的函数式接口*/
        //消费掉了：一个入参，无返回值
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept(s);
        //无中生有：无入参，返回一个值
        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());
        //一因一果：一入参一返回值
        Function<String, Boolean> function = str -> str.equals("hello worl");
        System.out.println(function.apply(s));
        //参数校验:一个入参，返回boolean
        Predicate<String> predicate = str -> str.equals("hello worl");
        System.out.println(predicate.test(s));
        //一元操作:一个T型参数，通过操作返回一个T型结果
        UnaryOperator<String> unaryOperator = str -> str + str;
        System.out.println(unaryOperator.apply(s));
    }
}
