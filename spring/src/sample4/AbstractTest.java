﻿package sample4;
import java.util.Calendar;
import java.util.GregorianCalendar;
public abstract class AbstractTest {
	public abstract String dayInfo();	
	public static AbstractTest getInstance(){
		GregorianCalendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_WEEK);
		/* abstract class는 팩토리 메서드여야 하고 해당클래스 내용과 같아야 한다. */
		AbstractTest test = null;
		switch(day)
		{
			case 1 : test = new Sunday(); break;
			case 2 : test = new Monday(); break;
			case 3 : test = new Tuesday(); break;
			case 4 : test = new Wednesday(); break;
			case 5 : test = new Thursday(); break;
			case 6 : test = new Friday(); break;
			case 7 : test = new Saturday(); break;
		}
		return test;
	}
}
