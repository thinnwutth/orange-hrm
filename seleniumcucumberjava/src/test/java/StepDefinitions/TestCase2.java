package StepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class TestCase2{
    public ActionWords actionwords = new ActionWords();

    @And("Click on Admin from side menu bar")
    public void ClickonAdminfromsidemenubar(){
        actionwords.ClickonAdminfromsidemenubar();
    }
    @And("Click Job dropdown")
    public void ClickJobdropdown(){
        actionwords.ClickJobdropdown();
    }
    @And("Click Pay Grades")
    public void ClickPayGrades(){
        actionwords.ClickPayGrades();
    }
    @And("Click green +Add button")
    public void ClickgreenAddbutton(){
        actionwords.ClickgreenAddbutton();
    }
    @And("^Type \"([^\"]*)\" in the name input field$")
    public void TypepayGradeNameinthenameinputfield(String payGradeName) {
        actionwords.TypepayGradeNameinthenameinputfield(payGradeName);
    }

    @And("Click green Save button")
    public void ClickgreenSavebutton(){
        actionwords.ClickgreenSavebutton();
    }
    @And("Click green + Add button on the Currencies section")
    public void ClickgreenAddbuttonontheCurrenciessection(){
        actionwords.ClickgreenAddbuttonontheCurrenciessection();
    }
    @And("Select Indian Rupee from Current dropdown")
    public void SelectIndianRupeefromCurrentdropdown(){
        actionwords.SelectIndianRupeefromCurrentdropdown();
    }
    @And("^Type Minimum Salary as \"([^\"]*)\"$")
    public void TypeMinimumSalary(String miniSalary) {
        actionwords.TypeMinimumSalary(miniSalary);
    }

    @And("^Type Maximum Salary as \"([^\"]*)\"$")
    public void TypeMaximumSalary(String maxiSalary) {
        actionwords.TypeMaximumSalary(maxiSalary);
    }
    @And("Click green Save button on Currencies section")
    public void ClickgreenSavebuttononCurrenciessection(){
        actionwords.ClickgreenSavebuttononCurrenciessection();
    }
    @Then("Verify user can observe the added records in the Currencies section \"([^\"]*)\" and \"([^\"]*)\"$")
    public void VerifyusercanobservetheaddedrecordsintheCurrenciessection(String miniSalary, String maxiSalary){
        actionwords.VerifyusercanobservetheaddedrecordsintheCurrenciessection(miniSalary,maxiSalary);
    }

}
