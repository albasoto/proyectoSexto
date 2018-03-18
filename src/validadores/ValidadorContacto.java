package validadores;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Contacto;
import entidades.UnidadHabitacional;

public class ValidadorContacto {
	
	
	public String existeUnidad(Contacto contacto, List<UnidadHabitacional> listaUnidad) {

		Boolean siExisteUnidad= false;
		

		for (UnidadHabitacional unidadHabitacional : listaUnidad) {
			if (unidadHabitacional.getId()==contacto.getUnidadHabitacional().getId()) {
				siExisteUnidad=true;
			}
		}

		if (siExisteUnidad) {
			return "Si existe la unidad";
		} else {
			return "No existe la unidad habitacional";
		}

	}
	
	/*public void validarContaco(List<Contacto> listaContactos) {
		
		for (Contacto contacto : listaContactos) {
			validarCelular(contacto.getIdentificacion());
			ValidarCampoObligatorio(contacto.getIdentificacion());
			ValidarCampoObligatorio(contacto.getApellido());
			
			contacto.setMensaje(contacto.getMensaje()+"\n"+ValidarCampoObligatorio(contacto.getIdentificacion()));
			
		}
		
		
	}*/
	
	
	
	
	
	
	

	public String ValidarCampoObligatorio(String campo) {
		
		
		
		if(campo!= null && campo !="") {
			return "Error, El campo es obligatorio";
		}
		else {
			return "Success, Datos correctos ";
		}
		
	}
	public static boolean  ValidarCedula(String x) {
		
		    int suma=0;
		    if(x.length()<=9){
		      System.out.println("Ingrese su cedula de 10 digitos");
		      return false;
		    }else{
		      int a[]=new int [x.length()/2];
		      int b[]=new int [(x.length()/2)];
		      int c=0;
		      int d=1;
		      for (int i = 0; i < x.length()/2; i++) {
		        a[i]=Integer.parseInt(String.valueOf(x.charAt(c)));
		        c=c+2;
		        if (i < (x.length()/2)-1) {
		          b[i]=Integer.parseInt(String.valueOf(x.charAt(d)));
		          d=d+2;
		        }
		      }
		    
		      for (int i = 0; i < a.length; i++) {
		        a[i]=a[i]*2;
		        if (a[i] >9){
		          a[i]=a[i]-9;
		        }
		        suma=suma+a[i]+b[i];
		      } 
		      int aux=suma/10;
		      int dec=(aux+1)*10;
		      if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length()-1))))
		        return true;
		      else
		        if(suma%10==0 && x.charAt(x.length()-1)=='0'){
		          return true;
		        }else{
		          return false;
		        }
		     
		    }


	}
	public String ValidarRUC() {
		return null;
	}
	
	public String ValidarRelacion() {
		//validar que la relacion sea Propietario / Contacto / Arrendatario
		return null;
	}

	public String ValidarUnicaRelacion() {
		return null;
	}
	public static boolean ValidarCorreo(String email) {
        
   String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//        String regex= "\\\\d{8}[A-HJ-NP-TV-Z]";
        
 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
	
	  public static boolean validarCelular(String cadena) {
	      if (cadena.matches("[0-9]*")) {
	         return true;
	      } else {
	         return false;
	      }
	   }
	public String ValidarTelefono() {
		return null;
	}
	public String ValidarEspaciosBlancola() {
		return null;
	}
}

