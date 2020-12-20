## retrofit-spring-boot-starter-demo
---

本项目是 [retrofit-spring-boot-starter](https://github.com/LianjiaTech/retrofit-spring-boot-starter) 的示例项目。

-  访问地址  http://localhost:8080/weather/livedWeather?version=v6&appid=54296672&appsecret=84RRenf9
-  https://tianqiapi.com/index/doc?version=v6


### 示例项目的 api
1. GET [http://localhost:8080/weather/livedWeather?version=v6&appid=54296672&appsecret=84RRenf9](http://localhost:8080/weather/livedWeather?version=v6&appid=54296672&appsecret=84RRenf9)
   
    * 可选参数信息
    
    | 参数名    | 必选 | 类型   | 说明          | 备注（示例）                                 |
    | --------- | ---- | ------ | ------------- | -------------------------------------------- |
    | appid     | 是   | string | 用户appid     | 注册开发账号                                 |
    | appsecret | 是   | string | 用户appsecret |                                              |
    | version   | 是   | string | 接口版本标识  | 固定值: v6 每个接口的version值都不一样       |
    | cityid    | 否   | string | 城市ID        | 请参考 城市ID列表                            |
    | city      | 否   | string | 城市名称      | 不要带市和区; 如: 青岛、铁西                 |
    | ip        | 否   | string | IP地址        | 查询IP所在城市天气                           |
    | callback  | 否   | string | jsonp参数     | 如: jQuery\.Callbacks                        |
    | vue       | 否   | string | 跨域参数      | 如果您使用的是react、vue、angular请填写值: 1 |
    
    * 响应内容
    ```json
    {
        "date": "2020-11-12",
        "countryEn": "China",
        "tem2": "10",
        "country": "中国",
        "win_meter": "小于12km/h",
        "air_level": "良",
        "week": "星期四",
        "tem1": "21",
        "visibility": "10.8km",
        "city": "济南",
        "cityid": "101120101",
        "pressure": "1007",
        "air": "84",
        "air_pm25": "84",
        "update_time": "2020-11-12 10:08:37",
        "wea": "晴",
        "air_tips": "空气好，可以外出活动，除极少数对污染物特别敏感的人群以外，对公众没有危害！",
        "wea_img": "qing",
        "alarm": {
            "alarm_type": "",
            "alarm_content": "",
            "alarm_level": ""
        },
        "cityEn": "jinan",
        "win_speed": "3级",
        "humidity": "45%",
        "tem": "17",
        "win": "西南风"
    }
    ```


## 参考资料
1. [retrofit-spring-boot-starter](https://github.com/LianjiaTech/retrofit-spring-boot-starter)
2. [https://tianqiapi.com/index/doc?version=v6](https://tianqiapi.com/index/doc?version=v6)
