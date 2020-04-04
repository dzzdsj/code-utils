package com.dzzdsj.demo.codeutils.Valid;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "id不能为空")
    private Long id;
    private String name;
    private String address;
}
