package com.dzzdsj.demo.codeutils.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class User {
    //定义新增时校验组
    public interface Add {
    }

    ;

    //定义更新时校验组
    public interface Update {
    }

    ;
    @Null(message = "新增id必须为空", groups = {Add.class})
    @NotNull(message = "id不能为空", groups = {Update.class})
    private Long id;
    private String name;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    /**另外支持自定义的验证，需要实现接口ConstraintValidator 接口initialize 方法及验证方法isValid
     * 还要使用@Constraint 注解声明用什么类来实现验证*/
}
