package online_tusur.unit_online_tusur;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/* Практическое задание 5 */

/* параметризированный тест для метода расчета среднего возраста avgAge() */

public class StudentTestNGParam {

	@DataProvider(name = "students", parallel = true)
	public Object[][] parameterProvider() {
		return new Object[][] { { 23, new Student[] { new Student("Иван", "Иванов", 20),
				new Student("Семен", "Семенов", 30), new Student("Алла-Виктория", "Петрова", 19) } } };
	}

	@Test(dataProvider = "students", threadPoolSize = 3)
	public void avgAgeTest(int expected, Student[] students) {

		long id = Thread.currentThread().getId();
		System.out.println("Параметризированный TestNG тест с провайдером. Tread id=" + id);

		assert expected == Student.avgAge(students);
	}

	@Test
	@Parameters({ "expectedAverAge", "students" })
	public void TestNG_AgeAvg(@Optional("25") int expectedAverAge,
			@Optional("Иван Иванов 20,Семен Семенов 30") String students) {
		String[] studentArr = students.split(",");
		Student[] arrOfStudent = new Student[studentArr.length];

		for (int i = 0; i < studentArr.length; i++) {
			arrOfStudent[i] = new Student();
			String[] studInf = studentArr[i].split(" ");

			arrOfStudent[i].setFirstName(studInf[0]);
			arrOfStudent[i].setLastName(studInf[1]);
			arrOfStudent[i].setAge(Integer.parseInt(studInf[2]));
		}

		long id = Thread.currentThread().getId();
		System.out.println("Параметризированный TestNG тест. Tread id=" + id);

		assert expectedAverAge == Student.avgAge(arrOfStudent);
	}
}
