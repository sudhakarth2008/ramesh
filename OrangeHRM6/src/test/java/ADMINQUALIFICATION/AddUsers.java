//import MercuryDemoTours;

package  ADMINQUALIFICATION;
import org.testng.annotations.Test;



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

 
public class AddUsers
{
	public String UserName,Password;
	public String Username,UserRole,EmpName,Status,Userrole,Empname,UName,status,password,CPassword;
	
	public  int iRow;
	
	
	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;

	public  void AddUsers(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	// Draws a red border around the found element. Does not set it back anyhow.
			public WebElement findElement(By by)throws Exception {
			    WebElement elem = driver.findElement(by);
			 
			    // draw a border around the found element
			    if (driver instanceof JavascriptExecutor) {
			        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
			    } 
			    Thread.sleep(1000);
			    
			    return elem;
			}
		
	
	
	@Test
	public  void AddEmp_datadriventest( )throws Exception
	{  
		
		
		
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
		  int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC03AddUser.xls","Sheet4");

				 for(int i=1;i<numberowsInputdata;i++)
				 {		 
					 UserName="Admin";
					 
					 Password="admin123";
					
					
					 Username=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,0);
					 UserRole=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,1);
					 EmpName=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,2);
					 Status=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,3);
					 Userrole=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,4);
					 Empname=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,5);
					 UName=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,6);
					 status=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,7);
					 password=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,8);
					 CPassword=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_AddEmp.xls","Sheet4",i,9);
					 System.out.println("Username is"+Username);
					 System.out.println(" UserRole is "+UserRole);
					 System.out.println(" EmpName is "+EmpName);
					 System.out.println(" Status is "+Status);
					
					 
					  iRow=i;
					  
						call_allmethods(iRow);
						
			 }
			
				 
				 driver.quit();
				 
	}
	
		public   void call_allmethods(int iRow )throws Exception
	{  
		
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC03_AddEmp" + str,"Chrome");
		
		
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
		
			
		
		AddUsers AE =new AddUsers();
		AE.AddUsers(driver,HtmlOutputFileName,TH3 );
		AE.AddUser(iRow, Username,UserRole,EmpName,Status,Userrole,Empname,UName,status,password,CPassword);
		TH3.HTMLCloser(HtmlOutputFileName);
		TH3=null;
		System.gc();

		
	}	
	
	
		

	public   void AddUser(int iRow,String Username,String UserRole,String EmpName,String Status,
			String Userrole,String Empname,String UName,String status,String password,String CPassword)throws Exception
	{  
		
		System.out.println("reached here");
		try 
		{
		
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=findElement(By.xpath(OR.AA_Admin_Focus));
		 actions.moveToElement(ele).click().perform();
		 TH3.HTMLScreenShot("Pim focus highlight","Pim  clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 Actions actions1 = new Actions(driver);   
			System.out.println("reached here1");
			 WebElement ele1=findElement(By.xpath(OR.UserManagement));
			 actions1.moveToElement(ele1).click().perform();
			 TH3.HTMLScreenShot("Pim focus highlight","Pim  clicked Succefully ","Pass", HtmlOutputFileName,driver);

			 Actions actions2 = new Actions(driver);   
				System.out.println("reached here1");
				 WebElement ele2=findElement(By.xpath(OR.Users));
				 actions2.moveToElement(ele2).click().perform();
				 TH3.HTMLScreenShot("Pim focus highlight","Pim  clicked Succefully ","Pass", HtmlOutputFileName,driver);
			
				 findElement(By.xpath(OR.U_SystemUsers)).click();	 
				 
		 findElement(By.xpath(OR.UsersName)).sendKeys(Username);
		 TH3.HTMLScreenShot("Enter MiddleName","MiddleName Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 Select listbox =new Select(findElement(By.xpath(OR.UsersRole)));
		 listbox.selectByVisibleText(UserRole);

		 
		 findElement(By.xpath(OR.UEmpName)).sendKeys(EmpName);
		 TH3.HTMLScreenShot("Enter LastName","LastName Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 Select listbox1 =new Select(findElement(By.xpath(OR.UStatus)));
		 listbox1.selectByVisibleText(Status);

		 
		 
		 findElement(By.xpath(OR.UserAdd)).click();
		 
		 Select listbox2 =new Select(findElement(By.xpath(OR.U_UserRole_List)));
		 listbox2.selectByVisibleText(Userrole);

		 findElement(By.xpath(OR.U_EmpName)).sendKeys(Empname);
		 TH3.HTMLScreenShot("Enter LastName","LastName Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 findElement(By.xpath(OR.U_UserName)).sendKeys(UName);
		 TH3.HTMLScreenShot("Enter LastName","LastName Succefully Entered","Pass", HtmlOutputFileName,driver);
		
		 Select listbox3 =new Select(findElement(By.xpath(OR.U_Status_L)));
		 listbox3.selectByVisibleText(status);
		 
		 
		 findElement(By.xpath(OR.U_Password)).sendKeys(password);
		 TH3.HTMLScreenShot("Enter password","password Succefully Entered","pass", HtmlOutputFileName,driver);
		
		 findElement(By.xpath(OR.U_C_PWord)).sendKeys(CPassword);
		 //TH3.HTMLScreenShot("Enter LastName","LastName Succefully Entered","Pass", HtmlOutputFileName,driver);
		

		 findElement(By.xpath(OR.UserSave)).click();
		 
		
	
		} 
		catch(Exception e)
		{
			
		}
		 
		 
	}
	
	
	
}