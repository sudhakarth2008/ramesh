package  ADMINQUALIFICATION;
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
 Admin
 Add_Membership
 logout
 */
public class MembershipAdd
{
	public String UserName,Password;
	public String Name;
	public  int iRow;
	
	
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
	//TestHTMLReporter6 TH3 = new TestHTMLReporter6();	
	
	public  void MembershipAdd(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )
	throws Exception
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
		
	/*
	 @Test
	 public  void ADD_EDU( )throws Exception
	{  
	AdminEducation AE =new AdminEducation();
	AE.Data_driven_test( );
	}
	 */
	
	
	@Test
	public  void Data_driven_test( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
		  int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC03_Membership.xls","Sheet1");

				 for(int i=1;i<4;i++)
				 {	
				 
					 UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_Membership.xls","Sheet1",i,0);
					 Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_Membership.xls","Sheet1",i,1);
					 Name=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_Membership.xls","Sheet1",i,2);
					
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 
	 
			 driver.quit();
	}

	
	public   void call_allmethods(int iRow )throws Exception
	{  
			
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC03_Membership" + str,"Chrome");
		 		 			
		if (iRow==1)
		{
			driver=TestBrowser.OpenChromeBrowser();
			Login l1=new Login();
			l1.Login(driver ,HtmlOutputFileName,TH3);
			l1.openOrangeHRM();
			l1.OrangeHRMlogin(UserName,Password);
			
			TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered",
					 "Pass", HtmlOutputFileName,driver);
			l1.OrangeHRMSigninClick();

		}
				
		MembershipAdd AE =new MembershipAdd();
		AE.MembershipAdd(driver, HtmlOutputFileName, TH3);
		AE.Membership(iRow, Name);
		
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
		 
	}	
	public   void Membership(int iRow,String Name)throws Exception
	{  
		 Actions actions = new Actions(driver);   
		 WebElement ele=driver.findElement(By.xpath(OR.AA_Admin_Focus));
		 actions.moveToElement(ele).click().perform();
		 
		 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ",
				 "Pass", HtmlOutputFileName,driver);
		 
		 Actions actions1 = new Actions(driver);   
		 WebElement ele1=driver.findElement(By.xpath(OR.AA_Qualification_Focus1));
		 actions1.moveToElement(ele1).click().perform();
			 
		Actions actions2 = new Actions(driver);   
		WebElement ele2=driver.findElement(By.xpath(OR.Membership_Focus));
		actions2.moveToElement(ele2).click().perform();
				 
		driver.findElement(By.xpath(OR.Membership_Click)).click(); 
		TH3.HTMLScreenShot("Job focus highlight","Job focused Succefully ",
				"Pass", HtmlOutputFileName,driver);
		driver.findElement(By.xpath(OR.Membership_Name_Sendkey)).sendKeys(Name);
		driver.findElement(By.xpath(OR.Membership_save_Click)).click();			 
	}
	
	

	@BeforeTest
    public void suiteSetup1() throws Exception {
		
		 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xls";
		 String xlsFileSheet="Sheet1";
		 
		 ExcelApiTest3 eat = new ExcelApiTest3();
		 eat.clearsheetdata(xlsFile,xlsFileSheet);
		 	 
    }  	
	
	@AfterTest
  
    public void AftersuiteSetup2() throws Exception {
		 
		 TestHTMLReporter6 TH4 = new TestHTMLReporter6();	
		 TH4.Regression_CretaeHTMLFile();
		 
		 
		
		
    }
			
	
}
 