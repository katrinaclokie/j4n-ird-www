package nz.co.bnz.webdriver;

import org.apache.commons.lang3.StringUtils;
import org.junit.rules.ExternalResource;

/**
 * JUnit rule to configure selenide.
 */
public class SelenideRule extends ExternalResource {

    private static final String SYSTEM_PROPERTY_KEY_FACTORY_CLASS = "browser";

    private String browser;

    /**
     * Use this constructor in most circumstances - this allows the browser to be configured at runtime.
     */
    public SelenideRule() {
        this(null);
    }

    /**
     * Set which browser to use. Use this constructor when the JUnit test must be run with a specific browser.
     */
    public SelenideRule(String browser) {
        this.browser = browser;
    }

    @Override
    protected void before() throws Throwable {
        setWebDriverProvider();
    }

    private void setWebDriverProvider() {
        System.setProperty("browser", "nz.co.bnz.webdriver.SelenideWebDriverProvider");
    }
}
