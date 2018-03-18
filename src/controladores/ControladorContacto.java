package controladores;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entidades.Contacto;
import entidades.UnidadHabitacional;
import validadores.ValidadorGeneral;


public class ControladorContacto {
	public static List<Contacto> listaContacto = new ArrayList<Contacto>();

	public void crearListaContacto(Contacto contacto) {
		listaContacto.add(contacto);
	}
	/*Método Contacto extraer datos de las columnas excel, ademas de eliminar los
	 * espacios en blanco de las celdas extraidas */
	public List<Contacto> extraerContacto (XSSFWorkbook libro){
		List<Contacto> listaContacto = new ArrayList<Contacto>();
		XSSFSheet hoja = libro.getSheetAt(0);
		for(int i=2; i<hoja.getLastRowNum();i++) {
			XSSFRow fila=hoja.getRow(i);


			if (!ValidadorGeneral.comprobarSiEstaVaciaLaFila(fila)) {
				Contacto contacto=
						new Contacto(
								new UnidadHabitacional(fila.getCell(11).toString().trim()),					 
								fila.getCell(12).toString().trim(), 
								fila.getCell(13).toString().trim(), 
								fila.getCell(14).toString().trim(), 
								fila.getCell(15).toString().trim(),
								fila.getCell(16).toString().trim(),
								fila.getCell(17).toString().trim(),
								fila.getCell(18).toString().trim(),
								fila.getCell(19).toString().trim(),
								fila.getCell(20).toString().trim(),
								fila.getCell(21).toString().trim(),						
								null,
								null);
				listaContacto.add(contacto);

			}	

		}
		return listaContacto;
	}



	
}
