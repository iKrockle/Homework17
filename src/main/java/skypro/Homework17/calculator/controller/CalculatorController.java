package skypro.Homework17.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.Homework17.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String showHelloWorld(){return "Добро пожаловать в калькулятор";}

    @GetMapping("/plus")
    public String showPlus(@RequestParam(required = false) Integer num1
            ,@RequestParam(required = false) Integer num2) {
        if (num1==null||num2==null){return "Укажите параметры num1 и num2";}
        return num1 +"+"+num2+"="+calculatorService.getPlus(num1,num2);
    }

    @GetMapping("/minus")
    public String showMinus(@RequestParam(required = false) Integer num1
            ,@RequestParam(required = false) Integer num2) {
        if (num1==null||num2==null){return "Укажите параметры num1 и num2";}
        return num1 +"-"+num2+"="+calculatorService.getMinus(num1,num2);
    }

    @GetMapping("/multiply")
    public String showMultiply(@RequestParam(required = false) Integer num1
            ,@RequestParam(required = false) Integer num2) {
        if (num1==null||num2==null){return "Укажите параметры num1 и num2";}
        return num1 +"*"+num2+"="+calculatorService.getMultiply(num1,num2);
    }

    @GetMapping("/divide")
    public String showDivide(@RequestParam(required = false) Integer num1
            ,@RequestParam(required = false) Integer num2)  {
        if (num1==null||num2==null){
            return "Укажите параметры num1 и num2";
        }
        if (num2==0) {
            return "Деление на 0";
        }
        return num1 +"/"+num2+"="+calculatorService.getDivide(num1,num2);
    }
}
