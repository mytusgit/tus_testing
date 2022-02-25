package online_tusur.unit_online_tusur;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/* Практическое задание 6 */

/* тесты для геттеров getLastName(), getFirstName(), getAge() */

public class StudentTestNGDynam {

	@Factory
	public Object[] TestFactory() {
		return new Object[] { new GetFirstNameTest(), new GetLastNameTest(), new GetAgeTest() };
	}
}

class GetLastNameTest {
	@DataProvider(name = "lastNameProvider", parallel = true)
	public Object[][] lastNameProvider() {
		return new Object[][] { { "Ivanov", new Student("Ivan", "Ivanov", 18) },
				{ "Petrova-Sergeeva", new Student("Alla-Victoria", "Petrova-Sergeeva", 50) } };
	}

	@Test(dataProvider = "lastNameProvider", threadPoolSize = 3)
	public void testNG_getLastName(String expLastName, Student student1) {

		long id = Thread.currentThread().getId();
		System.out.println("Динамический TestNG тест getLastName(). Tread id=" + id);

		Assert.assertEquals(expLastName, student1.getLastName());
	}
}

class GetFirstNameTest {
	@DataProvider(name = "firstNameProvider", parallel = true)
	public Object[][] firstNameProvider() {
		return new Object[][] { { "Ivan", new Student("Ivan", "Ivanov", 18) },
				{ "Alla-Victoria", new Student("Alla-Victoria", "Petrova-Sergeeva", 50) } };
	}

	@Test(dataProvider = "firstNameProvider", threadPoolSize = 3)
	public void testNG_getFirstName(String expFirstName, Student student2) {

		long id = Thread.currentThread().getId();
		System.out.println("Динамический TestNG тест getFirstName(). Tread id=" + id);

		Assert.assertEquals(expFirstName, student2.getFirstName());
	}
}

class GetAgeTest {
	@DataProvider(name = "ageProvider", parallel = true)
	public Object[][] ageProvider() {
		return new Object[][] { { 18, new Student("Ivan", "Ivanov", 18) },
				{ 50, new Student("Alla-Victoria", "Petrova-Sergeeva", 50) } };
	}

	@Test(dataProvider = "ageProvider", threadPoolSize = 3)
	public void testNG_getAge(int expAge, Student student3) {

		long id = Thread.currentThread().getId();
		System.out.println("Динамический TestNG тест getAge(). Tread id=" + id);

		Assert.assertEquals(expAge, student3.getAge());
	}
}