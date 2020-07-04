package com.dzzdsj.demo.codeutils.JavaSE.OOP;//: initialization/OrderOfInitialization.java
// Demonstrates initialization order.


// When the constructor is called to create a
// Window object, you'll see a message:
class Window {
  Window(int marker) {
    System.out.println("Window(" + marker + ")"); }
}
//这里w3被初始化了两次，一次是成员变量，在构造函数之前，之后是构造函数时，第一次的值被丢弃
class House {
  /**成员变量最先被初始化*/
  Window w1 = new Window(1); // Before constructor
  /**成员变量初始化后初始化构造函数*/
  House() {
    // Show that we're in the constructor:
    System.out.println("House()");
    w3 = new Window(33); // Reinitialize w3
  }
  /**成员变量最先被初始化*/
  Window w2 = new Window(2); // After constructor

  void f() { System.out.println("f()"); }

  /**成员变量最先被初始化*/
  Window w3 = new Window(3); // At end
}

/**
 * 演示初始化顺序： 成员变量-》构造函数
 */
public class OrderOfInitialization {
  public static void main(String[] args) {
    House h = new House();
    h.f(); // Shows that construction is done
  }
} /* Output:
Window(1)
Window(2)
Window(3)
House()
Window(33)
f()
*///:~
