import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTests1 {

    public WebDriver driver;
    @Test
    public void test11() {
        System.out.println("It is test 11");
        Assert.assertTrue(true);
    }

    @Test
    public void test12() {
        System.out.println("It is test 12");
        Assert.assertTrue(true);
    }

    @Test
    public void testToFail() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yavlena.com");
        Assert.assertTrue("Varna".equals("Burgas"));
    }
}
