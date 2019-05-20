package cn.clare.www.excel2img;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class Excel2imgApplication {

    public static void main(String[] args) {
        SpringApplication.run(Excel2imgApplication.class, args);
    }

}
