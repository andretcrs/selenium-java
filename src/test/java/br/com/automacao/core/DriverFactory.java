package br.com.automacao.core;

import br.com.automacao.config.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigManager.get("browser");

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                // Detecta se está rodando no GitHub Actions
                boolean isCI = System.getenv("GITHUB_ACTIONS") != null;

                if (isCI) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu"); // Recomendado para ambientes Linux CI
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--remote-allow-origins=*");
                }

                driver = new ChromeDriver(options);
            }

            // Só maximiza se NÃO estiver em modo headless (no headless definimos o window-size acima)
            if (driver != null && System.getenv("GITHUB_ACTIONS") == null) {
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}