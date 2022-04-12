import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.qameta.allure.Attachment;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@TestInstance(Lifecycle.PER_CLASS)
public class TestTriangle {
	private WebDriver driver;

	@AfterEach
	public void takeScreenTest() {
		makeScreenshot();
	}

	@Attachment(value = "Attachment Screenshot", type = "image/png")
	public byte[] makeScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@BeforeAll
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterAll
	public void tearDown() {
		driver.quit();
	}

	// Ne vse polya zadany
	@Test
	public void testEmptyField() {
		driver.get("https://www.calculator.net/triangle-calculator.html");
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

	// Ravnostoronnij treugol'nik
	@Test
	public void testEquilateralTriangle() {
		driver.get("https://www.calculator.net/triangle-calculator.html");
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

	// Ne vypolnilis' usloviya treugol'nika
	@Test
	public void testNotExistTriangle() {
		driver.get("https://www.calculator.net/triangle-calculator.html");
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

	// Ravnobedrennyj treugol'nik
	@Test
	public void testObtuseIsoscelesTriangle() {
		driver.get("https://www.calculator.net/triangle-calculator.html");
		driver.manage().window().setSize(new Dimension(794, 586));
		driver.findElement(By.cssSelector(".clearbtn")).click();
		driver.findElement(By.name("vx")).click();
		driver.findElement(By.name("vx")).sendKeys("10");
		driver.findElement(By.name("vy")).click();
		driver.findElement(By.name("vy")).sendKeys("10");
		driver.findElement(By.name("vz")).click();
		driver.findElement(By.name("vz")).sendKeys("15");
		driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
		assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "-Obtuse Isosceles Triangle");
	}

	// Pryamougol'nyj treugol'nik
	@Test
	public void testRightScaleneTriangle() {
		driver.get("https://www.calculator.net/triangle-calculator.html");
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
