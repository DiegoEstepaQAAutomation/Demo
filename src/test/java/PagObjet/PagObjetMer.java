package PagObjet;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import MapsObjet.MapsObjetMer;

public class PagObjetMer  extends MapsObjetMer{
  
	public PagObjetMer(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void urlAcceso(String url2) 
	{
		driver.get(url2);
		//busquedaInicial();
	}
	
	public String Registro(String FirstName,String LastName,String Phone,String Email,String Address,
			String City,String StateProvince,String PostalCode,String Country,String UserName,String Password,
			String ConfirmPassword,File rutaCarpeta,String generarEvidencia,String generarEvidencia5) throws Exception
	{
		try {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,100)");
		
		sendkey(FirstName, txtFN, rutaCarpeta,generarEvidencia);
		sendkey(LastName, txtLN, rutaCarpeta,generarEvidencia);
		sendkey(Phone, txtPhone, rutaCarpeta,generarEvidencia);
		sendkey(Email, txtEmail, rutaCarpeta,generarEvidencia);
		sendkey(Address, txtAd, rutaCarpeta,generarEvidencia);
		sendkey(City, txtCity, rutaCarpeta,generarEvidencia);
		sendkey(StateProvince, txtState, rutaCarpeta,generarEvidencia);
		sendkey(PostalCode, txtPC, rutaCarpeta,generarEvidencia);
		sendkey(Country, Pais, rutaCarpeta,generarEvidencia);
		sendkey(UserName, txtUN, rutaCarpeta,generarEvidencia);
		sendkey(Password, txtPswd, rutaCarpeta,generarEvidencia);
		tiempoEspera(1000);
		sendkey(ConfirmPassword, txtCPswd, rutaCarpeta,generarEvidencia);
		click(enviar,rutaCarpeta,generarEvidencia);
		
		} 		
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
		return valor;

		
		
	}
	
}
