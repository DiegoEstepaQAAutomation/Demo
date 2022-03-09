package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.testNG.ClaseBase;

public class MapsObjetWidges extends ClaseBase{
  public MapsObjetWidges(WebDriver driver) {
	  
	  super(driver);
		this.driver=driver;
	}
  
  
    protected By btnwidgets= By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]");
	protected By datepicker= By.xpath("//span[contains(text(),'Date Picker')]");
	protected By selectdate = By.xpath("//*[@id='datePickerMonthYearInput']");
	protected By dateMonthDateHour = By.id("dateAndTimePickerInput");
	protected By resultado =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td");	
	
 
@Test
  public void f() {
  }
}
