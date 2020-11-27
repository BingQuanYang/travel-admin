package com.smart.lct.handler;


import com.smart.commons.base.BaseException;
import com.smart.commons.result.BaseResult;
import com.smart.commons.result.ResultCodeEnum;
import com.smart.lct.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一的错误信息处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public BaseResult<Object> handler(Exception e) {
        if (e instanceof ServiceException) {
            log.error(e.getMessage());
            BaseException exception = (BaseException) e;
            return BaseResult.error();
        } else {
            return BaseResult.error(ResultCodeEnum.SYSTEM_UNKNOW_ERROR);
        }
    }
}
