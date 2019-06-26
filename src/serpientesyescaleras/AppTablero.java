package serpientesyescaleras;

//Iván Humberto Sánchez Aispuro
//12-1pm
//Estructura de datos

class Casilla {
	public int NoCasilla;
	public char TipoCasilla;
	public int Posiciones;
	
	public Casilla(int nc) {
		NoCasilla=nc;
		TipoCasilla='N';
		Posiciones=0;
	}
	
	public String toString() {
		return NoCasilla+(NoCasilla==100?"":NoCasilla>9?" ":"  ")+TipoCasilla;
	}
	
	
}

public class AppTablero {
ListaDBL<Casilla> L = new ListaDBL<Casilla>();	
NodoDBL<Casilla>[] Jugadores;
	public AppTablero() {
		CrearTablero();
		
		int njug=Rutinas.nextInt(2,10);
		byte i=0;
		boolean band=true;
		System.out.println("Jugarán "+njug+" jugadores");
		Jugadores=new NodoDBL[njug];
		MostrarTablero();
		System.out.println();
		
		while(band) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			for(i=0;i<njug;i++) 
				if(Turno(i)) {//Si es verdadero quiere decir que alguien ya terminó
					band=false;
					break;
				}
		}
		
		System.out.println("\nEl jugador ganador es: "+i);
	}
	
	public boolean Turno(int posJugador) {
		NodoDBL<Casilla> J=Jugadores[posJugador];
		System.out.println("Turno del jugador: "+(posJugador+1));
		int resDados=Rutinas.nextInt(2,12);
		System.out.println("Puntos en dados: "+resDados);
		System.out.println("Casilla inicial: "
							+(J==null?"Primer turno":J.Info.NoCasilla));
		
		if(J==null) {
			J=L.getFrente();
			resDados--;
		}
		boolean Cllegada=true;
		for(byte i=0;i<resDados;i++) {
			if(J.getSig()==null)
				Cllegada=false;
			J=Cllegada?J.getSig():J.getAnt();
		}
		
		System.out.println("Casilla final: "+J.Info.NoCasilla
											+" "+J.Info.TipoCasilla);
		if(J.Info.NoCasilla==100)
			return true;
		
		if(J.Info.TipoCasilla=='E') {
			int pos=J.Info.Posiciones;
			System.out.println("Bonus por escalera: "+pos);
			for(byte j=0;j<pos;J=J.getSig(),j++);
			System.out.println("Posicion después de la escalera: "+J.Info.NoCasilla);	
		}
		if(J.Info.TipoCasilla=='S') {
			int pos=J.Info.Posiciones;
			System.out.println("Penalización por serpiente: "+pos);
			for(byte k=0;k<pos;J=J.getAnt(),k++);
			System.out.println("Posicion después de la serpiente: "+J.Info.NoCasilla);	
		}
		System.out.println();
		Jugadores[posJugador]=J;
		return false;
	}
	
	public void CrearTablero() {
		for(byte i=1;i<=100;i++) 
			L.InsertaFin(new Casilla(i));
		for(byte i=0;i<5;i++)
			GenerarEscalera();
		for(byte i=0;i<5;i++)
			GenerarSerpiente();
	}
	
	public void GenerarEscalera() {
		int Pos,Rango;
		NodoDBL<Casilla> Aux,Aux2;
		do {
			Pos=Rutinas.nextInt(15,70);
			Aux=L.getFrente();
			for(byte i=1;i<Pos; Aux=Aux.getSig() , i++);
		}while(Aux.Info.TipoCasilla!='N'); 
		
		Aux.Info.TipoCasilla='E';
		
		do {
			Aux2=Aux;
			Rango=Rutinas.nextInt(5,20);
			for(byte j=0;j<Rango; Aux2=Aux2.getSig() , j++);
		}while(Aux2.Info.TipoCasilla!='N');
		Aux.Info.Posiciones=Rango;
		Aux2.Info.TipoCasilla='T';
	}
	
	public void GenerarSerpiente() {
		int Pos,Rango;
		NodoDBL<Casilla> Aux,Aux2;
		do {
		Pos=Rutinas.nextInt(30,95);
		Aux=L.getFrente();
		for(byte i=1;i<Pos; Aux=Aux.getSig() , i++);
		}while(Aux.Info.TipoCasilla!='N') ;
		
		Aux.Info.TipoCasilla='S';
		
		do{
			Aux2=Aux;
			Rango=Rutinas.nextInt(5,20);
			for(byte j=0;j<Rango; Aux2=Aux2.getAnt() , j++);
		}while(Aux2.Info.TipoCasilla!='N');
		Aux.Info.Posiciones=Rango;
		Aux2.Info.TipoCasilla='T';
	}

	public void MostrarTablero() {
		System.out.println(" _________________________________________________");
		NodoDBL<Casilla> Aux=L.getFrente();
		while(Aux!=null) {
			for(byte i=0;i<10;Aux=Aux.getSig(),i++)
				System.out.print("|"+Aux.Info.toString());
			System.out.print("|\n");
			for(byte j=1;j<10;Aux=Aux.getSig(),j++);
			System.out.println("|____|____|____|____|____|____|____|____|____|____|");
			System.out.println("                                             |  | |");
			System.out.println(" ____________________________________________|__V_|");
			for(byte k=10;k>0;Aux=Aux.getAnt(),k--)
				System.out.print("|"+Aux.Info.toString());
			System.out.print("|\n");
			for(byte l=0;l<=10;Aux=Aux.getSig(),l++);
			System.out.println("|____|____|____|____|____|____|____|____|____|____|");
			if(Aux!=null){
				System.out.println("|  | |                                             ");
				System.out.println("|__V_|____________________________________________ ");
			}
		}
	}
	
	public static void main(String args[]) {
		new AppTablero();
	}
}

