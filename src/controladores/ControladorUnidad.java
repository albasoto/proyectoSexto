package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.UnidadHabitacional;
import validadores.ValidadorGeneral;

public class ControladorUnidad {

	public static List<UnidadHabitacional> listaUnidad = new ArrayList<UnidadHabitacional>();

	public void crearListaUnidad(UnidadHabitacional unidad) {
		listaUnidad.add(unidad);
	}
	/*Método Contacto extraer datos de las columnas excel, ademas de eliminar los
	 * espacios en blanco de las celdas extraidas */
	public List<UnidadHabitacional> extraerUnidades(XSSFWorkbook libro) {

		List<UnidadHabitacional>  listaUnidades = new ArrayList<UnidadHabitacional>();
		//obtener la hoja que se va leer posicion cero 
		XSSFSheet hoja = libro.getSheetAt(0);
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);
			if (!ValidadorGeneral.comprobarSiEstaVaciaLaFila(fila)) {
				UnidadHabitacional unidad = 
						new UnidadHabitacional(
								fila.getCell(0).toString().trim(), 
								fila.getCell(1).toString().trim(), 
								fila.getCell(2).toString().trim(), 
								fila.getCell(3).toString().trim(), 
								fila.getCell(4).toString().trim(), 
								fila.getCell(5).toString().trim(), 
								fila.getCell(6).toString().trim(), 
								fila.getCell(7).toString().trim(), 
								fila.getCell(8).toString().trim(),
								fila.getCell(9).toString().trim(),
								null,
								null		
								);

				listaUnidades.add(unidad);
			}
		}

		return listaUnidades;

	}



	
}
