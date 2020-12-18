package com.example.retrofit.common.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class AjaxObject<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private String code;
    /**
     * 消息内容
     */
    private String msg;

    /**
     * 请求返回的数据
     */
    private T result;

    public static <T> AjaxObject<T> basicAjax(AjaxCodeEnum ajaxCodeEnum, T result) {
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.code = ajaxCodeEnum.getCode();
        ajaxObject.msg = ajaxCodeEnum.getName();
        ajaxObject.result = result;
        return ajaxObject;
    }

    public static <T> AjaxObject<T> customAjax(String code, String msg, T result) {
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.code = code;
        ajaxObject.msg = msg;
        ajaxObject.result = result;
        return ajaxObject;
    }

    public static <T> AjaxObject<T> customOk(String msg, T result) {
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.code = AjaxCodeEnum.OK.getCode();
        ajaxObject.msg = msg;
        ajaxObject.result = result;
        if (result == null) {
            ajaxObject.result = "";
        }
        return ajaxObject;
    }

    public static <T> AjaxObject<T> customFail(String msg, T result) {
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.code = AjaxCodeEnum.FAIL.getCode();
        ajaxObject.msg = msg;
        ajaxObject.result = result;
        if (result == null) {
            ajaxObject.result = "";
        }
        return ajaxObject;
    }

}
