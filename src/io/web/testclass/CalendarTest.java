package io.web.testclass;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.fold.core.actiondefinitions.PerformAction.findType;
import io.fold.core.actiondefinitions.ValidationTest;
import io.web.base.BaseTest;
import io.web.pageclass.CalendarPage;
import io.web.pageclass.CommonActionsPage;
import io.web.pageclass.CommonActionsPage.sideDrawerSections;

public class CalendarTest extends BaseTest

{
	CalendarPage calendarpage;
	
	
	@Test(description="To initiate calendar view screen",dataProvider = "globaldataprovider")
	public void initCalendarPage(HashMap<String,String> dataMap) throws Exception
	{
		
		logger.info("[Msg-Info] : Initializing calendar screen....");
		calendarpage = new CalendarPage(webDriver, logger, dataMap);
		
	}
	

	@Test(description = "Verify scheduled patient on calendar view",dataProvider = "globaldataprovider")
	public void verifyScheduledPatientOnCalendar(HashMap<String,String> dataMap) throws Exception
	{
		
		
		CommonActionsPage.navigateTo(sideDrawerSections.CALENDAR);
		ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("patientLocatorOnCalendar").replace("replace",dataMap.get("patientName")));
	}
	
	
}
