package io.web.testclass;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.fold.core.actiondefinitions.ValidationTest;
import io.fold.core.actiondefinitions.PerformAction;
import io.fold.core.actiondefinitions.PerformAction.findType;
import io.fold.core.actiondefinitions.PerformAction.loadingType;
import io.web.base.BaseTest;
import io.web.pageclass.CommonActionsPage;
import io.web.pageclass.CommonActionsPage.messageSideDrawerSections;
import io.web.pageclass.CommonActionsPage.sideDrawerSections;
import io.web.pageclass.MessagePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class MessageTest extends BaseTest{
	
	MessagePage messagepage;
	
	@Test(description="To initiate object of message screen",dataProvider = "globaldataprovider")
	public void initMessagePage(HashMap<String,String> dataMap) throws Exception
	{
		
		logger.info("[Msg-Info] : Initializing aNet screen....");
		messagepage = new MessagePage(webDriver, logger, locatorMap);
	}
	
	
	
	@Test(description="Navigate on message screen and verify all elements")
	public void verifyElementsOnMessageScreen()throws Exception
	{

		CommonActionsPage.navigateTo(sideDrawerSections.MESSAGES);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("assignToMeTabLocator")),"[Msg-Info] : Assigned to me tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("assignToOtherTabLocator")),"[Msg-Info] : Assigned to other tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("unassignedTabLocator")),"[Msg-Info] : Unassigned tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("mentionsTabLocator")),"[Msg-Info] : Mentions tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("missedCallTabLocator")),"[Msg-Info] : Missed call tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("allTabLocator")),"[Msg-Info] : All tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("chatTabLocator")),"[Msg-Info] : Chat tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("smsTabLocator")),"[Msg-Info] : SMS tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("emailTabLocator")),"[Msg-Info] : Email tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("eFaxTabLocator")),"[Msg-Info] : eFax tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("internalTabLocator")),"[Msg-Info] : Internal chat tab not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("inboxHeaderLocator")),"[Msg-Info] : Inbox header not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("settingButtonLocator")),"[Msg-Info] : Setting button not found on message screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("settingButtonLocator")),"[Msg-Info] : Setting button not found on message screen");
		

  }
	
	
	@Test(description="Navigate on chat screen and verify elements")
	public void navigateOnChatScreenAndVerifyElements()throws Exception
	{
		if(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("tokenExpiryPopUpLocator")))
		{

			PerformAction.clickOnElement(findType.XPATH,locatorMap.get("crossButtonLocator"));
			verifyFalse(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("tokenExpiryPopUpLocator")),"[Msg-Info] : Token expiry pop up is still opened on screen");
		}
		
			
		PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("chatTabLocator"), 60);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("chatTabLocator")),"[Msg-Info] : Chat button not found on chat screen");
		CommonActionsPage.messageNavigation(messageSideDrawerSections.CHATS);
     	//PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
     	//PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("selectChatsButtonLocator"), 80);

		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectChatsButtonLocator")),"[Msg-Info] : Select chats button not found on chat screen");

		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("archiveButtonLocator")),"[Msg-Info] : Archive button not found on chat screen");
		PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("assignButtonLocator"), 60);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("assignButtonLocator")),"[Msg-Info] : Assign button not found on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("searchButtonLocator")),"[Msg-Info] : Search button not found on chat screen");
		PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("moreButtonLocator"), 30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("moreButtonLocator")),"[Msg-Info] : More button not found on chat screen");
		PerformAction.clickOnElement(findType.ID, locatorMap.get("moreButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("editGroupButtonLocator"), 30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("copyButtonLocator")),"[Msg-Info] : Copy button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("editGroupButtonLocator")),"[Msg-Info] : Edit Group button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("callsMoreButtonLocator")),"[Msg-Info] : Calls button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("smsMoreButtonLocator")),"[Msg-Info] : SMS button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("emailMoreButtonLocator")),"[Msg-Info] : Email button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("videoMoreButtonLocator")),"[Msg-Info] : Video button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("chartMoreButtonLocator")),"[Msg-Info] : Chart button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("appointmentMoreButtonLocator")),"[Msg-Info] : Appointment button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("filesMoreButtonLocator")),"[Msg-Info] : Files button not found on more pop up on chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("scheduledMessagesMoreButtonLocator")),"[Msg-Info] :Schedule message button not found on more pop up on chat screen");	
		
		
	}
	
	
	@Test(description="Navigate on new chat screen from global chat action")
	public void navigateOnNewChatScreenFromGlobalAction()throws Exception
	{
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("createNewGlobalButtonLocator")),"[Msg-Info] : Create new global button not found on screen");
		PerformAction.clickOnElement(findType.XPATH,locatorMap.get("createNewGlobalButtonLocator"));
     	//PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("startNewLabelLocator"), 20);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("globalChatButtonLocator")),"[Msg-Info] : Global chat button not found on screen");
		PerformAction.clickOnElement(findType.XPATH,locatorMap.get("globalChatButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("groupChatHeaderLocator"), 20);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("groupChatHeaderLocator")),"[Msg-Info] : New chat screen is not opened yet");

		
	}
	
	
	@Test(description="Verify all elements on new chat screen",dataProvider = "globaldataprovider")
	public void verifyElementsOnNewChatScreen(HashMap<String,String> dataMap)throws Exception
	{
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("groupChatHeaderLocator"), 50);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("groupChatHeaderLocator")),"[Msg-Info] : New chat screen header not found");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("startChatButtonLocator")),"[Msg-Info] :Start chat button not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("typeLabelLocator")),"[Msg-Info] :Type label not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("typeDropDownLocator").replace("replace",dataMap.get("chatType1"))),"[Msg-Info] :Type drop down not found on new chat screen");
		//verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("patientLabelLocator")),"[Msg-Info] :Patient label not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("patientTextFieldLocator")),"[Msg-Info] :Patient text field not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("groupNameLabelLocator")),"[Msg-Info] :Group name label not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("groupNameTextFieldLocator")),"[Msg-Info] :Group name text field not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("internalUserLabelLocator")),"[Msg-Info] :Internal user label not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("internalTextFieldLocator")),"[Msg-Info] :Internal user ext field not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("familyMemberLabelLocator")),"[Msg-Info] :Family Member label not found on new chat screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("familyMemberTextFieldLocator")),"[Msg-Info] :Family Member text field not found on new chat screen");	
		
	}
	
	
	@Test(description="Create new chat and verify",dataProvider = "globaldataprovider")
	public void createNewChatandVerify(HashMap<String,String> dataMap)throws Exception
	{

		PerformAction.enterTextInElement(findType.XPATH, locatorMap.get("patientTextFieldLocator"), dataMap.get("firstName"));
        PerformAction.fluentWaitForVisibilityOfElement(findType.XPATH, locatorMap.get("textFieldLocator").replace("replace",dataMap.get("patientName")));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("textFieldLocator").replace("replace",dataMap.get("patientName")), 40);
		Thread.sleep(10000);
		PerformAction.clickOnElement(findType.XPATH,locatorMap.get("textFieldLocator").replace("replace",dataMap.get("patientName")));
		
	    PerformAction.clickOnElement(findType.ID, locatorMap.get("groupNameTextFieldLocator"));
		PerformAction.enterTextInElement(findType.ID,locatorMap.get("groupNameTextFieldLocator"),dataMap.get("groupName"));
	    PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);


		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("startChatButtonLocator"), 50);
		PerformAction.clickOnElement(findType.XPATH,locatorMap.get("startChatButtonLocator"));
		PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		PerformAction.waitForCheckLoadingGone(loadingType.LAZYLOADING);
		
		
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("groupChatHeaderLocator"), 50);		
		//verifyFalse(ValidationTest.isElementDisplayed(findType.ID, locatorMap.get("groupChatHeaderLocator")),"[Msg-Info] : New chat pop up is still opened");

	}
	
	
	
	@Test(description="Send secure message and verify",dataProvider = "globaldataprovider")
	public void sendMessageinSecureField(HashMap<String,String> dataMap)throws Exception
	{
		PerformAction.pullScreenToRefreshThePage();
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("messageTextFieldLocator"), 20);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("messageTextFieldLocator")),"[Msg-Info] : Message text field not found");
		//PerformAction.clickOnElement(findType.XPATH, locatorMap.get("messageTextFieldLocator"));
		PerformAction.enterTextInElement(findType.XPATH,locatorMap.get("messageTextFieldLocator"),dataMap.get("patientMessage"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("messageSendButtonLocator"), 30);
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("messageSendButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("textMessageLocator"), 30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("textMessageLocator").replace("replace",dataMap.get("sentPatientMessage"))),"[Msg-Info] :Text message not found on message screen");


	}
	
	
	@Test(description="Navigate on intersendAttachmentByVerifyingAllElementsnal chat and send message",dataProvider = "globaldataprovider")
	public void navigateOnInternalChatandSendMessage(HashMap<String,String> dataMap)throws Exception
	{
		//PerformAction.clickOnElement(findType.ID,locatorMap.get("internalChatButtonLocator"));
		PerformAction.clickOnElementByIndex(findType.ID,locatorMap.get("internalChatButtonLocator"), 1);
		Thread.sleep(2000);
		PerformAction.enterTextInElement(findType.XPATH,locatorMap.get("messageTextFieldLocator"),dataMap.get("providerMessage"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("messageSendButtonLocator"), 30);
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("messageSendButtonLocator"));
		verifyTrue(ValidationTest.isElementDisplayed(findType.ACCID,locatorMap.get("selectaFormHeaderLocator")),"[Msg-Info] :Select a form pop up is not opened yet");

		
		
	}
	
	@Test(description="Verify all elements on browse form screen")
	public void sendAttachementByVerifingAllElements()throws Exception
	{

		// Locate file input
		WebElement fileInput = PerformAction.findElement(findType.CSS, locatorMap.get("attachmentButtonLocator"));

        // Set the file input
        fileInput.sendKeys(System.getProperty("user.dir") + "/resources/TestFiles/Attachment1.pdf");

        // Check if elements are visible
        PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("sendAttachmentsButtonLocator"), 20);
        verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("attachmentsTextLocator")),"[Msg-Info] : Attachments text not found");
        verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("sendAttachmentsButtonLocator")),"[Msg-Info] : Send Attachments button not found");
        verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("addMoreButtonLocator")),"[Msg-Info] : Add more button not found");
        verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("maxFileSizeTextLocator")),"[Msg-Info] : Max file size text not found");
        // Send attachment 
        PerformAction.clickOnElement(findType.XPATH, locatorMap.get("sendAttachmentsButtonLocator"));
        
//        PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("clickOnMessageScreen"), 20);
//        PerformAction.clickOnElement(findType.XPATH, locatorMap.get("clickOnMessageScreen"));
        PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("attachmentFileLocator"), 20);
        verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("attachmentFileLocator")),"[Msg-Info] : Sent attachment not found");

    
	}
	
	
	
	@Test(description="Verify all elements on browse form screen")
	public void verifyElementsOnBrowseFormScreen()throws Exception
	{
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("browseFormLocator"), 40);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("browseFormLocator")),"[Msg-Info] : Browse Form icon field not found");
		PerformAction.clickOnElement(findType.ID, locatorMap.get("browseFormLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("selectFormHeaderLocator"), 20);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("selectFormHeaderLocator")),"[Msg-Info] : select form screen field not found");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("AddFormLinkButtonLocator")),"[Msg-Info] : Add form link button not found");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("searchFormDropDownPlaceholderLocator")),"[Msg-Info] : search Form dropdown  not found");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("formAutomationHintTextLocator")),"[Msg-Info] : form automation text not found");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("createCustomAutomationTextLinkLocator")),"[Msg-Info] : create custom automation text link not found");
		
	}
	
	@Test(description="Send form as message in secure field")
	public void sendForminSecureField()throws Exception
	{
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("clickOnMessageScreen"), 20);
        PerformAction.clickOnElement(findType.XPATH, locatorMap.get("clickOnMessageScreen"));
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("browseFormLocator"), 30);
		PerformAction.clickOnElement(findType.ID, locatorMap.get("browseFormLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("selectFormHeaderLocator"), 20);
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("searchFormDropDownPlaceholderLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("selectFormLocator"), 20);
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("selectFormLocator"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("AddFormLinkButtonLocator"), 20);
		PerformAction.clickOnElement(findType.ID, locatorMap.get("AddFormLinkButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("messageSendButtonLocator"), 40);
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("messageSendButtonLocator"));

		
		
	}
	
	
	
	

}
