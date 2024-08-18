package com.razor.dqa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.razor.dqa.service.DataQualityAssessService;
import com.razor.dqa.service.SxjtDqaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan("com.razor.dqa.mapper")
@SpringBootApplication
public class DqaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DqaApplication.class, args);
        log.info("============== start ==============");
        // DataQualityAssessService service = context.getBean(DataQualityAssessService.class);
        // service.assessData();
        SxjtDqaService service = context.getBean(SxjtDqaService.class);
        service.assessData();
        log.info("============== end ==============");
    }

}
