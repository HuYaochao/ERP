package com.codingfuture.erp.util;

import com.codingfuture.erp.constant.ResultConstant;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
    private String redirectUrl;
    private Object rows;

    private Result() {}

    public static <T> Result<T> ok(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.OK_CODE);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> ok() {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.OK_CODE);
        result.setMsg(ResultConstant.OK_MSG);
        return result;
    }

    public static <T> Result<T> err() {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.ERR_CODE);
        result.setMsg(ResultConstant.ERR_MSG);
        return result;
    }

    public static <T> Result<T> err(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.ERR_CODE);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.OK_CODE);
        result.setMsg(ResultConstant.OK_MSG);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> err(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.ERR_CODE);
        result.setMsg(ResultConstant.ERR_MSG);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> ok(String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.OK_CODE);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> err(String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.ERR_CODE);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public Result redirect(String url) {
        this.redirectUrl = url;
        return this;
    }

    public Result<T> rows(Object rows) {
        this.rows = rows;
        return this;
    }

    public Result<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> code(Integer code) {
        this.code = code;
        return this;
    }
}

