package com.assignment.java2;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class App {
	
	public static void main(String[] args) throws NumberFormatException, ParseException, IOException {
		
		TransactionReadAndWrite transaction = new TransactionReadAndWrite();
		List<AttributesUtil> list = transaction.read();
		Calculator calculator = new Calculator();
		calculator.calculate(list);
		transaction.write(list);
		
	}

}
