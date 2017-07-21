package com.example.administrator.baselib.retrofit;

/**
 * Created by Administrator on 2016/12/15.
 */

public class Response {
    public int code;

    public String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
