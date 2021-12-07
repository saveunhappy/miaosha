package com.imooc.miaoshaproject.controller;

import com.imooc.miaoshaproject.controller.viewobject.UserVO;
import com.imooc.miaoshaproject.response.CommonReturnType;
import com.imooc.miaoshaproject.service.UserService;
import com.imooc.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/get")
    public CommonReturnType getUser(@RequestParam("id")Integer id){
        UserModel userModel = userService.getUserById(id);
        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }
    private UserVO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
