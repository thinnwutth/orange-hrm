package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.menu;

public class ActionWords {
    public static String browser;
    static WebDriver driver;
    Duration timeout;
    public static void main(String[] args) throws IOException {

    }
    @Before
    public void setBrowserConfig() {
        String projectLocation = System.getProperty("user.dir");
        System.out.println("Project Location" + projectLocation);
        //System.setProperty("webdriver.chrome.driver", projectLocation + "/chromedriver_linux64/chromedriver");
        //System.setProperty("webdriver.chrome.driver", projectLocation + "/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", projectLocation + "/chromedriver_mac64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public static void runTest(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public static void Navigatetologinscreen() throws IOException {
        runTest();
    }

    public void setWait(){
        timeout = Duration.ofSeconds(60);

    }

    public void enterUsernameP1(String userName) {
        setWait();
        WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        element.sendKeys(userName);
    }

    public void enterPasswordP1(String password) {
        setWait();
        WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        element.sendKeys(password);
    }

    public void ClickLoginbutton() {
        WebElement clickable =  driver.findElement(By.xpath("//button[@type='submit']"));
        clickable.click();
    }

    public void ClickonPIMfromsidemenubar() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '/web/index.php/pim/viewPimModule')]")));
        clickable.click();
    }

    public void TypechintheEmployeeNametextinputfield(String EmployeeName) {
        WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")));
        element.sendKeys(EmployeeName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement EmpNameDropdown = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-autocomplete-dropdown")));
        List<WebElement> dropdownList = EmpNameDropdown.findElements(By.xpath("./*"));
        System.out.println("Number of child elements in autocompleteDropdown: " + dropdownList.size());
        for (WebElement EmpNameElement : dropdownList) {
            String EmpName = EmpNameElement.getText().toLowerCase();
            if (EmpName.contains(EmployeeName)) {
                System.out.println(EmpName);
            }else {
                throw new AssertionError("Employee name does not contain 'ch'");
            }
        }
    }

    public void ClickongreenSearchbutton() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        clickable.click();
    }

    public void Thesystemwilldisplayresultsofrecordsfound() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement SearchTable = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-table")));
        List<WebElement> rows = SearchTable.findElements(By.className("oxd-table-row"));
        System.out.println("rows:" + rows.size());
        int rowCount = rows.size();
        if (rowCount >= 3) {
            System.out.println("Table has at least three rows.");
        } else {
            throw new AssertionError("Table does not have at least three rows.");
        }

        List<String> firstName = new ArrayList<>();
        List<String> lastName = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.className("oxd-table-cell"));
            int colCount = cols.size();
            for (int i = 0; i < colCount; i++) {
                WebElement col = cols.get(i);
                String cellData = col.getText();
                if (i == 2) { // Column 3
                    firstName.add(cellData);
                } else if (i == 3) { // Column 4
                    lastName.add(cellData);
                }
                System.out.print(cellData + "\t");
            }
            System.out.println();
        }

        System.out.println("Column 2: " + firstName);
        System.out.println("Column 3: " + lastName);
        boolean isMatchFound = false;
        for (String name : firstName) {
            if (name.toLowerCase().contains("ch")) {
                isMatchFound = true;
                System.out.println("ch includes in first name");
                break;
            }
        }
        if (!isMatchFound) {
            for (String name : lastName) {
                if (name.toLowerCase().contains("ch")) {
                    isMatchFound = true;
                    System.out.println("ch includes in last name");
                    break;
                }
            }
        }
        if (!isMatchFound) {
            throw new AssertionError("ch does not include in either first or last name");
        }
    }

    public void ClickonAdminfromsidemenubar() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '/web/index.php/admin/viewAdminModule')]")));
        clickable.click();
    }

    public void ClickJobdropdown() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[(text() = 'Job ' or . = 'Job ')]")));
        clickable.click();
    }

    public void ClickPayGrades() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[(text() = 'Pay Grades' or . = 'Pay Grades')]")));
        clickable.click();
    }

    public void ClickgreenAddbutton() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
        clickable.click();
    }

    public void TypepayGradeNameinthenameinputfield(String payGradeName) {
        setWait();
        WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/form/div/div/div/div/div[2]/input")));
        element.sendKeys(payGradeName);
    }

    public void ClickgreenSavebutton() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type = 'submit' and (text() = ' Save ' or . = ' Save ')]")));
        clickable.click();
    }

    public void ClickgreenAddbuttonontheCurrenciessection() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type = 'button' and (text() = ' Add ' or . = ' Add ')]")));
        clickable.click();
    }

    public void SelectIndianRupeefromCurrentdropdown() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'-- Select --')]")));
        clickable.click();
        setWait();
        WebElement clickable1 = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[(text() = 'INR - Indian Rupee')]")));
        clickable1.click();
    }

    public void TypeMinimumSalary(String miniSalary) {
        setWait();
        WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")));
        element.sendKeys(miniSalary);
    }

    public void TypeMaximumSalary(String maxiSalary) {
        setWait();
        WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")));
        element.sendKeys(maxiSalary);
    }

    public void ClickgreenSavebuttononCurrenciessection() {
        setWait();
        WebElement clickable = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[3]/button[2]")));
        clickable.click();
    }

    public void VerifyusercanobservetheaddedrecordsintheCurrenciessection(String miniSalary, String maxiSalary) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addedRow = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-table")));
        List<WebElement> rows = addedRow.findElements(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]"));
        System.out.println("rows:" + rows.size());

        List<String> currency = new ArrayList<>();
        List<String> actualMiniSalary = new ArrayList<>();
        List<String> actualMaxiSalary = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.className("oxd-table-cell"));
            int colCount = cols.size();
            for (int i = 0; i < colCount; i++) {
                WebElement col = cols.get(i);
                String cellData = col.getText();
                if (i == 1) {
                    currency.add(cellData);
                } else if (i == 2) {
                    actualMiniSalary.add(String.valueOf((long) Double.parseDouble(cellData)));
                }else if (i == 3) {
                    actualMaxiSalary.add(String.valueOf((long) Double.parseDouble(cellData)));
                }
                System.out.print(cellData + "\t");
            }
            System.out.println();
        }

        String expectedCurrency = "Indian Rupee";
        if (currency.size() == 1 && actualMiniSalary.size() == 1 && currency.get(0).equals(expectedCurrency) && actualMiniSalary.get(0).equals(miniSalary) && currency.get(0).equals(expectedCurrency) && actualMaxiSalary.get(0).equals(maxiSalary)) {
            System.out.println("The added record was found in the Currencies table");
        } else {
            throw new AssertionError("No result found in the Currencies table");
        }

    }

    @After
    public static void tearDown(){
        driver.quit();
    }

}


