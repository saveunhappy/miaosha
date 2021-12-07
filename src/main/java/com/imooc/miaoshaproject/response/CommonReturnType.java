package com.imooc.miaoshaproject.response;

public class CommonReturnType {
    private String status;
    private Object data;

    public String getStatus() {
        return status;
    }
    //定义一个通用的创建方法
    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type  = new CommonReturnType();
        type.setData(result);
        type.setStatus(status);
        return type;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
