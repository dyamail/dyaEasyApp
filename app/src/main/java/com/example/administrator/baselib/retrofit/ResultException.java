package com.example.administrator.baselib.retrofit;

/**
 * Created by Administrator on 2016/12/15.
 */

public class ResultException extends RuntimeException{
    private int errCode;
    private String msg;

    public ResultException(int errCode,String msg){
        super();
        this.errCode = errCode;
        this.msg = msg;
    }


    public int getErrCode() {
        return errCode;
    }

    public String getMsg(){
        return msg;
    }
}
