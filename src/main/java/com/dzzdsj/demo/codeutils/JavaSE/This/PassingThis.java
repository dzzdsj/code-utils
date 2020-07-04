package com.dzzdsj.demo.codeutils.JavaSE.This;//: initialization/PassingThis.java
/**
 * 方法的调用者和入参正好是同一个对象时，使用this进行传递
 */
class Person {
  public void eat(Apple apple) {
    Apple peeled = apple.getPeeled();
    System.out.println("Yummy");
  }
}

/**
 * 剥皮
 */
class Peeler {
  static Apple peel(Apple apple) {
    // ... remove peel
    return apple; // Peeled
  }
}

/**
 * 方法的调用者和入参正好是同一个对象.
 */
class Apple {
  Apple getPeeled() { return Peeler.peel(this); }
}

public class PassingThis {
  public static void main(String[] args) {
    new Person().eat(new Apple());
  }
} /* Output:
Yummy
*///:~
