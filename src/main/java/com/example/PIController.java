package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anup on 22/04/17.
 */
@RestController
@RequestMapping("/math")
public class PIController {
    @GetMapping("/pi")
    public String  return_pi() {
      return ("3.141592653589793");
    }
}
