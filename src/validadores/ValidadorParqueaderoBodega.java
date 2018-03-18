package validadores;

import java.util.List;

import entidades.CuentaPorCobrar;
import entidades.ParqueaderoBodega;
import entidades.UnidadHabitacional;

public class ValidadorParqueaderoBodega {
	public String existeUnidad(ParqueaderoBodega parqueaderoBodega,List<UnidadHabitacional> listaUnidad) {

		Boolean siExisteUnidad= false;
		

		for (UnidadHabitacional unidadHabitacional : listaUnidad) {
			if (unidadHabitacional.getId()==parqueaderoBodega.getUnidadHabitacional().getId()) {
				siExisteUnidad=true;
			}
		}

		if (siExisteUnidad) {
			return "Si existe la unidad";
		} else {
			return "No existe la unidad habitacional";
		}

	}
	public String ValidarEspaciosBlancola() {
		return null;
	}
	
	public String ValidarCampoObligatorio() {
		return null;
	}
	public String ValidarUnicoParqueadero() {
		//validar que la identificaion del paruqeadero se unico
		return null;
	}
	public String ValidaDirecciones() {
		//valida dirrecciones si se repiten muetsra alerta
		return null;
	}
}
