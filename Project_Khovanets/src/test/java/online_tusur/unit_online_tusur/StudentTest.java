package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

@Execution(ExecutionMode.CONCURRENT)
public class StudentTest {
	/* объект тестового класса Student */
	private Student s = new Student();
	private Student s1 = new Student();

	/* Практическое задание 2 */

	/* негативные тесты */

	/*
	 * 1. проверка возраста студента, выходящего за нижнюю границу диапазона
	 */

	@Test
	@Tag("negative")
	void testAgeInvalid_lowRange() {
		int age = 17;
		s.setAge(age);
		int expectedAge = 18;
		int actualsAge = s.getAge();

		long id = Thread.currentThread().getId();
		System.out.println("JUnit тест. Tread id=" + id);

		assertEquals(expectedAge, actualsAge);

	}

	/*
	 * 2. проверка возраста студента, выходящего за верхнюю границу диапазона
	 */

	@Test
	@Tag("negative")
	void testAgeInvalid_upRange() {
		int age = 51;
		s.setAge(age);
		int expectedAge = 18;
		int actualsAge = s.getAge();

		long id = Thread.currentThread().getId();
		System.out.println("JUnit тест. Tread id=" + id);

		assertEquals(expectedAge, actualsAge);

	}

	/*
	 * 3. проверка фамилии, введённой с маленькой буквы
	 */

	@Test
	@Tag("negative")
	void testInvalid_lastName() {
		String lname = "иванов";
		s.setLastName(lname);
		String expectedLastName = "Иванов";
		String actualsLastName = s.getLastName();

		long id = Thread.currentThread().getId();
		System.out.println("JUnit тест. Tread id=" + id);

		assertEquals(expectedLastName, actualsLastName);

	}

	/* позитивные тесты */

	/*
	 * 1. проверка корректного имени студента
	 */

	@Test
	@Tag("positive")
	void testFirstName() {
		String fname = "Иван";
		s.setFirstName(fname);
		String expectedFirstName = "Иван";
		String actualsFirstName = s.getFirstName();

		long id = Thread.currentThread().getId();
		System.out.println("JUnit тест. Tread id=" + id);

		assertEquals(expectedFirstName, actualsFirstName);

	}

	/*
	 * 2. проверка корректной фамилии студента
	 */

	@Test
	@Tag("positive")
	void testLastName() {
		String lname = "Иванов";
		s.setLastName(lname);
		String expectedLastName = "Иванов";
		String actualsLastName = s.getLastName();

		long id = Thread.currentThread().getId();
		System.out.println("JUnit тест. Tread id=" + id);

		assertEquals(expectedLastName, actualsLastName);

	}

	/*
	 * 3. проверка двойного имени
	 */

	@Test
	@Tag("positive")
	void testFirstName_double() {
		String fname = "Алла-Виктория";
		s.setFirstName(fname);
		String expectedFirstName = "Алла-Виктория";
		String actualsFirstName = s.getFirstName();

		long id = Thread.currentThread().getId();
		System.out.println("JUnit тест. Tread id=" + id);

		assertEquals(expectedFirstName, actualsFirstName);

	}

	/**************************************************************************/
	/* Практическое задание 3 */

	/* параметризированный тест для метода расчета среднего возраста avgAge() */

	@ParameterizedTest
	@Tag("positive")
	@CsvSource({ "25, Иван, Иванов, 20, Семен, Семенов, 30" })
	void test_avgAge(ArgumentsAccessor argumentsAccessor) {

		int expected = argumentsAccessor.get(0, Integer.class);
		Student[] student = {
				new Student(argumentsAccessor.get(1, String.class), argumentsAccessor.get(2, String.class),
						argumentsAccessor.get(3, Integer.class)),
				new Student(argumentsAccessor.get(4, String.class), argumentsAccessor.get(5, String.class),
						argumentsAccessor.get(6, Integer.class)) };

		long id = Thread.currentThread().getId();
		System.out.println("Параметризированный JUnit тест. Tread id=" + id);

		assertEquals(expected, Student.avgAge(student));
	}

	/**************************************************************************/
	/* Практическое задание 4 */

	/* динамические тесты для геттера getLastName() */

	@TestFactory
	@Tag("positive")
	Collection<DynamicTest> dynamicTestGetLastName() {
		s.setLastName("Иванов");
		s1.setLastName("Петрова-Сергеева");

		long id = Thread.currentThread().getId();
		System.out.println("Динамический JUnit тест. Tread id=" + id);

		return Arrays.asList(
				DynamicTest.dynamicTest("Динамический тест getLastName(Иванов)",
						() -> assertEquals("Иванов", s.getLastName())),
				DynamicTest.dynamicTest("Динамический тест getLastName(Петрова-Сергеева)",
						() -> assertEquals("Петрова-Сергеева", s1.getLastName())));
	}

	/* динамические тесты для геттера getFirstName() */

	@TestFactory
	@Tag("positive")
	Collection<DynamicTest> dynamicTestGetFirstName() {
		s.setFirstName("Иван");
		s1.setFirstName("Алла-Виктория");

		long id = Thread.currentThread().getId();
		System.out.println("Динамический JUnit тест. Tread id=" + id);

		return Arrays.asList(
				DynamicTest.dynamicTest("Динамический тест getFirstName(Иван)",
						() -> assertEquals("Иван", s.getFirstName())),
				DynamicTest.dynamicTest("Динамический тест getFirstName(Алла-Виктория)",
						() -> assertEquals("Алла-Виктория", s1.getFirstName())));
	}

	/* динамические тесты для геттера getAge() */

	@TestFactory
	@Tag("positive")
	Collection<DynamicTest> dynamicTestGetAge() {
		s.setAge(18);
		s1.setAge(50);

		long id = Thread.currentThread().getId();
		System.out.println("Динамический JUnit тест. Tread id=" + id);

		return Arrays.asList(
				DynamicTest.dynamicTest("Динамический тест getAge(18)", () -> assertEquals(18, s.getAge())),
				DynamicTest.dynamicTest("Динамический тест getAge(50)", () -> assertEquals(50, s1.getAge())));
	}
}