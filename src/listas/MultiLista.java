package listas;
import java.util.*;


class Vuelos {
	public String Origen,Destino;
	public float Tiempo;
	
	public Vuelos(){
		Origen=Destino=null;
		Tiempo=0.0f;
	}
	
	public Vuelos(String O,String D,float T){
		Origen=O;
		Destino=D;
		Tiempo=T;
	}
}

class Aerolinea {
	public String RazonSocial;
	Lista<Vuelos> LV;
	
	public Aerolinea(String RZ){
		RazonSocial=RZ;
		LV=new Lista<Vuelos>();
	}
}

public class MultiLista {
Scanner S=new Scanner(System.in);
Lista<Aerolinea> L;
	public MultiLista(){
		Menu();
	}
	
	public void Menu(){
		while(true){
			System.out.println("1-. Registrar lineas áereas");
			System.out.println("2-. Registrar vuelos");
			System.out.println("3-. Consultar");
			System.out.println("4-. Consultar lineas áereas");
			System.out.println("5-. Buscar vuelo");
			System.out.println("0-. Salir");
			System.out.print("Opción: ");
			int O=S.nextInt();
			switch(O){
			case 0:return;
			case 1:Met1();break;
			case 2:Met2();break;
			case 3:Met3();break;
			case 4:Met4();break;
			case 5:Met5();break;
			}
		}
	}
	
	private void Met5() {
		// TODO Auto-generated method stub
		
	}

	private void Met4() {
		// TODO Auto-generated method stub
		
	}

	private void Met3() {
		System.out.println("Lineas áereas con sus vuelos");
		Nodo<Aerolinea> Aux=L.getFrente();
		while(Aux!=null){
			System.out.println(Aux.Info.RazonSocial);
			System.out.println("\tVuelos:");
			Nodo<Vuelos> AuxV=Aux.Info.LV.getFrente();
			while(AuxV!=null){
				System.out.println("\t"+AuxV.Info.Origen+"\t"+AuxV.Info.Destino+"\t"+AuxV.Info.Tiempo);
				AuxV=AuxV.getSig();
			}
			Aux=Aux.getSig();
		}
	}

	private void Met2() {
		System.out.println("Razon Social: ");
		S.nextLine();
		String RZ=S.nextLine();
		Nodo<Aerolinea> Aux=L.getFrente();
		while(Aux!=null){
			if(RZ.compareToIgnoreCase(Aux.Info.RazonSocial)==0)
				break;
			Aux=Aux.getSig();
		}
		if(Aux==null){
			System.out.println("Aerolinea no encontrada");
			return;
		}
		Vuelos V=new Vuelos();
		System.out.println("Ciudad origen: ");
		V.Origen=S.nextLine();
		System.out.println("Ciudad destino: ");
		V.Destino=S.nextLine();
		System.out.println("Tiempo: ");
		V.Tiempo=S.nextFloat();
		Aux.Info.LV.InsertaFrente(V);
	}

	public void Met1(){
		System.out.println("Razon Social: ");
		S.nextLine();
		String RZ=S.nextLine();
		
		L.InsertaFin(new Aerolinea(RZ));
	}
	
	public static void main(String[] args) {
		new MultiLista();
	}

}
