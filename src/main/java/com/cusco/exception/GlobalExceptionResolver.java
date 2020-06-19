/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusco.exception;

import com.cusco.wrap.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 *
 * @author Liu yizhe
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    private static final Log log = LogFactory.getLog(GlobalExceptionResolver.class);
    @Value("${spring.servlet.multipart.max-file-size:1MB}")
    private String maxFileSize = "1MB";

    @ExceptionHandler(value = CuscoException.class)
    public Object manulExceptionHandler(CuscoException ex, WebRequest request) {
        log.error(ex);
        ex.printStackTrace();
        return new ResponseEntity<Object>(new CommonResult<String>(ex.getErrorCode(), ex.getMessage()), HttpStatus.OK);
    }

    /**
     * 捕获该异常 表示超出业务逻辑范围 控制不了的情况
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception ex, WebRequest request) {
        log.error(ex);
        ex.printStackTrace();
        return new ResponseEntity<Object>(new CommonResult<String>(CuscoException.BUSINESS_ERR, "服务器内部错误"), HttpStatus.OK);
    }
    
    
    /**
     * 捕获该异常 表示上传文件超出spring定义的上传上限大小
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public Object maxUploadSizeExceededExceptionHandler(Exception ex, WebRequest request) {
        log.error(ex);
        ex.printStackTrace();
        return new ResponseEntity<Object>(new CommonResult(CuscoException.FILE_TOO_BIG, "文件不能超出" + maxFileSize), HttpStatus.OK);
    }
}
