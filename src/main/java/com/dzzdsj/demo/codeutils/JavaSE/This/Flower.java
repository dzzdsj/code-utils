package com.dzzdsj.demo.codeutils.JavaSE.This;//: initialization/Flower.java
// Calling constructors with "this"


/**
 * 使用this调用构造函数和区分成员变量与局部变量
 */
public class Flower {
  int petalCount = 0;
  String s = "initial value";
  Flower(int petals) {
    petalCount = petals;
    System.out.println("Constructor w/ int arg only, petalCount= "
      + petalCount);
  }
  Flower(String ss) {
//    print("Constructor w/ String arg only, s = " + ss);
    s = ss;
  }
  Flower(String s, int petals) {
    /**使用this调用构造函数，必须在构造器最开始的位置，且只能使用1次*/
    this(petals);
//!    this(s); // Can't call two!
    this.s = s; // Another use of "this"
//    print("String & int args");
  }
  Flower() {
    this("hi", 47);
//    print("default constructor (no args)");
  }
  void printPetalCount() {
//! this(11); // Not inside non-constructor!
//    print("petalCount = " + petalCount + " s = "+ s);
  }
  public static void main(String[] args) {
    Flower x = new Flower();
    x.printPetalCount();
  }
} /* Output:
Constructor w/ int arg only, petalCount= 47
String & int args
default constructor (no args)
petalCount = 47 s = hi
*///:~
