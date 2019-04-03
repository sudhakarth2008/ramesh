//import MercuryDemoTours;

package  TimeSheet;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import CommonUtil.*;

import ExcelUtil.ExcelApiTest3;
import HTMLReport.TestHTMLReporter6;
import Login.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.*;


 
public class TS_Att
{
	public String UserName,Password;
	public String EmpName, Date, Punchindate ,PunchINTime ,TimeZone ,PunchNote ,
	PunchOutDate ,PunchOUTTime ,OutTimeZone ,PunchOutNote ;
	public  int iRow;

	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;

	public  void TS_Att(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	@Test
	public  void TS_Att_datadrivenTest( )throws Exception
	{  
		ExcelApiTest3 eat = new ExcelApiTest3();
	
		 
		 int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1");
		 System.out.println("numberowsInputdata..." + numberowsInputdata);
		 


			 for(int i=1;i<numberowsInputdata;i++)
			 {		 
				
				 UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,0);
				 Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,1);
				 System.out.println("User name is"+UserName);
				 System.out.println(" Password is "+Password);
				 
				 EmpName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,2);
				 System.out.println(" EmpName is "+EmpName);

				 Date=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,3);
				 Punchindate=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,4);
				 PunchINTime=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,5);
				 TimeZone=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,6);
				 PunchNote=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,7);
				 PunchOutDate=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,8);
				 PunchOUTTime=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,9);
				 OutTimeZone=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,10);
				 PunchOutNote=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_TimeSheet.xls","Sheet1",i,11);

				 iRow=i;
				
				 TimeSheet_allmethods( iRow);
			 } 
			 
			 
			 
			
			 
			 driver.quit();
			 
			
	}
	
			 public   void TimeSheet_allmethods(int iRow)throws Exception
				{  
					
				 System.out.println(" 123 ");
				 String str=String.valueOf(iRow);
					TH3= new TestHTMLReporter6();

					HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_TIME_Iteration_" + str,"Chrome");
					
				
				
				
				 
					if (iRow==1)
					{
		
						 driver=TestBrowser.OpenChromeBrowser();
						
					      
						    Login l1=new Login();
							l1.Login(driver ,HtmlOutputFileName,TH3);
							l1.openOrangeHRM();
							
							l1.OrangeHRMlogin(UserName,Password);
							TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);

							l1.OrangeHRMSigninClick();
				
					}	
					
					TS_Att TA=new TS_Att();
					TA.TS_Att(driver, HtmlOutputFileName, TH3);
					TA.TimeSheet1(iRow, EmpName, Date, Punchindate ,PunchINTime ,TimeZone ,PunchNote ,
	PunchOutDate ,PunchOUTTime ,OutTimeZone ,PunchOutNote );
					TH3.HTMLCloser(HtmlOutputFileName);
					TH3=null;
					System.gc();
				
					
				}
			 
			 public   void TimeSheet1(int iRow,String EmpName,String Date,String Punchindate,
					 String PunchINTime,String TimeZone,
					 String PunchNote,String PunchOutDate,
					 String PunchOUTTime,String OutTimeZone,String PunchOutNote)throws Exception
				{  
					
					System.out.println("reached here");
					try 
					{
					
					
					Actions actions = new Actions(driver);   
					System.out.println("reached here1");
					 WebElement ele=driver.findElement(By.xpath(OR.TS_Time_Focus));
					 actions.moveToElement(ele).click().perform();
					 TH3.HTMLScreenShot("Pim focus highlight","Pim  clicked Succefully ","Pass", HtmlOutputFileName,driver);
					 
					 
					 System.out.println("reached here2");
					 driver.findElement(By.xpath(OR.TS_Attendance_Focus)).click();
					 TH3.HTMLScreenShot("Emp focus highlight","Emp focus highlighted Succefully ","Pass", HtmlOutputFileName,driver);
			
					 
					 System.out.println("reached here2");
					 driver.findElement(By.xpath(OR.TS_Emp_Records_focuscl)).click();
					 TH3.HTMLScreenShot("Emp focus highlight","Emp focus highlighted Succefully ","Pass", HtmlOutputFileName,driver);
		
					 
					 
					 
					 driver.findElement(By.xpath(OR.TS_EmpName_Sendkey)).sendKeys(EmpName);
					 TH3.HTMLScreenShot("Enter FirstName","FirstName Succefully Entered","Pass", HtmlOutputFileName,driver);

					 //driver.findElement(By.xpath(OR.TS_Date_sendkey)).clear();
					// driver.findElement(By.xpath(OR.TS_Date_sendkey)).sendKeys(Date);
					 //TH3.HTMLScreenShot("Enter FirstName","FirstName Succefully Entered","Pass", HtmlOutputFileName,driver);

					 
					 driver.findElement(By.xpath(OR.TS_View_click)).click();
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					 
					 driver.findElement(By.xpath(OR.TS_Add_Attendance)).click();
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					// driver.findElement(By.xpath(OR.TS_Date_sendkey)).clear();
					 driver.findElement(By.xpath(OR.TS_Punchindate_sendkey)).sendKeys(Punchindate);
					 //TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 
					// driver.findElement(By.xpath(OR.TS_In_Date_sideclick)).click();
					 //TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 
					 driver.findElement(By.xpath(OR.TS_Punch_Time_sendkey)).sendKeys(PunchINTime);
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 Select listbox =new Select(driver.findElement(By.xpath(OR.TS_TimeZone_Listbox)));
					 listbox.selectByVisibleText(TimeZone);

					 driver.findElement(By.xpath(OR.TS_PunchNote_Sendkey)).sendKeys(PunchNote);
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 
					 driver.findElement(By.xpath(OR.TS_In_click)).click();
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 
					 driver.findElement(By.xpath(OR.TS_AddAttRecord_click)).click();
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 driver.findElement(By.xpath(OR.TS_PunchOutDate_sendkey)).sendKeys(PunchOutDate);
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 driver.findElement(By.xpath(OR.TS_Out_Date_Side_click)).click();
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 driver.findElement(By.xpath(OR.TS_PunchOUTTime_sendkey)).sendKeys(PunchOUTTime);
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 Select listbox1 =new Select(driver.findElement(By.xpath(OR.TS_OutTimeZone_Listbox)));
					 listbox1.selectByVisibleText(OutTimeZone);

					 driver.findElement(By.xpath(OR.TS_Punch_Out_Note_Sendkey)).sendKeys(PunchOutNote);
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 driver.findElement(By.xpath(OR.TS_Out_click)).click();
					 TH3.HTMLScreenShot("Click Emp pim Add  ","Emp PIM Add clicked","Pass", HtmlOutputFileName,driver);
					
					 
					 
					 
										} 
					catch(Exception e)
					{
						
					}
					 
					 
				}
				

				
			}
			 
			/* @BeforeTest
			    public void suiteSetup1() throws Exception {
					
					
					
					//TestNGXML tn1 = new TestNGXML();
					//tn1.TestNG_Generate();
					
					
					 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xls";
					 String xlsFileSheet="Sheet1";
					 
					 ExcelApiTest3 eat = new ExcelApiTest3();
					 eat.clearsheetdata(xlsFile,xlsFileSheet);
			    }  	
				
				@AfterTest
			  
			    public void AftersuiteSetup2() throws Exception {
					 
					 TestHTMLReporter6 TH8 = new TestHTMLReporter6();	
					 TH8.Regression_CretaeHTMLFile();
					 
					 
					
					
			    }    
				
				
	*/
				
				
				
