package com.example.assessmentitems.result;

import com.example.assessmentitems.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;//响应码，0 代表成功; 1 代表失败
    private String message;  //响应信息 描述字符串
    private Object data; //返回的数据

    //增删改 成功响应
    public static Result success(){
        return new Result(1,"success",null);
    }
    //查询 成功响应
    public static Result success(Object data){
        return new Result(1,"success",data);
    }

    //失败响应
    public static Result error(String message){
        return new Result(0,message,null);
    }
}
