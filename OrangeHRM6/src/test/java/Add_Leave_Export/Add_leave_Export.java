//import MercuryDemoTours;

package  Add_Leave_Export;
import org.testng.annotations.Test;
import Employee.*;
import Leaves.*;

import CommonUtil.*;

import HTMLReport.TestHTMLReporter6;
import ExcelUtil.ExcelApiTest3;
import Login.Login;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
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
/*
 Openbrowser
 openurL
 login
 Addemp
 logout
 */

 
public class Add_leave_Export
{
	public String UserName,Password;
	public String EmpName,LeaveType,FromDate,ToDate,Coment;
	public String FirstName, MiddleName, LastName, Id;
	public  int iRow;
	
	
	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;

	public  void Add_leave_Export(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	
	@Test
	public  void AddLeave_datadriven( )throws Exception
	{  
		
		
		
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
		  int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1");
		  UserName="Admin";
			 
			 Password="admin123";
			 
				 for(int i=1;i<2 ;i++)
				 {		 
					 
					 FirstName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1",i,0);
					 MiddleName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1",i,1);
					 LastName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1",i,2);
					 Id=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1",i,3);
					 EmpName=FirstName + MiddleName + LastName;
					 LeaveType=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1",i,4);
					 FromDate=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1",i,5);
					 ToDate=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1",i,6);
					 Coment=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet1",i,7);
					 
					 
					 System.out.println("FirstName is"+FirstName);
					 System.out.println(" MiddleName is "+MiddleName);
					 System.out.println(" LastName is "+LastName);
					 System.out.println(" Id is "+Id);

				
					 System.out.println("EmpName is"+EmpName);
					 System.out.println(" FromDate is "+FromDate);
					 System.out.println(" ToDate is "+ToDate);
					 System.out.println(" Coment is "+Coment);
					  iRow=i;
					  
						call_allmethods(iRow);
						
						
						
					 
				 }
			
				 
				 driver.quit();
				 
	}
	
	
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_LeaveAssign_Iteration_" + str,"Chrome");
		
		
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
		
		
		
		Add_leave_Export ALE =new Add_leave_Export();
		ALE.Add_leave_Export(driver, HtmlOutputFileName, TH3);
		
		AddEmp AE=new AddEmp();
		ALE.AddLeave_datadriven();
		AE.addEmp1(iRow, FirstName, MiddleName, LastName, Id);
		
		
		Leavelist LL=new Leavelist();
		LL.LeaveAssign(iRow, EmpName,LeaveType,FromDate,ToDate,Coment);
		ALE.Export_addLeaveList(iRow);
		TH3.HTMLCloser(HtmlOutputFileName);
		TH3=null;
		System.gc();

		
	}	 
	
	
	
	public   void Export_addLeaveList(int iRow )throws Exception
	
	{  
		
		System.out.println("reached here");
		 
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.LE_Leave_focus));
		 actions.moveToElement(ele).click().perform();
		 TH3.HTMLScreenShot("Leave focus highlight","Leave  clicked Succefully ","Pass", HtmlOutputFileName,driver);

		 Actions actions2 = new Actions(driver);   
			System.out.println("reached here1");
			 WebElement ele2=driver.findElement(By.xpath(OR.LE_Leavelist_focus));
			 actions2.moveToElement(ele2).click().perform();
			 TH3.HTMLScreenShot("Leavelist focus highlight","Leavelist  clicked Succefully ","Pass", HtmlOutputFileName,driver);

			 driver.findElement(By.xpath(OR.LL_From_SendKey)).clear();

			// driver.findElement(By.xpath(OR.LL_From_SendKey)).sendKeys("20-01-2019");
			 System.out.println("reached here7");	
			 
			 driver.findElement(By.xpath(OR.Ll_Date_SendKey)).clear();

			// driver.findElement(By.xpath(OR.Ll_Date_SendKey)).sendKeys("31-12-2019");
			 System.out.println("reached here7");
			 
			 driver.findElement(By.xpath(OR.Ll_All_SearchFilter3)).click();

			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath(OR.Ll_All_Checkbox)).isSelected();
			 System.out.println("reached here8");
			 
			driver.findElement(By.xpath(OR.Ll_All_SearchFilter3)).click();
			 
			 Select listbox =new Select(driver.findElement(By.xpath(OR.Ll_Subunit_Listbox)));
			 //listbox.selectByVisibleText("All");
			 listbox.selectByIndex(0);
			 
			 System.out.println("reached here9");
			 

			 driver.findElement(By.xpath(OR.Ll_Search)).click();	
			 
		 List  columns = driver.findElements(By.xpath(OR.Ll_colmns)); 
	     System.out.println("No of columns are : " + columns.size());
	     
	     //No.of rows 
	     List  rows = driver.findElements(By.xpath(OR.Ll_rows)); 
	     System.out.println("No of rows are : " + rows.size());
	     
	    
	   
	     			ExcelApiTest3 eat = new ExcelApiTest3();
	      
					    for ( int i=1 ; i<=rows.size() ;i++)
					    {
					    	  for ( int j=2 ,k=0; j<=6;j++,k++)
					    	   {
					    		  
					    		  System.out.println("hai....112");
					      		   String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
					      		
					      		 System.out.println("hai....113");
					      		   
					    		    WebElement CellText1=driver.findElement(By.xpath(str1));
					    		    
					    		    System.out.println("hai....114");
					    		   
					    	        String valueIneed1 = CellText1.getText();
					    	        System.out.println("Cell Text Value is: " + valueIneed1);
					    	        
					    	        if (valueIneed1 !=null)
					    	
					    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet5",i,k,valueIneed1);
					    	  
					    	        else
					    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_ALE.xls","Sheet5",i,k,"Blank Data");
					    	       
					    	        
					    	   }
					    	  
					    	 
					    }
					    
					    
					    TH3.HTMLScreenShot("   Leave details exported C://HTML Report//OrangeHRM6//TC01_ALE.xls","Leavelist export success ","Pass", HtmlOutputFileName,driver);

					    

					    
			} 
	

	
	

	
	@BeforeTest
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
		
		




	

	
}