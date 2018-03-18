package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.Contacto;
import entidades.Proveedor;
import validadores.ValidadorGeneral;

public class ControladorProveedor {
public static List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
	
	public void crearListaProveedor(Proveedor proveedor) {
		listaProveedor.add(proveedor);
	}

	/*Método Contacto extraer datos de las columnas excel, ademas de eliminar los
	 * espacios en blanco de las celdas extraidas */
	public List<Proveedor> extraerProveedor(XSSFWorkbook libro) {

		List<Proveedor>  listaProveedor = new ArrayList<Proveedor>();
		//obtener la hoja que se va leer posicion cero 
		XSSFSheet hoja = libro.getSheetAt(3);
		
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);
			if (!ValidadorGeneral.comprobarSiEstaVaciaLaFila(fila)) {
			Proveedor proveedor = 
					new Proveedor(
						
							fila.getCell(0).toString().trim(), 
							fila.getCell(1).toString().trim(), 
							fila.getCell(2).toString().trim(), 
							fila.getCell(3).toString().trim(),
							fila.getCell(4).toString().trim(),
							fila.getCell(5).toString().trim(),
							fila.getCell(6).toString().trim(),
							fila.getCell(7).toString().trim(),
							fila.getCell(8).toString().trim(),						
							null,
							null											
																																			
							);

			listaProveedor.add(proveedor);
			}
		}
		return listaProveedor;
	}
	
	}
