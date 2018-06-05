
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    DataHandler dh0 = new DataHandler();
    Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue(dh0.saveAppt(appt0));
    assertTrue(dh0.deleteAppt(appt0));
    Appt appt1 = new Appt(-1, -1, -1, -1, -1, null, null, null);
    appt1.setValid();
    assertFalse(dh0.saveAppt(appt1));
    assertFalse(dh0.deleteAppt(appt1));
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    DataHandler dh0 = new DataHandler();
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		int[] recur= {2};
		appt0.setRecurrence(recur, Appt.RECUR_BY_MONTHLY, 2, 2);
		appt0.setValid();
		assertTrue(appt0.getValid());
		boolean output = dh0.saveAppt(appt0);
		assertTrue(output);
  }
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar2.xml", false);
    Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue(dh0.saveAppt(appt0));
    assertTrue(dh0.deleteAppt(appt0));
  }
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar3.xml",true);
    Appt appt0 = new Appt(5, 30, 3, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
    appt0.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 2, 2);
    appt0.setValid();
    assertTrue(appt0.getValid());
    dh0.saveAppt(appt0);

    Appt appt1 = new Appt(5, 50, 5, 4, 2018, null, null, null);
    appt0.setRecurrence(null, Appt.RECUR_BY_MONTHLY, 2, 2);
    appt1.setValid();
    dh0.saveAppt(appt1);
    assertTrue(appt1.getValid());

    GregorianCalendar day1 = new GregorianCalendar(2018,3,3);
    GregorianCalendar day2 = new GregorianCalendar(2018,8,6);
    LinkedList<CalDay> calDays = new LinkedList<CalDay>();
    calDays = (LinkedList<CalDay>) dh0.getApptRange(day1,day2);
    int firstappointment = 0;
    for(int i=0; i< calDays.size();i++) {
      LinkedList<Appt> apptlist = calDays.get(i).getAppts();
      if((firstappointment==0)&&(apptlist.size()>0)){
        firstappointment = i;
      }
    }
    LinkedList<Appt> apptlist = calDays.get(firstappointment).getAppts();
    Appt appt2 = apptlist.get(0);
    String string0 = appt2.toString();
  }
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar4.xml",true);
		Appt appt0 = new Appt(5, 30, 4, 4, 2018, "A3", "Appt2", "xyz@gmail.com");
		int[] recur= {0};
		appt0.setRecurrence(recur, Appt.RECUR_BY_YEARLY, 1, 10);
		appt0.setValid();
		assertTrue(appt0.getValid());
		dh0.saveAppt(appt0);

		GregorianCalendar day1 = new GregorianCalendar(2019,3,4);
		GregorianCalendar day2 = new GregorianCalendar(2019,5,6);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dh0.getApptRange(day1,day2);
		CalDay calday0;
		String string0;
		int firstappointment = -1;
		for(int i=0; i< calDays.size();i++) {
			LinkedList<Appt> apptlist = calDays.get(i).getAppts();
			if((firstappointment==-1)&&(apptlist.size()>0)){
				firstappointment = i;
			}
		}
		if(firstappointment != -1) {
			calday0 = calDays.get(firstappointment);
			string0 = calday0.getFullInfomrationApp(calday0);
			System.out.println(string0);
		}
		else {
			fail("Should have an appointment");
		}
  }
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar6.xml",true);
		Appt appt0 = new Appt(5, 30, 4, 4, 2018, "A3", "Appt2", "xyz@gmail.com");
		int[] recur= {0};
		appt0.setRecurrence(recur, Appt.RECUR_BY_YEARLY, 1, 10);
		appt0.setValid();
		assertTrue(appt0.getValid());
		dh0.saveAppt(appt0);
		GregorianCalendar day1 = new GregorianCalendar(2018,10,4);
		GregorianCalendar day2 = new GregorianCalendar(2018,10,5);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dh0.getApptRange(day1,day2);
		assertEquals(1, calDays.size());
  }
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar6.xml",true);
		Appt appt0 = new Appt(5, 30, 4, 4, 2018, "A3", "Appt2", "xyz@gmail.com");
		int[] recur= {0};
		appt0.setRecurrence(recur, Appt.RECUR_BY_MONTHLY, 1, 10);
		appt0.setValid();
		assertTrue(appt0.getValid());
		dh0.saveAppt(appt0);

		GregorianCalendar day1 = new GregorianCalendar(2018,5,3);
		GregorianCalendar day2 = new GregorianCalendar(2018,6,6);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dh0.getApptRange(day1,day2);
		CalDay calday0;
		String string0;
		int firstappointment = -1;
		for(int i=0; i< calDays.size();i++) {
			LinkedList<Appt> apptlist = calDays.get(i).getAppts();
			if((firstappointment==-1)&&(apptlist.size()>0)){
				firstappointment = i;
			}
		}
		if(firstappointment != -1) {
			calday0 = calDays.get(firstappointment);
			string0 = calday0.getFullInfomrationApp(calday0);
			System.out.println(string0);
		}
		else {
			fail("Should have an appointment");
		}
  }
  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar13.xml",true);
		Appt appt0 = new Appt(5, 31, 4, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		int[] recur= {2,3,4};
		appt0.setRecurrence(recur, Appt.RECUR_BY_WEEKLY, 10, Appt.RECUR_NUMBER_FOREVER);
		appt0.setValid();
		assertTrue("valid", appt0.getValid());
		dh0.saveAppt(appt0);

		GregorianCalendar day1 = new GregorianCalendar(2018,4,5);
		GregorianCalendar day2 = new GregorianCalendar(2018,5,10);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dh0.getApptRange(day1,day2);
		CalDay calday0;
		String string0;
		int firstappointment = -1;
		for(int i=0; i< calDays.size();i++) {
			LinkedList<Appt> apptlist = calDays.get(i).getAppts();
			if((firstappointment==-1)&&(apptlist.size()>0)){
				firstappointment = i;
			}
		}
		if(firstappointment != -1) {
			calday0 = calDays.get(firstappointment);
			string0 = calday0.getFullInfomrationApp(calday0);
			System.out.println(string0);
		}
		else {
			fail("Should have an appointment");
		}
  }
  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar2.xml",true);
		Appt appt0 = new Appt(5, 32, 4, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		int[] recur= null;
		appt0.setRecurrence(recur, Appt.RECUR_BY_WEEKLY, 10, Appt.RECUR_NUMBER_FOREVER);
		appt0.setValid();
		assertTrue(appt0.getValid());
		dh0.saveAppt(appt0);

		GregorianCalendar day1 = new GregorianCalendar(2018,4,5);
		GregorianCalendar day2 = new GregorianCalendar(2018,5,10);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dh0.getApptRange(day1,day2);
		CalDay calday0;
		String string0;
		int firstappointment = -1;
		for(int i=0; i< calDays.size();i++) {
			LinkedList<Appt> apptlist = calDays.get(i).getAppts();
			if((firstappointment==-1)&&(apptlist.size()>0)){
				firstappointment = i;
			}
		}
		if(firstappointment != -1) {
			calday0 = calDays.get(firstappointment);
			string0 = calday0.getFullInfomrationApp(calday0);
			System.out.println(string0);
		}
		else {
			fail("Should have an appointment");
		}
  }
  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar3.xml",true);
		Appt appt0 = new Appt(5, 32, 4, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		int[] recur= null;
		appt0.setRecurrence(recur, Appt.RECUR_BY_WEEKLY, 10, Appt.RECUR_NUMBER_FOREVER);
		appt0.setValid();
		assertTrue(appt0.getValid());
		dh0.saveAppt(appt0);

		GregorianCalendar day1 = new GregorianCalendar(2018,4,5);
		GregorianCalendar day2 = new GregorianCalendar(2018,5,10);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		try {
			calDays = (LinkedList<CalDay>) dh0.getApptRange(day2,day1);
			fail("Should fail");
		} catch (DateOutOfRangeException e) {
			System.err.println(e.toString());
		}
  }
  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar8.xml",true);
		Appt appt0 = new Appt(5, 33, 2, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		int[] recur= {3,4};
		appt0.setRecurrence(recur, Appt.RECUR_BY_WEEKLY, 1, 30);
		appt0.setValid();
		assertTrue(appt0.getValid());
		dh0.saveAppt(appt0);

		GregorianCalendar day1 = new GregorianCalendar(2018,5,5);
		GregorianCalendar day2 = new GregorianCalendar(2018,5,12);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dh0.getApptRange(day1,day2);
		CalDay calday0;
		String string0;
		int firstappointment = -1;
		for(int i=0; i< calDays.size();i++) {
			LinkedList<Appt> apptlist = calDays.get(i).getAppts();
			if((firstappointment==-1)&&(apptlist.size()>0)){
				firstappointment = i; 
			}
		}
		if(firstappointment != -1) {
			calday0 = calDays.get(firstappointment);
			string0 = calday0.getFullInfomrationApp(calday0);
			System.out.println(string0);
		}
		else {
			fail("Should have an appointment");
		}
  }
  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
    DataHandler dh0 = new DataHandler("calendar4.xml",false);
		Appt appt0 = new Appt(15, 30, 4, 4, 2018, "A2", "Appt2", "xyz@gmail.com");
		appt0.setValid();
		dh0.saveAppt(appt0);
		assertTrue(appt0.getValid());

		Appt appt1 = new Appt(5, 5, 5, 4, 2018, null, null, null);
		appt1.setValid();
		dh0.saveAppt(appt1);
		assertTrue(appt1.getValid());

		GregorianCalendar day1 = new GregorianCalendar(2018,3,4);
		GregorianCalendar day2 = new GregorianCalendar(2018,4,6);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = (LinkedList<CalDay>) dh0.getApptRange(day1,day2);
		int numappts = 0;
		for(int i=0; i < calDays.size();i++) {
			LinkedList<Appt> apptlist = calDays.get(i).getAppts();
			numappts += apptlist.size();
		}
		LinkedList<Appt> apptlist = calDays.get(0).getAppts();
		Appt appt2 = apptlist.get(0);
		String string0 = appt2.toString();
  }

}
