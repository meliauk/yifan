package com.hz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.hz.mapper")
@SpringBootApplication
@ServletComponentScan
public class YifanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YifanApplication.class, args);
    }

}
