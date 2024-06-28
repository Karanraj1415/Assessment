import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Report implements ITestListener {
	


		public void onTestStart(ITestResult result) {
			System.out.println("This is Test Start");
		}

		public void onTestSuccess(ITestResult result) {
			System.out.println("This is Test sucess");
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("This is Test failure");
		}

		public void onTestSkipped(ITestResult result) {
			System.out.println("This is Test skipped");
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("This is Test Failed But With in Success Percentage");
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			onTestFailure(result);
			System.out.println("This is Test Failed With Timeout");
		}

		public void onStart(ITestContext context) {
			System.out.println("This is On Start");
		}


		public void onFinish(ITestContext context) {
			System.out.println("This is On Finish");
			

			
		}


	}



