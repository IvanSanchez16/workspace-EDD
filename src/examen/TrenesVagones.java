package examen;


public class TrenesVagones {
	static int TamañoTren=Rutinas.nextInt(50,70);
	static Cola<Integer> Tren= new Cola<Integer>(TamañoTren);
	static int Vagones=(int)(TamañoTren*0.6);
	static Cola<Integer> Aux= new Cola<Integer>(Vagones); //That is the problem
	static int TamañoEstacionamiento=150-Vagones;
	static Cola<Integer> Estacionamiento= new Cola<Integer>(TamañoEstacionamiento);
	
	public static void LlenarVagones(){
		Tren.Inserta(1);
		for(int i=0;i<Vagones-1;i++){
			int NumeroAleatorio= Rutinas.nextInt(1/*Pudiste haber puesto 2*/,200);
			if(Comprobar(Tren,NumeroAleatorio)){
				Tren.Inserta(NumeroAleatorio);
				continue;	
			}
			i--;
		}
	}
	
	
	
	public static void LlenarEstacionamiento(){
		for(int i=0;i<TamañoEstacionamiento;i++){//while(!Estacionamiento.Llena()) está mejor y te ahorras el continue y el i--
			int NumeroAleatorio= Rutinas.nextInt(2,200);
			if(Comprobar(Tren,NumeroAleatorio) && Comprobar(Estacionamiento,NumeroAleatorio)){
				Estacionamiento.Inserta(NumeroAleatorio);
				continue;
			}
			i--;
		}
	}
	
	public static boolean Comprobar(Cola<Integer> C,int N){//al 100 por culiacan
		boolean B=true;
		while(C.Retira() && Aux.Inserta(C.Dr))
			if(C.Dr==N)
				B=false;
		while(Aux.Retira() && C.Inserta(Aux.Dr));
		return B;
	}
	
	public static void LlenarTren(){//Para que hacer un metodo que es una linea xdxd no mame joben
		while(Estacionamiento.Retira() && Tren.Inserta(Estacionamiento.Dr));
	}

	public static void main(String [] args){
		//Que pedo con el tremendo lagazo criminal que te dio con esta madre
		//He visto cosas inecesarias y luego esta lo de arriba
		//Un 0 a la izquierda sirve más
		Cola<Integer> Aux= new Cola<Integer>(200);
		//Se generan los vagones
		System.out.println("Tamaño del tren: "+TamañoTren);//Hasta el eclipse te dice que estas bien pendejo
		System.out.println("Vagones asignados: "+Vagones);
		LlenarVagones();
		while(Tren.Retira() && Aux.Inserta(Tren.Dr))
			System.out.println(Tren.Dr);
		System.out.println();
		while(Aux.Retira() && Tren.Inserta(Aux.Dr));
		//Se llena el estacionamiento
		System.out.println("Tamaño del estacionamiento: "+TamañoEstacionamiento);
		LlenarEstacionamiento();
		while(Estacionamiento.Retira() && Aux.Inserta(Estacionamiento.Dr)) //Primero se acababa el espacio en Aux antes de vaciar el estacionamiento
			System.out.println(Estacionamiento.Dr);//Por eso nomas muestra los mismos elementos que vagones
		System.out.println();
		while(Aux.Retira() && Estacionamiento.Inserta(Aux.Dr));//Aqui lo dejas todo pa la vrg
		//Se termina de llenar el tren
		System.out.println("Tamaño del tren: "+TamañoTren);
		LlenarTren();
		while(Tren.Retira() && Aux.Inserta(Tren.Dr))
			System.out.println(Tren.Dr);
		System.out.println();
		
	}
}
