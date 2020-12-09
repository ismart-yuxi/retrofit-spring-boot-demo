package com.example.retrofit.common.result;

public enum AjaxCodeEnum {
    /**
     * 失败
     **/
    FAIL("500","失败"),
    /**
     * 成功
     **/
    OK("200","成功");

    private final String code;
    private final String name;

    AjaxCodeEnum(final String code, final String name) {
        this.code = code;
        this.name = name;
    }
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
