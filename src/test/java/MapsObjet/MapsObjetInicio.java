package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.testNG.ClaseBase;

public class MapsObjetInicio extends ClaseBase{
  public MapsObjetInicio(WebDriver driver) {
		
	  super(driver);
		this.driver=driver;
	}
  
  protected By btnregistrar= By.xpath("//a[@href='register.php']");

  protected By resultado =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td");	
	
  
@Test
  public void f() {
  }
}
