package online_tusur.unit_online_tusur;

import java.util.List;
import java.util.Map;
 
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
 
public class CustomReporter implements IReporter{
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
     
        //Iterating over each suite included in the test
        for (ISuite suite : suites) {
  
            //Following code gets the suite name
            String suiteName = suite.getName();
  
            //Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
              ITestContext tc = sr.getTestContext();
              System.out.println("Всего тестов '" + suiteName +
                      "' is: " + tc.getSuite().getAllMethods().size());
              System.out.println("Пройденные тесты '" + suiteName +
                "' is: " + tc.getPassedTests().getAllResults().size());
              System.out.println("Упавшие тесты '" + suiteName +
                "' is: " + tc.getFailedTests().getAllResults().size());
              System.out.println("Пропущенные тесты '" + suiteName +
                "' is: " + tc.getSkippedTests().getAllResults().size());
            }
        }
    }
}
