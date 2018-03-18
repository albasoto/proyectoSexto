package validadores;

import java.util.List;

import entidades.CuentaPorCobrar;
import entidades.CuentaPorPagar;
import entidades.Proveedor;
import entidades.UnidadHabitacional;

public class ValidadorCuentasPorPagar {
	public String existeProveedor(CuentaPorPagar cuentaxPagar,List<Proveedor> listaProveedor) {

		Boolean siExisteUnidad= false;
		

		for (Proveedor provedores : listaProveedor) {
			if (provedores.getIdentificacion() ==cuentaxPagar.getProveedor().getIdentificacion()) {
				siExisteUnidad=true;
			}
		}

		
		if (siExisteUnidad) {
			return "Si existe el proveedor";
		} else {
			return "No existe proveedor";
		}

	}
	public String ValidarRubro() {
		return null;
	}
	
	public String ValidarCampoObligatorio() {
		return null;
	}
	public String ValidarFechaFactura() {
		//fecha factura debe ser menor a fecha fencimiento
		//debe estar en el formato AÑO-MES-DIA
		return null;
	}
	public String ValidarFechaVencimiento() {
		//fecha vencimiento debe ser mayor a fecha factura
		//formato año-mes-dia
		return null;
	}
 public double ValidaValor(){
	 //validar que valor sea mayor a cero y decimal
	 return 0;
 }
}
