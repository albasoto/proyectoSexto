package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

import entidades.Contacto;
import entidades.CuentaPorCobrar;
import entidades.CuentaPorPagar;
import entidades.ParqueaderoBodega;
import entidades.Persona;
import entidades.Proveedor;
import entidades.UnidadHabitacional;

public class ProcesadorArchivos {

	public File abrirArchivo(String nombreTipo, String extension) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				nombreTipo, extension);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}
		return null;
	}


	public XSSFWorkbook leerExcel(String rutaArchivo) {
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
			XSSFWorkbook archivoExcel = new XSSFWorkbook(file);
			//System.out.println("numero de sheets "+worbook.getNumberOfSheets());
			return archivoExcel;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
			}
	
		
}
