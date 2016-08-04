package nz.co.bnz.webdriver;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.WebDriverProvider;

public class SelenideWebDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
        firefoxProfile.setPreference("startup.homepage_welcome_url", "about:blank");
        firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        firefoxProfile.setPreference("app.update.auto", false);
        firefoxProfile.setPreference("app.update.enabled", false);
        firefoxProfile.setPreference("app.update.silent", true);

        firefoxProfile.setPreference("network.automatic-ntlm-auth.trusted-uris", ".thenational.com, .bnz.co.nz");
        firefoxProfile.setPreference("network.automatic-ntlm-auth.allow-non-fqdn", true);
        firefoxProfile.setPreference("network.negotiate-auth.delegation-uris", ".thenational.com, .bnz.co.nz");
        firefoxProfile.setPreference("network.negotiate-auth.trusted-uris", ".thenational.com, .bnz.co.nz");
        firefoxProfile.setPreference("network.negotiate-auth.using-native-gsslib", false);

        desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

        Proxy proxy = new Proxy();
        proxy.setProxyType(ProxyType.SYSTEM);

        desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
        desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);

        return new FirefoxDriver(desiredCapabilities);
    }
}
