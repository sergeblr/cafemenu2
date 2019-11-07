package com.cafemenu.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.cafemenu.entity")
//@ComponentScan(basePackages = "com.cafemenu.repository")
public class TestConfig {

}
