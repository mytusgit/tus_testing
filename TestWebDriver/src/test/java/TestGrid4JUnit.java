import static org.junit.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@TestInstance(Lifecycle.PER_CLASS)
class TestGrid4JUnit {
	private WebDriver driver;

	String baseURL, nodeURL;

	@BeforeAll
	public void setUp_1() throws MalformedURLException {
		baseURL = "https://www.calculator.net/triangle-calculator.html";
		nodeURL = "http://localhost:4444/";
	}

	@AfterEach
	public void tearDown_1() {
		driver.close();
	}

	//
	// Тесты для неродных драйверов
	//

	// Тесты Firefox

	// Не все поля заданы
	@Test
	public void testEmptyField_Ff() throws Throwable {
		System.out.println("Executing on Firefox");
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);

		driver = new RemoteWebDriver(new URL(nodeURL), capability);

		driver.get(baseURL);
		
		driver.manage().window().setSize(new Dimension(794, 586));
		driver.findElement(
				By.cssSelector("#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(5) > td > img"))
				.click();
		driver.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(1) > input"))
				.click();
		driver.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(1) > input"))
				.sendKeys("7");
		driver.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(3) > td:nth-child(3) > input"))
				.click();
		driver.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(3) > td:nth-child(3) > input"))
				.sendKeys("7");
		driver.findElement(By.cssSelector(
				"#content > table.panel > tbody > tr > td > table > tbody > tr:nth-child(5) > td > input[type=image]"))
				.click();
		assertEquals(driver.findElement(By.cssSelector("#content > p:nth-child(4) > font")).getText(),
				"Please provide 3 positive values, including at least one side.");
	}

	// Равносторонний треугольник
	@Test
	public void testEquilateralTriangle_Ff() throws Throwable {
		System.out.println("Executing on Firefox");
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);

		driver = new RemoteWebDriver(new URL(nodeURL), capability);

		driver.get(baseURL);
		
		driver.manage().window().setSize(new Dimension(794, 586));
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[5]/td/img")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[1]/input"))
				.sendKeys("7");
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[3]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td[3]/input"))
				.sendKeys("7");
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[3]/td[3]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[3]/td[3]/input"))
				.sendKeys("7");
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[5]/td/input")).click();
		assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td[1]/h3")).getText(),
				"Equilateral Triangle");
	}

	// Не выполнились условия треугольника
	@Test
	public void testNotExistTriangle_Ff() throws Throwable {
		System.out.println("Executing on Firefox");
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);

		driver = new RemoteWebDriver(new URL(nodeURL), capability);

		driver.get(baseURL);
		
		driver.manage().window().setSize(new Dimension(794, 586));
		driver.findElement(By.cssSelector(".clearbtn")).click();
		driver.findElement(By.name("vx")).click();
		driver.findElement(By.name("vx")).sendKeys("5");
		driver.findElement(By.name("vy")).click();
		driver.findElement(By.name("vy")).sendKeys("10");
		driver.findElement(By.name("vz")).click();
		driver.findElement(By.name("vz")).sendKeys("15");
		driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
		assertEquals(driver.findElement(By.cssSelector("p:nth-child(4)")).getText(),
				"The sum of two sides must be larger than the third.");
	}

	// Равнобедренный треугольник
	@Test
	public void testObtuseIsoscelesTriangle_Chrome() throws Throwable {
		System.out.println("Executing on Chrome");
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WINDOWS);

		driver = new RemoteWebDriver(new URL(nodeURL), capability);

		driver.get(baseURL);
		
		driver.manage().window().setSize(new Dimension(794, 586));
		driver.findElement(By.cssSelector(".clearbtn")).click();
		driver.findElement(By.name("vx")).click();
		driver.findElement(By.name("vx")).sendKeys("10");
		driver.findElement(By.name("vy")).click();
		driver.findElement(By.name("vy")).sendKeys("10");
		driver.findElement(By.name("vz")).click();
		driver.findElement(By.name("vz")).sendKeys("15");
		driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
		assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Obtuse Isosceles Triangle");
	}

	// Прямоугольный треугольник
	@Test
	public void testRightScaleneTriangle_Chrome() throws Throwable {
		System.out.println("Executing on Chrome");
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WINDOWS);

		driver = new RemoteWebDriver(new URL(nodeURL), capability);

		driver.get(baseURL);
		
		driver.manage().window().setSize(new Dimension(794, 586));
		driver.findElement(By.cssSelector(".clearbtn")).click();
		driver.findElement(By.name("va")).click();
		driver.findElement(By.name("va")).sendKeys("90");
		driver.findElement(By.name("vx")).click();
		driver.findElement(By.name("vx")).sendKeys("8");
		driver.findElement(By.name("vy")).click();
		driver.findElement(By.name("vy")).sendKeys("10");
		driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
		assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Right Scalene Triangle");
	}
}
