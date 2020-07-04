package com.dzzdsj.demo.codeutils.JavaSE.JVM;//: initialization/TerminationCondition.java
// Using finalize() to detect an object that
// hasn't been properly cleaned up.

/**
 * 演示了finalize方法的一种用途。排错。一般我们不使用它
 */
class Book {
  boolean checkedOut = false;
  Book(boolean checkOut) {
    checkedOut = checkOut;
  }
  void checkIn() {
    checkedOut = false;
  }

  /**
   * gc之前会被调用。这个代码演示本来在gc之前所有的book都要被checkIn，但
   * main函数里有个book的状态为true，它本来在gc之前需要被置为false（即checkIn）,
   * 但是被遗忘了。由于我们写了finalize方法，所有状态被打印了出来，我们得以发现了这个问题
   */

protected void finalize() {
    if(checkedOut)
      System.out.println("Error: checked out");
    // Normally, you'll also do this:
    // super.finalize(); // Call the base-class version
  }
}

public class TerminationCondition {
  public static void main(String[] args) {
    Book novel = new Book(true);
    // Proper cleanup:
    novel.checkIn();
    // Drop the reference, forget to clean up:
    new Book(true);
    // Force garbage collection & finalization:
    System.gc();
  }
} /* Output:
Error: checked out
*///:~
