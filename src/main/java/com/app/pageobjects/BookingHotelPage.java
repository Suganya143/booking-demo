package com.app.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.commons.BrowserUtils;

public class BookingHotelPage {

	final WebDriver driver;

	String selectCheckInOutDate = "//div[@id='calendar-searchboxdatepicker']//td//span[text()='value']";

	@FindBy(id = "onetrust-accept-btn-handler")
	WebElement acceptButton;

	@FindBy(css = "input[name='ss']")
	WebElement destination;

	@FindBys(@FindBy(css = "div[data-testid='destination-container'] ul li div[role='button']"))
	List<WebElement> destinationDropdownList;

	@FindBy(css = "div[class='hero-banner-searchbox'] button[type='submit']")
	WebElement searchButton;

	@FindBys(@FindBy(css = "a[data-testid='availability-cta-btn']"))
	List<WebElement> availabilityButtonList;

	@FindBy(css = "div[class='property_hightlights_wrapper'] button[class*='primary']")
	WebElement reserveButton;
	
	@FindBy(css = "select[data-testid='select-room-trigger']")
	WebElement roomDropdown;
	
	@FindBy(css = "div[class*='reservation'] button[class*='primary']")
	WebElement iReserveButton;

	@FindBy(id= "firstname")
	WebElement firstNameField;

	@FindBy(id= "lastname")
	WebElement lastNameField;

	@FindBy(id= "email")
	WebElement emailAddressField;

	@FindBy(css= "button[data-popover-content-id='bp-submit-popover']")
	WebElement finalDetailsButton;

	@FindBy(id= "address1")
	WebElement addressField;

	@FindBy(id= "city")
	WebElement cityField;

	@FindBy(css= "#phone")
	WebElement mobileNumberField;

	@FindBy(css= "input[name='name']")
	WebElement cardHolderNameField;

	@FindBy(css= "input[id*='pc-card-number-field']")
	WebElement cardNumberField;

	@FindBy(css= "input[id*='pc-card-expiration-date']")
	WebElement expirationDateField;

	@FindBy(id= "P0-1")
	WebElement cvvField;

	@FindBy(css= "button[name='book']")
	WebElement bookingButton;

	@FindBy(css= "iframe[title='Payment']")
	WebElement paymentIFrame;
	
	public BookingHotelPage() {
		this.driver = BrowserUtils.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void clickAcceptButton() {
		this.acceptButton.click();
	}

	public void selectDestination(String destination) {
		BrowserUtils.waitForElementToBeClickable(this.destination, 2);
		BrowserUtils.enterValueUsingJS(this.destination, destination);
		this.destination.click();
		this.destinationDropdownList.get(0).click();
	}

	public void selectCheckInDate(String date) {
		List<WebElement> element = driver.findElements(By.xpath(selectCheckInOutDate.replace("value", date)));
		element.get(1).click();
	}

	public void clickSearchButton() {
		BrowserUtils.waitForElementToBeClickable(this.searchButton, 2);
		this.searchButton.click();
	}

	public void clickAvailabilityButtonFromListByPosition(int position) {
		BrowserUtils.waitForElementToBeClickable(this.availabilityButtonList.get(position-1), 2);
		this.availabilityButtonList.get(position - 1).click();
	}
	
	public void clickReserveButton() {
		this.reserveButton.click();
	}
	
	public void selectRoomDropdown(String value) {
		Select dropdown = new Select(this.roomDropdown);
		dropdown.selectByValue(value);
	}

	public void clickIReserveButton() {
		this.iReserveButton.click();
	}
	
	public void enterFirstName(String firstName) {
		this.firstNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		this.lastNameField.sendKeys(lastName);
	}
	
	public void enterEmailAddress(String emailId) {
		this.emailAddressField.sendKeys(emailId);
	}
	
	public void clickFinalDetailsButton() {
		this.finalDetailsButton.click();
	}
	
	public void enterAddressDetails(String address) {
		this.addressField.sendKeys(address);
	}
	
	public void enterCity(String city) {
		this.cityField.sendKeys(city);
	}
	
	public void enterMobileNumber(String number) {
		BrowserUtils.moveToElementAndclick(this.mobileNumberField);
//		this.mobileNumberField.sendKeys(number);
		BrowserUtils.enterValueUsingJS(this.mobileNumberField, number);
	}
	
	public void enterCardHolderName(String name) {
		BrowserUtils.scrollToBottom();
		this.cardHolderNameField.sendKeys(name);
	}
	
	public void enterCardNumber(String number) {
		BrowserUtils.scrollToBottom();
		BrowserUtils.switchToIframe(this.paymentIFrame);
		this.cardNumberField.sendKeys(number);
	}
	
	public void enterExpirationDate(String expiryDate) {
		BrowserUtils.moveToElementAndclick(this.expirationDateField);
		this.expirationDateField.sendKeys(expiryDate);
	}
	
	public void enterCVC(String cvc) {
		this.cvvField.sendKeys(cvc);
	}
	
	public void clicksBookingButton() {
		BrowserUtils.switchToDefaultContent();
		this.bookingButton.click();
	}
}
