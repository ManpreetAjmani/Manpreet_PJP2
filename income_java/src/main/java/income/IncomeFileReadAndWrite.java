package income;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class IncomeFileReadAndWrite {
	
	List<IncomeUtil> list = new ArrayList<>();
	
	public void read() throws NumberFormatException, IOException {
			
		
		
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\manpr\\Downloads\\Sample_Input.csv"), ',' , '"' , 1);
		String[] nextLine;
		
		while((nextLine = reader.readNext()) != null) {

				IncomeUtil incomeUtil = new IncomeUtil();
				 
				incomeUtil.setCity(nextLine[0]); 
				incomeUtil.setCountry(nextLine[1]);
				incomeUtil.setGender(nextLine[2]); 
				incomeUtil.setCurrency(nextLine[3]);
				incomeUtil.setAverageIncome(Double.parseDouble(nextLine[4])); 
				
				list.add(incomeUtil);
			
		}
		list.sort((temp1,temp2) -> {
			
			if (temp1.getCountry().equals(temp2.getCountry()))
				if (temp1.getCity().equals(temp2.getCity()))
					
						if (temp1.getGender().equals("F"))
							return 1;
						else
							return -1;
				else
					return temp1.getCity().compareTo(temp2.getCity());
			else
				return temp1.getCountry().compareTo(temp2.getCountry());
			
		});
	}
	
	public void write() throws FileNotFoundException, ParseException {
		
		String csv = "IncomeReport.csv";
	    PrintWriter writer = new PrintWriter(new File(csv));
	    StringBuilder sb=new StringBuilder();
	    
	    sb.append("Country");
		sb.append(",");
		sb.append("City");
		sb.append(",");
		sb.append("Gender");
		sb.append(",");
		sb.append("Income in USD");
		sb.append("\n");
		
		Map<String, Double> rates = new HashMap<>();
		rates.put("INR", 66.0);
		rates.put("GBP", 0.67);
		rates.put("SGP", 1.5);
		rates.put("HKD", 8.0);
		rates.put("USD", 1.0);
		
		for(IncomeUtil x : list) {
            sb.append(x.getCountry()+",");
            sb.append(x.getCity()+",");
            sb.append(x.getGender()+",");
            Double amt=x.getAverageIncome();
            String curr=x.getCurrency();
            Double rate=rates.get(curr);
            Double income=amt/rate;
            String avg=Double.toString(income);
            
            
            sb.append(avg);
            sb.append('\n');
        }

        
        writer.write(sb.toString());
        writer.close();
		
	}
	
	 

	
	
	
	
}
