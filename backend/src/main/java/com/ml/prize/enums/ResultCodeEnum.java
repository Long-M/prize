package com.ml.prize.enums;

/**
 * @author Mr.ml
 * @date 2021/3/13
 */
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    USER_INPUT_ERROR(400, "用户名或者密码不能为空");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return message;
    }

}
