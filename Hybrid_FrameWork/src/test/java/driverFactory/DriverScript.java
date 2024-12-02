package driverFactory;

import org.openqa.selenium.WebDriver;

import commonFunctions.FunctionLibrary;
import utilities.ExcelFileUtil;

import utilities.ExcelFileUtil;

public class DriverScript {
	WebDriver driver;
	String inputpath ="./FileInput/Controller.xlsx";
	String outputpath ="./FileOutput/HybridResults.xlsx";
	String TCSheet ="MasterTestCases";
	public void startTest() throws Throwable
	{
		String ModuleStatus="";
		String Module_New="";
		//create object for Excelfileutil class
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no of rows in TCsheet
		int rc =xl.rowCount(TCSheet);
		//iterate all rows in a TCsheet
		for(int i=1;i<=rc;i++)
		{
			if(xl.getCellData(TCSheet, i, 2).equalsIgnoreCase("Y"))
			{
				//store Module name celli nto one variable
				//tcmodule is holding all sheets
				String TCModule =xl.getCellData(TCSheet, i, 1);
				//iterate all rows in TCmodule
				for(int j=1;j<=xl.rowCount(TCModule);j++)
				{
					//read each cell from TCModule sheet
					String Object_Type = xl.getCellData(TCModule, j, 1);
					String Ltype = xl.getCellData(TCModule, j, 2);
					String Lvalue = xl.getCellData(TCModule, j, 3);
					String TestData = xl.getCellData(TCModule, j, 4);
					try {
						if(Object_Type.equalsIgnoreCase("startBrowser"))
						{
							driver = FunctionLibrary.startBrowser();
						}
						if(Object_Type.equalsIgnoreCase("openUrl"))
						{
							FunctionLibrary.openUrl();
						}
						if(Object_Type.equalsIgnoreCase("waitForElement"))
						{
							FunctionLibrary.waitForElement(Ltype, Lvalue, TestData);
						}
						if(Object_Type.equalsIgnoreCase("typeAction"))
						{
							FunctionLibrary.typeAction(Ltype, Lvalue, TestData);
						}
						if(Object_Type.equalsIgnoreCase("clickAction"))
						{
							FunctionLibrary.clickAction(Ltype, Lvalue);
						}
						if(Object_Type.equalsIgnoreCase("validateTitle"))
						{
							FunctionLibrary.validateTitle(TestData);
						}
						if(Object_Type.equalsIgnoreCase("closeBrowser"))
						{
							FunctionLibrary.closeBrowser();
						}
						if(Object_Type.equalsIgnoreCase("dropDownAction"))
						{
							FunctionLibrary.dropDownAction(Ltype, Lvalue, TestData);
						}
						if(Object_Type.equalsIgnoreCase("captureStock"))
						{
							FunctionLibrary.captureStock(Ltype, Lvalue);
						}
						if(Object_Type.equalsIgnoreCase("stockTable"))
						{
							FunctionLibrary.stockTable();
						}
						if(Object_Type.equalsIgnoreCase("captureSup"))
						{
							FunctionLibrary.captureSup(Ltype, Lvalue);
						}
						if(Object_Type.equalsIgnoreCase("supplierTable"))
						{
							FunctionLibrary.supplierTable();
						}
						if(Object_Type.equalsIgnoreCase("captureCus"))
						{
							FunctionLibrary.captureCus(Ltype, Lvalue);
						}
						if(Object_Type.equalsIgnoreCase("customerTable"))
						{
							FunctionLibrary.customerTable();
						}
						//write pass into TCModule sheet
						xl.setCellData(TCModule, j, 5, "Pass", outputpath);
						ModuleStatus="True";
					} catch (Exception e) {
						System.out.println(e.getMessage());
						//write as fail into TCModule sheet
						xl.setCellData(TCModule, j, 5, "Fail", outputpath);
						Module_New="False";
					}
					
				}
				if(ModuleStatus.equalsIgnoreCase("True"))
				{
					//write as pass into TCSheet
					xl.setCellData(TCSheet, i, 3, "Pass", outputpath);
				}
				if(Module_New.equalsIgnoreCase("False"))
				{
					xl.setCellData(TCSheet, i, 3, "Fail", outputpath);
				}
			}
			else 
			{
				//write as Blocked into TCSheet for testcases flag N
				xl.setCellData(TCSheet, i, 3, "Blocked", outputpath);
			}
		}
	}
	}


