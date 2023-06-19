package api.stepdefinitions;

import api.app.testfunctions.FetchSearchInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class APIBookingStepDef {

	@Given("User hits booking request api with test data")
	public void user_hits_booking_request_api_with_test_data() {
		FetchSearchInfo.getDataSearchDetails();
	}

	@Then("User verifies that response status code is {int}")
	public void user_verifies_that_response_status_code_is(Integer code) {
		FetchSearchInfo.verifyStatus(code);
	}

	@Then("User verifies that response json data as expected results")
	public void user_verifies_that_response_json_data_as_expected_results() {
	}
}