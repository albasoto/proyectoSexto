package validadores;

import java.util.List;

import entidades.UnidadHabitacional;

public class ValidadorUnidad {
	/*comprueba que la ID UNIDAD HABITACIONAL NO SE REPITA*/
	
	public String comprobarSiSeRepiteUnidad(UnidadHabitacional unidad, List<UnidadHabitacional> listaUnidad) {
		int aux= 0;
		for (UnidadHabitacional unidadHabitacional : listaUnidad) {
			if (unidadHabitacional.getId()==unidad.getId()) {
				aux++;
			}
		}
		if (aux>1) {
			return "La unidad habitacional se repetite "+aux+ " veces";
		} else {
			return "No se repite la unidad";
		}
	}
	
public String ValidarUnicaUnidad()  {
	//unidad habitacional debe ser unica y menor a 15 caracteres
	//campo obligatorio
	
	return null;	
	
}

public String ValidarCampoObligatorio() {
	return null;
}

public double ValidarNumeroDecimales() {
	//maximo 4 decimales
	return 0;
	
}

public double ValidarSumaAlicuota(){
	// debe ser decimal
	//suma de todos los campos de dar 100%
	//campo obligatorio
	return 0;
}


public boolean ValidarEstaArrendadaOcupado() {
	//validar el campo debe estar (YES/NO) caso contrario pone YES a todo
	return false;
	
}

}
