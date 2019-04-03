
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
 Skill_Add
 Skill_Export
 Skill_Search
 Skill_Delete
 logout
 */

 
public class Skill
{
	public String UserName,Password,Skill;
	public  int iRow;
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
		
	public  void SkillpBooleanSearchs(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
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
		
	@Test(priority=1)
	public  void AddSkill( )throws Exception
	{  	
		SkillsAdd AS=new SkillsAdd();
		AS.Data_driven_test();
	}
	@Test(priority=2)
	public  void ExpoSkill()throws Exception
	{  	
		SkillsExport ES=new  SkillsExport();
		ES.ExportSkills();
	}

	@Test(priority=3)
	public  void Data_driven_test( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet1");

				 for(int i=1;i<numberowsInputdata;i++)
				 {		 
					 UserName="Admin";
					 Password="admin123";
					 Skill=eat.getCellData("C://HTML Report//OrangeHRM6//TC03_Skills.xls","Sheet1",i,4);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					 System.out.println(" Skill is "+Skill);
					 
						
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
		
		 TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
		l1.OrangeHRMSigninClick();

		}
		
		
		Skill ASS =new Skill();
		ASS.SkillpBooleanSearchs(driver, HtmlOutputFileName, TH3);
				
		Boolean BL=false;
		BL=ASS.SkillpBooleanSearchDelete(iRow, Skill);
		if(BL==true)	 
		/*{
			System.out.println("YES Membership found and delete"+Membership);
			 TH3.HTMLScreenShot("YES Membership found and delete"+Membership,"YES Membership found and delete"+Membership,"Pass", HtmlOutputFileName,driver);
		}
		 else
		  {
			 System.out.println("No Membership found to delete"+Membership);
			 TH3.HTMLScreenShot("No Membership found to delete"+Membership,"No Membership found to delete"+Membership,"Pass", HtmlOutputFileName,driver);
		  }
			*/  
		 
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
	
			}	
	
	public   Boolean SkillpBooleanSearchDelete(int iRow,String Skill)throws Exception
	{  
		
		Boolean Record_Present=false;
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=findElement(By.xpath(OR.AA_Admin_Focus));
		 actions.moveToElement(ele).click().perform();
		 
		 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
		 System.out.println("reached here2");
		 
		 Actions actions1 = new Actions(driver);   
		 System.out.println("reached here2");
		 WebElement ele1=findElement(By.xpath(OR.AA_Qualification_Focus1));
		 actions1.moveToElement(ele1).click().perform();
			 

		 
			 Actions actions2 = new Actions(driver);   
			 System.out.println("reached here2");
			 WebElement ele2=findElement(By.xpath(OR.AA_skills_Focus));
			 actions2.moveToElement(ele2).click().perform();
		 List  columns = driver.findElements(By.xpath(OR.AA_Coloumns_Click)); 
	    
	     List  rows = driver.findElements(By.xpath(OR.AA_Rows_Click)); 
	     System.out.println("No of rows are : " + rows.size());
	    	        
	    		ExcelApiTest3 eat = new ExcelApiTest3();
	         
	           for ( int i=1 ; i<=rows.size() ;i++)
	  		      {
	  			     	String pathdelete="//*[@id='recordsListTable']/tbody/tr["  + i +  "]"  + "/td" + "[2]";
	  				    
	  			        WebElement CellText1=driver.findElement(By.xpath(pathdelete));
	  				    		   
	  			    	String SkillinApp = CellText1.getText();
	  				  				        
	  			    	if ( Skill.equals(SkillinApp) )
	  					    		
	  			       {
	  			    		
	  			   	  Record_Present=true;
	  		  					    	   
	  			   	 String path_checkbox="//*[@id='recordsListTable']/tbody/tr["  + i +  "]"  + "/td" + "[1]";
	  			   	 driver.findElement(By.xpath(path_checkbox)).click();
	  				 TH3.HTMLScreenShot("Check box","Membership checkbox clicked","Pass", HtmlOutputFileName,driver);
	  							 
	  				 driver.findElement(By.xpath(OR.AA_Rows_Delete)).click();
	  				 TH3.HTMLScreenShot("Delte clicked","Membership deleted Succefully ","Pass", HtmlOutputFileName,driver);
	  			
	  				//driver.findElement(By.xpath(OR)).click();
	  			   // TH3.HTMLScreenShot("ConfirmDelte clicked","Membership deleted Succefully ","Pass", HtmlOutputFileName,driver);	  					    	
	  				return Record_Present;
	  				
	  	              	}
	  				else
	  				  	{
	  				TH3.HTMLScreenShot("No Skill found to deelte"+Skill,"No Skill found to deelte"+Skill,"Pass", HtmlOutputFileName,driver);
	  				   	}
	  					  		    	
	  					  					    	
	  				    } 
	        			  	return Record_Present;
	        			  /*if(Record_Present==true)	 
	        				System.out.println("YES Skill found");
	        			  else
	      					System.out.println("No-Skill, Skill not found");
	        				  
	        			  driver.quit();*/
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