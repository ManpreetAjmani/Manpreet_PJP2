package income;

import java.io.IOException;
import java.text.ParseException;

public class App {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		
		IncomeFileReadAndWrite income=new IncomeFileReadAndWrite();
		income.read();
		income.write();

	}

}
