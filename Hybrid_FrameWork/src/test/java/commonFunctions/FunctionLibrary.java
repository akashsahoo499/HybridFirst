package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;


public class FunctionLibrary {
public static Properties conpro;
public static WebDriver driver;
//method for launching browser
public static WebDriver startBrowser() throws Throwable
{
	conpro=new Properties();
	//load property file
	conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	else if(conpro.getProperty("Browser").equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		Reporter.log("Browser Value is Not Matching",true);
	}
	return driver;
}
public static void typeAction(String ltype, String lvalue, String testData) {
	// TODO Auto-generated method stub
	
}
public static void waitForElement(String ltype, String lvalue, String testData) {
	// TODO Auto-generated method stub
	
}
public static void clickAction(String ltype, String lvalue) {
	// TODO Auto-generated method stub
	
}
public static void validateTitle(String testData) {
	// TODO Auto-generated method stub
	
}
public static void captureSup(String ltype, String lvalue) {
	// TODO Auto-generated method stub
	
}
public static void supplierTable() {
	// TODO Auto-generated method stub
	
}
public static void captureCus(String ltype, String lvalue) {
	// TODO Auto-generated method stub
	
}
public static void customerTable() {
	// TODO Auto-generated method stub
	
}
public static void closeBrowser() {
	// TODO Auto-generated method stub
	
}
public static void dropDownAction(String ltype, String lvalue, String testData) {
	// TODO Auto-generated method stub
	
}
public static void captureStock(String ltype, String lvalue) {
	// TODO Auto-generated method stub
	
}
public static void stockTable() {
	// TODO Auto-generated method stub
	
}

	
}
public static void typeAction(String ltype, String lvalue, String testData) {
	// TODO Auto-generated method stub
	
}
public static void clickAction(String ltype, String lvalue) {
	// TODO Auto-generated method stub
	
}

	
}
public static void openUrl() {
	// TODO Auto-generated method stub
	
}

}
