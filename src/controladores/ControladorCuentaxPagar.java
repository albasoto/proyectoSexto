package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.Contacto;
import entidades.CuentaPorPagar;
import entidades.Proveedor;
import validadores.ValidadorGeneral;

public class ControladorCuentaxPagar {
public static List<CuentaPorPagar> listaCuentaPagar = new ArrayList<CuentaPorPagar>();
	
	public void crearListaContacto(CuentaPorPagar cuentaPorPagar) {
		listaCuentaPagar.add(cuentaPorPagar);
	}
	/*
/*Método extraer datos de las columnas excel, ademas de eliminar los
	 * espacios en blanco de las celdas extraidas */
	public List<CuentaPorPagar> extraerCuentaPagar(XSSFWorkbook libro) {

		List<CuentaPorPagar>  listaCuentaPagar = new ArrayList<CuentaPorPagar>();
		//obtener la hoja que se va leer posicion cero 
		XSSFSheet hoja = libro.getSheetAt(4);
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);

			if (!ValidadorGeneral.comprobarSiEstaVaciaLaFila(fila)) {
				CuentaPorPagar cuentaxPagar = 
						new CuentaPorPagar(
							new Proveedor (fila.getCell(0).toString()),						
							fila.getCell(1).toString().trim(), 
							fila.getCell(2).toString().trim(), 
							fila.getCell(3).toString().trim(),
							fila.getCell(4).toString().trim(),
							fila.getCell(5).toString().trim(),
							fila.getCell(6).toString().trim(),											
								null,
								null			
																																		
								);

				listaCuentaPagar.add(cuentaxPagar);
			}
		
		}
		return listaCuentaPagar;
	}
	

}
