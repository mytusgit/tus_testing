package calculator;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class StepsTriangle {
	WebDriver driver;

	@Given("^I open Triangle Calculator$")
	public void i_openCalc() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/triangle-calculator.html");
	}

	@When("^I clear all param$")
	public void i_clearParam() {
		driver.findElement(By.cssSelector(".clearbtn")).click();
	}

	@And("^I set value \"90\" for \"A\"$")
	public void i_setA() {
		driver.findElement(By.name("va")).click();
		driver.findElement(By.name("va")).sendKeys("90");
	}

	@And("^I set value \"8\" for \"side b\"$")
	public void i_setSideB() {
		driver.findElement(By.name("vx")).click();
		driver.findElement(By.name("vx")).sendKeys("8");
	}

	@And("^I set value \"10\" for \"side a\"$")
	public void i_setSideA() {
		driver.findElement(By.name("vy")).click();
		driver.findElement(By.name("vy")).sendKeys("10");
	}

	@And("^I click button \"Calculate\"$")
	public void i_clickCalc() {
		driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
	}

	@Then("^The calculated result is \"Right Scalene Triangle\"$")
	public void i_assert() {
		assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Right Scalene Triangle");
		driver.close();
	}
}
