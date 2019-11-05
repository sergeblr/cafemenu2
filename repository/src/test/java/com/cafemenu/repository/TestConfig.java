package com.cafemenu.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.cafemenu.entity")
//@ComponentScan(basePackages = "com.cafemenu.repository")
public class TestConfig {
}
