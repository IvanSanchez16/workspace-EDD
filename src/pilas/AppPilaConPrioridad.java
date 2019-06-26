package pilas;

import java.util.Random;

public class AppPilaConPrioridad {

	public AppPilaConPrioridad(){
		Pila<Reporte> P = new Pila<Reporte>(20);
		Pila<Reporte> PAux = new Pila<Reporte>(20);
		while(!P.Llena()){
			Reporte Nuevo=new Reporte();
			if(P.Vacia()){
				P.Inserta(Nuevo);
				continue;
			}
			while(P.Retira()){
				if(P.Dr.Prioridad < Nuevo.Prioridad){
					PAux.Inserta(Nuevo);
					PAux.Inserta(P.Dr);
					break;	
				}
				PAux.Inserta(P.Dr);
			}
			while(PAux.Retira() && P.Inserta(PAux.Dr));
		}
		
		while(P.Retira())
			System.out.println(P.Dr);
	}
	
	public static void main(String[] args) {
		new AppPilaConPrioridad();

	}
	
	private class Reporte{
		public int NoComp,NoPaginas,Prioridad;//1 baja 2 media y 3 alta
		
		public Reporte(){
			NoComp=new Random().nextInt(10)+1;
			NoPaginas=new Random().nextInt(100)+1;
			Prioridad=new Random().nextInt(3)+1;
		}
		
		public String toString(){
			return NoComp+"\t"+NoPaginas+"\t"+Prioridad;
		}
	}
}
