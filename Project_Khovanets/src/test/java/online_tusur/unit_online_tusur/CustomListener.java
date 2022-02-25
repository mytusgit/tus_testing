package online_tusur.unit_online_tusur;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Количество успешных тестов: " + context.getPassedTests().getAllResults().size());
		System.out.println("Количество упавших тестов: " + context.getFailedTests().getAllResults().size());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Успешные тесты: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Провальные тесты: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Пропущенные тесты: " + result.getName());
	}
}
