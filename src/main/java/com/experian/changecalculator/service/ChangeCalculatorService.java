package com.experian.changecalculator.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ChangeCalculatorService {
    // Define the denominations in pence
    private static final int[] DENOMINATIONS_IN_PENCE = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
    private static final String[] DENOMINATIONS_NAMES = {"£10", "£5", "£2", "£1", "50p", "20p", "10p", "5p", "2p", "1p"};


    public Map<String, Integer> calculateChange(double amountPaid, double productPrice) {
        double change = amountPaid - productPrice;
        Map<String, Integer> denominations = new LinkedHashMap<>();

        // Convert change to pence
        int changeInPence = (int) (change * 100);

        // Iterate through each denomination
        for (int i = 0; i < DENOMINATIONS_IN_PENCE.length; i++) {
            int denominationInPence = DENOMINATIONS_IN_PENCE[i];
            String denominationName = DENOMINATIONS_NAMES[i];
            int count = changeInPence / denominationInPence;
            if (count > 0) {
                denominations.put(denominationName, count);
                changeInPence %= denominationInPence;
            }
        }

        return denominations;
    }

}

