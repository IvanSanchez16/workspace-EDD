package colas;

import colaReportes.ColaCircular;

public class AppColaCir {
	
	class Dato{
		public String Nombre;
		public int 	  Edad;
		
		public Dato(String nombre,int edad) {
			Nombre=nombre;
			Edad=edad;
		}
	}
	
	public AppColaCir() {
		ColaCircular<Dato> C=new ColaCircular<Dato>(5);
		ColaCircular<Dato> CA=new ColaCircular<Dato>(5);
		String Nombre;
		boolean Band;
		int Edad;
		while(!C.Llena()) {
			Nombre = "";
			Edad = 0;
			//System.out.println(Nombre+"\t"+Edad);
			Band=false;
			while(C.Retira()) {
				if(C.Dr.Nombre.compareTo(Nombre)==0)
					Band=true;
				CA.Inserta(C.Dr);
			}
			while(CA.Retira() && C.Inserta(CA.Dr));
			if(!Band)
				C.Inserta(new Dato(Nombre,Edad));
		}
		System.out.println("Contenido de la cola");
		while(C.Retira())
			System.out.println(C.Dr.Nombre+"\t"+C.Dr.Edad);
	}
	
	public static void main (String []a) {
		new AppColaCir();
	}
}
