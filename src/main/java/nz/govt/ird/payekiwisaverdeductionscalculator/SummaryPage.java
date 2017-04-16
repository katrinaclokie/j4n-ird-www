package nz.govt.ird.payekiwisaverdeductionscalculator;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SummaryPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(SummaryPage.class);

    private WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getName() {
        String yourName = "#summary85 > div > table > tbody > tr:nth-child(1) > td:nth-child(2)";
        return $(yourName).getText();
    }

    public String getReferenceNumber() {
        String referenceNumber = "#summary85 > div > table > tbody > tr:nth-child(2) > td:nth-child(2)";
        return $(referenceNumber).getText();
    }

    public String getTaxCode() {
        String taxCode = "#summary85 > div > table > tbody > tr:nth-child(3) > td:nth-child(2)";
        return $(taxCode).getText();
    }

    public String getPayFrequency() {
        String payFrequency = "#summary96 > div > table > tbody > tr:nth-child(1) > td:nth-child(2)";
        return $(payFrequency).getText();
    }

    public String getPayAmount() {
        String payAmount = "#summary96 > div > table > tbody > tr:nth-child(3) > td:nth-child(2)";
        return $(payAmount).getText();
    }

    public String getCalculatePAYE() {
        String calculationPAYE = "#summary104 > div > table > tbody > tr:nth-child(2) > td:nth-child(3)";
        return $(calculationPAYE).getText();
    }
}
