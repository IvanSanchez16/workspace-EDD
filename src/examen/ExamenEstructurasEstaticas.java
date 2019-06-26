package examen;

/*
 * Alumno: Iván Humberto Sánchez Aispuro
 * Materia: Estructura de datos
 * Profesor: Dr. Clemente Garcia Gerardo
 * 
 */
public class ExamenEstructurasEstaticas {
	public ExamenEstructurasEstaticas(){
		int LargoTren=Rutinas.nextInt(50,70);
		System.out.println("Largo máximo del tren: "+LargoTren);
		Cola<Integer> T = new Cola<Integer>(LargoTren);
		Cola<Integer> E;
		Cola<Integer> Aux;
		
		int NT;
		int largo=(int) (LargoTren * 0.6);
		
		E = new Cola<Integer>(150-largo);
		Aux = new Cola<Integer>(150-largo);
		
		T.Inserta(1);
		for(int i=1;i<largo;i++){
			NT=Rutinas.nextInt(2,200);
			if(!Existe(T,Aux,NT))
				T.Inserta(NT);
			else
				i--;
		}
		System.out.println("\nContenido del tren: ");
		MostrarCola(T,Aux);
		
		while(!E.Llena()){
			NT=Rutinas.nextInt(2,200);
			if(!Existe(T,Aux,NT) && !Existe(E,Aux,NT))
				E.Inserta(NT);
		}
		System.out.println("\nContenido del estacionamiento: ");
		MostrarCola(E,Aux);

		while(!T.Llena()){
			E.Retira();
			T.Inserta(E.Dr);
		}
		
		System.out.println("\nContenido final del tren");
		MostrarCola(T,Aux);
		
		System.out.println("\nContenido final del estacionamiento");
		MostrarCola(E,Aux);
	}
	
	
	public boolean Existe(Cola<Integer> C,Cola<Integer> Aux,int dato){
		boolean band=false;
		while(C.Retira()){
			if(dato==C.Dr)
				band=true;
			Aux.Inserta(C.Dr);
		}
		while(Aux.Retira() && C.Inserta(Aux.Dr));
		return band;
	}
	
	public void MostrarCola(Cola<Integer> C,Cola<Integer> Aux){
		int cont=1;
		while(C.Retira()){
			System.out.println("#"+cont+" :\t"+C.Dr);
			cont++;
			Aux.Inserta(C.Dr);
		}
		while(Aux.Retira() && C.Inserta(Aux.Dr)); 
	}
	
	public static void main(String[] args) {
		new ExamenEstructurasEstaticas();
	}

}
