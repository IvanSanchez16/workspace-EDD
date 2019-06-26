package zzGeneradordeEncuentros;

public class Actividad {
	private int NdeActividad;
	private String Nombre;
	
	public Actividad(int nda,String n) {
		NdeActividad=nda;
		Nombre=n;
	}
	
	public int getNdeActividad() {
		return NdeActividad;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public String toString() {
		return Nombre;
	}
}
