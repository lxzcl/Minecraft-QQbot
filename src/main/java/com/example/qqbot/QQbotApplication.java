package com.example.qqbot;

import com.zhuangxv.bot.EnableBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBot
public class QQbotApplication {
    public static void main(String[] args) {
        SpringApplication.run(QQbotApplication.class, args);
    }

}
