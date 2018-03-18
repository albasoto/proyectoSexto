package ficherosExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class LeerExcel {
	public static void main(String[] args) {
		String nombreArchivo = "datos.xlsx";
		String rutaArchivo = "C:\\Users\\gabri\\Downloads\\" + nombreArchivo;
		String hoja = "Hoja1";

		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			System.out.println("numero de sheets "+worbook.getNumberOfSheets());
		
			//obtener la hoja que se va leer por indice o nombre
			
			
			
			XSSFSheet sheet = worbook.getSheetAt(0);
			
			
			
			//obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();
		

			Row row;
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				//se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				//se recorre cada celda
				while (cellIterator.hasNext()) {
					// se obtiene la celda en espec�fico y se la imprime
					cell = cellIterator.next();
					
					System.out.print(cell.toString()+" | ");
					
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
