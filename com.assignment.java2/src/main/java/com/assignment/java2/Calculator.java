package com.assignment.java2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator extends AttributesUtil {
	
	private static final int IntradayFee  = 10;
	private static final int add50 = 50;
	private static final int add100 = 100;
	private static final int add500 = 500;
	private static final String Priority = "Y";
	
	private final Map<String, List<AttributesUtil>> buy;
	private final Map<String, List<AttributesUtil>> sell;
	
	public Calculator() {
		this.buy = new HashMap<>();
		this.sell = new HashMap<>();
	}
	
	public void calculate(List<AttributesUtil> list) {
		for (AttributesUtil t : list) {
			
			if(t.getTransactionType().equals("WITHDRAW") || t.getTransactionType().equals("DEPOSIT")) setNominalValue(t);
			
			else if(t.getTransactionType().equals("BUY")) {
				
				if(check(t, sell)) 
					continue;
				List<AttributesUtil> temp = buy.getOrDefault(t.getKey(), new ArrayList<>());
				temp.add(t);
				
				if(!buy.containsKey(t.getKey()))
					buy.put(t.getKey(), temp);
			} else {
				
				if(check(t, buy)) 
					continue;
				List<AttributesUtil> temp = sell.getOrDefault(t.getKey(), new ArrayList<>());
				temp.add(t);
				
				if(!sell.containsKey(t.getKey()))
					sell.put(t.getKey(), temp);
			}
		}
		Next(buy);
		Next(sell);
	}
	
	private void Next(Map<String, List<AttributesUtil>> map) {
		for (String key : map.keySet()) {
			map.get(key).forEach(this::setNominalValue);
		}
	}

	private boolean check(AttributesUtil t, Map<String, List<AttributesUtil>> map) {
		
		if(map.containsKey(t.getKey())) {
			AttributesUtil temp = map.get(t.getKey()).remove(0);
			if(map.get(t.getKey()).isEmpty())
				map.remove(t.getKey());
			temp.setProcessingFee(IntradayFee);
			t.setProcessingFee(IntradayFee);
			setNominalValue(temp);
			setNominalValue(t);
		}
		
		return false;
	}

	private void setNominalValue(AttributesUtil t) {
		
		if(t.getPriorityFlag().equals(Priority)) t.setProcessingFee(add500 + t.getProcessingFee());
		
		else if(t.getTransactionType().equals("SELL") || t.getTransactionType().equals("WITHDRAW"))
				t.setProcessingFee(add100 + t.getProcessingFee());
			
		else t.setProcessingFee(add50 + t.getProcessingFee());
	}
	
}
