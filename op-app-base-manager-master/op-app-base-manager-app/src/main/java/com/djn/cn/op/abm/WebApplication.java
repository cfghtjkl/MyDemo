package com.djn.cn.op.abm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement // 开启事务
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableSwagger2
public class WebApplication {
    public static void main(final String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
}
