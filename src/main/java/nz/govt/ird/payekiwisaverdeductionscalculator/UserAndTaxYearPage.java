package nz.govt.ird.payekiwisaverdeductionscalculator;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAndTaxYearPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAndTaxYearPage.class);

    private WebDriver driver;

    public UserAndTaxYearPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserAndTaxDetails(String user, String period) {
        selectUser(user);
        selectTaxPeriod(period);
        $("#submit").click();
    }

    private void selectUser(String user) {
        if (user.contentEquals("Employee")) {
            $("#n11").click();
        }
        else if (user.contentEquals("Employer")) {
            $("#n12").click();
        }
        else {
            LOGGER.warn("Invalid option for user: " + user);
        }
    }

    private void selectTaxPeriod(String period) {
        $("#qss2Interviews_PAYECalculatorUpdated_xintglobalglobal7").selectOptionByValue(period);
    }

}
