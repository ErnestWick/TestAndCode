package base;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public  class BaseDriver {

    protected WebDriver driver=null;
    protected BaseDriver bd;

    public BaseDriver(WebDriver driver) {
        this.driver=driver;
    }

    public void get(String url,int retryCount) {
        for(int i=0;i<retryCount;i++) {
            try {
                driver.get(url);
                break;
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public WebElement findElement(By by,long timeout) {
        WebElement element=null;
        long timeBegins=System.currentTimeMillis();
        do {
            try {
                element=driver.findElement(by);
                break;
            }catch (Exception e) {
                System.out.println("findelement error: "+ e);
            }
            pause(5000);
        }while(System.currentTimeMillis() - timeBegins<=timeout*1000);
        return element;
    }

    public WebElement findElement(By by) {
        return findElement(by,0);
    }

    public void pause(long millisecond) {
        try {
            Thread.sleep(millisecond);
        }catch (InterruptedException e) {
            System.out.println("pause error: "+e);
        }
    }

    public By getLocatorByType(String type,String locatorString) {
        By locator=null;
        switch(type) {
            case "id":
                locator=By.id(locatorString);
                break;
            case "name":
                locator=By.name(locatorString);
                break;
            case "xpath":
                locator=By.xpath(locatorString);
                break;
            case "linkText":
                locator=By.linkText(locatorString);
                break;
            case "partialLinkText":
                locator=By.partialLinkText(locatorString);
                break;
            case "className":
                locator=By.className(locatorString);
                break;
            case "tagName":
                locator=By.tagName(locatorString);
                break;
            case "cssSelector":
                locator=By.cssSelector(locatorString);
                break;
            default:
                locator=null;
                break;
        }
        return locator;
    }

    public File getCaptureScreenshotFile() {
        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        return screenShotFile;
    }


    public WebElement waitAndGetElement(final By loc,long timeout) {
        WebElement element=null;
        WebDriverWait wait=new WebDriverWait(driver,  Duration.ofSeconds(10));
        element=wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(loc);
            }
        });
        pause(2000);
        return element;
    }


    public Select waitAndGetSelect(final By loc, long timeout)
    {
        Select element=null;
        WebDriverWait wait=new WebDriverWait(driver,  Duration.ofSeconds(10));
        element=wait.until(new ExpectedCondition<Select>() {
            @Override
            public Select apply(WebDriver d) {
                return (Select) d.findElement(loc);
            }
        });
        pause(2000);
        return element;
    }

    public boolean waitElement(final By loc, long timeout) {
        boolean findOrNot=false;
        findOrNot=new WebDriverWait(driver,  Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                Boolean result=false;
                try {
                    d.findElement(loc);
                    result=true;
                }catch (Exception e) {
                }
                return result;
            }
        });

        pause(3000);
        return findOrNot;
    }

    public void elementHighlightBorderRed(WebElement element) {
        for (int i=0;i<2;i++) {
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"border:2px solid red;");
        }
    }

    public void elementHighlightBorderBlue(WebElement element) {
        for (int i=0;i<2;i++) {
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"border:2px solid blue;");
        }
    }

    public void elementUnHighlightBorder(WebElement element) {
        for (int i=0;i<2;i++) {
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"");
        }
    }

    public void refresh() {
        driver.navigate().refresh();
    }


}
