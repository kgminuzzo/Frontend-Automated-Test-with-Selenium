package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private ConfigReader configReader;
	
	public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,3);
        js = (JavascriptExecutor) driver;
        configReader = new ConfigReader();
    }
	
	public void click (WebElement element) {
		waitVisibility(element).click();
	}
	
	public void clickButton (WebElement element) {
		waitVisibility(element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void selectInDropdown(WebElement element, String value) {
		try {
			WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(element));
			dropdown.findElement(By.xpath("//option[. = '"+value+"']")).click();
		}catch(NoSuchElementException e) {
			System.out.println(value + " is not a valid value");
		}
	}
	
	public boolean isAttributeEmpty(WebElement element, String attribute) {  
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));		
	}
	
	public String getAttribute(WebElement element, String attribute) {  
		return (isAttributeEmpty(element, attribute)? element.getAttribute(attribute) : "");		
	}
	
    public WebElement waitVisibility(WebElement elementBy) {
        return wait.until(ExpectedConditions.visibilityOf(elementBy));
    }

    public void setText(WebElement element, String text) {
        waitVisibility(element).sendKeys(text);
    }
 
    public String getText(WebElement element) {
        return waitVisibility(element).getText();
    }
    
    public void navigateToHomePage() {
    	driver.get(configReader.getURL());
    }

}
