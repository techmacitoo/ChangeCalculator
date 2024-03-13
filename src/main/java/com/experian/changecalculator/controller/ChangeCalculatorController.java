package com.experian.changecalculator.controller;

import com.experian.changecalculator.service.ChangeCalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class ChangeCalculatorController {

    private final ChangeCalculatorService changeCalculatorService;

    public ChangeCalculatorController(ChangeCalculatorService changeCalculatorService) {
        this.changeCalculatorService = changeCalculatorService;
    }

    // This endpoint calculates the change to be returned based on the amount paid and the product price
    @PostMapping("/calculateChange")
    public Map<String, Integer> calculateChange(@RequestBody Map<String, Double> request) {
        double amountPaid = request.get("amountPaid");
        double productPrice = request.get("productPrice");
        return changeCalculatorService.calculateChange(amountPaid, productPrice);
    }
}