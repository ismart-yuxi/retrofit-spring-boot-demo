package com.example.retrofit.openservice.domain.requestEntity;

import lombok.Data;

/**
 * @author wangyuxi
 */
@Data
public class LifeRepoEntity {
    /*城市ID*/
    private String cityid;
    /*城市名称*/
    private String city;
    /*IP地址*/
    private String ip;
    /*jsonp参数*/
    private String callback;
    /*跨域参数*/
    private String vue;
}
