package com.smart.lct.exception;

import com.smart.commons.base.BaseException;
import com.smart.commons.result.ResultCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceException extends BaseException {

    public ServiceException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum);
    }
}
