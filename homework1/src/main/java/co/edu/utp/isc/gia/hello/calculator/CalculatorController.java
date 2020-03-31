/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.hello.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CJ
 */
@RestController
@RequestMapping("calc")
public class CalculatorController {
    
    Double result;
    
    @GetMapping("/add")
    public String add(
            @RequestParam("numA") double numA,
            @RequestParam("numB") double numB
    ) {
        result = numA + numB;
        return  "Add result: " + result.toString();
    }
    
    @GetMapping("/sub")
    public String sub(
            @RequestParam("numA") double numA,
            @RequestParam("numB") double numB
    ) {
        result = numA - numB;
        return  "Sub result: " + result.toString();
    }
    
    @GetMapping("/mul")
    public String mul(
            @RequestParam("numA") double numA,
            @RequestParam("numB") double numB
    ) {
        result = numA * numB;
        return  "Mul result: " + result.toString();
    }
    
    @GetMapping("/div")
    public String div(
            @RequestParam("numA") double numA,
            @RequestParam("numB") double numB
    ) {
        if (numB == 0) {
            return "Div by zero";
        }
        result = numA / numB;
        return  "Div result: " + result.toString();
    }
}
