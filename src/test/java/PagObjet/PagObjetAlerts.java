package PagObjet;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjet.MapsObjetAlerts;
import MapsObjet.MapsObjetElements;



public class PagObjetAlerts extends MapsObjetAlerts
{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PagObjetAlerts(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	
	//METODO INICIAL
	public void urlAcceso (String url)
	{
		driver.get(url);
	}
	
	public String busquedaAlert(String casilla,File rutaCarpeta,String generarEvidencia,String generarEvidencia5) throws Exception
	{
		try
		{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,100)");
		
		click(alertsframe, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		click(alerts, rutaCarpeta,generarEvidencia);
		tiempoEspera(1000);
		
		clickDato(btnClic1);
		driver.switchTo().alert().dismiss();
		tiempoEspera(1000);
		clickDato(btnClic2);
		tiempoEspera(7000);
		driver.switchTo().alert().dismiss();
		tiempoEspera(500);
		clickDato(btnClic3);
		tiempoEspera(500);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		tiempoEspera(500);
		clickDato(btnClic3);
		tiempoEspera(500);
		driver.switchTo().alert().dismiss();
		tiempoEspera(500);
		clickDato(btnClic4);
		tiempoEspera(500);
		driver.switchTo().alert().sendKeys(casilla);
		alert();
		captureScreen(rutaCarpeta, generarEvidencia, btnClic2);
		
		captureScreen(rutaCarpeta, generarEvidencia, btnClic3);
		
		captureScreen(rutaCarpeta, generarEvidencia, btnClic4);
		
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
		return valor;
	}

}
