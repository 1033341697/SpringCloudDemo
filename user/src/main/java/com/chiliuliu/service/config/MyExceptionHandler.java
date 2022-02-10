package com.chiliuliu.service.config;

import com.baomidou.mybatisplus.extension.api.R;
import com.chiliuliu.common.exception.MyException;
import com.chiliuliu.common.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: liuyu
 * @Date: 2020/11/28 9:52
 **/
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(MyException.class)
    public R HandlerMyException(MyException e) {
        logger.info("HandlerMyException：（MyException）异常处理。");
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R HandlerMyException(MethodArgumentNotValidException e) {
        logger.info("HandlerMyException：（MethodArgumentNotValidException）异常处理。");
        BindingResult result = e.getBindingResult();
        String message = "";
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            if (errors != null && errors.size() > 0) {
                FieldError fieldError = (FieldError) errors.get(0);
                message = fieldError.getDefaultMessage();
            }
        }
        return Result.error(422L, message);
    }

    @ExceptionHandler(Exception.class)
    public R HandlerMyException(Exception e) {
        e.printStackTrace();
        logger.info("HandlerMyException：（Exception）异常处理。");
        return Result.error(500L, e.getMessage());
    }
}