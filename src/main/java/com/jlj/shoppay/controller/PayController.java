package com.jlj.shoppay.controller;

import com.jlj.shoppay.service.impl.PayService;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private PayService payService;
    @GetMapping("/create")
    public ModelAndView create(String orderid,
                               BigDecimal amount,
                               @RequestParam("payType")BestPayTypeEnum bestPayTypeEnum){
        Map<String,String> map=new HashMap<>();
        PayResponse payResponse=payService.create(orderid,amount,bestPayTypeEnum);
        if(bestPayTypeEnum==BestPayTypeEnum.WXPAY_NATIVE){
            map.put("qrcode",payResponse.getCodeUrl());
            return new ModelAndView("create",map);
        }else if (bestPayTypeEnum==BestPayTypeEnum.ALIPAY_PC){
            map.put("body",payResponse.getBody());
            return new ModelAndView("createForAlipayPc",map);
        } throw new RuntimeException("暂不支持其他的支付方式！");

    }
    @RequestMapping("/notify")
    public void asyncNotify(@RequestBody String notifyData){
        payService.asyncNotify(notifyData);
    }
}
