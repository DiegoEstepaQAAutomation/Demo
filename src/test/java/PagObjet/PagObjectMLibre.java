package PagObjet;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import MapsObjet.MapObjectMLibreNG;


public class PagObjectMLibre extends MapObjectMLibreNG
{

	public  String url3 ;
	
	


	public String getUrl3() {
		return url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	public PagObjectMLibre(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}
	
	public void urlAcceso() 
	{
		driver.get(url3);
		
	}
	
	
	
	// METODO PRIMERA PRUEBA - BUSCAR OBJETO EN MERCADO LIBRE
	public String buscarObjeto(String Producto,String Correo,File rutaCarpeta,String generarEvidencia,String generarEvidencia2) throws Exception
	{
		try
		{
		
		sendkey(Producto,txtBusquedaML, rutaCarpeta,generarEvidencia);
		submit(txtBusquedaML, rutaCarpeta,generarEvidencia);
		click(btnBuscarML, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		click(selecObjeto, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);	
	
		
		
	//public void crearCuenta2(String Correo,File rutaCarpeta) throws Exception {
		
		
		click(crearCuentaML, rutaCarpeta,generarEvidencia);
		tiempoEspera(3000);
		click(validarDatosML, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		click(btnvalidarEmailML, rutaCarpeta,generarEvidencia);
		tiempoEspera(3000);
		sendkey(Correo,txtIngresarEmailML1, rutaCarpeta,generarEvidencia);
		click(btnIngresarEMailML1, rutaCarpeta,generarEvidencia);
		//submit(crearCuentaML, rutaCarpeta);
		tiempoEspera(2000);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		String valor = capturarValorSelenium(Message);
		return valor;
	}


}
