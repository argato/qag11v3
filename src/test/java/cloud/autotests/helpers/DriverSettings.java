package cloud.autotests.helpers;

import cloud.autotests.config.Project;
import cloud.autotests.config.planetazdorovo.App;
import com.codeborne.selenide.Configuration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();
        System.out.println("+++++++++webUrl=" + App.config.webUrl());
        System.out.println("+++++++++Configuration.baseUrl=" + Configuration.baseUrl);
        System.out.println("+++++++++Configuration.browserVersion=" + Configuration.browserVersion);
        System.out.println("+++++++++Configuration.remote=" + Configuration.remote);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (Project.isWebMobile()) { // for chrome only
            ChromeOptions chromeOptions = new ChromeOptions();
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", Project.config.browserMobileView());
            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            String user = Project.config.remoteDriverUser();
            String password = Project.config.remoteDriverPassword();
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub", user, password,
                                                 Project.config.remoteDriverUrl());
        }

        Configuration.browserCapabilities = capabilities;
    }
}
