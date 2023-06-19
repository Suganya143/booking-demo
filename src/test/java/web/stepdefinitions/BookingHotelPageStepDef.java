package web.stepdefinitions;

import java.util.Properties;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import web.app.commons.BrowserUtils;
import web.app.commons.GenericUtils;
import web.app.pageobjects.BookingHotelPage;

public class BookingHotelPageStepDef {
	
	private final BookingHotelPage bookingHotelPage = new BookingHotelPage();
	private final Properties property = GenericUtils.AppFileReader("src/main/resources/data/web/App.properties");
	private final String url = property.getProperty("Booking_URL");

	@Given("User launches the booking application")
	public void launches_exeter_app() {
		BrowserUtils.openPage(url);
	}

	@Given("User verifies browser title for booking home page is displayed")
	public void clicks_privacy_policys() {
		bookingHotelPage.clickAcceptButton();
		Assert.assertTrue("Verify browser title",
				property.getProperty("Booking_HomePage_Title").trim().equals(BrowserUtils.getTitle().trim()));
	}

	@Then("^User selects destination as \"(.*?)\"$")
	public void user_selects_destination(String destination) {
		bookingHotelPage.selectDestination(destination);
	}

	@Then("^User selects check (.*) date as current date plus (.*) days$")
	public void user_selects_check_in_date_as_current_date_plus_days(String field, Integer incrementDaysBy) {
		int futureDayOfMonth = GenericUtils.getDayByIncrementDaysFromcurrentDate(incrementDaysBy);
		bookingHotelPage.selectCheckInDate(Integer.toString(futureDayOfMonth));
	}

	@Then("User clicks on Search button")
	public void user_clicks_on_search_button() {
		bookingHotelPage.clickSearchButton();
	}

	@Then("User clicks on see availability button of the first hotel in searched list")
	public void user_clicks_availability_first_hotel() {
		bookingHotelPage.clickAvailabilityButtonFromListByPosition(1);
	}

	@Then("User navigates to hotel details page")
	public void user_navigates_hotel_details() {
		BrowserUtils.switchToChildWindow();
	}

	@Then("User clicks on the reserve button")
	public void user_clicks_reserve() {
		BrowserUtils.scrollToBottom();
		bookingHotelPage.clickReserveButton();
	}

	@Given("^User selects amount as \"(.*?)\"$")
	public void user_selects_amount(String value) {
		BrowserUtils.scrollToBottom();
		bookingHotelPage.selectRoomDropdown(value);
	}

	@Then("User clicks on I'll reserve button")
	public void user_clicks_i_reserve() {
		bookingHotelPage.clickIReserveButton();
	}

	@Given("^User enters first name as \"(.*?)\"$")
	public void user_enters_firstName(String firstName) {
		bookingHotelPage.enterFirstName(firstName);
	}

	@Given("^User enters last name as \"(.*?)\"$")
	public void user_enters_lastName(String lastName) {
		bookingHotelPage.enterLastName(lastName);
	}

	@Given("^User enters email id as \"(.*?)\"$")
	public void user_enters_emailId(String mailId) {
		bookingHotelPage.enterEmailAddress(mailId);
	}

	@Given("^User clicks on final details$")
	public void user_clicks_final_button() {
		bookingHotelPage.clickFinalDetailsButton();
	}

	@Given("^User enters address as \"(.*?)\"$")
	public void user_enters_address(String address) {
		bookingHotelPage.enterAddressDetails(address);
	}

	@Given("^User enters city as \"(.*?)\"$")
	public void user_enters_city(String city) {
		bookingHotelPage.enterCity(city);
	}

	@Given("^User enters mobile number as \"(.*?)\"$")
	public void user_enters_mobile_number(String mobileNumber) {
		bookingHotelPage.enterMobileNumber(mobileNumber);
	}

	@Given("User enters card number")
	public void user_enters_card_number() {
		bookingHotelPage.enterCardNumber(property.getProperty("CardNumber"));
	}
	
	@Given("User enters expiration date")
	public void user_enters_expiration_date() {
		bookingHotelPage.enterExpirationDate(property.getProperty("ExpirationDate"));
	}
	
	@Given("User enters CVC")
	public void user_enters_cvc() {
		bookingHotelPage.enterCVC(property.getProperty("CVC"));
	}
	
	@Given("User clicks on complete booking")
	public void user_clicks_on_complete_booking() {
		bookingHotelPage.clicksBookingButton();
	}
}