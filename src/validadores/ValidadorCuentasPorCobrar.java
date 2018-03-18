package validadores;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import entidades.Contacto;
import entidades.CuentaPorCobrar;
import entidades.UnidadHabitacional;

public class ValidadorCuentasPorCobrar {
	
	
	public String existeUnidad(CuentaPorCobrar cuentaxCobrar,List<UnidadHabitacional> listaUnidad) {

		Boolean siExisteUnidad= false;
		

		for (UnidadHabitacional unidadHabitacional : listaUnidad) {
			if (unidadHabitacional.getId()==cuentaxCobrar.getUnidadHabitacional().getId()) {
				siExisteUnidad=true;
			}
		}

		if (siExisteUnidad) {
			return "Si existe la unidad";
		} else {
			return "No existe la unidad habitacional";
		}

	}
	
	public String ValidarCampoObligatorio() {
		//campos obligatoios ID uNidad habitacional e identificacion
		return null;
	}
	public String ValidarRubro() {
		//valida qu el rubro sea Alicuota mensual, Saldo Inicial, Consumo de Agua, Consumo de Gas, Consumo de Energía, Intereses
		return null;
	}
	public String ValidarFormatoFecha() {
		//AÑO-MES- DIA(2017-12-05)
		return null;
	}
	public String ValidarFechaEmision() {
		//validar q se menor a la fecha vencimiento y que tenga el formato
		return null;
	}
	
	public String ValidarFechaVencimiento() {
		//validar que la fecha vencimiento sea mayor a emision y tenga el formato
		return null;
	}
	public double ValidarValor() {
		//Validar valor sea mayor a cero
		return 0;
	}
	public String ValidarModo() {
		//validar que Modo sea entre (1,2,3,4)
		return null;
	}
	
}
