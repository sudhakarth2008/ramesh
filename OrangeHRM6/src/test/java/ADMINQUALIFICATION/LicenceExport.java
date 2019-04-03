//import MercuryDemoTours;

package ADMINQUALIFICATION;

import CommonUtil.*;
import HTMLReport.TestHTMLReporter6;
import ExcelUtil.ExcelApiTest3;
import Login.Login;

import org.testng.annotations.Test;



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
Admin_Licence_Export
logout
*/

 
public class LicenceExport
{
	public String UserName,Password;
	
	
	
	public  int iRow;
	
	WebDriver driver;
	TestHTMLReporter6 TH3;	
	String HtmlOutputFileName;
	String error;
	
	public  void LicenceExport(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
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
	 public  void ADD_LiCX( )throws Exception
	{  
	AdminLicenceExport A_LiC_X =new AdminLicenceExport();
	A_LiC_X.Data_driven_test( );
	}
	 */

	
	
	
	@Test
	public  void ExportLicence( )throws Exception
	{  
		
			// ExcelApiTest3 eat = new ExcelApiTest3();
			 //int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC03_Licence.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName="ADMIN";
					 Password="admin123";
					 iRow=i;
					 call_allmethods(iRow);
				 }
			
				 driver.quit();
				  
	}
	
				 
				 
				 public void call_allmethods(int iRow )throws Exception
					{  
						
					 
					String str=String.valueOf(iRow);
					TH3= new TestHTMLReporter6();
					HtmlOutputFileName=TH3.CretaeHTMLFile("TC03_Licence","Chrome");
					 
					 
						driver=TestBrowser.OpenChromeBrowser();
						
						Login l1=new Login();
						l1.Login(driver ,HtmlOutputFileName,TH3);
						l1.openOrangeHRM();
						l1.OrangeHRMlogin(UserName,Password);
						TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
						l1.OrangeHRMSigninClick();
						
						TH3.HTMLScreenShot("HomePage navigation","Navigated to HomePage","Pass", HtmlOutputFileName,driver);
						
						LicenceExport ES=new  LicenceExport();	
						ES.LicenceExport(driver, HtmlOutputFileName, TH3);						
						ES.Export_Licence();
						TH3.HTMLScreenShot("Export Employee Details","Employee Details exported to \"C://HTML Report//OrangeHRM6//TC01_ALE.xls\",\"Sheet5\",i,k,\"Blank Data\"","Pass", HtmlOutputFileName,driver);
						
						//driver.quit();
						TH3.HTMLCloser(HtmlOutputFileName);
						TH3=null;
						System.gc();
					}

					public  void Export_Licence()throws Exception
					{ 
						Actions actions = new Actions(driver);   
						System.out.println("reached here1");
						 WebElement ele=driver.findElement(By.xpath(OR.AA_Admin_Focus));
						 actions.moveToElement(ele).click().perform();
						 
						 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
						 System.out.println("reached here2");
						 
						 Actions actions1 = new Actions(driver);   
							System.out.println("reached here2");
							 WebElement ele1=driver.findElement(By.xpath(OR.AA_Qualification_Focus1));
							 actions1.moveToElement(ele1).click().perform();
							 
							 Actions actions2 = new Actions(driver);   
								System.out.println("reached here2");
								 WebElement ele2=driver.findElement(By.xpath(OR.Licence_Focus));
								 actions2.moveToElement(ele2).click().perform();
								 
						
												
				        //No. of columns
				        List  columns = driver.findElements(By.xpath(OR.Licence_Coloms_Click)); 
				        //System.out.println("No of columns are : " + columns.size());
				        
				        //No.of rows 
				        List  rows = driver.findElements(By.xpath(OR.Licence_Rows_Click)); 
				       // System.out.println("No of rows are : " + rows.size());
				        
				       
				      
				        			ExcelApiTest3 eat = new ExcelApiTest3();
				         
								    for ( int i=1 ; i<=rows.size() ;i++)
								    {
								    	  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
								    	   {
								      		   String str1="//*[@id='recordsListTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
								      		   
								      		
								    		    WebElement CellText1=driver.findElement(By.xpath(str1));
								    		   
								    	        String valueIneed1 = CellText1.getText();
								    	    
								    	        
								    	        if (valueIneed1 !=null)
								    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC03_Licence.xls","Sheet5",i,k,valueIneed1);
								    	        else
								    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC03_Licence.xls","Sheet5",i,k,"Blank Data");
								    	        	
								    	   }
								    }
				   
					
					}
				
}
