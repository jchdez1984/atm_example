package nicebank;

import common.AbstractSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends AbstractSteps {
    
    @Given("^I have deposited \\$(\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(int arg1) throws Throwable {

    }

    @When("^I request \\$(\\d+)$")
    public void i_request_$(int arg1) throws Throwable {

    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int arg1) throws Throwable {

    }
}
