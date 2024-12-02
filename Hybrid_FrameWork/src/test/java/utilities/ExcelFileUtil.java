package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
		XSSFWorkbook wb;
		//constructor to read path of excel file
		public ExcelFileUtil(String ExcelPath)throws Throwable
		{
			FileInputStream fi = new FileInputStream(ExcelPath);
			wb = new XSSFWorkbook(fi);
		}
		//method for counting no of rows in sheet
		public int rowCount(String sheetName)
		{
			return wb.getSheet(sheetName).getLastRowNum();
		}
		//method for reading cell data
		public String getCellData(String sheetname,int row,int column)
		{
			String data="";
			if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==CellType.NUMERIC)
			{
				int celldata =(int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
				data =String.valueOf(celldata);
			}
			else
			{
				data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
			}
			return data;
			
		}
		//method for writing status into new wb
		public void setCellData(String sheetname,int row,int column,String status,String WriteExcel)throws Throwable
		{
			//get sheet from wb
			XSSFSheet ws =wb.getSheet(sheetname);
			//get row from sheet
			XSSFRow rowNum = ws.getRow(row);
			//create cell
			XSSFCell cell =rowNum.createCell(column);
			cell.setCellValue(status);
			if(status.equalsIgnoreCase("pass"))
			{
				XSSFCellStyle style =wb.createCellStyle();
				XSSFFont font = wb.createFont();
				font.setColor(IndexedColors.GREEN.getIndex());
				font.setBold(true);
				style.setFont(font);
				rowNum.getCell(column).setCellStyle(style);
			}
			else if(status.equalsIgnoreCase("Fail"))
			{
				XSSFCellStyle style =wb.createCellStyle();
				XSSFFont font = wb.createFont();
				font.setColor(IndexedColors.RED.getIndex());
				font.setBold(true);
				style.setFont(font);
				rowNum.getCell(column).setCellStyle(style);
			}
			else if(status.equalsIgnoreCase("Blocked"))
			{
				XSSFCellStyle style =wb.createCellStyle();
				XSSFFont font = wb.createFont();
				font.setColor(IndexedColors.BLUE.getIndex());
				font.setBold(true);
				style.setFont(font);
				rowNum.getCell(column).setCellStyle(style);
			}
			FileOutputStream fo = new FileOutputStream(WriteExcel);
			wb.write(fo);
		}
		}

