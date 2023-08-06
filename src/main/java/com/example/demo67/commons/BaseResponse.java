package com.example.demo67.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/5 18:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse <T> {
    private int code;

    private String message;

    private T data;

    public static <T> BaseResponse success(int code, String message, T data){
        BaseResponse<T> response = new BaseResponse<>();
        response.code = code;
        response.message = message;
        response.data = data;
        return response;
    }
}
