package zzGeneradordeEncuentros;

import java.util.Vector;

public class Equipo {
	private int NdeEquipo;
	private Vector<Actividad> Va = new Vector<Actividad>();
	private Vector<Equipo> Ve = new Vector<Equipo>();
	private Vector<Integer> Hora = new Vector<Integer>();
	
	public Equipo(int nde) {
		NdeEquipo=nde;
	}
	
	public void IngresarEquipo(Equipo e) {
		Ve.add(e);
	}
	
	public void IngresarActividad(Actividad a) {
		Va.add(a);
	}
	
	public boolean ExisteEquipo(Equipo e) {
		for(int i=0;i<Ve.size();i++)
			if(e==Ve.get(i))
				return true;
		return false;
	}
	
	public boolean ExisteActividad(Actividad a) {
		for(int i=0;i<Va.size();i++)
			if(a==Va.get(i))
				return true;
		return false;
	}
	
	public int getNdeEquipo() {
		return NdeEquipo;
	}
	
	public String toString() {
		return NdeEquipo+"";
	}

	public void AgregarHora(int h) {
		Hora.add(h);
	}
	
	public boolean ExisteHora(int h) {
		for(int i=0;i<Hora.size();i++)
			if(h==Hora.get(i))
				return true;
		return false;
	}
	
}
