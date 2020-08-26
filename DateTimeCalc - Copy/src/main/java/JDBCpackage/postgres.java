package JDBCpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import calculator.CalcMenu;

public class postgres {
	private static final String INSERT_USERS_SQL="INSERT INTO Calculator (USER_ID,NAME,OPTION,OUTPUT) VALUES (?, ?, ?, ?)";;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/DateTimeCalculator","postgres","root");
			
			if(connection!=null) System.out.println("connected to db");
			else System.out.println("connection failed");
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		calculator.CalcMenu calc=new CalcMenu();
		List<String> list = new ArrayList<String>();
		list=calc.menu();
		
		
		 
		PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL);
		int count=1;
		for(int i=0 ; i<list.size() ;i+=3) {
			
			count++;
			statement.setInt(1,count);
			statement.setString(2, list.get(i));
			statement.setInt(3, Integer.parseInt(list.get(i+1)));
			statement.setString(4, list.get(i+2));
			
			statement.addBatch();
		
            statement.executeBatch();
            
			
		}
		
	}

}
