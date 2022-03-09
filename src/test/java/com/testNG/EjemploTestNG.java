package com.testNG;

import org.testng.annotations.Test;

import com.Utilidades.ExcelUtilidades;
import com.Utilidades.GenerarReportePdf;
import com.Utilidades.MyScreenRecorder;

import PagObjet.PagObjectMLibre;
import PagObjet.PagObjetAlerts;
//import PagObjet.PagObjetAlerts;
import PagObjet.PagObjetElements;
import PagObjet.PagObjetInicio;
import PagObjet.PagObjetMer;
import PagObjet.PagObjetWidges;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class EjemploTestNG 

{
	private WebDriver driver;
	
	PagObjetElements DemoGuri;
	PagObjetWidges Widgets;
	PagObjetAlerts  Alertas;
	PagObjetInicio pagObjetInicio;
	PagObjetMer Mercurio;
	PagObjectMLibre MercaLibre;
	ClaseBase claseBase;
	File rutaCarpeta = null;
	GenerarReportePdf generarReportepdf;
	String valor;
	
	
	
	@BeforeClass
	@Parameters({"url","url2","url3","rutaImagenReporte","rutaOutut"}) 
	
	  public void beforeClass(@Optional("default") String url,@Optional("default")String url2,@Optional("default")String url3,@Optional("default")String rutaImagenReporte,@Optional("default")String rutaOutut ) 
	{
	
		driver =ClaseBase.chromeDriverConnection();
		
		claseBase = new ClaseBase(driver);
		
		generarReportepdf = new GenerarReportePdf();
		
		Widgets = new PagObjetWidges(driver);
		
		Alertas = new PagObjetAlerts(driver);
		
		DemoGuri = new PagObjetElements(driver);
		
		pagObjetInicio = new PagObjetInicio(driver);
		
		Mercurio = new PagObjetMer(driver);
		
		MercaLibre = new PagObjectMLibre(driver);
		
		generarReportepdf.setRutaImagen(rutaImagenReporte);
		
		claseBase.setRutaOutut(rutaOutut);
		
		DemoGuri.setUrl(url);
		pagObjetInicio.setUrl2(url2);
		MercaLibre.setUrl3(url3);
		
		//guru.urlAcceso(url);
		//pagObjetInicio.urlAcceso(url2);

		
	  }
	
	// TEST MERCURY TOOLS QA
  @Test(dataProvider = "busqueda")
  public void pruebaInicialTestNG(String Ejecutar,String Evidencia,String FirstName,String LastName,String Email,String Age,String Salary,
		  String Department,String Dia,String casilla,String Hour,String generarEvidencia,String generarEvidencia5) throws Exception {
  
       if(Ejecutar.equals("No")) {
  
	  String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		File rutaCarpeta = claseBase.crearCarpeta(nomTest);
		
	  //pagObjetInicio.busquedaI(FirstName, rutaCarpeta);
	  DemoGuri.urlAcceso();
	  
	  if (generarEvidencia5.contains("Si")) {
		  
		  rutaCarpeta = claseBase.crearCarpeta(nomTest);
		  
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		
		
		generarReportepdf.crearPlantilla(nomTest,rutaCarpeta);
		
	  valor= DemoGuri.Registro(FirstName, LastName, Email, Age, Salary, Department, rutaCarpeta,generarEvidencia,generarEvidencia5);
	  valor= Widgets.SeleccionarDate(Dia, rutaCarpeta,Hour,generarEvidencia,generarEvidencia5);
	  valor =Alertas.busquedaAlert(casilla, rutaCarpeta,generarEvidencia,generarEvidencia5);
	  
	  MyScreenRecorder.stopRecording();
	  
	  generarReportepdf.cerrarPlantilla();
	  
	  
	  }
	  
      else {
 		  
    	valor=DemoGuri.Registro(FirstName, LastName, Email, Age, Salary, Department, rutaCarpeta,generarEvidencia,generarEvidencia5);
    	valor=Widgets.SeleccionarDate(Dia, rutaCarpeta,Hour,generarEvidencia,generarEvidencia5);
    	valor=Alertas.busquedaAlert(casilla, rutaCarpeta,generarEvidencia,generarEvidencia5);

   }  
	  
       }
       assert valor.contains(Department);
       assert valor.contains(Dia);
       assert valor.contains(casilla);
		

  }

  
  @DataProvider(name="busqueda")
  public Object [][] datos() throws Exception 
  {
	  Object [][] arreglo=ExcelUtilidades.getTableArray("./Data/buscar.xlsx","Hoja1");
		
		
	  return arreglo;
  }
  
  
	
	 @Test(dataProvider = "busqueda2")
	  public void pruebaInicialTestNG( String  Evidencia1 ,String FirstName,String LastName,String Phone,String Email,String Address,String City,
			  String StateProvince,String PostalCode,String Country,String UserName,String Password,String ConfirmPassword,String Ejecutar1,String generarEvidencia,String generarEvidencia1) throws Exception 
	  {
		 if(Ejecutar1.equals("Si")) {
			 
		  	 
		  String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			
		  pagObjetInicio.urlAcceso();
		  
		  if (generarEvidencia1.contains("Si")) {
			  
			  rutaCarpeta = claseBase.crearCarpeta(nomTest);
			  
			  MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
			  
			  generarReportepdf.crearPlantilla(nomTest,rutaCarpeta);
		  
		 valor = pagObjetInicio.busquedaI(rutaCarpeta,generarEvidencia,generarEvidencia1);
		 valor=  Mercurio.Registro(FirstName, LastName, Phone, Email, Address, City, StateProvince, PostalCode, Country, UserName, Password, ConfirmPassword, rutaCarpeta,generarEvidencia1,generarEvidencia);
		  
		  MyScreenRecorder.stopRecording();
		  
		  generarReportepdf.cerrarPlantilla();
		 }
		  
		  
		  
			  if (generarEvidencia1.contains("Si")) {
				  
				 valor = pagObjetInicio.busquedaI(rutaCarpeta,generarEvidencia,generarEvidencia1);
				 valor =Mercurio.Registro(FirstName, LastName, Phone, Email, Address, City, StateProvince, PostalCode, Country, UserName, Password, ConfirmPassword, rutaCarpeta,generarEvidencia1,generarEvidencia);
				
		  }  
		  
		  assert valor.contains(StateProvince);
			
		   
			  
		  }
		 
	    
		 
	  
	  }

	  
	  @DataProvider(name="busqueda2")
	  public Object [][] datos2() throws Exception 
	  {
		  Object [][] arreglo=ExcelUtilidades.getTableArray("./Data/buscar.xlsx","Hoja2");
			
			
		  return arreglo;
	  }
	  
	  @Test(dataProvider = "busqueda3")
	  public void PruebaMLibre(String Producto,String Correo,String Ejecutar2,String Evidencia2,String generarEvidencia,String generarEvidencia2) throws Exception 
	  {
		  
		  if(Ejecutar2.equals("No")) {
		  
		  //pagObjetInicio.urlAcceso();
			
		  
		  String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
		  File rutaCarpeta = claseBase.crearCarpeta(nomTest);
		  MercaLibre.urlAcceso();
		  
		  if (generarEvidencia2.contains("Si")) {
			  
		  rutaCarpeta = claseBase.crearCarpeta(nomTest);
			  
		  MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		  
		  generarReportepdf.crearPlantilla(nomTest,rutaCarpeta);
		  
		  valor = MercaLibre.buscarObjeto(Producto,Correo,rutaCarpeta,generarEvidencia2, generarEvidencia);
		  //libre.crearCuenta2(Correo,rutaCarpeta);	  
		  
		  MyScreenRecorder.stopRecording();
		  
		  generarReportepdf.cerrarPlantilla();
		  
		  
		  }
		  

		  else  
		  
		  {
			  
			 valor = MercaLibre.buscarObjeto(Producto,Correo,rutaCarpeta,generarEvidencia2, generarEvidencia);
		  			
		  }
		  assert valor.contains(Producto);
		  
		  
		  
		  
        
        }
		  
          
		  
		  	  }
	  
	  @DataProvider(name="busqueda3")
	  public Object [][] datos3() throws Exception 
	  {
		  Object [][] arreglo=ExcelUtilidades.getTableArray("./Data/buscar.xlsx","Hoja3");
			
		  return arreglo;
	  }
  
	  
	  /*  public void pruebaInicialmLibreNG(String ejecutar, String video,String Producto,String Correo ) throws Exception
			{
			  boolean m = false;
			  String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
								
				if(ejecutar.equals("Si")) {
					File rutaCarpeta = pagObjectmLibreNG.crearCarpeta(nomTest);
					if (video.equals("Si")) {
						System.out.println("// Ejecutar caso de prueba '"+nomTest+"' con evidencia de video //");
						MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
						m= true;
					}else
						System.out.println("// Ejecutando caso de prueba '"+nomTest+"' sin evidencia en video//");
				
					pagObjectmLibreNG.urlAcceso();
					pagObjectmLibreNG.buscarObjeto(Producto,Correo, rutaCarpeta);
				
				if(Boolean.TRUE.equals(m))
					MyScreenRecorder.stopRecording();
				}else
					System.out.println("// Caso de prueba '"+nomTest+"', no se ejecutara//");
				
		  }*/
	  

  @AfterClass
  public void afterClass() 
  {
	  driver.close();
  }

}
