package com.nongguoguo.Website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.nongguoguo.Website.mapper")
public class TikNongguoguoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TikNongguoguoApplication.class,args);
    }

}
