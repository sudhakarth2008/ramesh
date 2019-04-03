package CommonUtil;


import org.openqa.selenium.WebDriver;

public class OR {
	
public static String sTargetTestCaseExcelPath="";	
public static String sTargetFolderPath="";	
public static String sTestCaseName="";	

//public static WebDriver driver ; 

//Pages
//1.MercuryFlightFinderPage  = MFFPage
//2.MercuryLoginPage  = MLPage
//3.SelectFlightPage = SFPage


// starts MercuryLoginPage by Sudhakar Date:12-Jan-2018
public static String MLPage_UserNameTextbox="//input[@type='text'and @name='userName']";
public static String MLPage_PasswordTextbox="//input[@type='password' and @name='password']";
public static String MLPage_SignInButton="//*[@name='login']";
//end MercuryLoginPage 


//Starts MercuryFlightFinderPage by Sudhakar Date:12-Jan-2018
public static String MFFPage_OneWayRadiobutton="//input[@type='radio'and @name='tripType' and @value='oneway' ]";
public static String MFFPage_RoundTripRadiobutton="//input[@type='radio'and @name='tripType' and @value='roundtrip' ]";



public static String MFFPage_PassengersCountListbox="//select[@name='passCount']";
public static String MFFPage_DepartingFromListbox="//select[@name='fromPort']";
public static String MFFPage_DepartingStartMonthListbox="//select[@name='fromMonth']";
public static String MFFPage_DepartingStartDateListbox="//select[@name='fromDay']";
public static String MFFPage_ArrivingIn="//select[@name='toPort']";
public static String MFFPage_ReturningEndMonthListbox="//select[@name='toMonth']";
public static String MFFPage_ReturningEndDateListbox="//select[@name='toDay']";
public static String MFFPage_EconomyclassRadioButton="//input[@type='radio' and @name='servClass' and @value='Coach']";
public static String MFFPage_BusinessclassRadioButton="//input[@type='radio' and @name='servClass' and @value='Business']";
public static String MFFPage_FirstClassRadioButton ="//input[@type='radio' and @name='servClass' and @value='First']";
public static String MFFPage_AirLineListbox ="//select[@name='airline']";
public static String MFFPage_ContinueButton ="//*[@name='findFlights']";
public static String MFFPage_SelectFlightImg ="//img[ @src='/images/masts/mast_flightfinder.gif' and @width='492' and @height='30']";
//End MercuryFlightFinderPage


//starts Mercury Select Flight Page by Sudhakar Date:12-Jan-2018
public static String SFPage_SelectFlightImg ="//img[ @src='/images/masts/mast_selectflight.gif' and @width='492' and @height='30']";
public static String SFPage_Continue_Click ="//input[@name='reserveFlights']";
//End Mercury Select Flight Page 

public static String BookFlightPage_FirstName ="//*[@name='passFirst0']";


public static String BookFlightPage_lastName ="//input[@name='passLast0']";
public static String BookFlightPage_meal1 ="//select[@name='pass.0.meal']";
public static String BookFlightPage_CardName ="//select[@name='creditCard']";
public static String BookFlightPage_CardNumber ="//input[@name='creditnumber']";
public static String BookFlightPage_expirymonth="//select [@name='cc_exp_dt_mn']";
public static String BookFlightPage_expiryyear="//select [@name='cc_exp_dt_yr']";
public static String BookFlightPage_SecurePurchase_Click="//input [@name='buyFlights']";



public static String Output_FlightConfirmation_Number = "(.//*[normalize-space(text()) and normalize-space(.)='CONTACT'])[1]/following::font[6]";
public static String Output_FlightBookingDate_Time="(.//*[normalize-space(text()) and normalize-space(.)='Departing'])[1]/preceding::b[1]";
public static String Output_DepartingDetails= "(.//*[normalize-space(text()) and normalize-space(.)='Departing'])[1]/following::td[1]";
public static String Output_ReturningDetails= "(.//*[normalize-space(text()) and normalize-space(.)='Returning'])[1]/following::td[1]";
public static String Output_PassengersDetails="(.//*[normalize-space(text()) and normalize-space(.)='Passengers'])[1]/following::td[1]";
public static String Output_BilledToDetails="(.//*[normalize-space(text()) and normalize-space(.)='Billed To'])[1]/following::p[1]";
public static String Output_DeliveryAddressDetails="(.//*[normalize-space(text()) and normalize-space(.)='Delivery Address (N/A for Ticketless Travel)'])[1]/following::p[1]";
public static String Output_TotalTaxes="(.//*[normalize-space(text()) and normalize-space(.)='Delivery Address (N/A for Ticketless Travel)'])[1]/following::font[9]";
//public static String Output_TotalPrice="(.//*[normalize-space(text()) and normalize-space(.)='$89 USD'])[1]/following::font[7]";
public static String Logout="//img[@src='/images/forms/Logout.gif']";





//public static String sTargetTestCaseExcelPath="";	
///public static String sTargetFolderPath="";	
//public static String sTestCaseName="";	

public static String username_sendkey="//input[@id='txtUsername']";
public static String password_sendkey="//input[@id='txtPassword']";
public static String login_click="//input[@id='btnLogin']";

//EMP EXPORT


public static String pim_focus="//a[@id='menu_pim_viewPimModule']";
public static String EMPlist_click="//a[@id='menu_pim_viewEmployeeList']";
public static String EMPcolumn="//*[@id='resultTable']/thead/tr/th";
public static String EMProws="//*[@id='resultTable']/tbody/tr/td[2]";

//*[@id="resultTable"]/thead/tr/th[1]

//ADMIN EXPORT

public static String ADMIN_focus="//a[@id='menu_admin_viewAdminModule']";
public static String ADMIN_USERMANAGEMENT_focus="//a[@id='menu_admin_UserManagement']";
public static String ADMIN_USERS_click="//a[@id='menu_admin_viewSystemUsers']";
public static String ADMIN_COLUMNS_click="//*[@id='resultTable']/thead/tr/th";
public static String ADMIN_ROWS_click="//*[@id='resultTable']/tbody/tr/td[2]";

//ADMIN_ADD_USERS
public static String AD_User_Role="//*[@id='systemUser_userType']";
public static String AD_User_EName="//*[@id='systemUser_employeeName_empName']";
public static String AD_User_UserName="//*[@id='systemUser_userName']";
public static String AD_User_Status="//*[@id='systemUser_status']";
public static String AD_User_Pass1="//*[@id='systemUser_password']";
public static String AD_User_Pass2="//*[@id='systemUser_confirmPassword']";
public static String AD_User_Save="//*[@id='btnSave']";
public static String AD_User_Add="//*[@id='btnAdd']";





//admin qualifications export
public static String ADMIN_FOCUS="//a[@id='menu_admin_viewAdminModule']";


public static String ADMIN_QUALIFICATIONS_FOCUS="//a[@id='menu_admin_Qualifications']";


public static String ADMIN_SKILLS_CLICK="//a[@id='menu_admin_viewSkills']";

public static String ADMIN_NUMOFCOLUMNS="//*[@id='recordsListTable']/thead/tr/th";

public static String ADMIN_NUMOFROWS="//*[@id='recordsListTable']/tbody/tr/td[2]";
//BooLEAN USERROLE


//*[@id='menu_admin_UserManagement']
//*[@id='menu_admin_viewSystemUsers']
//*[@id="searchSystemUser_userName"]
public static String Admin_focus="//a[@ id='menu_admin_viewAdminModule' ]";

public static String UserManagement="//*[@id='menu_admin_UserManagement']";
public static String Users="//*[@id='menu_admin_viewSystemUsers']";
public static String UsersName="//*[@id='searchSystemUser_userName']";
public static String UsersRole="//*[@id='searchSystemUser_userType']";
public static String UEmpName="//*[@id='searchSystemUser_employeeName_empName']";
public static String UStatus="//*[@id='searchSystemUser_status']";
public static String UserAdd="//*[@id='btnAdd']";
public static String UserSave="//*[@id='btnSave']";
public static String NoColumns="//*[@id='resultTable']/thead/tr/th";
public static String NoRows="//*[@id='resultTable']/tbody/tr/td[2]/a";
public static String U_SystemUsers="//*[@id='systemUser-information']/a";
public static String U_UserRole_List="//*[@id='systemUser_userType']";
public static String U_EmpName="//*[@id='systemUser_employeeName_empName']";
public static String U_UserName="//*[@id='systemUser_userName']";
public static String U_Status_L="//*[@id='systemUser_status']";
public static String U_Password="//*[@id='systemUser_password']";
public static String U_C_PWord="//*[@id='systemUser_confirmPassword']";
public static String search_click="//input[@id='searchBtn']";
//Pim Jobtitle Search



public static String Employee_focus="//a[@id='menu_pim_viewEmployeeList']";

public static String Jobtitle_listbox="//select[@id='empsearch_job_title']";
public static String Jobtitle_search_click="//input[@id='searchBtn']";

public static String PimColumns="//*[@id='resultTable']/thead/tr/th";
public static String PimRows="//*[@id='resultTable']/tbody/tr/td[2]";

//pimempidsearch
public static String Pim_focus1="//*[@id='menu_pim_viewPimModule']";
public static String emp_listclick="//*[@id='menu_pim_viewEmployeeList']";
public static String empid_sendkey="//*[@id='empsearch_id']";

public static String emp_searchclick="//*[@id='searchBtn']";

public static String empcoloumns="//*[@id='resultTable']/thead/tr/th";
public static String emprows="//*[@id='resultTable']/tbody/tr/td[2]";
public static String emp_name="//*[@id='empsearch_employee_name_empName']";


//boolean various search
public static String BSpimfocus="//a[@id='menu_pim_viewPimModule']";

public static String BSEMPCLICK="//a[@id='menu_pim_viewEmployeeList']";

public static String BSEMPNAMESENDKEY="//input[@id='empsearch_employee_name_empName' ] ";

public static String BSIDSENDKEY="//input [@id='empsearch_id']";

public static String BSJOBTITLELISTBOX="//select[@id='empsearch_job_title' ]";

public static String BSSEARCHCLICK="//input[@id='searchBtn' ]";

public static String BSCOLOUMNS="//*[@id='resultTable']/thead/tr/th";

public static String BSROWS="//*[@id='resultTable']/tbody/tr/td[1]";

//addemp
public static String Emp_Pim_focus1="//*[@id='menu_pim_viewPimModule']";
public static String Emp_list_focus="//*[@id='menu_pim_viewEmployeeList']";
public static String Emp_firstname_sendkey="//*[@id='firstName']";
public static String Emp_middlename_sendkey="//*[@id='middleName']";
public static String Emp_lastname_sendkey="//*[@id='lastName']";
public static String Emp_id_sendkey="//*[@id='employeeId']";
public static String Emp_save_click="//*[@id='btnSave']";
public static String Emp_pimadd_click="//input[@id='btnAdd']";

// addempuser
public static String EMP_login_chkbox="//*[@id='chkLogin']";
public static String EMP_Username="//*[@id='user_name']";
public static String EMP_pass1="//*[@id='user_password']";
public static String EMP_pass2="//*[@id='re_password']";
public static String EMP_status="//*[@id='status']";
public static String EMP_savebtn="//*[@id='btnSave']";










////////////////////



public static String username="//input[@id='txtUsername']";
public static String password="//input[@id='txtPassword'] ";
public static String login="//input[@id='btnLogin']";
//public static String admin="//a[@id='menu_admin_viewAdminModule']";

//PIM starts
public static String Home_MainMenu_PIM_click="//a[@id='menu_pim_viewPimModule']";

public static String PIM_Addemployee_click="//a[@id='menu_pim_addEmployee']";
//PIM ends


//Add employee starts


public static String firstname_sendkeys="//input[@id='firstName']";

public static String middlename_sendkeys="//input[@id='middleName']";

public static String lastname_sendkeys="//input[@id='lastName']";

public static String EmployeeId_defaultno="//input[@id='employeeId']";


public static String CreateLoginDetails_checkbox="//input[@id='chkLogin']";

public static String UserName_sendkeys="//input[@id='user_name']";

public static String Password_sendkeys="//input[@id='user_password']";

public static String ConfirmPassword_sendkeys="//input[@id='re_password']";

public static String Status_listbox="//select[@id='status']";

public static String save="//input[@id='btnSave']";

public static String Vacancies_Add_Backbutton_click="//input[@id='btnBack']";

//Add employee 


public static String Pim_focus="//*[@id='menu_pim_viewPimModule']";

public static String Employee_click="//*[@id='menu_pim_viewEmployeeList']";
public static String Employeename_click="//*[@id='empsearch_employee_name_empName']";
public static String Empserch_click="//*[@id='searchBtn']";
public static String Empcoloums="//*[@id='resultTable']/thead/tr/th";
public static String EmpRows="//*[@id='resultTable']/tbody/tr/td[5]";



//Admin_Qualification Starts

public static String  Admin="//a[@id='menu_admin_viewAdminModule']";

public static String Qualification_Focus="//a[@id='menu_admin_Qualifications']";

public static String Qualification_skills_click="//a[@id='menu_admin_viewSkills']";

public static String Skills_Add="//input[@id='btnAdd']";

public static String AddSkill_Name="//input[@id='skill_name']";

public static String AddSkill_Description="//textarea[@id='skill_description']";

public static String AddSkill_Save="//input[@id='btnSave']";

public static String skillcoloumns="//*[@id='recordsListTable']/thead/tr/th";

public static String SkillRows="//*[@id='recordsListTable']/tbody/tr/td[2]";



//Leave starts

public static String LE_Leave_focus="//*[@id='menu_leave_viewLeaveModule']";
public static String LE_Assignleave_focus=" //*[@id='menu_leave_assignLeave']";
public static String LE_Empnaqme_sendkey="//*[@id='assignleave_txtEmployee_empName']";
public static String LE_Leavetype_listbox="//*[@id='assignleave_txtLeaveType']";
public static String LE_Fromdate_sendkey="//*[@id='assignleave_txtFromDate']";
public static String LE_Todate_sendkey="/*[@id='assignleave_txtToDate']";
public static String LE_Comment_sendkey="//*[@id='assignleave_txtComment']";
public static String LE_Assign_click="//*[@id='assignBtn']";
public static String LE_Confirm_click="//*[@id='confirmOkButton']";
public static String LE_Leavelist_focus="//*[@id='menu_leave_viewLeaveList']";
public static String LE_All_checkbox="//*[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']";
public static String LE_search_click="//*[@id='btnSearch']";
public static String LE_No_coloumns="//*[@id='resultTable']/thead/tr/th";
public static String LE_No_Rows="//*[@id='resultTable']/tbody/tr/td[1]";




public static String LL_From_SendKey="//*[@id='calFromDate']";

public static String Ll_Date_SendKey="//*[@id='calToDate']";

//public static String Ll_All_Checkbox="//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']";  
//*[@id="leaveList_chkSearchFilter_1"]


public static String Ll_All_SearchFilter3="//*[@id='leaveList_chkSearchFilter_3']";


//public static String Ll_All_Checkbox="//*[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']";
public static String Ll_All_Checkbox="//*[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']";


public static String Ll_Subunit_Listbox="//*[@id='leaveList_cmbSubunit']";

public static String Ll_Search="//*[@id='btnSearch']";



public static String Ll_colmns="//*[@id='resultTable']/thead/tr/th";
public static String Ll_rows="//*[@id='resultTable']/tbody/tr/td[1]";


//Leave Ends

//TimeStarts
public static String TS_Time_Focus="//*[@id='menu_time_viewTimeModule']";
public static String TS_Attendance_Focus="//*[@id='menu_attendance_Attendance']";
public static String TS_Emp_Records_focuscl="//*[@id='menu_attendance_viewAttendanceRecord']";
public static String TS_EmpName_Sendkey="//*[@id='attendance_employeeName_empName']";
public static String TS_Date_sendkey="//*[@id='attendance_date']";
public static String TS_View_click="//*[@id='btView']";
public static String TS_Add_Attendance="//*[@id='btnPunchOut']";
public static String TS_Punchindate_sendkey="//*[@id='attendance_date']";
public static String TS_In_Date_sideclick="//*[@id='punchTimeForm']/fieldset/ol/li[1]";
public static String TS_Punch_Time_sendkey="//*[@id='attendance_time']";
public static String TS_TimeZone_Listbox="//*[@id='attendance_timezone']";
public static String TS_PunchNote_Sendkey="//*[@id='attendance_note']";
public static String TS_In_click="//*[@id='btnPunch'] ";
public static String TS_AddAttRecord_click="//*[@id='btnPunchOut']";
public static String TS_PunchOutDate_sendkey="//*[@id='attendance_date']";
public static String TS_Out_Date_Side_click="//*[@id='punchTimeForm']/fieldset/ol/li[1]";
public static String TS_PunchOUTTime_sendkey ="//*[@id='attendance_time']";
public static String TS_OutTimeZone_Listbox="//*[@id='attendance_timezone']";
public static String TS_Punch_Out_Note_Sendkey="//*[@id='attendance_note']";
public static String TS_Out_click="//*[@id='btnPunch']";
public static String TS_Columns="//*[@id='resultTable']/thead/tr/th";
public static String TS_Rows="//*[@id='resultTable']/tbody/tr/td[2]";


//ADMINQUALIFICATION_SKILLS
public static String AA_Admin_Focus="//a[@id='menu_admin_viewAdminModule']";
public static String AA_Qualification_Focus1="//a[@id='menu_admin_Qualifications']";
public static String AA_skills_Focus="//a[@id='menu_admin_viewSkills']";
public static String AA_Add_Click="//*[@id='btnAdd']";
public static String AA_Name_Sendkey="//*[@id='skill_name']";
public static String AA_Description_Sendkey="//*[@id='skill_description']";
public static String AA_Save_Click="//*[@id='btnSave']";
public static String AA_Coloumns_Click="//*[@id='recordsListTable']/thead/tr/th";
public static String AA_Rows_Click="//*[@id='recordsListTable']/tbody/tr/td[2]";
public static String AA_Rows_Checkbox="//*[@id='recordsListTable']/tbody/tr[2]/td[1]/input";
public static String AA_Rows_Delete="//*[@id='btnDel']";

//ADMINQUALIFICATION_EDUCATION
public static String AB_Education_Focus="//*[@id='menu_admin_viewEducation']";
public static String AB_EducationAdd_click="//*[@id='btnAdd']";
public static String AB_Level_Send="//*[@id='education_name']";
public static String AB_Save_Click="//*[@id='btnSave']";
public static String AB_Coloumn_Click="//*[@id='recordsListTable']/thead/tr/th";
public static String AB_rows_Click="//*[@id='recordsListTable']/tbody/tr/td[2]";
public static String AB_Rows_Checkbox="//*[@id='recordsListTable']/tbody/tr[2]/td[1]/input";
public static String AB_Rows_Delete="//*[@id='btnDel']";


//ADMINQUALIFICATION_LICENCE
public static String Licence_Focus="//*[@id='menu_admin_viewLicenses']";
public static String Licence_Add_Click="//*[@id='btnAdd']";
public static String Licence_Add_Sendkey="//*[@id='license_name']";
public static String Licence_Save_Click="//*[@id='btnSave']";
public static String Licence_Coloms_Click="//*[@id='recordsListTable']/thead/tr/th";
public static String Licence_Rows_Click="//*[@id='recordsListTable']/tbody/tr/td[2]";
public static String Licence_Rows_Checkbox="//*[@id='recordsListTable']/tbody/tr/td[1]/input";
public static String Licence_Rows_Delete="//*[@id='btnDel']";

//ADMINQUALIFICATION_LANGUAGES

public static String Languages_Focus="//*[@id='menu_admin_viewLanguages']";
public static String Languages_Add_Click="//*[@id='btnAdd']";
public static String Languages_Name_Sendkey="//*[@id='language_name']";
public static String Languages_Save_Click="//*[@id='btnSave']";
public static String Languages_Coloms_Click="//*[@id='recordsListTable']/thead/tr/th";
public static String Languages_Rows_Click="//*[@id='recordsListTable']/tbody/tr/td[2]";
public static String Languages_Rows_Checkbox="//*[@id='recordsListTable']/tbody/tr/td[1]/input";
public static String Languages_Rows_Delete="//*[@id='btnDel']";

//ADMINQUALIFICATION_MEMBERSHIP
public static String Membership_Focus="//*[@id='menu_admin_membership']";
public static String Membership_Click="//*[@id='btnAdd'] ";
public static String Membership_Name_Sendkey="//*[@id='membership_name']";
public static String Membership_save_Click="//*[@id='btnSave']";
public static String Membership_Coloms_Click="//*[@id='resultTable']/thead/tr/th";
public static String Membership_Rows_Click="//*[@id='resultTable']/tbody/tr/td[2]";
public static String Membership_Rows_checkbox="//*[@id='ohrmList_chkSelectAll']";
public static String Membership_Rows_checkbo2="//*[@id='ohrmList_chkSelectRecord_2']";
public static String Membership_Delete="//*[@id='btnDelete']";
public static String Membership_Delete_Confirmation="//*[@id='dialogDeleteBtn']";

}


