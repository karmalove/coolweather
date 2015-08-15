package com.kevin.able.coolweather.modle;

/**
 * Created by Kevin on 2015/8/15.
 */
public class City {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityCode() {

        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {

        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;


}
