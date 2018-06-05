/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.*;
import static org.junit.Assert.*;
import calendar.Appt;

public class ApptTest {
	@Test(timeout = 4000)
	public void test_00() throws Throwable {
		int days = CalendarUtil.NumDaysInMonth(2018, 0);
		assertEquals(31, days);
		days = CalendarUtil.NumDaysInMonth(2018, 1);
		assertEquals(28, days);
		days = CalendarUtil.NumDaysInMonth(2016, 1);
		assertEquals(29, days);
		days = CalendarUtil.NumDaysInMonth(2016, 2);
		assertEquals(31, days);
		days = CalendarUtil.NumDaysInMonth(2018, 11);
		assertEquals(31, days);

		boolean leap = CalendarUtil.IsLeapYear(2018);
		assertFalse(leap);
		leap = CalendarUtil.IsLeapYear(2016);
		assertTrue(leap);
		leap = CalendarUtil.IsLeapYear(2000);
		assertTrue(leap);
		leap = CalendarUtil.IsLeapYear(1900);
		assertFalse(leap);
	}
	@Test(timeout = 4000)
	public void test01() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt0.setValid();
		assertTrue(appt0.getValid());
		String string0 = appt0.toString();
		assertFalse(appt0.isRecurring());

		assertEquals(0, appt0.getRecurIncrement());
	}
	@Test(timeout = 4000)
	public void test02() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt5 = new Appt(15, 30, 4, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt5.setValid();
		assertTrue(appt5.getValid());
		String string0 = appt5.toString();
		System.out.println(string0);
		assertEquals("\t4/4/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
	}
	@Test(timeout = 4000)
	public void test03() throws Throwable {
		//hour, minute, day, month, year, title, desc, email
		Appt appt0 = new Appt(00, 30, 4, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt0.setValid();
		assertTrue(appt0.getValid());
	}
	@Test(timeout = 4000)
	public void test04() throws Throwable {
		Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals(30, appt1.getStartMinute());
		assertEquals(15, appt1.getStartHour());
		assertEquals(9, appt1.getStartDay());
		assertEquals(4, appt1.getStartMonth());
		assertEquals(2018, appt1.getStartYear());
		assertEquals("Birthday Party", appt1.getTitle());
		assertEquals("This is my birthday party", appt1.getDescription());
		assertEquals("xyz@gmail.com", appt1.getEmailAddress());
		assertTrue(appt1.hasTimeSet());
		assertTrue(appt1.isOn(9, 4, 2018));
		assertFalse(appt1.isOn(10, 14, 2018));
		assertFalse(appt1.isOn(9, 15, 2018));
		assertFalse(appt1.isOn(9, 14, 2019));
		appt1.setValid();
		assertTrue(appt1.getValid());
		assertFalse(appt1.isRecurring());
	}
	@Test(timeout = 4000)
	public void test05() throws Throwable {
		Appt appt2 = new Appt(0, 00, 10, 5, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals(00, appt2.getStartMinute());
		assertEquals(0, appt2.getStartHour());
		assertTrue(appt2.hasTimeSet());
		assertTrue(appt2.isOn(10, 5, 2019));
		appt2.setValid();
		assertTrue(appt2.getValid());
	}
	@Test(timeout = 4000)
	public void test06() throws Throwable {
		Appt appt3 = new Appt(12, 01, 10, 5, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals(01, appt3.getStartMinute());
		assertEquals(12, appt3.getStartHour());
		assertTrue(appt3.hasTimeSet());
		assertTrue(appt3.isOn(10, 5, 2019));
		appt3.setValid();
		assertTrue(appt3.getValid());
	}
	@Test(timeout = 4000)
	public void test07() throws Throwable {
		Appt appt4 = new Appt(23, 01, 10, 5, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals(01, appt4.getStartMinute());
		assertEquals(23, appt4.getStartHour());
		assertTrue(appt4.hasTimeSet());
		assertTrue(appt4.isOn(10, 5, 2019));
		appt4.setValid();
		assertTrue(appt4.getValid());
	}

	@Test(timeout = 4000)
	public void test08() throws Throwable {
		Appt appt5 = new Appt(9, 01, 32, 4, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertEquals(32, appt5.getStartDay());
		assertEquals(4, appt5.getStartMonth());
		assertTrue(appt5.hasTimeSet());
		assertTrue(appt5.isOn(32, 4, 2019));
		appt5.setValid();
		appt5.toString();
		assertFalse(appt5.getValid());
	}
	@Test(timeout = 4000)
	public void test09() throws Throwable {
		Appt appt5 = new Appt(9, 01, 0, 4, 2019, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt5.setValid();
		assertFalse(appt5.getValid());
	}

	@Test(timeout = 4000)
	public void test10() throws Throwable {
		Appt appt5 = new Appt(25, 65, 35, 14, -1, null, null, null);
		appt5.setValid();
		assertFalse(appt5.getValid());
	}

	@Test(timeout = 4000)
	public void test11() throws Throwable {
		Appt appt5 = new Appt(15, 65, 5, 4, 2000, null, null, null);
		appt5.setValid();
		assertFalse(appt5.getValid());
		Appt appt6 = new Appt(15, -60, 5, 4, 2000, null, null, null);
		appt6.setValid();
		assertFalse(appt6.getValid());
	}

	@Test(timeout = 4000)
	public void test12() throws Throwable {
		Appt appt0 = new Appt(35, 4, 2018, null, null, null);
		appt0.setValid();
		assertFalse(appt0.getValid());
		Appt appt1 = new Appt(-1, 4, 2018, null, null, null);
		appt1.setValid();
		assertFalse(appt1.getValid());
	}

	@Test(timeout = 4000)
	public void test13() throws Throwable {
		Appt appt0 = new Appt(5, -1, 2018, null, null, null);
		appt0.setValid();
		assertFalse(appt0.getValid());
		Appt appt1 = new Appt(5, 13, 2018, null, null, null);
		appt1.setValid();
		assertFalse(appt1.getValid());
	}

	@Test(timeout = 4000)
	public void test14() throws Throwable {
		Appt appt0 = new Appt(5, 4, -1, null, null, null);
		appt0.setValid();
		assertFalse(appt0.getValid());
	}

	@Test(timeout = 4000)
	public void test15() throws Throwable {
		Appt appt0 = new Appt(9, 60, 15, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt0.setValid();
		assertFalse(appt0.getValid());
		appt0.setStartMinute(-1);
		appt0.setValid();
		assertFalse(appt0.getValid());

		Appt appt1 = new Appt(25, 01, 15, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt1.setValid();
		assertFalse(appt1.getValid());
		appt1.setStartHour(-1);
		appt1.setValid();
		assertFalse(appt1.getValid());

		Appt appt2 = new Appt(13, 01, 0, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt2.setValid();
		assertFalse(appt2.getValid());

		Appt appt3 = new Appt(13, 01, 35, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt3.setValid();
		assertFalse(appt3.getValid());

		Appt appt4 = new Appt(13, 01, 15, 13, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt4.setValid();
		assertFalse(appt4.getValid());
		appt4.setStartMonth(-1);
		appt4.setValid();
		assertFalse(appt4.getValid());

		Appt appt5 = new Appt(9, 01, 15, 4, -1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt5.setValid();
		assertFalse(appt5.getValid());

	}

	@Test(timeout = 4000)
	public void test16() throws Throwable {
		Appt appt0 = new Appt(15, 4, 2018, null, null, null);
		appt0.setValid();
		assertFalse(appt0.getValid());
		assertFalse(appt0.hasTimeSet());
	}

	@Test(timeout = 4000)
	public void test17() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		int[] recurDaysArr= {2};
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		assertEquals(Appt.RECUR_NUMBER_FOREVER, appt0.getRecurNumber());
		assertEquals(Appt.RECUR_BY_WEEKLY, appt0.getRecurBy());
		assertEquals(recurDaysArr, appt0.getRecurDays());
		assertEquals(2, appt0.getRecurIncrement());
		appt0.setValid();
		assertTrue(appt0.getValid());
	}

	@Test(timeout = 4000)
	public void test18() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		int[] recurDaysArr= {2};
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_MONTHLY, 2, 2);
		assertEquals(2, appt0.getRecurNumber());
		assertEquals(Appt.RECUR_BY_MONTHLY, appt0.getRecurBy());
		assertEquals(recurDaysArr, appt0.getRecurDays());
		appt0.setValid();
		assertTrue(appt0.getValid());
	}

	@Test(timeout = 4000)
	public void test19() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		int[] recurDaysArr= {2};
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 2, 4);
		assertEquals(4, appt0.getRecurNumber());
		assertEquals(Appt.RECUR_BY_YEARLY, appt0.getRecurBy());
		assertEquals(recurDaysArr, appt0.getRecurDays());
		appt0.setValid();
		assertTrue(appt0.getValid());
	}

	@Test(timeout = 4000)
	public void test20() throws Throwable {
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		int[] recurDaysArr= null;
		appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_YEARLY, 1, 4);
		assertEquals(4, appt0.getRecurNumber());
		}
}
