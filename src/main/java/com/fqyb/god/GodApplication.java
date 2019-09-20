package com.fqyb.god;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class GodApplication {

    public static void main(String[] args) {
        SpringApplication.run(GodApplication.class, args);
    }

    @GetMapping("/a")
    public String a() {
        return "a";
    }
    @GetMapping("/camera")
    public String camera() {
        return "camera";
    }
}
