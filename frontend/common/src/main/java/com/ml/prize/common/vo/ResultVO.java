package com.ml.prize.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Mr.ml
 * @date 2021/3/16
 */
@ApiModel("响应报文")
public class ResultVO {

    @ApiModelProperty(value = "状态码（-1=异常，0=业务不成功，1=业务成功）", required = true)
    private int code;
    @ApiModelProperty(value = "信息", required = true)
    private String message;
    @ApiModelProperty(value = "数据")
    private Object data;
    @ApiModelProperty(value = "服务器时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date now = new Date();

    public ResultVO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

}
