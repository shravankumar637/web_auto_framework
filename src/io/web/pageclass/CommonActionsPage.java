package io.web.pageclass;

import java.util.Random;

import io.fold.core.actiondefinitions.PerformAction;
import io.fold.core.actiondefinitions.ValidationTest;
import io.fold.core.actiondefinitions.PerformAction.findType;
import io.fold.core.configuration.ConfigurationPage;

public class CommonActionsPage extends ConfigurationPage
{
	public enum sideDrawerSections
	{
		
		HOME,PATIENTS,CALENDAR,TASKS,MESSAGES,CALLS,LEADS,CAMPAIGNS,ANALYTICS,SETTINGS
	}
	
	
	public enum messageSideDrawerSections
	{
		ASSIGNEDTOME,ASSIGNEDTOOTHER,UNASSIGNED,MENTIONS,MISSEDCALLS,ARCHIVED,ALL,CHATS,SMS,EMAIL,EFAX,INTERNALCHAT
		
	}
	
	
	
	public static void navigateTo(sideDrawerSections sectionName) throws Exception
	{
		
		displayPageClassMethodname();
		try
		{
			logger.info("Msg-Info] : Navigating to "+sectionName);
			
			switch (sectionName)
			
			{
			case HOME:
				PerformAction.clickOnElement(findType.XPATH, locatorMap.get("homeButtonLocator"));
				PerformAction.waitForVisibilityOfElement(findType.XPATH,locatorMap.get("overviewHeaderLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("overviewHeaderLocator")));
			    break;
			    
			case PATIENTS:
				PerformAction.clickOnElement(findType.XPATH,locatorMap.get("patientsButtonLocator"));
//				PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("populationGroupsLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("populationGroupsLocator")));
				break;
				
			case CALENDAR:
				PerformAction.clickOnElement(findType.XPATH,locatorMap.get("calendarButtonLocator"));
				PerformAction.waitForVisibilityOfElement(findType.XPATH,locatorMap.get("scheduleButtonLocator"), 2);
				ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("scheduleButtonLocator"));
				break;
				
			case TASKS:
				PerformAction.clickOnElement(findType.ID,locatorMap.get("tasksButtonLocator"));
				PerformAction.waitForVisibilityOfElement(findType.XPATH,locatorMap.get("addTaskButtonLocator"), 2);
				ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("addTaskButtonLocator"));
				
				break;
				
			case MESSAGES:
				PerformAction.clickOnElement(findType.ID,locatorMap.get("messageButtonLocator"));
				PerformAction.waitForVisibilityOfElement(findType.XPATH,locatorMap.get("createNoteButtonLocator"), 2);
				ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("createNoteButtonLocator"));
				
				break;
				
			case CALLS:
				PerformAction.clickOnElement(findType.XPATH,locatorMap.get("callsButtonLocator"));
				break;
				
				
				
						


			default:
				break;
			}
			
		}
		catch(Exception e)
		{
			pageSnap.capture(e, "BasicUserActions");
			logger.error(e.getMessage());
			
		}
		
	}
	
	
	
	
	public static void messageNavigation(messageSideDrawerSections sectionName) throws Exception
	{
		
		displayPageClassMethodname();
		try
		{
			logger.info("Msg-Info] : Navigating to "+sectionName);
			
			switch (sectionName)
			
			{
			case ASSIGNEDTOME :
				PerformAction.clickOnElement(findType.ID, locatorMap.get("assignToMeTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case ASSIGNEDTOOTHER:
				
				PerformAction.clickOnElement(findType.ID, locatorMap.get("assignToOtherTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case UNASSIGNED:
				PerformAction.clickOnElement(findType.ID, locatorMap.get("unassignedTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case MENTIONS:
				
				PerformAction.clickOnElement(findType.ID, locatorMap.get("mentionsTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
				
			case MISSEDCALLS :
				
				PerformAction.clickOnElement(findType.ID, locatorMap.get("missedCallTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case ARCHIVED :
				
				PerformAction.clickOnElement(findType.ID, locatorMap.get("archivedTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case ALL:
				
				PerformAction.clickOnElement(findType.ID, locatorMap.get("allTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case CHATS:
				PerformAction.clickOnElement(findType.ID, locatorMap.get("chatTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 30);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case SMS:
				PerformAction.clickOnElement(findType.ID, locatorMap.get("smsTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case EMAIL:
				PerformAction.clickOnElement(findType.ID, locatorMap.get("emailTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case EFAX:
				PerformAction.clickOnElement(findType.ID, locatorMap.get("eFaxTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
			case INTERNALCHAT:
				PerformAction.clickOnElement(findType.ID, locatorMap.get("internalTabLocator"));
				PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("selectChatsButtonLocator"), 2);
				verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")));
			    break;
			    
				
			    
			default:
				break;
			}
			
		}
		catch(Exception e)
		{
			pageSnap.capture(e, "BasicUserActions");
			logger.error(e.getMessage());
			
		}
		
	}
	
	public static String generateRandomString(int length) {
		
		 Random random = new Random();
	        StringBuilder sb = new StringBuilder(length);
	        
	        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(CHARACTERS.length());
	            char randomChar = CHARACTERS.charAt(randomIndex);
	            sb.append(randomChar);
	        }
	        
	        return sb.toString();
	}
	
	
}
