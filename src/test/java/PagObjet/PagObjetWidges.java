package PagObjet;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import MapsObjet.MapsObjetWidges;

public class PagObjetWidges extends MapsObjetWidges {
	public PagObjetWidges(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void urlAcceso(String url) {
		driver.get(url);
		// busquedaInicial();
	}

	public String SeleccionarDate(String Dia,File rutaCarpeta,String Hour,String generarEvidencia,String generarEvidencia5) throws Exception {
		
		try
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		click(btnwidgets, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);

		click(datepicker, rutaCarpeta,generarEvidencia);
		tiempoEspera(1000);

		click(selectdate, rutaCarpeta,generarEvidencia);
		tiempoEspera(3000);

		controla(selectdate, rutaCarpeta,generarEvidencia);
		tiempoEspera(3000);

		teclaborrar(selectdate, rutaCarpeta,generarEvidencia);

		sendkey(Dia, selectdate, rutaCarpeta,generarEvidencia);

		intro(selectdate, rutaCarpeta,generarEvidencia);

		controla(dateMonthDateHour, rutaCarpeta,generarEvidencia);
		tiempoEspera(3000);
		
		teclaborrar(dateMonthDateHour, rutaCarpeta,generarEvidencia);
		
		//sendkey(Dia, selectdate, rutaCarpeta);
		
		String datos2 = (Dia)+","+(Hour);
		
		sendkey(datos2,dateMonthDateHour, rutaCarpeta,generarEvidencia);
		
		//intro(dateMonthDateHour,rutaCarpeta);
		
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
		return valor;
		
	} 

}
