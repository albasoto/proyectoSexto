package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.Contacto;
import entidades.CuentaPorCobrar;
import entidades.UnidadHabitacional;
import validadores.ValidadorCuentasPorCobrar;
import validadores.ValidadorGeneral;

public class ControladorCuentaxCobrar {
public static List<CuentaPorCobrar> listaCuentaCobrar = new ArrayList<CuentaPorCobrar>();
	
	public void crearListaCuentaPorCobrar(CuentaPorCobrar cuentaPorCobrar) {
		listaCuentaCobrar.add(cuentaPorCobrar);
	}
	/*Método extraer datos de las columnas excel, ademas de eliminar los
	 * espacios en blanco de las celdas extraidas */
	public List<CuentaPorCobrar> extraerCuentaCobrar(XSSFWorkbook libro) {

		List<CuentaPorCobrar>  listaCuentaCobrar = new ArrayList<CuentaPorCobrar>();
		//obtener la hoja que se va leer posicion cero 
		XSSFSheet hoja = libro.getSheetAt(2);
		
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);

			if (!ValidadorGeneral.comprobarSiEstaVaciaLaFila(fila)) {
				CuentaPorCobrar cuentaPorCobrar = 
						new CuentaPorCobrar(
								new UnidadHabitacional(fila.getCell(0).toString()),
								fila.getCell(1).toString().trim(), 
								fila.getCell(2).toString().trim(), 
								fila.getCell(3).toString().trim(),
								fila.getCell(4).toString().trim(),
								fila.getCell(5).toString().trim(),
								fila.getCell(6).toString().trim(),
								fila.getCell(7).toString().trim(),
								null,
								null																													
								);

				listaCuentaCobrar.add(cuentaPorCobrar);	
			}		
		}
		return listaCuentaCobrar;
	}

}
