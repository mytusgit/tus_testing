import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import java.net.MalformedURLException;

public class TestGrid4TestNG {

	FirefoxDriver driver1;
	ChromeDriver driver2;
	String baseURL, nodeURL;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		baseURL = "https://www.calculator.net/triangle-calculator.html";
		nodeURL = "http://localhost:4444";
	}

	//
	// Тесты для родных драйверов
	//

	// Не все поля заданы
	@Test
	public void testEmptyField() throws MalformedURLException {
		System.out.println("Executing on Firefox");
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WINDOWS);
		driver1 = new FirefoxDriver(options);

		driver1.get(baseURL);

		driver1.manage().window().setSize(new Dimension(794, 586));
		driver1.findElement(
				By.cssSelector("#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(5) > td > img"))
				.click();
		driver1.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(1) > input"))
				.click();
		driver1.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(1) > input"))
				.sendKeys("7");
		driver1.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(3) > td:nth-child(3) > input"))
				.click();
		driver1.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(3) > td:nth-child(3) > input"))
				.sendKeys("7");
		driver1.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(5) > td > input[type=image]"))
				.click();
		Assert.assertEquals(driver1.findElement(By.cssSelector("#content > p:nth-child(4) > font")).getText(),
				"Please provide 3 positive values, including at least one side.");
		driver1.quit();
	}

	// Равносторонний треугольник
	@Test
	public void testEquilateralTriangle() throws MalformedURLException {
		System.out.println("Executing on Firefox");
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WINDOWS);
		driver1 = new FirefoxDriver(options);

		driver1.get(baseURL);

		driver1.manage().window().setSize(new Dimension(794, 586));
		driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[5]/td/img")).click();
		driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[1]/input"))
				.click();
		driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[1]/input"))
				.sendKeys("7");
		driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[3]/input"))
				.click();
		driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[3]/input"))
				.sendKeys("7");
		driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[3]/td[3]/input"))
				.click();
		driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[3]/td[3]/input"))
				.sendKeys("7");
		driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[5]/td/input")).click();
		Assert.assertEquals(driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td[1]/h3")).getText(),
				"Equilateral Triangle");
		driver1.quit();
	}

	// Не выполнились условия треугольника
	@Test
	public void testNotExistTriangle() throws MalformedURLException {
		System.out.println("Executing on Firefox");
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WINDOWS);
		driver1 = new FirefoxDriver(options);

		driver1.get(baseURL);

		driver1.manage().window().setSize(new Dimension(794, 586));
		driver1.findElement(By.cssSelector(".clearbtn")).click();
		driver1.findElement(By.name("vx")).click();
		driver1.findElement(By.name("vx")).sendKeys("5");
		driver1.findElement(By.name("vy")).click();
		driver1.findElement(By.name("vy")).sendKeys("10");
		driver1.findElement(By.name("vz")).click();
		driver1.findElement(By.name("vz")).sendKeys("15");
		driver1.findElement(By.cssSelector("tr:nth-child(5) input")).click();
		Assert.assertEquals(driver1.findElement(By.cssSelector("p:nth-child(4)")).getText(),
				"The sum of two sides must be larger than the third.");
		driver1.quit();
	}

	// Равнобедренный треугольник
	@Test
	public void testObtuseIsoscelesTriangle() throws MalformedURLException {
		System.out.println("Executing on Chrome");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);
		driver2 = new ChromeDriver(options);

		driver2.get(baseURL);

		driver2.manage().window().setSize(new Dimension(794, 586));
		driver2.findElement(By.cssSelector(".clearbtn")).click();
		driver2.findElement(By.name("vx")).click();
		driver2.findElement(By.name("vx")).sendKeys("10");
		driver2.findElement(By.name("vy")).click();
		driver2.findElement(By.name("vy")).sendKeys("10");
		driver2.findElement(By.name("vz")).click();
		driver2.findElement(By.name("vz")).sendKeys("15");
		driver2.findElement(By.cssSelector("tr:nth-child(5) input")).click();
		Assert.assertEquals(driver2.findElement(By.cssSelector("td > h3")).getText(), "Obtuse Isosceles Triangle");
		driver2.quit();
	}

	// Прямоугольный треугольник
	@Test
	public void testRightScaleneTriangle() throws MalformedURLException {
		System.out.println("Executing on Chrome");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);
		driver2 = new ChromeDriver(options);

		driver2.get(baseURL);

		driver2.manage().window().setSize(new Dimension(794, 586));
		driver2.findElement(By.cssSelector(".clearbtn")).click();
		driver2.findElement(By.name("va")).click();
		driver2.findElement(By.name("va")).sendKeys("90");
		driver2.findElement(By.name("vx")).click();
		driver2.findElement(By.name("vx")).sendKeys("8");
		driver2.findElement(By.name("vy")).click();
		driver2.findElement(By.name("vy")).sendKeys("10");
		driver2.findElement(By.cssSelector("tr:nth-child(5) input")).click();
		Assert.assertEquals(driver2.findElement(By.cssSelector("td > h3")).getText(), "Right Scalene Triangle");
		driver2.quit();
	}
}
