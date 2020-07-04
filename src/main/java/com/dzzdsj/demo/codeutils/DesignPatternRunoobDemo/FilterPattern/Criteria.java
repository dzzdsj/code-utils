package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.FilterPattern;

import java.util.List;

//步骤 2
//为标准（Criteria）创建一个接口。
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
