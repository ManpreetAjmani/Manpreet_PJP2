package calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcMenu {

	public int option;
	public String Name;
	public String answer;

	functionalities obj = new functionalities();
	Scanner scanner = new Scanner(System.in);

	public void WriteFile(List<String> wordList) throws Exception {

		FileOutputStream fileOutPutStream = new FileOutputStream("file.txt", true);
		DataOutputStream write = new DataOutputStream(fileOutPutStream);
		for (String s : wordList) {
			write.writeUTF(s);
		}
		// write.writeUTF("\r\n");
		write.close();

	}

	public void readfile() throws Exception, FileNotFoundException, IOException {
		List<String> wordList = new ArrayList<String>();
		FileInputStream input = new FileInputStream("file.txt");
		DataInputStream read = new DataInputStream(input);
		for (int i = 0; i < read.available(); i++) {
			wordList.add(read.readUTF());
		}
		for (String s : wordList) {
			System.out.println(s);

		}
		read.close();

	}

	public List<String> menu() throws Exception {
		
		List<String> list = new ArrayList<String>();
		do {
			//List<String> list = new ArrayList<String>();
			System.out.println("Menu: ");
			System.out.println("1. Add and substract two dates");
			System.out.println("2. Add days/months/weeks to the given date : format= n units");
			System.out.println("3. Determine the day of the week for a given date");
			System.out.println("4. Determine the week number for a given date");
			System.out.println("5. Translate one of the language phrases: ");
			System.out.println(
					"Today, Tomorrow, Day-after-tomorrow, yesterday,Day-before-yesterday, Lastweek, Previousweek,Nextweek, Nextmonth, Nextyear, Lastmonth,Lastyear, Monthafter, Monthbefore, Nweeksfromnow,Ndaysfromnow, Nmonthsfromnow, Nyearsfromnow,Ndaysearlier,Nweeksearlier,Nmonthsearlier,Nyearsearlier");
			System.out.println("\nNote: When the prompt asks for date, enter the date in the format: DD/MM/YYYY");

			System.out.println("\nEnter your Name: ");

			Name = scanner.next();

			System.out.println("\nEnter your option: ");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				answer = option1();
				list.add(Name);
				list.add(String.valueOf(option));
				list.add(answer + "\r\n");
				WriteFile(list);

				break;
			case 2:
				answer = option2();
				list.add(Name);
				list.add(String.valueOf(option));
				list.add(answer + "\r\n");
				WriteFile(list);

				break;
			case 3:
				answer = option3();
				list.add(Name);
				list.add(String.valueOf(option));
				list.add(answer + "\r\n");
				WriteFile(list);

				break;
			case 4:
				answer = option4();
				list.add(Name);
				list.add(String.valueOf(option));
				list.add(answer + "\r\n");
				WriteFile(list);

				break;
			case 5:
				option5();
				break;
			default:
				answer = "Try again";
				System.out.println("Incorrect option type.");
				break;
			}

		} while (option <= 5 && option > 0);

		readfile();
		return list;

	}

	public String option1() throws ParseException {
		String date1, date2, operation;

		System.out.println("\nEnter Date 1: ");
		date1 = scanner.next();

		System.out.println("Enter Date 2: ");
		date2 = scanner.next();

		System.out.println("Enter the operation(+, -):");
		operation = scanner.next();

		answer = obj.AddorSubtract(date1, date2, operation);
		System.out.println(answer);
		return answer;

	}

	private String option2() throws ParseException {
		int n;
		String unit;

		String date;

		System.out.println("enter date");
		date = scanner.next();

		System.out.println("enter count");
		n = scanner.nextInt();

		System.out.println("enter unit : day/month/year");
		unit = scanner.next();

		answer = obj.AddUnits(date, n, unit);
		System.out.println(answer);
		return answer;
	}

	private String option3() throws ParseException {

		String date;

		System.out.println("enter date");
		date = scanner.next();

		answer = obj.DetermineDay(date);
		System.out.println(answer);
		return answer;

	}

	private String option4() throws ParseException {

		String date;

		System.out.println("enter date");
		date = scanner.next();

		answer = obj.DetermineWeek(date);
		System.out.println(answer);
		return answer;
	}

	private void option5() throws ParseException {

		String expression;
		int x = 0;

		System.out.println("enter expression from choices displayed previously");
		expression = scanner.next();

		if (expression.charAt(0) == 'N') {

			System.out.println("enter value of N");
			x = scanner.nextInt();
		}
		obj.nlp(expression, x);

	}

}
