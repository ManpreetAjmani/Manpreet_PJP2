package calculator;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FunctionalitiesTest {

	private functionalities fun;
	public static final String test = "21/08/2020";
	public static final String test1 = "22/03/2020";
	private Date date1;
	private Date date2;

	@Before
	public void initialise() throws ParseException {
		fun = new functionalities();
		date1 = new SimpleDateFormat("dd/MM/yyyy").parse(test);
		date2 = new SimpleDateFormat("dd/MM/yyyy").parse(test1);
	}

	@Test
	public void add() throws ParseException {
		assertEquals("13/12/4040", fun.AddorSubtract(test, test1, "+"));
	}

	@Test
	public void AfterNdays() throws ParseException {
		assertEquals("25/08/2020", fun.AddUnits(test, 4, "days"));
	}

	@Test
	public void AfterNmonths() throws ParseException {
		assertEquals("22/08/2020", fun.AddUnits(test1, 5, "months"));
	}

	@Test
	public void day() throws ParseException {
		assertEquals("Sunday", fun.DetermineDay("23/08/2020"));
	}

	@Test
	public void week() throws ParseException {
		assertEquals("35", fun.DetermineWeek("23/08/2020"));
	}

	@After
	public void end() {
		date1 = null;
		date2 = null;
	}

}
