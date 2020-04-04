package com.dzzdsj.demo.codeutils.Valid;

import org.springframework.beans.BeanUtils;
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
}
