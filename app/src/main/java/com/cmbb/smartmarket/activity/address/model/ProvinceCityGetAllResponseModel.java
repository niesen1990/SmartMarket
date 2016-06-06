package com.cmbb.smartmarket.activity.address.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/2 下午6:45
 * 修改人：N.Sun
 * 修改时间：16/6/2 下午6:45
 * 修改备注：
 */
public class ProvinceCityGetAllResponseModel {

    /**
     * data : [{"name":"北京","code":"110000"},{"name":"天津","code":"120000"},{"name":"河北省","code":"130000"},{"name":"山西省","code":"140000"},{"name":"内蒙古自治区","code":"150000"},{"name":"辽宁省","code":"210000"},{"name":"吉林省","code":"220000"},{"name":"黑龙江省","code":"230000"},{"name":"上海","code":"310000"},{"name":"江苏省","code":"320000"},{"name":"浙江省","code":"330000"},{"name":"安徽省","code":"340000"},{"name":"福建省","code":"350000"},{"name":"江西省","code":"360000"},{"name":"山东省","code":"370000"},{"name":"河南省","code":"410000"},{"name":"湖北省","code":"420000"},{"name":"湖南省","code":"430000"},{"name":"广东省","code":"440000"},{"name":"广西壮族自治区","code":"450000"},{"name":"海南省","code":"460000"},{"name":"重庆","code":"500000"},{"name":"四川省","code":"510000"},{"name":"贵州省","code":"520000"},{"name":"云南省","code":"530000"},{"name":"西藏自治区","code":"540000"},{"name":"陕西省","code":"610000"},{"name":"甘肃省","code":"620000"},{"name":"青海省","code":"630000"},{"name":"宁夏回族自治区","code":"640000"},{"name":"新疆维吾尔自治区","code":"650000"},{"name":"台湾省","code":"710000"},{"name":"香港特别行政区","code":"810000"},{"name":"澳门特别行政区","code":"820000"}]
     * msg : 操作成功
     */

    private String msg;
    /**
     * name : 北京
     * code : 110000
     */

    private List<DataEntity> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private String name;
        private String code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
