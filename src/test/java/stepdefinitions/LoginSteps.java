package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private String username;
    private String password;
    private String errorMessage;
    private boolean loggedIn;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        System.out.println("User is on login page");
    }

    @When("the user enters username {string}")
    public void userEntersUsername(String username) {
        this.username = username;
    }

    @When("the user enters password {string}")
    public void userEntersPassword(String password) {
        this.password = password;
    }

    @When("the user clicks the login button")
    public void userClicksLoginButton() {

        if (username == null || username.isEmpty()) {
            errorMessage = "Username is required";
        } else if (!username.equals("admin")
                || !password.equals("admin123")) {
            errorMessage = "Invalid username or password";
        } else {
            loggedIn = true;
        }
    }

    @Then("the user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        assertEquals(true, loggedIn);
    }

    @Then("the user should see an {string} error")
    public void userShouldSeeError(String expectedError) {
        assertEquals(expectedError, errorMessage);
    }
}
