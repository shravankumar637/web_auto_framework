package io.web.testclass;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.fold.core.actiondefinitions.PerformAction.findType;
import io.fold.core.actiondefinitions.PerformAction;
import io.fold.core.actiondefinitions.ValidationTest;
import io.web.base.BaseTest;
import io.web.base.GlobalConst;
import io.web.pageclass.CommonActionsPage;
import io.web.pageclass.CommonActionsPage.sideDrawerSections;
import io.web.pageclass.TaskPage;

public class TaskTest extends BaseTest

{
	
	TaskPage taskPage;
	
	@Test(description="To initiate object of task screen",dataProvider = "globaldataprovider")
	public void initTaskPage(HashMap<String,String> dataMap) throws Exception
	{
		
		logger.info("[Msg-Info] : Initializing task screen....");
		taskPage = new TaskPage(webDriver, logger, locatorMap);
	}
	
	
	
	
	@Test(description="Navigate on task screen and verify all elements")
	public void verifyElementsOnTaskScreen()throws Exception
	{
		
		CommonActionsPage.navigateTo(sideDrawerSections.TASKS);
		Thread.sleep(3000);
		if(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("tokenExpiryPopUpLocator")))
		{

			PerformAction.clickOnElement(findType.XPATH,locatorMap.get("crossButtonLocator"));
			verifyFalse(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("tokenExpiryPopUpLocator")),"[Msg-Info] : Token expiry pop up is still opened on screen");
		}
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("assignedButtonLocator"),2);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("assignedToMeButtonLocator")),"[Msg-Info] : 'Assigned To Me' button not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("taskPoolButtonLocator")),"[Msg-Info] : Task pool button not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("createdByMeButtonLocator")),"[Msg-Info] : 'Created By Me' button not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("mentionsButtonLocator")),"[Msg-Info] : Mentions button not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("searchTaskTextFieldLocator")),"[Msg-Info] :'Search Task by title and description' text field not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("addTaskButtonLocator")),"[Msg-Info] : Add Task button locator not found on task screen");
		//verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("sortTaskIconLocator")),"[Msg-Info] : Short task icon not found on task screen");
		//verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("clearAllButtonLocator")),"[Msg-Info] : Clear all button not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("assignedToButtonLocator")),"[Msg-Info] : Assigned to button not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("viewByButtonLocator")),"[Msg-Info] : View by button not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("memberButtonLocator")),"[Msg-Info] : Member button not found on task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("priorityButtonLocator")),"[Msg-Info] : Priority button not found on task screen");
		
		
	}
	
	@Test(description="Open add new task screen and verify element")
	public void openAddNewTaskScreenandVerifyElement()throws Exception
	{
		PerformAction.fluentWaitForVisibilityOfElement(findType.XPATH, locatorMap.get("addTaskButtonLocator"));
		Thread.sleep(3000);
		PerformAction.clickOnElement(findType.XPATH,locatorMap.get("addTaskButtonLocator"));
		PerformAction.fluentWaitForVisibilityOfElement(findType.XPATH, locatorMap.get("saveButtonLocator"));
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("saveButtonLocator")),"[Msg-Info] : Task screen is not opened yet");
		CommonActionsTest.clickOnCancelButton();

		
	}
	
	@Test(description="Verify elements on add new task screen",dataProvider = "globaldataprovider")
	public void verifyElementsOnAddNewTaskScreen(HashMap<String,String> dataMap)throws Exception
	{
		
		CommonActionsPage.navigateTo(sideDrawerSections.TASKS);
		Thread.sleep(3000);
		PerformAction.clickOnElement(findType.XPATH,locatorMap.get("addTaskButtonLocator"));
		Thread.sleep(3000);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("taskTitleLabelLocator")),"[Msg-Info] :Title label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("taskDescriptionFieldLocator")),"[Msg-Info] :Task description text field not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("attachFiledButtonLocator")),"[Msg-Info] :Attach file button not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("addSubtaskButtonLocator")),"[Msg-Info] :Add subtask button not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("assignToLabelLocator")),"[Msg-Info] :Assign to label not found on add task screen");
		logger.info("heheheh");
//		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("assignToTextFieldLocator").replace("replace",dataMap.get("assignToName"))),"[Msg-Info] :Assign to not found on add task screen");
		logger.info("i passed ");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("taskPoolLabelLocator")),"[Msg-Info] :Task pool label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("dueDateLocator")),"[Msg-Info] :Due date label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("calendarIconLocator")),"[Msg-Info] :Calendar icon not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("priorityButtonLocator")),"[Msg-Info] :Priority label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("memberLabelLocator")),"[Msg-Info] :Member label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("addMemberTaskMessageLocator")),"[Msg-Info] :Add member label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("activityLabelLocator")),"[Msg-Info] :Activity label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("automationLablelLocator")),"[Msg-Info] :Automation label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("showLabelLocator")),"[Msg-Info] :Show :label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("allLabelLocator")),"[Msg-Info] :Show : All label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("commentsLabelLocator")),"[Msg-Info] :Comment label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("historyLabelLocator")),"[Msg-Info] :History label not found on add task screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("addCommentTextFieldLocator")),"[Msg-Info] :Add comment text field not found on add task screen");
		CommonActionsTest.clickOnCancelButton();
	
		
		
	}
	
	
	@Test(description="Add data on add task screen and verify elements",dataProvider = "globaldataprovider")
	public void addTaskDataandVerify(HashMap<String,String> dataMap)throws Exception
	{
		
		
		CommonActionsPage.navigateTo(sideDrawerSections.TASKS);
		Thread.sleep(3000);
		if(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("tokenExpiryPopUpLocator")))
		{

			PerformAction.clickOnElement(findType.XPATH,locatorMap.get("crossButtonLocator"));
			verifyFalse(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("tokenExpiryPopUpLocator")),"[Msg-Info] : Token expiry pop up is still opened on screen");
		}
		PerformAction.clickOnElement(findType.XPATH,locatorMap.get("addTaskButtonLocator"));
		Thread.sleep(3000);
		PerformAction.enterTextInElement(findType.ID,locatorMap.get("addTaskFieldLocator"),dataMap.get("taskName"));
		PerformAction.enterTextInElement(findType.XPATH,locatorMap.get("taskDescriptionFieldLocator"),dataMap.get("taskDescription"));
		Thread.sleep(3000);
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("assign2TextFieldLocator"));
		Thread.sleep(3000);
		String patientName = dataMap.get("patientFName") + " " + dataMap.get("patientLName");
		webDriver.findElement(By.xpath(locatorMap.get("assign2TextFieldLocator")))
	    .sendKeys(patientName);
		PerformAction.clickOnElement(findType.XPATH, "//span[contains(text(),'"+patientName+"')]");
		
		CommonActionsTest.clickOnSaveButton();
		Thread.sleep(2000);
		
	}
	
	

}
