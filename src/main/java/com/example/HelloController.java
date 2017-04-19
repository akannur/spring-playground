package com.example;

/**
 * Created by anup on 18/04/17.
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello Anup";
    }
}
