package StepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class TestCase1{
    public ActionWords actionwords = new ActionWords();

    @Given("Navigate to login screen")
    public void Navigatetologinscreen() throws IOException {
        actionwords.Navigatetologinscreen();
    }

    @When("^enter username: \"([^\"]*)\"$")
    public void enterUsernameP1(String userName) {
        actionwords.enterUsernameP1(userName);
    }

    @And("^enter password: \"([^\"]*)\"$")
    public void enterPasswordP1(String password) {
        actionwords.enterPasswordP1(password);
    }

    @And("Click Login button")
    public void ClickLoginbutton() {
        actionwords.ClickLoginbutton();
    }

    @And("Click on PIM from side menu bar")
    public void ClickonPIMfromsidemenubar() {
        actionwords.ClickonPIMfromsidemenubar();
    }

    @And("^Type \"([^\"]*)\" in the Employee Name text input field$")
    public void TypechintheEmployeeNametextinputfield(String EmployeeName) {
        actionwords.TypechintheEmployeeNametextinputfield(EmployeeName);
    }

    @And("Click on green Search button")
    public void ClickongreenSearchbutton() {
        actionwords.ClickongreenSearchbutton();
    }
    @Then("The system will display results of records found")
    public void Thesystemwilldisplayresultsofrecordsfound(){
        actionwords.Thesystemwilldisplayresultsofrecordsfound();
    }


}
