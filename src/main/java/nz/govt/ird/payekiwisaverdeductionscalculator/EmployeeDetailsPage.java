package nz.govt.ird.payekiwisaverdeductionscalculator;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDetailsPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDetailsPage.class);

    private WebDriver driver;

    public EmployeeDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPayDetails(String name, String reference, String tax, String frequency, String perPay, String amount) {

        $("#qss3Interviews_PAYECalculatorUpdated_xintglobalglobal7").sendKeys(name);
        $("#qss3Interviews_PAYECalculatorUpdated_xintglobalglobal9").sendKeys(reference);
        $("#qss3Interviews_PAYECalculatorUpdated_xintglobalglobal11").selectOptionByValue(tax);

        $("#qss3Interviews_PAYECalculatorUpdated_xintglobalglobal19").selectOptionByValue(frequency);
        $("#qss3Interviews_PAYECalculatorUpdated_xintglobalglobal20").sendKeys(perPay);
        selectAmountNetOrGross(amount);

        $("#submit").click();
    }

    private void selectAmountNetOrGross(String amount) {
        if (amount.contentEquals("Gross")) {
            $("#n81").click();
        }
        else if (amount.contentEquals("Net")) {
            $("#n92").click();
        }
        else {
            LOGGER.warn("Invalid option for amount: " + amount);
        }
    }
}
