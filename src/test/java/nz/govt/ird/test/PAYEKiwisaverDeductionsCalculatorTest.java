package nz.govt.ird.test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;
import nz.co.bnz.webdriver.SelenideRule;
import nz.govt.ird.payekiwisaverdeductionscalculator.EmployeeDetailsPage;
import nz.govt.ird.payekiwisaverdeductionscalculator.SummaryPage;
import nz.govt.ird.payekiwisaverdeductionscalculator.UserAndTaxYearPage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PAYEKiwisaverDeductionsCalculatorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PAYEKiwisaverDeductionsCalculatorTest.class);

    private static WebDriver driver;

    @ClassRule
    public static SelenideRule selenideRule = new SelenideRule();

    @BeforeClass
    public static void setupDriver() {
        driver = getWebDriver();
    }

    @Before
    public void openKiwisaverDeductionsCalculator() {
        String url = "http://brc.ird.govt.nz/web-determinations/startsession/PAYE_Calculator/en-GB/Attribute~b1%40Rules_ProceduralRules_VisibilityRules_doc~global~global";
        LOGGER.info(url);
        open(url);
    }

    @Test
    public void testDefaultValues() {
        UserAndTaxYearPage userTaxYearPage = new UserAndTaxYearPage(driver);
        userTaxYearPage.enterUserAndTaxDetails("Employee", "1 April 2017 to 31 March 2018");

        EmployeeDetailsPage employeeDetailsPage = new EmployeeDetailsPage(driver);
        employeeDetailsPage.enterPayDetails("Test User", "TEST1234", "M", "Weekly", "1,024.00", "Net");

        SummaryPage summaryPage = new SummaryPage(driver);
        assertEquals("Name should be Test User", "Test User", summaryPage.getName());
        assertEquals("Reference should be TEST1234", "TEST1234", summaryPage.getReferenceNumber());
        assertEquals("Tax code should be M", "M", summaryPage.getTaxCode());
        assertEquals("Pay frequency should be Weekly", "Weekly", summaryPage.getPayFrequency());
        assertEquals("Pay amount should be $1,024.00 net", "$1,024.00 net", summaryPage.getPayAmount());
    }

}
