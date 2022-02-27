package online_tusur.unit_online_tusur;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestFullStudent {

	private Student s = new Student();

	@Factory
	public Object[] TestFactory() {
		return new Object[] { new GetFirstNameTest(), new GetLastNameTest(), new GetAgeTest(), new GetFullNameTest(),
				new AvgAgeTest(), new MinAgeTest(), new MaxAgeTest() };
	}

	class GetLastNameTest {
		@DataProvider(name = "lastNameProvider", parallel = true)
		public Object[][] lastNameProvider() {
			return new Object[][] { { "Ivanov", "i" }, { "Petrova-Sergeeva", "Petrova-Sergeeva" } };
		}

		@Test(dataProvider = "lastNameProvider", threadPoolSize = 3)
		public void test_getLastName(String expLastName, String lastNamePar) {

			s.setLastName(lastNamePar);

			long id = Thread.currentThread().getId();
			System.out.println("Тест getLastName(). Tread id=" + id);

			Assert.assertEquals(expLastName, s.getLastName());
		}
	}

	class GetFirstNameTest {
		@DataProvider(name = "firstNameProvider", parallel = true)
		public Object[][] firstNameProvider() {
			return new Object[][] { { "Ivan", new Student("i", "Ivanov", 17) },
					{ "Alla-Victoria", new Student("Alla-Victoria", "Petrova-Sergeeva", 50) } };
		}

		@Test(dataProvider = "firstNameProvider", threadPoolSize = 3)
		public void test_getFirstName(String expFirstName, Student student) {

			long id = Thread.currentThread().getId();
			System.out.println("Тест getFirstName(). Tread id=" + id);

			Assert.assertEquals(expFirstName, student.getFirstName());
		}
	}

	class GetAgeTest {
		@DataProvider(name = "ageProvider", parallel = true)
		public Object[][] ageProvider() {
			return new Object[][] { { 18, new Student("Ivan", "Ivanov", 18) },
					{ 50, new Student("Alla-Victoria", "Petrova-Sergeeva", 50) } };
		}

		@Test(dataProvider = "ageProvider", threadPoolSize = 3)
		public void test_getAge(int expAge, Student student) {

			long id = Thread.currentThread().getId();
			System.out.println("Тест getAge(). Tread id=" + id);

			Assert.assertEquals(expAge, student.getAge());
		}
	}

	class GetFullNameTest {
		@DataProvider(name = "fullNameProvider", parallel = true)
		public Object[][] fullNameProvider() {
			return new Object[][] { { "Ivanov Ivan", new Student("Ivan", "Ivanov", 17) },
					{ "Petrova-Sergeeva Alla-Victoria", new Student("Alla-Victoria", "Petrova-Sergeeva", 50) } };
		}

		@Test(dataProvider = "fullNameProvider", threadPoolSize = 3)
		public void test_fullName(String expFullName, Student student) {

			long id = Thread.currentThread().getId();
			System.out.println("Тест getFullName(). Tread id=" + id);

			Assert.assertEquals(expFullName, student.getFullName());
		}
	}

	class AvgAgeTest {
		@DataProvider(name = "avgAgeProvider", parallel = true)
		public Object[][] avgAgeProvider() {
			return new Object[][] { { 23, new Student[] { new Student("Иван", "Иванов", 20),
					new Student("Семен", "Семенов", 30), new Student("Алла-Виктория", "Петрова", 19) } } };
		}

		@Test(dataProvider = "avgAgeProvider", threadPoolSize = 3)
		public void avgAgeTest(int expAvgAge, Student[] students) {

			long id = Thread.currentThread().getId();
			System.out.println("Тест avgAge(). Tread id=" + id);

			Assert.assertEquals(expAvgAge, Student.avgAge(students));
		}
	}

	class MinAgeTest {
		@DataProvider(name = "minAgeProvider", parallel = true)
		public Object[][] minAgeProvider() {
			return new Object[][] { { 19, new Student[] { new Student("Иван", "Иванов", 20),
					new Student("Семен", "Семенов", 30), new Student("Алла-Виктория", "Петрова", 19) } } };
		}

		@Test(dataProvider = "minAgeProvider", threadPoolSize = 3)
		public void minAgeProvider(int expMinAge, Student[] students) {

			long id = Thread.currentThread().getId();
			System.out.println("Тест minAge(). Tread id=" + id);

			Assert.assertEquals(expMinAge, Student.minAge(students));
		}
	}

	class MaxAgeTest {
		@DataProvider(name = "maxAgeProvider", parallel = true)
		public Object[][] maxAgeProvider() {
			return new Object[][] { { 30, new Student[] { new Student("Иван", "Иванов", 20),
					new Student("Семен", "Семенов", 30), new Student("Алла-Виктория", "Петрова", 19) } } };
		}

		@Test(dataProvider = "maxAgeProvider", threadPoolSize = 3)
		public void maxAgeTest(int expMaxAge, Student[] students) {

			long id = Thread.currentThread().getId();
			System.out.println("Тест maxAge(). Tread id=" + id);

			Assert.assertEquals(expMaxAge, Student.maxAge(students));
		}
	}
}
