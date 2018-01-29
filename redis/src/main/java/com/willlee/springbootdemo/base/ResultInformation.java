package com.willlee.springbootdemo.base;

/**
 * 错误信息的枚举类
 * 
 * @author pangweili
 *
 */
public enum ResultInformation {

    FAIL(-1, "FAIL"),

    SUCCESS(0, "SUCCESS"),

    PASSWORD_ERROR(1, "PASSWORD_ERROR"),

    ACCOUNT_EXISTS(2, "ACCOUNT_EXISTS"),

    PLATFORM_AUTHENTICATION_FAILED(3, "PLATFORM_AUTHENTICATION_FAILED"),

    PARAMETER_NULL(4, "PARAMETER_NULL"),

    PARAMETER_ERROR(5, "PARAMETER_ERROR"),

    SYSTEM_ERROR(6, "SYSTEM_ERROR"),

    SERVER_DATA_NULL(7, "SERVER_DATA_NULL"),

    SDK_AUTH_FAIL(8, "SDK AUTH FAIL"),

    CHANNEL_ERROR(9, "CHANNEL_ERROR"),

    WORD_IS_DIRTY(10, "WORD_IS_DIRTY"),

    CDKEY_ERROR(11, "CDKEY_ERROR"),

    CDKEY_USED(12, "CDKEY_USED"),

    CDKEY_EXPIRED(13, "CDKEY_EXPIRED"),

    CDKEY_TIMES_LIMIT(14, "CDKEY_TIMES_LIMIT"),

    CDKEY_FAILED(15, "CDKEY_FAILED"),

    SERVER_MAINTAIN(16, "SERVER_MAINTAIN"),

    BILLNO_CREATE_FAILED(17, "BILLNO_CREATE_FAILED"),

    BILLNO_EXIST(18, "BILLNO_EXIST"),

    PAY_ERROR(19, "PAY_ERROR"),

    SAVE_FAILED(38, "SAVE_FAILED"),

    FLAG_UNAUTHORISED(42, "FLAG_UNAUTHORISED"),

    USER_NOTEXISTS(43, "USER_NOTEXISTS"),

    FIND_REGIONS_FAIL(44, "FIND_REGIONS_FAIL"),

    TIME_OUT(45, "TIME_OUT"),

    NOTICE_PARSE_ERROR(45, "NOTICE_PARSE_ERROR")

    ;
    // 错误代码
    private Integer code;
    // 错误信息
    private String msg;

    private ResultInformation(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
