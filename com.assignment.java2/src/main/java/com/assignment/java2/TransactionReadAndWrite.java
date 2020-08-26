package com.assignment.java2;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class TransactionReadAndWrite {
	

	public List<AttributesUtil> read() throws ParseException, NumberFormatException, IOException {
		
		List<AttributesUtil> list = new ArrayList<>();
		
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\manpr\\Downloads\\Sample_Data_Fee_Calculator.csv"), ',' , '"' , 1);
		
			String[] nextLine;
			
			while((nextLine = reader.readNext()) != null) {
				
				
				AttributesUtil attributesUtil = new AttributesUtil();
				 
				attributesUtil.setTransactionId(nextLine[0]);
				attributesUtil.setClientId(nextLine[1]);
				attributesUtil.setSecurityId(nextLine[2]);
				attributesUtil.setTransactionType(nextLine[3]);
				attributesUtil.setTransactionDate(new SimpleDateFormat("mm/dd/yyyy").parse(nextLine[4]));
				attributesUtil.setMarketValue(Double.parseDouble(nextLine[5]));
				attributesUtil.setPriorityFlag(nextLine[6]);
				list.add(attributesUtil);
			}
		
		return list;
	}

	public void write(List<AttributesUtil> list) throws IOException {
		
			
		
		
		String csv = "ProcessingFeeReport.csv";
	    PrintWriter writer = new PrintWriter(new File(csv));
	    StringBuilder sb=new StringBuilder();
		
		//String [] str = "Client ID,TransactionType,Transaction Date,Priority Flag,ProcessingFee".split(",");
		
		//writer.writeNext(str);
		
		System.out.println("output file created");
		
		sb.append("Client ID");
		sb.append(",");
		sb.append("TransactionType");
		sb.append(",");
		sb.append("Transaction Date");
		sb.append(",");
		sb.append("Priority Flag");
		sb.append(",");
		sb.append("ProcessingFee");
		sb.append("\n");
		
		writer.write(sb.toString());
		
			list.sort((a,b) -> {
				
				if(!a.getClientId().equals(b.getClientId()))
					return a.getClientId().compareTo(b.getClientId());
				
				else if(!a.getTransactionType().equals(b.getTransactionType()))
					return a.getTransactionType().compareTo(b.getTransactionType());
				
				else if(!a.getTransactionDate().equals(b.getTransactionDate()))
					return a.getTransactionDate().compareTo(b.getTransactionDate());
				
				else 
					return a.getPriorityFlag().compareTo(b.getPriorityFlag()); 
				
			});
			
			
			for (AttributesUtil attributesUtil  : list) {
				StringBuilder sbnew=new StringBuilder();
				String [] nextLine = new String[5];
				
				nextLine[0] = attributesUtil.getClientId(); 
				sbnew.append(nextLine[0]);
				sbnew.append(",");
				
				nextLine[1] = attributesUtil.getTransactionType(); 
				sbnew.append(nextLine[1]);
				sbnew.append(",");
				
				nextLine[2] = attributesUtil.DateToSTring(); 
				sbnew.append(nextLine[2]);
				sbnew.append(",");
				
				nextLine[3] = attributesUtil.getPriorityFlag();
				sbnew.append(nextLine[3]);
				sbnew.append(",");
				
				nextLine[4] = Integer.toString(attributesUtil.getProcessingFee());
				sbnew.append(nextLine[4]);
				sbnew.append("\n");
				
				writer.write(sbnew.toString());
				
				//writer.writeNext(nextLine);
			}
	
		writer.close();
	}	
	
}
