package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver getWebDriver(String browserName, String appUrl) {
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(appUrl);
        return driver;
    }

    protected void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Error while closing driver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        deleteAllFilesInFolder("allure-results");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllDriverProcesses();
    }

    protected void killAllDriverProcesses() {
        try {
            String[] driverNames = {"geckodriver", "chromedriver", "msedgedriver", "safaridriver"};
            String osName = GlobalConstants.OS_NAME.toLowerCase();
            String killCommand;
            ProcessBuilder processBuilder;

            for (String driverName : driverNames) {
                if (osName.contains("win")) {
                    killCommand = "taskkill /F /FI \"IMAGENAME eq " + driverName + "*\"";
                    processBuilder = new ProcessBuilder("cmd.exe", "/c", killCommand);
                } else {
                    killCommand = "pkill -f " + driverName;
                    processBuilder = new ProcessBuilder("sh", "-c", killCommand);
                }

                Process process = processBuilder.start();
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("Successfully terminated: " + driverName);
                } else {
                    System.out.println("Failed to terminate: " + driverName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error while killing driver processes: " + e.getMessage());
        }
    }

    public void deleteAllFilesInFolder(String folderName) {
        try {
            String folderPath = GlobalConstants.PROJECT_BASE_PATH + folderName;
            File folder = new File(folderPath);
            if (folder.exists()) {
                File[] listOfFiles = folder.listFiles();
                if (listOfFiles != null) {
                    for (File file : listOfFiles) {
                        if (file.isFile()) {
                            file.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error deleting files: " + e.getMessage());
        }
    }

    protected int getRandomNumber() {
        return new Random().nextInt(10000);
    }

}
