package listas;

import examen.Rutinas;

public class AppLista {
	class Dato{
		public String Nombre;
		public int Edad;
		
		public Dato(String n,int e){
			Nombre=n;
			Edad=e;
		}
		
		public String toString(){
			return Rutinas.PonBlancos(Nombre,50)+Rutinas.PonCeros(Edad,10);
		}
	}
	public AppLista(){
		Lista<Dato> L= new Lista<Dato>();
		
	} 
	
	public void Llena(Lista<Dato> L){
		for(int i=0;i<20;i++)
			L.InsertaFrente(new Dato(Rutinas.nextNombre(2,2),Rutinas.nextInt(50)));
	}
	public static void main(String[] args) {
		new AppLista();
	}

}
