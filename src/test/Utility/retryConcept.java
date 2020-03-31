import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryConcept implements IRetryAnalyzer {


    int intialCount=0;
    int maxIntialCount=4;
    public boolean retry(ITestResult iTestResult) {
        if(intialCount<maxIntialCount) {
            intialCount++;
            return true ;
        }
        return false;
    }
}
