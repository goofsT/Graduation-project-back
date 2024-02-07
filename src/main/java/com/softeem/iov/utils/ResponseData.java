package com.softeem.iov.utils;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ResponseData<T> {
    private int code;
    private String message;
    private T data;
    //构造方法
    public ResponseData(int code,String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }
    //成功
    public static <T> ResponseData<T> success(T data){
        return new ResponseData<T>(200,"成功",data);
    }
    //失败
    public static <T> ResponseData<T> error(int code,String message){
        return new ResponseData<T>(code,message,null);
    }
    //服务器错误
    public static <T> ResponseData<T> serverError(){
        return new ResponseData<T>(500,"服务器错误",null);
    }
}
