package com.myblog.controller;


import com.myblog.common.lang.Result;
import com.myblog.entity.User;
import com.myblog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-09-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Object index(){
        return userService.getById(1l);
    }

    @PostMapping("/save")
    public Object save(@Validated @RequestBody User user){
        userService.save(user);
        return Result.success(user);
    }

}
