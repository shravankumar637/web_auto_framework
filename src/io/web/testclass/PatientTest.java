package io.web.testclass;

import java.util.HashMap;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import java.util.List;
import io.fold.core.actiondefinitions.PerformAction;
import io.fold.core.actiondefinitions.PerformAction.findType;
import io.fold.core.actiondefinitions.ValidationTest;
import io.web.base.BaseTest;
import io.web.pageclass.CommonActionsPage;
import io.web.pageclass.CommonActionsPage.sideDrawerSections;
import io.web.pageclass.PatientPage;

public class PatientTest extends BaseTest {

	PatientPage patientpage;
	LoginTest loginTest = new LoginTest();

	public void initPatientPage(HashMap<String, String> dataMap) throws Exception {

		logger.info("[Msg-Info] : Initializing aNet screen....");
		patientpage = new PatientPage(webDriver, logger, locatorMap);
	}
	
	public void verifyAndEnterTextinFirstNameField(HashMap<String, String> dataMap) throws Exception {
		
		// Verify first name label & text box, then enter 
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("firstNameLabelLocator")), "[Msg-Info] : First name label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("firstNameTestboxLocator")), "[Msg-Info] : Enter first name text box is not found on add member Screen");
		PerformAction.enterTextInElement(findType.XPATH, locatorMap.get("firstNameTestboxLocator"), dataMap.get("patientFName"));
	}
	
	public void verifyAndEnterTextinLastNameField(HashMap<String, String> dataMap) throws Exception {
		
		// Verify last name label & text box, then enter last name
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("lastNameLabelLocator")), "[Msg-Info] : Last name label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("lastNameTestboxLocator")), "[Msg-Info] : Enter last name text box is not found on add member Screen");
		PerformAction.enterTextInElement(findType.XPATH, locatorMap.get("lastNameTestboxLocator"), dataMap.get("patientLName"));

	}
	
	public void verifyAndEnterDob(HashMap<String, String> dataMap) throws Exception {
		
		// Verify DOB label & text box, then enter DOB
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("DOBLabelLocator")), "[Msg-Info] : Date Of Birth label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("DOBTestboxLocator")), "[Msg-Info] : Enter DOB is not found on add member Screen");
		PerformAction.enterTextInElement(findType.XPATH, locatorMap.get("DOBTestboxLocator"), dataMap.get("patientDOB"));
		Thread.sleep(2000);
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("selectDobLocator"));
	}
	
	public void verifyAndSelectSexAtBirth(HashMap<String, String> dataMap) throws Exception {
		
		// Verify sex at birth label & select value from drop down
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("sexAtBirthLabelLocator")), "[Msg-Info] : Sex at birth label is not found on add member Screen");
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("sexAtBirthTestboxLocator"));
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("selectSexAtBirthLocator"));
	}
	
	public void verifyAndEnterEmail(HashMap<String, String> dataMap) throws Exception {
		
		// Verify email label & text box, then enter zipcode
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("emailLabelLocator")), "[Msg-Info] : Email label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("emailTestboxLocator")), "[Msg-Info] : Enter email text box is not found on add member Screen");
		PerformAction.enterTextInElement(findType.XPATH, locatorMap.get("emailTestboxLocator"), dataMap.get("patientEmail") + CommonActionsPage.generateRandomString(5) + dataMap.get("patientEmailDomain"));

	}
	
	public void verifyAndEnterMobileNumber(HashMap<String, String> dataMap) throws Exception {
		
		// Verify mobile number label & text box, then enter mobile number
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("mobileNumberLabelLocator")), "[Msg-Info] : Mobile number label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("mobileNumberTestboxLocator")), "[Msg-Info] : Enter mumber text box is not found on add member Screen");
		PerformAction.enterTextInElement(findType.XPATH, locatorMap.get("mobileNumberTestboxLocator"), dataMap.get("patientMobileNmbr"));


	}
	
	public void verifyAndEnterZipcode(HashMap<String, String> dataMap) throws Exception {
		
		// Verify zipcode label & text box, then enter zipcode
		PerformAction.scrollTillElementVisible(findType.XPATH, locatorMap.get("zipcodeTestboxLocator"));
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("zipcodeLabelLocator")), "[Msg-Info] : Zipcode label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("zipcodeTestboxLocator")), "[Msg-Info] : Enter zip code is not found on add member Screen");
		PerformAction.enterTextInElement(findType.XPATH, locatorMap.get("zipcodeTestboxLocator"), dataMap.get("zipcode"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("enterZipcode"), 2);
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("enterZipcode"));

	}
	
	public void verifyAndClickOnAddButton() throws Exception {
		
		// Verify email label & text box
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("addButtonLocator")), "[Msg-Info] : Add button is not found on add member Screen");
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("addButtonLocator"));


	}
	

	@Test(description = "Open add new patient screen and verify all mandatory elements ")
	public void openAddNewPatientScreenAndVerifyMandatoryElements() throws Exception {


		CommonActionsPage.navigateTo(sideDrawerSections.PATIENTS);
		Thread.sleep(3000);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("addNewButtonLocator")), "[Msg-Info] : Add New button is not found on patients Screen");
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("addNewButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("addMemberHeaderLocator"), 2);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("addMemberHeaderLocator")), "[Msg-Info] : Add Member pop up is not opened yet to create new member");
		Thread.sleep(3000);

		// Verify first name label & text box
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("firstNameLabelLocator")), "[Msg-Info] : First name label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("firstNameTestboxLocator")), "[Msg-Info] : Enter first name text box is not found on add member Screen");

		// Verify last name label & text box
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("lastNameLabelLocator")), "[Msg-Info] : Last name label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("lastNameTestboxLocator")), "[Msg-Info] : Enter last name text box is not found on add member Screen");

		// Verify DOB label & text box
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("DOBLabelLocator")), "[Msg-Info] : Date Of Birth label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("DOBTestboxLocator")), "[Msg-Info] : Enter DOB is not found on add member Screen");

		// Verify sex at birth label & drop down
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("sexAtBirthLabelLocator")), "[Msg-Info] : Sex at birth label is not found on add member Screen");

		// Verify email label & text box
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("emailLabelLocator")), "[Msg-Info] : Email label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("emailTestboxLocator")), "[Msg-Info] : Enter email text box is not found on add member Screen");

		// Verify mobile number label & text box
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("mobileNumberLabelLocator")), "[Msg-Info] : Mobile number label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("mobileNumberTestboxLocator")), "[Msg-Info] : Enter mumber text box is not found on add member Screen");
		PerformAction.scrollTillElementVisible(findType.XPATH, locatorMap.get("address1TestboxLocator"));

		// Verify Zip code label & text box
		Thread.sleep(1000);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("zipcodeLabelLocator")), "[Msg-Info] : Zipcode label is not found on add member Screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("zipcodeTestboxLocator")), "[Msg-Info] : Enter zip code is not found on add member Screen");

		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("addButtonLocator")), "[Msg-Info] : Add button is not found on add member Screen");
		
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("cancelButtonLocator")), "[Msg-Info] : Cancel button is not found on add member Screen");
		CommonActionsTest.clickOnCancelButton();
		Thread.sleep(2000);
		// Click on Cancel button to Cancel add member page
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("ConfirmationCloseButtonLocator"));

		logger.info("All mandatory element are verified on add patient page ");

	}

	@Test(description = "Create new patient with mandatory data",dataProvider = "globaldataprovider")
	public void createNewPatientWithMandatoryData(HashMap<String, String> dataMap) throws Exception {


		CommonActionsPage.navigateTo(sideDrawerSections.PATIENTS);
		Thread.sleep(3000);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("addNewButtonLocator")), "[Msg-Info] : Add New button is not found on patients Screen");
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("addNewButtonLocator"));
		Thread.sleep(3000);
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("addMemberHeaderLocator"), 2);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("addMemberHeaderLocator")), "[Msg-Info] : Add Member pop up is not opened yet to create new member");

		Thread.sleep(2000);
		verifyAndEnterTextinFirstNameField(dataMap);
		
		verifyAndEnterTextinLastNameField(dataMap);
		verifyAndEnterDob(dataMap);
		verifyAndSelectSexAtBirth(dataMap);
		verifyAndEnterEmail(dataMap);
		verifyAndEnterMobileNumber(dataMap);
		verifyAndEnterZipcode(dataMap);
		verifyAndClickOnAddButton();
		
		String patientFullName = dataMap.get("patientFName") + " " + dataMap.get("patientLName");
		
		List<WebElement> elements = ValidationTest.findElements(findType.NAME, patientFullName);
		if (elements.size() > 1) {
			WebElement patientName = elements.get(2);

			System.out.println(patientName);
			verifyTrue(ValidationTest.isElementDisplayed(findType.NAME, patientFullName),
					"[Msg-Info]: Created patient is not found on patient table");
			logger.info("Patient Verified:" + patientFullName);

		}
		logger.info("Patient:" + patientFullName + "created successfully");
		
		
	}

}
