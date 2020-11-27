package com.smart.lct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
@MapperScan("com.smart.lct.mapper")
public class LeagueConstructionTravelApp {
    public static void main(String[] args) {
        SpringApplication.run(LeagueConstructionTravelApp.class, args);
    }
}
