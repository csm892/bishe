package com.javapandeng.po;

import java.util.Date;

/**
 * Created by yoyo on 20/3/28
 */
public class Seckill {
    private long seckillId;
    private String name;
    private int number;
    private Date startTime;
    private Date endTime;
    private Date createTime;

    /**
     * 商品价格
     */
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 商品对象
     */
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Seckill{" +
                "seckillId=" + seckillId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", price='" + price + '\'' +
                ", item=" + item +
                '}';
    }
}
