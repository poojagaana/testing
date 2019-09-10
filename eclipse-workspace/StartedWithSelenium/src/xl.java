import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDemo1 {

	public static String vSearch="testing";
	public static int xlRows,xlCols;
	public static String xData[][];
	
	public static void main(String[] args) throws Exception 
	{
		xlRead("C:\\Selenium Jars\\Google.xls");
		
		for(int i=1;i<xlRows;i++)
		{
		if(xData[i][2].equals("Y"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver.exe");
		WebDriver myD=new ChromeDriver();
		myD.get("https://www.google.co.in");
		vSearch=xData[i][0];
		myD.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(vSearch);
		Thread.sleep(4000);
		myD.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div[2]/center/input[1]")).click();
		String vSearchout=myD.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div/div[1]/input")).getAttribute("value");
		if(vSearch.equals(vSearchout))
		{
			xData[i][3]="PASS";
		}
		else
		{
			xData[i][3]="FAIL";
		}
		myD.close();
		}
		}
		xlwrite("C:\\Selenium Jars\\GoogleResult.xls", xData);
	}

	public static void xlRead(String sPath) throws Exception
	{
		File myFile=new File(sPath);
		FileInputStream myStream=new FileInputStream(myFile);
		HSSFWorkbook myWorkbook=new HSSFWorkbook(myStream);
		HSSFSheet mySheet=myWorkbook.getSheetAt(0);
		xlRows=mySheet.getLastRowNum()+1;
		xlCols=mySheet.getRow(0).getLastCellNum();
		//System.out.println("Row Count is "+xlRows);
		//System.out.println("Col Count is "+xlCols);
		xData =new String[xlRows][xlCols];
		for (int i=0;i<xlRows;i++)
		{
			HSSFRow row=mySheet.getRow(i);
			for (short j=0;j<xlCols;j++)
			{
				HSSFCell cell=row.getCell(j);
				String value=cellToString(cell);
				xData[i][j]=value;
				//System.out.print(xData[i][j]+"    ");
			}
			//System.out.println();
		}
	}
	public static String cellToString(HSSFCell cell)
		{
		int type=cell.getCellType();
		Object result;
		switch(type)
		{
		case HSSFCell.CELL_TYPE_NUMERIC:
		result=cell.getNumericCellValue();
		break;
		case HSSFCell.CELL_TYPE_STRING:
		result=cell.getStringCellValue();
		break;
		case HSSFCell.CELL_TYPE_FORMULA:
		throw new RuntimeException("We cannot evaluate formula");
		case HSSFCell.CELL_TYPE_BLANK:
		result="-";
		case HSSFCell.CELL_TYPE_BOOLEAN:
		result=cell.getBooleanCellValue();
		case HSSFCell.CELL_TYPE_ERROR:
		result="This Cell has some error";
		default:
		throw new RuntimeException("We do not evaluate this data");
		}
		return result.toString();
		}
	public static void xlwrite(String xlpath1,String[][] xData) throws Exception
	{
		System.out.println("Inside XL Write");
		File myFile1=new File(xlpath1);
		FileOutputStream fout=new FileOutputStream(myFile1);
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet mySheet1=wb.createSheet("TestResults");
		for(int i=0;i<xlRows;i++)
		{
			HSSFRow row1=mySheet1.createRow(i);
			for(short j=0;j<xlCols;j++)
			{
				HSSFCell cell1=row1.createCell(j);
				cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell1.setCellValue(xData[i][j]);
			}
		}
		wb.write(fout);
		fout.flush();
		fout.close();
	}


	
}