package com.cusco.wrap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果统一封装类
 *
 * @author liuyz
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(T data) {
        this(200, null, data);
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
