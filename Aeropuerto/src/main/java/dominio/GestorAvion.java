package dominio;

import java.util.ArrayList;
import java.util.List;

import dominio.exceptions.ExceptionGeneral;

public class GestorAvion {

	private List<Avion> misAviones = new ArrayList<Avion>();
	private static GestorAvion gAvion;
	
	public static GestorAvion getInstancia() {
		if(gAvion == null) {
			return gAvion = new GestorAvion();
		}
		
		return gAvion;
	}

	public void limpiarAviones() {
		misAviones = new ArrayList<Avion>();
	}
	
	public boolean crearAvion(int idAvion, String modelo, String matricula, List<Asiento> listaAsientos) throws ExceptionGeneral {
		try {
			Avion avion = new Avion(idAvion, modelo, matricula, listaAsientos);
			misAviones.add(avion);
			return true;
		} catch(ExceptionGeneral e) {
			throw new ExceptionGeneral("Error de Avion");
		}
	}

	public Avion traerUno(int idAvion) {

		for (Avion avion : misAviones) {
			if(avion.getIdAvion() == idAvion) {
				return avion;
			}
		}
		return null;
	}

	public List<Avion> traerTodosAviones() {
		
		return misAviones;
	}

	public boolean BorrarAvion(Avion avion1) {
		
		for (Avion avion : misAviones) {
			if(avion.equals(avion1)) {
				misAviones.remove(avion);
				return true;
			}
		}
		return false;
	}

	public Avion ModificarAvion(Avion avion1, String matricula) {
		
		for (Avion avion : misAviones) {
			if(avion.equals(avion1)) {	
				avion.setMatricula(matricula);
				return avion;
			}
			
		}
		return null;
	}

	public Avion traerPorCriterio(String modelo) {

		for (Avion avion : misAviones) {
			if(avion.getModelo() == modelo) {	
				
				return avion;
			}
			
		}
		return null;
	}
	
	
}
