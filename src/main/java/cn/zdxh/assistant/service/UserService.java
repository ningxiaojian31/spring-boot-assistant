package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.User;

public interface UserService {
    //注册用户,返回对象
    public User registerUser(User user);
    //登录用户,返回对象
    public User loginUser(User user);
    //更新用户头像
    public void changePic(String uploadPath,Integer uid);
}
