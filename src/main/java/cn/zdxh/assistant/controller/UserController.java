package cn.zdxh.assistant.controller;

import cn.zdxh.assistant.entity.User;
import cn.zdxh.assistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //用户注册
    @ResponseBody
    @RequestMapping(value = "/user/reg",method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    //用户登录
    @ResponseBody
    @RequestMapping(value = "/user/log",method = RequestMethod.POST)
    public User loginUser(@RequestBody User user){
        return userService.loginUser(user);
    }
    //更新头像
    @ResponseBody
    @RequestMapping(value = "/user/change",method = RequestMethod.POST)
    public void changeUserPic(@RequestBody User user){
        userService.changePic(user.getUserImage(),user.getId());
    }
}
