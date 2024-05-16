package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Date;

public class ExtentManager {

    public static ExtentReports extentReports;

    public static Date date = new Date();
    static String myReportsPath = date.toString().replace(" ", "_").replace(":", "_");

    public static ExtentReports getReporterInstance() {
        if (extentReports == null) {
            // Create reporter
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./reports/"+ myReportsPath + ".html");

            // Configure reporter
            extentSparkReporter.config().setReportName("Test Report");
            extentSparkReporter.config().setDocumentTitle("Test document title");

            // Create extent reports
            extentReports = new ExtentReports();

            // Configure reports
            extentReports.setSystemInfo("QA", "Tsanka Strelkova");
            extentReports.setSystemInfo("Env", "UAT");

            // Attach reporter to the reports
            extentReports.attachReporter(extentSparkReporter);
        }
        return extentReports;
    }
}
