package com.demoautomatizacion.Maps;

import java.io.File;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class DemoBlazePage extends DemoBlazeMap {

	public DemoBlazePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//METODO PARA AGREGAR PRODUCTOS A CARRITO DE COMPRAS
		@Step("Adquirir Productos en Carrito de compras")
		public DemoBlazePage AdquirirProductosCarrito(File folderPath, String Evidencia) throws Exception 
		{
			
			time(3);
			//AGREGA PRODUCTO 1 A CARRITO
			click(Producto1, folderPath, "Se da click en producto 1",Evidencia);
			click(btnAgregarACarrito, folderPath, "Se da click en Agregar a carrito",Evidencia);
			enter1();
			click(Home, folderPath, "Se da click en modulo Home",Evidencia);
			click(Producto2, folderPath, "Se da click en producto 2",Evidencia);
			click(btnAgregarACarrito, folderPath, "Se da click en Agregar Carrito",Evidencia);
			enter1();
			click(Home, folderPath, "Se da click en producto 1",Evidencia);
			time(2);
			click(CarroComprasBlaze, folderPath, "Se da click en el elemento",Evidencia);
			Boolean Validacion =validarElemento(ProductoAdquirido1, 2);
			ValidacionObjeto(Validacion, "Se valida correctamente que el carrito de compras existe", folderPath, Evidencia);
			click(btnPlaceOrder, folderPath, "Se da click en boton place order",Evidencia);
			writeRandomAlp(CampoNombreBlaze1, 4);
			writeRandomAlp(CampoPaisBlaze1, 4);
			writeRandomAlp(CampoCiudadBlaze, 4);
			writeRandomNum(CampoTarjetaBlaze, 8);
			writeRandomNum(CampoMesBlaze, 4);
			writeRandomNum(CampoAñoBlaze, 4);
			click(btnPurshuase, folderPath, "Se da click en el elemento",Evidencia);
			click(BtnAceptar, folderPath, "Se da click en el elemento",Evidencia);
			return this;
			
		}
		
		
}
