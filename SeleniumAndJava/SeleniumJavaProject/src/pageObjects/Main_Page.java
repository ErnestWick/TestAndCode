package pageObjects;
import base.BaseDriver;
import org.openqa.selenium.WebElement;
public class Main_Page
{

    protected BaseDriver bd;
    public Main_Page(BaseDriver driver)
    {
        super();
        this.bd=driver;
    }

    public WebElement getMenuEnvolveCRC()
    {
        return bd.waitAndGetElement(bd.getLocatorByType("xpath","//*[@id=\"navigation\"]/div/div[3]/div/nav/ul/li[2]/div[1]/span/a"),100);
    }

    public WebElement getBtnPolicy()
    {
        return bd.waitAndGetElement(bd.getLocatorByType("xpath","//*[@id=\"onetrust-accept-btn-handler\"]"),100);
    }

    public WebElement getMenuCRCRise()
    {
        return bd.waitAndGetElement(bd.getLocatorByType("xpath","//*[@id=\"navigation\"]/div/div[3]/div/nav/ul/li[2]/div[2]/div/div/ul/li[1]/div[1]/a"),100);
    }


}
