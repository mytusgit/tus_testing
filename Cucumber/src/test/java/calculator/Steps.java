package calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

import static org.junit.Assert.*;

public class Steps {

	WebDriver driver;

	@Given("^I use the calculater$")
	public void i_useCalc() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/math-calculator.html");
	}

	@When("^I enter \"1\" into the calculator$")
	public void i_enter() {
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[3]/span[1]")).click();
	}

	@And("^I add \"200\"$")
	public void i_add() {
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[1]/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[3]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[4]/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[4]/span[1]")).click();
	}

	@And("^I subtract \"200\"$")
	public void i_subtract() {
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[2]/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[3]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[4]/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[4]/span[1]")).click();
	}

	@And("^I divide by \"555\"$")
	public void i_divide() {
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[4]/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[2]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[2]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[2]/span[2]")).click();
	}

	@And("^I multiply by \"555\"$")
	public void i_multiply() {
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[3]/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[2]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[2]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[2]/span[2]")).click();
	}

	@Then("^the calculated result is \"1\"$")
	public void i_assert() {
		driver.findElement(By.xpath("//*[@id=\"sciout\"]/div[2]/div[5]/span[4]")).click();
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sciOutPut\"]")).getText(), " 1");
		driver.close();
	}
}