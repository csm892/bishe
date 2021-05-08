package com.javapandeng.po;

/**
 * @author csm
 * @create 2021-05-08 下午 3:32
 */
public class Pay {
    private String code;
    private  String total;

    public Pay(String code, String total) {

        this.code = code;
        this.total = total;
    }

    public Pay() {

    }

    @Override
    public String toString() {
        return "Pay{" +
                "code='" + code + '\'' +
                ", total='" + total + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
