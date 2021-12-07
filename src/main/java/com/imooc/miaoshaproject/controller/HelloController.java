package com.imooc.miaoshaproject.controller;

import com.imooc.miaoshaproject.dao.UserDOMapper;
import com.imooc.miaoshaproject.dataobject.UserDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if (userDO == null) {

            return "用户对象不存在";
        }else {
            return userDO.getName();
        }
    }
}
