package gradle.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.client.RestClient;

import static org.junit.Assert.assertEquals;

public class PeopleStepDefs {
    private static final String EXPECTED_PERSON = "[{\"id\":1,\"fullName\":\"Fernando Ayala\",\"jobTitle\":\"DevOps\"}]";
    private RestClient client;

    @Given("^there is a rest api service client$")
    public void thereIsARestApiServiceClient() {
        client = new RestClient();
    }

    @When("^I add (.*) with Job title (.*)$")
    public void iAddAPersonWithJobTitle(String name, String title) {
        client.postPerson(name, title);
    }

    @Then("^I get listed the new person$")
    public void itGetListedTheNewPerson() {
        String person = client.getPeople();
        assertEquals("Person is expected.", EXPECTED_PERSON, person);
    }
}
