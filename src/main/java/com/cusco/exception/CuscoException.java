/*
 * CuscoException.java
 * 
 * Copyright(c) 2018-2020 by MY New Tech
 * All Rights Reserved
 * 
 * Created at 2020-01-12 09:28:04
 */
package com.cusco.exception;

/**
 * 自定义异常
 *
 * @author Administrator
 */
public class CuscoException extends Exception {

    /**
     * 200 接口请求成功状态码
     */
    public static final int SUCCESS_CODE = 200;
    /**
     * 200 接口请求成功描述语
     */
    public static final String SUCCESS_MSG = "成功";

    // 100xxx 登录，权限相关
    /**
     * 100001 登陆token失效或未登录
     */
    public static final int TOKEN_ERR = 100001;

    /**
     * 没有权限 需要绑定小程序
     */
    public static final int UNAUTHORIZED = 100010;

    // 101xxx 文件相关
    /**
     * 上传文件过大(超出spring设置的上传文件上限)
     */
    public static final int FILE_TOO_BIG = 101010;
    /**
     * 文件未找到
     */
    public static final int FILE_NOT_FOUND = 101020;
    /**
     * 文件读写错误
     */
    public static final int FILE_RW_ERR = 101030;
    /**
     * 缩略图读写失败
     */
    public static final int THUMB_RW_ERR = 101031;

    // 102xxx 数据库相关
    /**
     * 数据库存储异常
     */
    public static final int DB_ERR = 102010;

    // 103xxx 业务相关
    /**
     * 请求参数错误
     */
    public static final int REQUEST_PARAM_ERR = 103010;

    public static final String REQUEST_PARAM_ERR_MSG = "请求参数错误";
    /**
     * 解析数据错误
     */
    public static final int ANALYSIS_ERR = 103020;
    /**
     * 业务异常（影响业务逻辑流程的问题或不符合业务逻辑）
     */
    public static final int BUSINESS_ERR = 103030;

    // 103040~  业务相关异常
    // 104xxx wechat service 异常
    /**
     * 调用 微信 api 失败
     */
    public static final int GET_WEIXIN_API_ERR = 104000;
    /**
     * 获取微信 ACCESS_TOKEN 失败
     */
    public static final int GET_WEIXIN_ACCESS_TOKEN_ERR = 104001;
    /**
     * 获取微信信息失败
     */
    public static final int GET_WEIXIN_INFO_ERR = 104002;
    /**
     * 错误代码
     */
    private int errorCode;

    public CuscoException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public CuscoException(int errorCode, String msg, Throwable th) {
        super(msg, th);
        th.printStackTrace();
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
