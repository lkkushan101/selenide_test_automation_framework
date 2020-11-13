package TestClasses;
import java.io.FileNotFoundException;
import java.io.IOException;
import Utility.*;
import static com.codeborne.selenide.Selenide.*;
import PageClasses.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.json.simple.parser.ParseException;
import com.codeborne.selenide.WebDriverRunner;

public class LoginTest {
	JSONReader jsonRead = new JSONReader();
	LoginPage loginPage = new LoginPage(driver);
	public static WebDriver driver  = null;
	@BeforeClass
	public void setup()
	{
		      driver = BaseClass.initilize();
	 }
	@Test
	public void test() throws FileNotFoundException, IOException, ParseException
	{
		WebDriverRunner.setWebDriver(driver);
		open(ConstantVariables.URl);
		loginPage.login(jsonRead.ReadJSONFile("username", "./Data/data.json"), jsonRead.ReadJSONFile("password", "./Data/data.json"));
		HomePage objHomePage = new HomePage(driver);
		objHomePage.getHomePageDashboardUserName();
		WebDriverRunner.getWebDriver().quit();
	}
}
