package validadores;

import java.util.List;

import entidades.Proveedor;
import entidades.UnidadHabitacional;

public class ValidadorProveedor {
	
	
	public String comprobarSiSeRepiteProveedor(Proveedor proveedor, List<Proveedor> listaProveedor) {
		int aux= 0;
		for (Proveedor proveedores : listaProveedor) {
			if (proveedores.getIdentificacion()==proveedor.getIdentificacion()) {
				aux++;
			}
		}
		if (aux>1) {
			return "El proveedor se repetite "+aux+ " veces";
		} else {
			return "No se repite el proveedor";
		}
	}
	
	public String ValidarCampoObligatorio() {
		return null;
	}
	public String ValidarCorreo() {
		
		return null;
	}
	public String ValidarTelefono() {
		return null;
	}
	public String ValidarUnicoProveedor(){
		return null;
	}

}
