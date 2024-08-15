package io.web.testclass;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.fold.core.actiondefinitions.PerformAction;
import io.fold.core.actiondefinitions.ValidationTest;
import io.fold.core.actiondefinitions.PerformAction.findType;
import io.web.base.BaseTest;
import io.web.base.GlobalConst;
import io.web.pageclass.LoginPage;

public class LoginTest extends BaseTest
{
	LoginPage loginPage;
	
	
	@Test(description="To initiate object of fold screen test",dataProvider = "globaldataprovider")
	public void initWebPage(HashMap<String,String> dataMap) throws Exception
	{
		
		logger.info("[Msg-Info] : Initializing login screen....");
		loginPage = new LoginPage(webDriver, logger, locatorMap);
	}
	
	@Test(description = "Verify login functionality for provider")
	public static void verifyLoginFunctionality()throws Exception
	{
		
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("userNameTextFieldLocator"),20);
		PerformAction.enterTextInElement(findType.ID,locatorMap.get("userNameTextFieldLocator"),GlobalConst.FOLDHEALTHUSER);

		PerformAction.clickOnElement(findType.ID,locatorMap.get("passWordTextFieldLocator"));
		
		PerformAction.enterTextInElement(findType.ID,locatorMap.get("passWordTextFieldLocator"),GlobalConst.FOLDHEALTHPASS);

		PerformAction.clickOnElement(findType.ID, locatorMap.get("loginButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("homeButtonLocator"),30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("homeButtonLocator")));
		
	

		
	}
	
	
	@Test(description="Verify all elements on login screen for provider app")
	public void verifyAllElementsOnLoginPage()throws Exception
	{
	   PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("userNameTextFieldLocator"),20);
	   //verifyTrue(ValidationTest.isElementDisplayed(findType.CLASS,locatorMap.get("loginLogoLocator")),"Login logo is not found on login screen");
	   verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("usernamePlaceHolderLocator")),"'name@email.com' place holder not found on login screen");
	   verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("userNameTextFieldLocator")),"Email text field is not found on login screen");
	   verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("passwordPlaceHolderLocator")),"Password place holder not found on login screen");
	   verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("passWordTextFieldLocator")),"Password text field is not found on login screen");
	   verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("termsandConditionLocator")),"'Terms & Condition'link not found on login screen");
	   verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("privacyPolicyLocator")),"'Privacy Policy' link not found on login screen");
	   verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("loginButtonLocator")),"Login button not found on login screen");
	   verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("forgotPasswordLocator")),"Forgot password ?' button not found on login screen");   
	   
	}
	
	
	@Test(description="Navigate to the forgot password screen from the  login screen")
	public void navigateFromLoginToForgotPasswordScreen()throws Exception
	{
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("forgotPasswordLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("submitButtonLocator"),2);
        verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("forgotPassEmailTextFieldLocator")),"Forgot password screen is not opened yet");

		
	}
	
	
	
	@Test(description="Verify elments on forgot password screen")
	public void verifyElmentsOnForgotPasswordPage()throws Exception
	{
		
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("forgotPasswordLabelLocator"),2);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID, locatorMap.get("forgotPasswordLabelLocator")),"Forgot password' header not found on login screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID, locatorMap.get("resetPasswordMessageLocator")),"Enter your registered email. We will send you a link to reset password' message not found on forgot password screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("emailLabelLocator")),"Email label not found on forgot password screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID, locatorMap.get("forgotPassEmailTextFieldLocator")),"Email text field not found on forgot password screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID, locatorMap.get("submitButtonLocator")),"Submit button not found on forgot password screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH, locatorMap.get("backtoLoginButtonLocator")),"Back to login button not found on forgot password screen");	
		
	}
	
	
	
	
	@Test(description="Navigate to the login screen from the forgot password")
	public void navigateFromForgotToLoginScreen()throws Exception
	{
		PerformAction.clickOnElement(findType.XPATH, locatorMap.get("backtoLoginButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("userNameTextFieldLocator"),2);
        verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("userNameTextFieldLocator")),"Login screen is not opened yet");

		
	}
	

	@Test(description="Verify forgot password functionality for provider",dataProvider = "globaldataprovider")
	public void verifyForgotPasswordFunctionality(HashMap<String,String> dataMap)throws Exception
	{
		navigateFromLoginToForgotPasswordScreen();
		PerformAction.enterTextInElement(findType.ID,locatorMap.get("forgotPassEmailTextFieldLocator"),dataMap.get("emailid"));
		PerformAction.clickOnElement(findType.ACCID,locatorMap.get("submitButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("userNameTextFieldLocator"),2);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("loginButtonLocator")),"Login button not found on login screen");

				
		
	}
	
	
	
	@Test(description="Navigate on SSO screen and verify all elements")
	public void navigateOnSSOScreenandVerifyElements()throws Exception
	{
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("pickTitleLocator"), 30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("pickTitleLocator")),"'Pick an account' label not found on SSO screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("bannerLogoLocator")),"Fold logo not found on SSO screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("emailPhoneSkypeFieldLocator")),"Email, phone or Skype text field not found on SSO screen");
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("nextButtonLocator")),"Next button not found on SSO screen");


	}
	

	@Test(description="Verify invalid username functionality on SSO screen",dataProvider = "globaldataprovider")
	public void verifyInvalidUserFunctionalityOnSSOScreen(HashMap<String,String> dataMap)throws Exception
	{
		PerformAction.enterTextInElement(findType.XPATH,locatorMap.get("emailPhoneSkypeFieldLocator"),dataMap.get("invalidEmaild"));
		PerformAction.clickOnElement(findType.ID,locatorMap.get("nextButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("errorMessageLocator"), 30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("errorMessageLocator")),"'Enter a valid email address, phone number or Skype name.' error message not found");
	
	}
	
	
	

	@Test(description="Verify valid username functionality on SSO screen",dataProvider = "globaldataprovider")
	public void verifyValidUserFunctionalityOnSSOScreen(HashMap<String,String> dataMap)throws Exception
	{
	
		PerformAction.clearTextInElement(findType.XPATH,locatorMap.get("emailPhoneSkypeFieldLocator"), null);
		PerformAction.enterTextInElement(findType.XPATH,locatorMap.get("emailPhoneSkypeFieldLocator"),GlobalConst.FOLDHEALTHUSER);
		PerformAction.clickOnElement(findType.ID,locatorMap.get("nextButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH,locatorMap.get("passwordTextFieldLocator"), 30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("passwordTextFieldLocator")),"Password screen not opened yet");

		
	}
	
	@Test(description="Verify invalid password functionality on SSO screen",dataProvider = "globaldataprovider")
	public void verifyInvalidPassFunctionalityOnSSOScreen(HashMap<String,String> dataMap)throws Exception
	{
		PerformAction.enterTextInElement(findType.XPATH,locatorMap.get("passwordTextFieldLocator"),dataMap.get("invalidEmaild"));
		PerformAction.clickOnElement(findType.ID,locatorMap.get("nextButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.ID,locatorMap.get("errorMessageLocator"), 30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.ID,locatorMap.get("errorMessageLocator")),"'Sorry, your sign-in timed out. Please sign in again.' error message not found on SSO screen");

		
		
	}
	
	@Test(description="Verify valid password functionality on SSO screen",dataProvider = "globaldataprovider")
	public void verifyValidPassFunctionalityOnSSOScreen(HashMap<String,String> dataMap)throws Exception
	{
	
		PerformAction.clearTextInElement(findType.XPATH,locatorMap.get("passwordTextFieldLocator"), null);
		PerformAction.enterTextInElement(findType.XPATH,locatorMap.get("passwordTextFieldLocator"),GlobalConst.FOLDHEALTHPASS);
		PerformAction.clickOnElement(findType.ID,locatorMap.get("nextButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH,locatorMap.get("passwordTextFieldLocator"), 30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("passwordTextFieldLocator")),"Password screen not opened yet");
	}
	
	@Test(description = "Verify login functionality for provider")
	public static void reLoginToApplication()throws Exception
	{
		
		PerformAction.waitForVisibilityOfElement(findType.ID, locatorMap.get("userNameTextFieldLocator"),20);
		PerformAction.enterTextInElement(findType.ID,locatorMap.get("userNameTextFieldLocator"),GlobalConst.FOLDHEALTHUSER);
		PerformAction.enterTextInElement(findType.ID,locatorMap.get("passWordTextFieldLocator"),GlobalConst.FOLDHEALTHPASS);
		PerformAction.clickOnElement(findType.ID, locatorMap.get("loginButtonLocator"));
		PerformAction.waitForVisibilityOfElement(findType.XPATH, locatorMap.get("homeButtonLocator"),30);
		verifyTrue(ValidationTest.isElementDisplayed(findType.XPATH,locatorMap.get("homeButtonLocator")));
		

	}
	
	
	

}
