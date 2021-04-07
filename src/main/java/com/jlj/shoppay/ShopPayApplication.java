package com.jlj.shoppay;

import com.jlj.shoppay.dao.CategoryMapper;
import com.jlj.shoppay.pojo.Category;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.jlj.shoppay.dao")
public class ShopPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopPayApplication.class, args);


    }
}