package io.web.testclass;
import org.testng.annotations.Test;

import io.fold.core.actiondefinitions.PerformAction;
import io.fold.core.actiondefinitions.ValidationTest;
import io.fold.core.actiondefinitions.PerformAction.findType;
import io.web.base.BaseTest;

public class CommonActionsTest extends BaseTest
{


	@Test(description="Click on Save button")
	public static void clickOnSaveButton()throws Exception
	{
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("saveButtonLocator")),"[Msg-Info] :Save button not found on screen");
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("saveButtonLocator"));
	}
	
	@Test(description="Click on Cancel button")
	public static void clickOnCancelButton()throws Exception
	{
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("cancelButtonLocator")),"[Msg-Info] :Cancel button not found on screen");
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("cancelButtonLocator"));
	}
	
}
