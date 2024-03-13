package com.experian.changecalculator;

import com.experian.changecalculator.service.ChangeCalculatorService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class ChangeCalculatorApplication implements CommandLineRunner {

	@Autowired
	private ChangeCalculatorService changeCalculatorService;

	public static void main(String[] args) {
		SpringApplication.run(ChangeCalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		// Prompt user to enter the amount paid
		System.out.print("Enter the amount paid: £");
		double amountPaid = scanner.nextDouble();

		// Prompt user to enter the product price
		System.out.print("Enter the product price: £");
		double productPrice = scanner.nextDouble();

		// Calculate change denominations using ChangeCalculatorService
		Map<String, Integer> changeDenominations = changeCalculatorService.calculateChange(amountPaid, productPrice);

		// Display change denominations
		System.out.println("Your change is:");
		for (Map.Entry<String, Integer> entry : changeDenominations.entrySet()) {
			System.out.println(entry.getValue() + " x " + entry.getKey());
		}
	}

}
