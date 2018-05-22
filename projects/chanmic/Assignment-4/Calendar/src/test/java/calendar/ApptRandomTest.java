package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 int iteration = 0;
		 long oldElapsed = 0;

		 System.out.println("Start testing Appt...");

		 try{
			for (iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				// System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 24) - 6;
				int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 60) - 1;
				int startDay=ValuesGenerator.getRandomIntBetween(random, 0, 30) -1;
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 0, 12) -1;
				int startYear=ValuesGenerator.getRandomIntBetween(random, 1, 2030) - 5;
				String title="Birthday Party";
				String description="This is my birthday party.";
				String emailAddress="xyz@gmail.com";

				//Construct a new Appointment object with the initial data
				//Construct a new Appointment object with the initial data
						Appt appt = new Appt(startHour,
										 startMinute ,
										 startDay ,
										 startMonth ,
										 startYear ,
										 title,
										description,
										emailAddress);

				if(startMonth < 12){
					appt.setValid();
				}
				else if ((startMonth > 12) && (startDay < 28) && (startDay > 0) && (startYear > 0)){
					appt.setValid();
				}
				else { continue; }
				if(appt.getValid()) {
					for (int i = 0; i < NUM_TESTS; i++) {
						String methodName = ApptRandomTest.RandomSelectMethod(random);
						if (methodName.equals("setTitle")){
							String newTitle = (String) ValuesGenerator.getString(random);
							appt.setTitle(newTitle);
						}
						else if (methodName.equals("setRecurrence")){
							int nullOrNot = ValuesGenerator.getRandomIntBetween(random, 0, 30);
							int[] recurDays;
							if(nullOrNot!=0) {
								int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
								recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
							}
							else {
								recurDays = null;
							}
							int recur=ApptRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
							assertTrue(appt.isOn(startDay, startMonth, startYear));
							assertFalse(appt.isOn(startDay - 1, startMonth, startYear));
							assertFalse(appt.isOn(startDay, startMonth - 1, startYear));
							assertFalse(appt.isOn(startDay, startMonth, startYear - 1));
						}
					}
				}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if(((elapsed%500)==0) && (iteration!=0) && (oldElapsed != elapsed)) {
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
					oldElapsed = elapsed;
				}

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}

}
