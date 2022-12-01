package at.tectrain.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import at.tectrain.demo.service.CalculatorService;

@RestController
@RequestMapping
public class CalculatorController {

    private CalculatorService service;

    CalculatorController(CalculatorService service){
        this.service = service;
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, int b){
        return service.subtract(a,b);
    }
    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, int b){
        return service.multiply(a,b);
    }
    @GetMapping("/divide")
    public int divide(@RequestParam int a, int b){
        return service.divide(a,b);
    }
    @GetMapping("/add")
    public int add(@RequestParam int a, int b){
        return service.add(a,b);
    }
}
