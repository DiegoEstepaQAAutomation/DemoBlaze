package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import io.qameta.allure.*;
import utilities.ExcelUtilidades;
import utilities.GenerarReportePdf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginTest.
 */
@Listeners({ TestListener.class })
@Epic("Login")
@Feature("Login Tests")

public class LoginTest extends BaseTest {

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(LoginTest.class.getName());	
	// LLAMA A EL ARCHIVO DE EXCEL QUE CONTIENE EL USUARIO Y CONTRASEÑA
	@DataProvider(name = "AppClaro")
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
	@Test(dataProvider = "AppClaro",priority = 0, description = "Login Portal Almaviva")
	@Severity(SeverityLevel.NORMAL)
	@Description("Ingresar Portal Almaviva")
	@Story("Login")
	public void ingresarPortalAlmaviva(String routeImageReport,String nameFolder,String path,
			String Evidencia,String nameTest,
			String analista,String url,String urlPrivada,String usuario2,String password) throws Exception { 


		System.setProperty("testname", nomClass.replace(".java", ""));
		log.info("INICIA LA EJECUCION DE LA CLASE "+nomClass);
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		
		
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
				
		home.irPortal(urlPrivada);
		login.privacidadIp();
		home.irPortal(url);
		login.privacidadIp();
		home.irPortal(urlPrivada);
		login.ingresarCredenciales(usuario2, password,folderPath, Evidencia)
	    .cerrarSesion(folderPath,Evidencia);
		
		GenerarReportePdf.closeTemplate("",Evidencia);
		log.info("FINALIZA LA EJECUCION DEL TEST");
		
		}else { 
			
			File folderPath = BasePage.createFolder(nameFolder,
					path,Evidencia);
			
			home.irPortal(urlPrivada);
			login.privacidadIp();
			home.irPortal(url);
			login.privacidadIp();
			home.irPortal(urlPrivada);
			login.ingresarCredenciales(usuario2, password,folderPath, Evidencia)
		    .cerrarSesion(folderPath,Evidencia);	

			log.info("FINALIZA LA EJECUCION DEL TEST");
		}
	
	
}
	
} 
	

	

			
		
	
