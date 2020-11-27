package com.smart.commons.base;

import com.smart.commons.result.ResultCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseException extends RuntimeException {
    public int code;
    public String message;

    public BaseException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getRetCode();
        this.message = resultCodeEnum.getRetMsg();
    }
}
