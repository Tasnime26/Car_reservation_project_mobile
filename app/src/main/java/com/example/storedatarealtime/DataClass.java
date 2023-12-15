package com.example.storedatarealtime;

public class DataClass {
    private String dataTitle;
    private String dataDesc;
    private String dataBrand;
    private String dataImage;
    private float dataPrice;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public String getDataBrand() {
        return dataBrand;
    }

    public String getDataImage() {
        return dataImage;
    }

    public float getDataPrice() {
        return dataPrice;
    }

    public void setDataPrice(float dataPrice) {
        this.dataPrice = dataPrice;
    }

    public DataClass(String dataTitle, String dataDesc, String dataBrand, String dataImage, float dataPrice) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataBrand = dataBrand;
        this.dataImage = dataImage;
        this.dataPrice = dataPrice;
    }

    public DataClass() {
    }
}
