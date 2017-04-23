package com.example;

/**
 * Created by anup on 22/04/17.
 */
import com.example.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    public MathService mathService;

    @GetMapping("/calculate")
    public String getCalculationParams(
            @RequestParam(defaultValue = "add") String operation,
            @RequestParam String x,
            @RequestParam String y) {

        return mathService.calculate(operation, x, y);
    }

    @PostMapping("/sum")
    public String getSumParams(@RequestParam MultiValueMap<String, String> query) {
        return mathService.sum(query);
    }

}