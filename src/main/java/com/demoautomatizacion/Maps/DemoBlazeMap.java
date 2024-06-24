package com.demoautomatizacion.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class DemoBlazeMap extends BasePage {

	public DemoBlazeMap(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	} 
	
	
	
	protected By CarroCompras = By.xpath("//*[@id='cartur']");
	protected By CarroComprasBlaze = By.id("cartur");
	protected By Producto1 = By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a");
	protected By Producto2 = By.xpath("//*[@id='tbodyid']/div[2]/div/div/h4/a");
	protected By btnAgregarACarrito = By.xpath("//*[@id='tbodyid']/div[2]/div/a");
	protected By Home = By.xpath("//*[@id='navbarExample']/ul/li[1]/a");
	protected By btnPlaceOrder = By.xpath("//*[@id='page-wrapper']/div/div[2]/button");
	protected By CampoNombreBlaze = By.id("name");
	protected By CampoNombreBlaze1 = By.xpath("//*[@id='name']");
	protected By CampoPaisBlaze = By.id("country");
	protected By CampoPaisBlaze1 = By.xpath("//*[@id='country']");
	protected By CampoCiudadBlaze = By.id("city");
	protected By CampoTarjetaBlaze = By.id("card");
	protected By CampoMesBlaze = By.id("month");
	protected By CampoAñoBlaze = By.id("year");
	protected By btnPurshuase = By.xpath("//*[@id='orderModal']/div/div/div[3]/button[2]");
	protected By ProductoAdquirido1 = By.xpath("//*[@id='tbodyid']/tr[1]/td[2]");
	protected By BtnAceptar = By.xpath("/html/body/div[10]/div[7]/div/button");
	
	
	
	//*[@id="orderModal"]/div/div/div[3]/button[2]
	
	
	
}
