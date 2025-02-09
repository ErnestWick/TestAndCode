package base;
import util.ReportUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseCase
{
    //protected WebDriver driver=null;
    protected WebDriver driver=null;
    //protected BaseDriver bd;
    private ReportUtil reporter=null;

    public  void setReporter(ReportUtil reporter)
    {
        this.reporter=reporter;
        this.reporter.printReport("START");
    }

    public void afterClass() {
        if (reporter != null) {
            reporter.printReport("END");
        }
        try {
            driver.close();
            Thread.sleep(3000);
        } catch (Exception b) {
            b.getMessage();
        }
    }
}
