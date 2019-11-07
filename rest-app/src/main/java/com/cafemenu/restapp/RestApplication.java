package com.cafemenu.restapp;

import com.cafemenu.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.cafemenu"})
@SpringBootApplication
@EnableJpaRepositories("com.cafemenu.repository")
//@ImportResource(locations = {"classpath:test-db.xml"})
public class RestApplication {

    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
