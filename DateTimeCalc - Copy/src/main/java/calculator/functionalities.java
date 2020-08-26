package calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class functionalities {

	public String out;

	public String AddorSubtract(String date1, String date2, String operation) throws ParseException {

		String out;
		Date sdate1 = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
		Date sdate2 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(sdate1);
		c2.setTime(sdate2);

		if (operation.equals("+")) {
			Calendar cTotal = (Calendar) c1.clone();

			cTotal.add(Calendar.YEAR, c2.get(Calendar.YEAR));
			cTotal.add(Calendar.MONTH, c2.get(Calendar.MONTH) + 1);
			cTotal.add(Calendar.DATE, c2.get(Calendar.DATE));
			Date finaldate = cTotal.getTime();
			out = new SimpleDateFormat("dd/MM/yyyy").format(finaldate);
		}

		else {
			Calendar before, after;

			before = (Calendar) c1.clone();
			after = (Calendar) c2.clone();

			if (!before.before(after)) {
				before = (Calendar) c2.clone();
				after = (Calendar) c1.clone();
			}

			int[] fields = { Calendar.YEAR, Calendar.MONTH, Calendar.DATE };
			int[] changes = { 0, 0, 0 };
			Calendar c = (Calendar) before.clone();
			int index = 0;

			for (int field : fields) {
				int changed = -1; // 0 indexed
				Calendar subs_tracker = (Calendar) c.clone();
				while (!subs_tracker.after(after)) {
					subs_tracker.add(field, 1);
					changed++;
				}
				changes[index++] = changed;
				c.add(field, changed);
			}

			String answer = changes[2] + "/" + changes[1] + "/" + changes[0];
			c.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(answer));

			out = c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
		}

		return out;
	}

	public String AddUnits(String date, int n, String unit) throws ParseException {

		Date sdate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

		Calendar c1 = Calendar.getInstance();
		c1.setTime(sdate);

		if (unit.contentEquals("days") || unit.contentEquals("weeks")) {
			if (unit.equals("weeks")) {
				n *= 7;
			}
			c1.add(Calendar.YEAR, 0);
			c1.add(Calendar.MONTH, 0);
			c1.add(Calendar.DATE, n);
		} else if (unit.equals("months")) {
			c1.add(Calendar.YEAR, 0);
			c1.add(Calendar.MONTH, n);
			c1.add(Calendar.DATE, 0);
		}

		// c1.add(n, days);
		Date finaldate = c1.getTime();
		out = new SimpleDateFormat("dd/MM/yyyy").format(finaldate);

		return out;

	}

	public String DetermineDay(String date) throws ParseException {

		Date sdate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

		Calendar c1 = Calendar.getInstance();
		c1.setTime(sdate);

		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday" };

		out = days[c1.get(Calendar.DAY_OF_WEEK) - 1];
		return out;
	}

	public String DetermineWeek(String date) throws ParseException {

		Date sdate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

		Calendar c1 = Calendar.getInstance();
		c1.setTime(sdate);
		int x = c1.get(Calendar.WEEK_OF_YEAR);
		out = String.valueOf(x);
		return out;
	}

	public void nlp(String expression, int x) {
		LocalDateTime today = LocalDateTime.now();
		if (expression.contentEquals("Today")) {
			// LocalDateTime today = LocalDateTime.now();
			System.out.println(today);
		} else if (expression.contentEquals("Yesterday")) {
			LocalDateTime ans = today.minusDays(1);
			System.out.println(ans);
		}

		else if (expression.contentEquals("Tomorrow")) {
			LocalDateTime ans = today.plusDays(1);
			System.out.println(ans);
		}

		else if (expression.contentEquals("Day-after-tomorrow")) {
			LocalDateTime ans = today.plusDays(2);
			System.out.println(ans);
		} else if (expression.contentEquals("-Day-before-yesterday")) {
			LocalDateTime ans = today.minusDays(2);
			System.out.println(ans);
		} else if (expression.contentEquals("LastWeek") || expression.contentEquals("PreviousWeek")) {
			LocalDateTime ans = today.minusDays(7);
			System.out.println(ans);
		} else if (expression.contentEquals("NextWeek")) {
			LocalDateTime ans = today.plusDays(7);
			System.out.println(ans);
		}

		else if (expression.contentEquals("LastMonth") || expression.contentEquals("PreviousMonth")) {
			LocalDateTime ans = today.minusMonths(7);
			System.out.println(ans);
		} else if (expression.contentEquals("NextMonth")) {
			LocalDateTime ans = today.plusMonths(7);
			System.out.println(ans);
		}

		else if (expression.contentEquals("LastYear") || expression.contentEquals("PreviousYear")) {
			LocalDateTime ans = today.minusYears(7);
			System.out.println(ans);
		} else if (expression.contentEquals("NextYear")) {
			LocalDateTime ans = today.plusYears(7);
			System.out.println(ans);
		}

		else if (expression.charAt(0) == 'N') {

			if (expression.contains("days") && expression.contains("after")) {
				LocalDateTime ans = today.plusDays(x);
				System.out.println(ans);
			} else if (expression.contains("days") && expression.contains("before")) {
				LocalDateTime ans = today.minusDays(x);
				System.out.println(ans);
			} else if (expression.contains("weeks") && expression.contains("after")) {
				LocalDateTime ans = today.plusWeeks(x);
				System.out.println(ans);
			}

			else if (expression.contains("weeks") && expression.contains("before")) {
				LocalDateTime ans = today.minusDays(x);
				System.out.println(ans);
			} else if (expression.contains("months") && expression.contains("before")) {
				LocalDateTime ans = today.minusMonths(x);
				System.out.println(ans);
			} else if (expression.contains("months") && expression.contains("after")) {
				LocalDateTime ans = today.plusMonths(x);
				System.out.println(ans);
			} else if (expression.contains("years") && expression.contains("before")) {
				LocalDateTime ans = today.minusYears(x);
				System.out.println(ans);
			} else if (expression.contains("years") && expression.contains("after")) {
				LocalDateTime ans = today.plusYears(x);
				System.out.println(ans);
			}

			else {
				System.out.println("Invalid expression");
			}
		}
	}
}
