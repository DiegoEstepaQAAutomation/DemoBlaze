package com.demoautomatizacion;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtilidades;
import utilities.MyScreenRecorder;
import utilities.OracleBD;
import utilities.ReadExcelFile;
import utilities.WriteExcelFile;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demoautomatizacion.Maps.DemoBlazePage;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.Pages.HomePage;
import com.demoautomatizacion.Pages.LoginPage;

//ESTA ES UNA CLASE QUE GUARDA TODAS LAS INSTANCIAS DE TODOS LOS OBJETOS EXISTENTES
public class BaseTest {

	//INSTANCIA DE WEBDRIVER
	public WebDriver driver;

	public HomePage home;
	public LoginPage login;
	public BasePage base;
	public DemoBlazePage demoblaze;

	
	public ReadExcelFile readexcel;
	public WriteExcelFile writeexcel;
	public ExcelUtilidades excelutilidades;
	
	
	
	public WebDriver getDriver() {
		return driver;
	}

	//INICIALIZA LOS OBJETOS CON UN DRIVER RESPECTIVO
	@BeforeMethod
	public void inicializar() {

		//CONFIGURA EL COMO SE VA A ABRIR EL NAVEGADOR
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-notifications");
		 options.addArguments("--headless");
		//MAXIMIZA LA PAGINA DEL NAVEGADOR
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		home = new HomePage(driver);
		login = new LoginPage(driver);
		base = new BasePage(driver);
		


		demoblaze = new DemoBlazePage(driver);
	

		readexcel = new ReadExcelFile();
		writeexcel = new WriteExcelFile();
		excelutilidades = new ExcelUtilidades();
	
				

		// M�dulo Visitas
	
	}
	
	//INSTANCIA DE CONEXION DE BASE DE DATOS
	public ArrayList<Object> consultaBD(String sql) {

		ArrayList<Object> datos = new ArrayList<Object>();
		//CREA UNA INSTANCIA DE LA CLASE ORACLEBD QUE CONTIENE LA CONEXION A BASE DE DATOS
		try {
			OracleBD conexion = new OracleBD().conectar();
			//SI LA CONEXION ES DIFERENTE A NULO REALIZARA LA CONSULTA QUE ESTA LLAMADA EN EL METODO CONSULTAR CON EL STRING QUE ES LA CONSULTA QUE SE LE ENVIA
			if (conexion != null) {

				ResultSet resultado = conexion.consultar(sql);
				ResultSetMetaData metadata = resultado.getMetaData();
				int columnas = metadata.getColumnCount();
				//MEDIANTE UN CICLO SE AÑADE EL RESULTADO DE CADA COLUMNA 
				while (resultado.next()) {
					Object dato = new Object[columnas];
					for (int i = 1; i <= columnas; i++) {
						dato = resultado.getObject(i);
						//System.out.println(resultado.getString(i));
						datos.add(dato);
					}
				}
			}
			
			conexion.cerrarConexion();
		//SE RETORNA DATOS QUE ES LA METADATA DEL RESULTADO DE LA CONSULTA 	
		} catch (Exception e) {
			System.out.println("error de conexion");
			throw new RuntimeException(e.getMessage());
		}
		return datos;
	}

	

	
	//CIERRE DE INSTANCIA UNIVERSAL
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
