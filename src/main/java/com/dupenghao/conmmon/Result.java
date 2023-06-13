package com.dupenghao.conmmon;

/**
 * Created by 杜鹏豪 on 2023/6/13.
 */
public class Result {

    private int code;   // 状态码
    private String msg; // 状态信息
    private Object data;    // 数据

    public Result() {
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static Result error(Object data) {
        Result result = new Result();
        result.setCode(500);
        result.setMsg("error");
        result.setData(data);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
