import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://themes.woocommerce.com/homestore/");
        driver.manage().window().maximize();
    }

    @AfterEach
    void close(){
        driver.quit();
    }
}
