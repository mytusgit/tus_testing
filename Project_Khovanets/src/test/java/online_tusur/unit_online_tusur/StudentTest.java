package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class StudentTest {
	/* объект тестового класса Student */
	private Student s = new Student();

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

		assertEquals(expected, Student.avgAge(student));
	}
}