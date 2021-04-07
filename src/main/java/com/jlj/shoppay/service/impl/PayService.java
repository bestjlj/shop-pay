package com.jlj.shoppay.service.impl;
import com.jlj.shoppay.service.IpayService;
import com.lly835.bestpay.enums.BestPayPlatformEnum;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
@Slf4j
@Service
public class PayService implements IpayService {

    @Autowired
    private BestPayService bestPayService;

    public PayResponse create(String orderId, BigDecimal amount,BestPayTypeEnum bestPayTypeEnum) throws RuntimeException{
        //BestPayService bestPayService = new BestPayServiceImpl();
        PayRequest payRequest=new PayRequest();
        payRequest.setOrderName("8066134-支付sdk");
        payRequest.setOrderId(orderId);
        payRequest.setOrderAmount(amount.doubleValue());
        payRequest.setPayTypeEnum(bestPayTypeEnum);
        PayResponse response=bestPayService.pay(payRequest);
        log.info("response={}",response);
        return response;
    }
    public String  asyncNotify(String notifyData) {
        BestPayService bestPayService = new BestPayServiceImpl();
        PayResponse payResponse=bestPayService.asyncNotify(notifyData);
        log.info("payResponce={}",payResponse);
        if (payResponse.getPayPlatformEnum()== BestPayPlatformEnum.WX)
        {

        }else if(payResponse.getPayPlatformEnum()==BestPayPlatformEnum.ALIPAY){
            return "success";
        }
        throw new RuntimeException("异步通知中错误的支付平台！");

    }

}
