/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusco.handler;

import com.cusco.exception.CuscoException;
import com.cusco.wrap.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对接口返回结果进行封装
 *
 * @author lp 
 */
@ControllerAdvice(basePackages = {"com.cusco.controller"})
public class ApiResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter mp, Class<? extends HttpMessageConverter<?>> type) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter mp, MediaType mt, Class<? extends HttpMessageConverter<?>> type, ServerHttpRequest shr, ServerHttpResponse shr1) {
        if (object == null) {
            CommonResult result = new CommonResult();
            result.setCode(CuscoException.SUCCESS_CODE);
            result.setMessage(CuscoException.SUCCESS_MSG);
            return result;
        } else {
            if (mt.equals(MediaType.APPLICATION_JSON)) {
                CommonResult result = new CommonResult();
                result.setCode(CuscoException.SUCCESS_CODE);
                result.setMessage(CuscoException.SUCCESS_MSG);
                result.setData(object);
                return result;
            } else {
                return object;
            }
        }
    }

}
