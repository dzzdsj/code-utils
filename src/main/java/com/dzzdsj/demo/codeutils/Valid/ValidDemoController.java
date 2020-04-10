package com.dzzdsj.demo.codeutils.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class ValidDemoController {
    @GetMapping("/testValid")
    public User testValid(@Valid @RequestBody User user){
        User u = new User();
        BeanUtils.copyProperties(user,u);
        return u;
    }
    /**使用用户组groups区分分别验证*/
    @GetMapping("/addUser")
    public User addUser(@Validated({User.Add.class}) @RequestBody User user){
        User u = user;
        return u;
    }
    @GetMapping("/updateUser")
    public User updateUser(@Validated({User.Update.class}) @RequestBody User user){
        System.out.println("input: "+user.getTime());
        User u = user;
        System.out.println("output: "+u.getTime());
        return u;
    }
}
