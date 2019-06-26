package examen;


public class TrenesVagones {
	static int Tama�oTren=Rutinas.nextInt(50,70);
	static Cola<Integer> Tren= new Cola<Integer>(Tama�oTren);
	static int Vagones=(int)(Tama�oTren*0.6);
	static Cola<Integer> Aux= new Cola<Integer>(Vagones); //That is the problem
	static int Tama�oEstacionamiento=150-Vagones;
	static Cola<Integer> Estacionamiento= new Cola<Integer>(Tama�oEstacionamiento);
	
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
		for(int i=0;i<Tama�oEstacionamiento;i++){//while(!Estacionamiento.Llena()) est� mejor y te ahorras el continue y el i--
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
		//Un 0 a la izquierda sirve m�s
		Cola<Integer> Aux= new Cola<Integer>(200);
		//Se generan los vagones
		System.out.println("Tama�o del tren: "+Tama�oTren);//Hasta el eclipse te dice que estas bien pendejo
		System.out.println("Vagones asignados: "+Vagones);
		LlenarVagones();
		while(Tren.Retira() && Aux.Inserta(Tren.Dr))
			System.out.println(Tren.Dr);
		System.out.println();
		while(Aux.Retira() && Tren.Inserta(Aux.Dr));
		//Se llena el estacionamiento
		System.out.println("Tama�o del estacionamiento: "+Tama�oEstacionamiento);
		LlenarEstacionamiento();
		while(Estacionamiento.Retira() && Aux.Inserta(Estacionamiento.Dr)) //Primero se acababa el espacio en Aux antes de vaciar el estacionamiento
			System.out.println(Estacionamiento.Dr);//Por eso nomas muestra los mismos elementos que vagones
		System.out.println();
		while(Aux.Retira() && Estacionamiento.Inserta(Aux.Dr));//Aqui lo dejas todo pa la vrg
		//Se termina de llenar el tren
		System.out.println("Tama�o del tren: "+Tama�oTren);
		LlenarTren();
		while(Tren.Retira() && Aux.Inserta(Tren.Dr))
			System.out.println(Tren.Dr);
		System.out.println();
		
	}
}
