package StepDefinition;

import Library.ApiCall;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiSteps {
	
	ApiCall apiCall = new ApiCall();
	
	@Given("Client without auth")
	public void client_without_auth() {
	    apiCall.setBaseURI();
	}
	
	@When("Client {string} request with path {string}")
	public void user_get_request_with_path(String method, String path) {
	    apiCall.sendRequest(method, path);
	}
	
	@When("Client {string} request with path {string} with body:")
	public void client_request_with_path_with_body(String method, String path, String body) {
	    apiCall.sendRequestWithBody(method, path, body);
	}
	
	@Then("Client assert {string} should be match with {int}")
	public void user_assert_should_be_match_with(String path, Integer expected) {
	    apiCall.assertDataEquals(path, expected);
	}

	@Then("Response status should be {int}")
	public void response_status_should_be(Integer expected) {
	    apiCall.isResponseCode(expected);
	}

	@Then("Response message should be {string}")
	public void response_message_should_be(String expected) {
	    apiCall.isResponseMessageError(expected);
	}
}
