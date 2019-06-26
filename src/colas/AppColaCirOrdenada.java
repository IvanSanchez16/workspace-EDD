package colas;

import colaReportes.ColaCircular;
import serpientesyescaleras.Rutinas;

public class AppColaCirOrdenada {
	class Dato{
		public String Nombre;
		public int 	  Edad;
		
		public Dato(String nombre,int edad) {
			Nombre=nombre;
			Edad=edad;
		}
		
		public String toString() {
			return Rutinas.PonCeros(Edad,3)+Rutinas.PonBlancos(Nombre,50);
		}
	}
	
	public AppColaCirOrdenada() {
		ColaCircular<Dato> C=new ColaCircular<Dato>(5);
		ColaCircular<Dato> CA=new ColaCircular<Dato>(5);
		String Nombre;
		boolean Band,ver=false;
		int Edad;
		Dato dato;
		while(!C.Llena()) {
			Nombre = Rutinas.nextNombre(2,Rutinas.nextInt(1,2));
			Edad = Rutinas.nextInt(18,60);
			//System.out.println(Nombre+"\t"+Edad);
			Band=false;
			while(C.Retira()) {
				if(C.Dr.Nombre.compareTo(Nombre)==0)
					Band=true;
				CA.Inserta(C.Dr);
			}
			dato=new Dato(Nombre,Edad);
			while(CA.Retira() && C.Inserta(CA.Dr));
			if(!Band)
				if(C.Vacia())
					C.Inserta(dato);
				else {
					while(C.Retira()) {
						if(C.Dr.toString().compareTo(dato.toString())>0) {
							CA.Inserta(dato);
							CA.Inserta(C.Dr);
							ver=true;
							break;
						}
						CA.Inserta(C.Dr);
					}
					if(!ver)
						CA.Inserta(dato);
					while(C.Retira() && CA.Inserta(C.Dr));
					while(CA.Retira() && C.Inserta(CA.Dr));
				}
		}
		System.out.println("Contenido de la cola");
		while(C.Retira())
			System.out.println(C.Dr.Nombre+"\t"+C.Dr.Edad);
	}
	
	public static void main (String []a) {
		new AppColaCirOrdenada();
	}
}
