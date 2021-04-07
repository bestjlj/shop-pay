package com.jlj.shoppay.service.impl;

import com.jlj.shoppay.ShopPayApplicationTests;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class PayServiceTest extends ShopPayApplicationTests {
    @Autowired
    private PayService payService;
    @Test
    public void create() {
        payService.create("1234567844354363465464578946546", BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }
}