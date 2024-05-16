package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Base {
    public String takeScreenShot(String testName, WebDriver driver) {
        File sourceScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinatioScreenshotFile = new File(System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + testName + ".png");
        try {
            FileUtils.copyFile(sourceScreenshotFile, destinatioScreenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destinatioScreenshotFile.getAbsolutePath();
    }
}
