package com.john.name.advice;

import com.google.common.base.Joiner;
import com.john.name.vo.RespData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiangliang
 * @date 2022/8/12 3:17 PM
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.john.name.controller"})
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespData methodArgumentNotValidExceptionHandle(MethodArgumentNotValidException exception) {
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        String errorMsg = Joiner.on(",").join(allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()));
        return RespData.error(500, errorMsg);
    }
}
