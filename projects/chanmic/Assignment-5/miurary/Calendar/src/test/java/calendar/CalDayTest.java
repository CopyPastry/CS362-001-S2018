/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class CalDayTest{

	@Test(timeout = 4000)
	public void test00()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue(calday0.isValid());
		assertEquals(1, calday0.getSizeAppts());
		assertEquals(sDay, calday0.getDay());
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\t3:30PM Birthday Party This is my birthday party ";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals(strTest, strOut);

		Appt appt2 = new Appt(10, 5, sDay, sMonth, sYear, "Test 3", "Testing calday", "xyz@gmail.com");
		assertTrue(appt2.getValid());
		calday0.addAppt(appt2);
		assertEquals(2, calday0.getSizeAppts());
		assertTrue(calday0.isValid());
	}
	@Test(timeout = 4000)
	public void test01()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue(calday0.isValid());
		assertEquals(1, calday0.getSizeAppts());
		assertEquals(sDay, calday0.getDay());

		Appt appt1 = new Appt(0, 8, sDay, sMonth, sYear, "Test 2", "Test calday", "xyz@gmail.com");
		assertTrue(appt1.getValid());
		calday0.addAppt(appt1);
		assertEquals(2, calday0.getSizeAppts());
	}

	@Test(timeout = 4000)
	public void test02()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue(calday0.isValid());
		assertEquals(1, calday0.getSizeAppts());
		assertEquals(sDay, calday0.getDay());
		Appt appt1 = new Appt(0, 8, sDay, sMonth, sYear, "Test 2", "Test calday", "xyz@gmail.com");
		assertTrue(appt1.getValid());
		calday0.addAppt(appt1);
		assertEquals(2, calday0.getSizeAppts());
		assertEquals(2, calday0.getSizeAppts());
		LinkedList<Appt> apptlist = calday0.getAppts();
		Appt appt2 = apptlist.get(0);
	}

	@Test(timeout = 4000)
	public void test03()	throws Throwable	{
		Appt appt0 = new Appt(-1, -1, 4, 4, 2018, null, null, null);
		appt0.setValid();
		assertFalse(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(4, 4, 2018);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue(calday0.isValid());
		assertEquals(0, calday0.getSizeAppts());
	}

	@Test(timeout = 4000)
	public void test04()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(5, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue(calday0.isValid());
		assertEquals(1, calday0.getSizeAppts());
		assertEquals(sDay, calday0.getDay());
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\t5:30AM Birthday Party This is my birthday party ";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals(strTest, strOut);
	}
	@Test(timeout = 4000)
	public void test05()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(14, 9, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\t2:09PM Birthday Party This is my birthday party ";
		assertEquals(strTest, strOut);
	}
	@Test(timeout = 4000)
	public void test06()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(12, 10, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);

		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\t0:10AM Birthday Party This is my birthday party ";
		assertEquals(strTest, strOut);
	}
	@Test(timeout = 4000)
	public void test07()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue(calday0.isValid());
		assertEquals(1, calday0.getSizeAppts());
		assertEquals(sDay, calday0.getDay());
		Appt appt1 = new Appt(10, 8, sDay, sMonth, sYear, "Test 2", "Test calday", "xyz@gmail.com");
		assertTrue(appt1.getValid());
		calday0.addAppt(appt1);
		assertEquals(2, calday0.getSizeAppts());
		Appt appt2 = new Appt(10, 5, sDay, sMonth, sYear, "Test 3", "Testing calday", "xyz@gmail.com");
		assertTrue(appt2.getValid());
		calday0.addAppt(appt2);
		assertEquals(3, calday0.getSizeAppts());
		assertTrue(calday0.isValid());
	}
	@Test(timeout = 4000)
	public void test08()	throws Throwable	{
		CalDay constCD = new CalDay();
		assertFalse(constCD.isValid());
	}
	@Test(timeout = 4000)
	public void test09()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertTrue(calday0.isValid());
		assertEquals(1, calday0.getSizeAppts());
		assertEquals(sDay, calday0.getDay());
	}
	@Test(timeout = 4000)
	public void test10()	throws Throwable	{
		int sDay = -1;
		int sMonth = 5;
		int sYear = 2018;
		Appt appt0 = new Appt(0, 30, sDay, sMonth, sYear, "A2", null, null);
		appt0.setValid();
		assertFalse(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		assertEquals(0, calday0.getSizeAppts());
		String strOut = calday0.toString();
		String strTest = "\t --- 6/30/2018 --- \n"
				+ " --- -------- Appointments ------------ --- \n\n";
		assertEquals(strTest, strOut);
	}
	@Test(timeout = 4000)
	public void test11()	throws Throwable	{
		Appt appt0 = new Appt(0, 30, -1, 5, 2018, "A2", null, null);
		appt0.setValid();
		assertFalse(appt0.getValid());
		Appt appt1 = new Appt(2, 30, -1, 5, 2018, "A2", null, null);
		appt1.setValid();
		assertFalse(appt1.getValid());
		GregorianCalendar testDay = new GregorianCalendar(-1, 5, 2018);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		calday0.addAppt(appt1);
		assertEquals(0, calday0.getSizeAppts());
	}
	@Test(timeout = 4000)
	public void test12()	throws Throwable	{
		int sDay = 9;
		int sMonth = 4;
		int sYear = 2018;
		Appt appt0 = new Appt(sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		assertTrue(appt0.getValid());
		GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
		CalDay calday0 = new CalDay(testDay);
		calday0.addAppt(appt0);
		String strOut = calday0.getFullInfomrationApp(calday0);
		String strTest = "5-9-2018 \n\tBirthday Party This is my birthday party ";
		System.out.println(strOut);
		System.out.println(strTest);
		assertEquals(strTest, strOut);
	}

}
