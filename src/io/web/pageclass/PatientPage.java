package io.web.pageclass;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import io.fold.core.configuration.ConfigurationPage;
import io.fold.core.utility.CustomLogger;

public class PatientPage extends ConfigurationPage
{

	public PatientPage(WebDriver webDriver, CustomLogger logger, HashMap<String, String> locatorMap) throws Exception
	{
		setStaticValue(webDriver, logger, locatorMap);
		logger.info("[Msg-Info]: Initializing patients screen...");
		
	}
}
