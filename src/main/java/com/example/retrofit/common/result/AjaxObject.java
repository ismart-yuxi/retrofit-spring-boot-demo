package com.example.retrofit.common.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class AjaxObject<T> implements Serializable {

    /**
	 *
	 */
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


    /**
     * @return com.wdx.bootplum.common.vo.AjaxObject
     * @Author wangwei
     * @Description //TODO 根据ajaxCodeEnum去生成返回值
     * @Date 15:37 2019-03-13
     * @Param [ajaxCodeEnum, result]
     **/
    public static <T> AjaxObject<T> basicAjax(AjaxCodeEnum ajaxCodeEnum, T result) {
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.code = ajaxCodeEnum.getCode();
        ajaxObject.msg = ajaxCodeEnum.getName();
        ajaxObject.result = result;
        return ajaxObject;
    }

    /**
     * @return com.wdx.bootplum.common.vo.AjaxObject
     * @Author wangwei
     * @Description //TODO 自定义返回值
     * @Date 15:41 2019-03-13
     * @Param [ajaxCodeEnum, result]
     **/
    public static <T> AjaxObject<T> customAjax(String code, String msg, T result) {
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.code = code;
        ajaxObject.msg = msg;
        ajaxObject.result = result;
        return ajaxObject;
    }

    /**
     * @return com.wdx.bootplum.common.vo.AjaxObject
     * @Author wangwei
     * @Description //TODO 成功
     * @Date 15:41 2019-03-13
     * @Param [ajaxCodeEnum, result]
     **/
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

    /**
     * @return com.wdx.bootplum.common.vo.AjaxObject
     * @Author wangwei
     * @Description //TODO 失败,无result
     * @Date 15:41 2019-03-13
     * @Param [ajaxCodeEnum, result]
     **/
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
