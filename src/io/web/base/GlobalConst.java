package io.web.base;



import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import io.fold.core.utility.CustomLogger;
import io.fold.core.utility.FileHandler;
import io.fold.core.utility.FileHandler.FILETYPE;

public class GlobalConst 
{

	public static  String APPPATH ;
	public static final String APP_PROPERTIES ="app.properties";
	public static final String CREDENTIAL_PROPERTIES="resources/Properties/credentials.properties";
	//public static final String BASESCREENSHOTPATH;
	public static final String LOCATORS="resources/Locators/Locators.properties";
	public static final String COMMONLOCATORS="resources/Locators/CommonLocators.properties";
	public static final String SCENARIO_DATA_FOLD="io.fold.web/resources/InputData/scenariodata_FoldHealth.xml";
	public static final String DEVICEUDID;
	public static final String BUNDLEID;
	public static final String DEVICENAME;
	public static final String PLATFORMVERSION;
	public static final Boolean IS_NORESET_APP;
	public static final Boolean IS_REALDEVICE;
//	public static boolean IS_ANDROID =false;
//	public static boolean IS_IOS = false;
	
	public static String FOLDHEALTHUSER;
	public static String FOLDHEALTHPASS;
	public static String FOLDHEALTHUSERNAME;
	//public static final String PORT;
	
	public static final Logger logger =LogManager.getLogger(CustomLogger.class.getName());
	public static final String LOG4J_PROPERTIES="resources/Properties/log4jConfiguration.xml";
	
	
	static {
		
		
		logger.info("Msg-Info : Initializing variables in Global constants...");
		
		LoggerContext context=(org.apache.logging.log4j.core.LoggerContext)LogManager.getContext(false);
		
		File file = new File(LOG4J_PROPERTIES);
		context.setConfigLocation(file.toURI());
		
		FileHandler fileHandler1= new FileHandler(APP_PROPERTIES,FILETYPE.PROPERTY);
		FileHandler fileHandler2 = new FileHandler(CREDENTIAL_PROPERTIES,FILETYPE.PROPERTY);
		//BASESCREENSHOTPATH="io.fold.screens";
		DEVICEUDID= fileHandler1.get("DeviceUDID");
		BUNDLEID =fileHandler1.get("BundleID");
		DEVICENAME=fileHandler1.get("DeviceName");
		PLATFORMVERSION= fileHandler1.get("PlatformVersion");
		IS_NORESET_APP =Boolean.parseBoolean(fileHandler1.get("IS_NORESET_APP"));
		IS_REALDEVICE= Boolean.parseBoolean(fileHandler1.get("IS_REALDEVICE"));
		
		//Port use if we will use parallel ports on server
		//PORT = fileHandler1.get("Port");
		
		
		//Saving username and password, we have to use filehandler 2 for using username and password
		
		FOLDHEALTHUSER = fileHandler2.get("fold_username");
		FOLDHEALTHPASS = fileHandler2.get("fold_password");
		FOLDHEALTHUSERNAME = fileHandler2.get("fold_user");
		
		
		//Note : will use for android and iOS
		
		
//		if(ConfigurationTest.expPlatformType==platformType.ANDROID)
//			IS_ANDROID = true;
//		if(ConfigurationTest.expPlatformType==platformType.IOS)
//			IS_IOS = true;
//		
		
	}

}


