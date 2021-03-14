package com.ml.prize.vo;

import com.ml.prize.enums.ResultCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Mr.ml
 * @date 2021/3/13
 */
@Data
@NoArgsConstructor
public class ResultVO implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    public void setResultCode(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCode(ResultCodeEnum.SUCCESS);
        return resultVO;
    }

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCode(ResultCodeEnum.SUCCESS);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(ResultCodeEnum resultCodeEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCode(resultCodeEnum);
        return resultVO;
    }

    public static ResultVO error(ResultCodeEnum resultCodeEnum, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCode(resultCodeEnum);
        resultVO.setData(data);
        return resultVO;
    }

}
