package com.demoautomatizacion.test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.ExcelUtilidades;
import utilities.GenerarReportePdf;

public class DemoBlazeTest extends BaseTest {
	
	
	
	 //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(LoginTest.class.getName());	
	// LLAMA A EL ARCHIVO DE EXCEL QUE CONTIENE EL USUARIO Y CONTRASEÑA
	@DataProvider(name = "DemoBlaze")
	public Object[][] primerPaso() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/Almaviva.xlsx", "TestPropertiesLogin");

		return arreglo;
	}

	
	
	/**
	 * Ingresar portal almaviva.
	 *
	 * @throws Exception the exception
	 */
	//ESTE METODO LLAMA LAS PROPIEDADES QUE PERMITEN EL LOGUEO EN ALMAVIVA
	@Test(dataProvider = "DemoBlaze",priority = 0, description = "Login Portal Almaviva")
	@Severity(SeverityLevel.NORMAL)
	@Description("Ingresar Portal Almaviva")
	@Story("Login")
	public void RealizarCompra(String routeImageReport,String nameFolder,String path,
			String Evidencia,String nameTest,
			String analista,String url,String urlPrivada,String usuario2,String password ) throws Exception
	{
		
		if(Evidencia.equals("SI")) 
		{
		log.info("SE EMPIEZA A GENERAR EVIDENCIA");
		GenerarReportePdf.setRutaImagen(routeImageReport);
		File folderPath = BasePage.createFolder(nameFolder,
				path,Evidencia);
		GenerarReportePdf.createTemplate(folderPath,
				nameTest,
				analista,
				url,
				Evidencia);
		GenerarReportePdf.setImgContador(0);
		
				
		home.irPortal(url);
		demoblaze.AdquirirProductosCarrito(folderPath, Evidencia);
		
		GenerarReportePdf.closeTemplate("",Evidencia);
		
		
		}else { 
			
			File folderPath = BasePage.createFolder(nameFolder,
					path,Evidencia);
			
			home.irPortal(url);
			demoblaze.AdquirirProductosCarrito(folderPath, Evidencia);
			
			
				}
	

		
		
		
		
		
	}

}
