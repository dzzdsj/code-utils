package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.CompositePattern;

import java.util.ArrayList;
import java.util.List;

//步骤 1
//创建 Employee 类，该类带有 Employee 对象的列表。
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;//下级; 部属   相似的对象放到list里

    //构造函数
    public Employee(String name, String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String toString() {
        return ("Employee :[ Name : " + name
                + ", dept : " + dept + ", salary :"
                + salary + " ]");
    }
}
