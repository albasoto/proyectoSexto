package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.ParqueaderoBodega;
import entidades.UnidadHabitacional;
import validadores.ValidadorGeneral;

public class ControladorParqueadero {
public static List<ParqueaderoBodega> listaParqueadero = new ArrayList<ParqueaderoBodega>();
	
	public void crearListaParqueadero(ParqueaderoBodega parqueaderoBodega) {
		listaParqueadero.add(parqueaderoBodega);
	}
	/*Método extraer datos de las columnas excel, ademas de eliminar los
	 * espacios en blanco de las celdas extraidas */
	public List<ParqueaderoBodega> extraerParqueaderoBodega(XSSFWorkbook libro) {

		List<ParqueaderoBodega>  listaParqueaderoBodega = new ArrayList<ParqueaderoBodega>();
		//obtener la hoja que se va leer posicion cero 
		XSSFSheet hoja = libro.getSheetAt(1);
		for (int i = 2; i < hoja.getLastRowNum(); i++) {
			XSSFRow fila = hoja.getRow(i);
			
			if (!ValidadorGeneral.comprobarSiEstaVaciaLaFila(fila)) {
				
			ParqueaderoBodega parqueaderoBodega = 
					new ParqueaderoBodega(
							new UnidadHabitacional(fila.getCell(0).toString()),
							fila.getCell(1).toString().trim(), 
							fila.getCell(2).toString().trim(), 
							fila.getCell(3).toString().trim(),							
							null,
							null																													
							);

			listaParqueaderoBodega.add(parqueaderoBodega);
			}
		}
		return listaParqueaderoBodega;
	}

}
