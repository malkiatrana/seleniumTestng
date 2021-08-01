package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

    public class ConfigValidationsReader {
	public static WebDriver driver;
	public static Properties pro;

	public ConfigValidationsReader()
	{
	try {
			// Specify the path
			File src = new File("./Configuration/Config_validation_msgs.property");
			// Convert into input stream
			FileInputStream fis = new FileInputStream(src);
			// Create Properties class object to read properties file
			pro = new Properties();
			// Load file so we can use into our script
			pro.load(fis);

		} catch (Exception e) {

			System.out.println("Exception is : " + e.getMessage());
		}
	}
	public String getEmailExist() 
	{
		return pro.getProperty("aiw.EmailExist");
	}
	public String getRegistrationSuccess()
	{
	return pro.getProperty("aiw.RegistrationSuccess");
	}
	public String PopupNotSelectDestination()
	{
	return pro.getProperty("aiw.PopupNotSelectDestination");
	}
	public String LiveBookingOpenedTitle()
	{
	return pro.getProperty("aiw.LiveBookingOpenedTitle");
	}
	public String HoursareRequired()
	{
	return pro.getProperty("aiw.HoursareRequired");
	}
	public String MinutesareRequired()
	{
	return pro.getProperty("aiw.MinutesareRequired");
	}
	public String Durationcheck()
	{
	return pro.getProperty("aiw.Durationcheck");
	}
	public String Phonenumber()
	{
	return pro.getProperty("aiw.Phonenumber");
	}
	public String Phonenumberinvalid()
	{
	return pro.getProperty("aiw.Phonenumberinvalid");
	}
	public String DateRequired()
	{
	return pro.getProperty("aiw.DateRequired");
	}
	public String DateWrongformat()
	{
	return pro.getProperty("aiw.DateWrongformat");
	}
	public String AMorPM()
	{
	return pro.getProperty("aiw.AMorPM");
	}

	public String PopUp_message()
	{
	return pro.getProperty("aiw.popupmessage");
	}
	public String PopUp_Attention()
	{
	return pro.getProperty("aiw.popupattention");
	}
	public String ConfrimBooking_Request()
	{
	return pro.getProperty("aiw.ConfirmBookingRequestTitle");
	}
	public String ConfirmationBooking_Page()
	{
	return pro.getProperty("aiw.Bookconfimation");  
	}
	public String Calendercolor()
	{
	return pro.getProperty("aiw.Calendercolor");
	}
	public String ForgotPasswordValidationTextCorrectEmailID()
	{
	return pro.getProperty("aiw.forgot.pwd.validation.correct.email.id");	  
	}
	public String ForgotPasswordValidationText()
	{
	return pro.getProperty("aiw.forgot.password.validation.text");	
	}
	public String AccountSelector()
	{
	return pro.getProperty("aiw.accountSelector");	
	}
	public String PopupbookingbadText()
	{
	return pro.getProperty("aiw.popupbadtext");	
	}
	public String PopuWrongfromat()
	{
	return pro.getProperty("aiw.wrongformat");	
	}
	public String Preparationmaterial()
	{
	return pro.getProperty("aiw.preparationmaterial");	
	}
	public String PostDetailTitle()
	{
	return pro.getProperty("aiw.postdetailtitle");	
	}
	public String PostDetailsDescription()
	{
	return pro.getProperty("aiw.posdetaildescription");	
	}
	public String WrongSignupUsing_FB()
	{
	return pro.getProperty("aiw.Wrong_FBSignUp");	
	}
	public String getbillingSettings()
	{
		return pro.getProperty("aiw.billingSettingpage");
	}
	public String getbillingSettingsCardNumber()
	{
		return pro.getProperty("aiw.billingSettingspagevalidationCard");
	}
	public String getbillingSettingsCVV()
	{
		return pro.getProperty("aiw.billingSettingspagevalidationCVV");
	}
	public String getTextApplyNow()
	{
		return pro.getProperty("aiw.billingSettingspageApplyNow");
	}
	public String getCityrequiredApplyNow()
	{
		return pro.getProperty("aiw.billingSettingsCityApplyNow");
	}
	
	public String getCountrytApplyNow()
	{
		return pro.getProperty("aiw.billingSettingsCountryApplyNow");
	}
	public String getcity() {
		return pro.getProperty("aiw.billingSettingsCity");
	}
	public String getcountry() {
		return pro.getProperty("aiw.billingSettingsCountry");
	}public String getcontactperson() {
		return pro.getProperty("aiw.billingcontactperson");
	}public String getbillingcontactcode() {
		return pro.getProperty(" aiw.billingcontactcode");
	}public String getbillingphone() {
		return pro.getProperty("aiw.billingphone");
	}public String getemail() {
		return pro.getProperty("aiw.email");
	}public String getAddress() {
		return pro.getProperty("aiw.AddressLine");
	}public String getstate() {
		return pro.getProperty("aiw.state");
	}
	public String getzipcode() {
		return pro.getProperty("aiw.zipcode");
	}
	public String getprimaryemail() {
		return pro.getProperty("aiw.PrimaryEmail");
	}
	public String getcontactustitle() {
		return pro.getProperty("aiw.contactTitle");
	}
	public String getcontactustitlepage() {
		return pro.getProperty("aiw.contactustitlepage");
	}
	public String getconactusdesciption() {
		return pro.getProperty("aiw.contactDescription");
	}
	public String getconactuslabelthankyou() {
		return pro.getProperty("aiw.thankyoulabel");
	}
	public String getconactuslabelFirstnameLabelWarning() {
		return pro.getProperty("aiw.fristnamelabel");
	}
	public String getconactuslabelLastnameLabelWarning() {
		return pro.getProperty("aiw.lastnamelabel");
	}
	public String getconactuslabelEmailLabelWarning() {
		return pro.getProperty("aiw.emailwarninglabel");
	}
	// Sign up page Elements starts here
	public String getcontactusFirstname() {
		return pro.getProperty("aiw.contactus.firstname");
	}

	public String getcontactuslastname() {
		return pro.getProperty("aiw.contactus.lastname");
	}

	public String getcontactusEmailAddress() {
		return pro.getProperty("aiw.contactus.emailaddress");
	}
	
}  