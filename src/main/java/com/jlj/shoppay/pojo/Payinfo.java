package com.jlj.shoppay.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Payinfo {
    private Integer id;

    private Integer userId;

    private Long orderNo;

    private Integer payPlatform;

    private String platformNumber;

    private String platformStatus;

    private BigDecimal payAmount;

    private Date createTime;

    private Date updateTime;

    public Payinfo(Long orderNo, Integer payPlatform, String platformNumber, String platformStatus, BigDecimal payAmount) {
        this.orderNo = orderNo;
        this.payPlatform = payPlatform;
        this.platformNumber = platformNumber;
        this.platformStatus = platformStatus;
        this.payAmount = payAmount;
    }
}