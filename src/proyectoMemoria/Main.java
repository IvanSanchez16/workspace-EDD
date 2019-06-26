package proyectoMemoria;

import java.util.Scanner;

/**
 * @author Iván Humberto Sánchez Aispuro
 * Estructura de Datos
 *12 - 1 pm
 */

public class Main {
	static Scanner S=new Scanner(System.in);
	static Dato VDatos[];
	static int Inicio=-1;
	static int Sub=0;
	
	public static void main(String[] args) {
		System.out.println("Ingrese largo del vector");
		int l=S.nextInt();
		VDatos=new Dato[l];
		boolean c=true;
		while(c) {
			MostrarMenu();
			int m=S.nextInt();
			switch(m) {
			case 1:
				if(Sub<VDatos.length)
					DarAlta();
				else
					System.out.println("Máximo de datos alcanzados");
				break;
			case 2:
				BajaCliente();
				break;
			case 3: 
				Consulta();
				break;
			case 4:
				MostrarVector();
				break;
			case 5:
				c=false;
				break;
			default:
				System.out.println("Ingrese carácter válido");
			}
		}

	}
	
	public static void MostrarMenu() {
		System.out.println(" - - - MENU - - -");
		System.out.println("1-. Dar de alta un cliente");
		System.out.println("2-. Dar de baja un cliente");
		System.out.println("3-. Consultar");
		System.out.println("4-. Mostrar arreglo en orden");
		System.out.println("5-. Salir");
	}
	public static void DarAlta() {
		System.out.print("Clave: ");
		int clv=S.nextInt();
		System.out.print("Nombre: ");
		String nom=S.next();
		System.out.print("Edad: " );
		int edad=S.nextInt();
		System.out.print("Edo Civil: ");
		char edc=S.next().charAt(0);
		VDatos[Sub]=new Dato(clv,nom,edad,edc);
		AsignarSiguientes();
		Sub++;
	}
	public static void AsignarSiguientes() {
		if(Inicio == -1) { //Caso 1 (Primer elemento)
			Inicio = Sub;
			VDatos[Sub].Siguiente=-1;
			return;
		}else if((VDatos[Inicio].Nombre.compareToIgnoreCase(VDatos[Sub].Nombre))>0) { //Caso 2 (Nuevo dato menor que el inicio)
			VDatos[Sub].Siguiente=Inicio;
			Inicio=Sub;
			return;
		}else { //Caso 3 (Nuevo dato mayor al ultimo)
			int i;
			for(i=Inicio;VDatos[i].Siguiente!=-1;i=VDatos[i].Siguiente);
			if((VDatos[i].Nombre.compareToIgnoreCase(VDatos[Sub].Nombre))<0) {
				VDatos[i].Siguiente=Sub;
				VDatos[Sub].Siguiente=-1;
				return;
			}else { //Caso 4 (Nuevo Dato en medio del vector)
				i=Inicio;
				while((VDatos[i].Nombre.compareToIgnoreCase(VDatos[Sub].Nombre)<0))
					i=VDatos[i].Siguiente;
				VDatos[Sub].Siguiente=i;
				for(int k=0;k<Sub;k++) 
					if(VDatos[k].Siguiente==i)
						VDatos[k].Siguiente=Sub;
			}
		}	
	}
	public static void Consulta() {
		System.out.println("|Clave\t|Nombre\t\t|Edad\t|E.Civil|");
		int c=Inicio;
		while(c!=-1) {
			System.out.println(VDatos[c]);
			c=VDatos[c].Siguiente;
		}
	}
	public static void BajaCliente() {
		Consulta();
		System.out.print("Ingrese el nombre del elemento a borar: ");
		String nb=S.next();
		int SubB;
		for(SubB=0;!VDatos[SubB].Nombre.equalsIgnoreCase(nb) && SubB<Sub;SubB++); //Se busca el subindice del elemento a borrar
			if(SubB==Sub)
				System.out.println("Clave inexistente");
			else {
				if(SubB==Inicio) {	//Caso que sea el inicio
					Inicio=VDatos[SubB].Siguiente;
				}else { //El resto de casos
					int PAnt=Inicio;
					while(VDatos[PAnt].Siguiente!=SubB)//Se busca la posicion anterior
						PAnt=VDatos[PAnt].Siguiente;
					if(VDatos[SubB].Siguiente==-1) {
						VDatos[PAnt].Siguiente=-1;
					}else
						VDatos[PAnt].Siguiente=VDatos[SubB].Siguiente;
				}
				OrdenarVector(SubB);
			}
	}
	
	public static void OrdenarVector(int posB) {
		if(Inicio>posB)//Acomodamos el inicio
			Inicio--;
		for(int i=0;i<Sub;i++)	//Se ordenan los 'siguientes'
			if(VDatos[i].Siguiente>=posB)
				VDatos[i].Siguiente--;
		while(posB<Sub-1) {	//Se bajan los datos dentro del vector
			VDatos[posB]=VDatos[posB+1];
			posB++;
		}
		VDatos[Sub]=null; //Borramos el ultimo ya que se ordeno el vector
		Sub--;
	}
	public static void MostrarVector() {
		System.out.println("|Clave\t|Nombre\t\t|Edad\t|E.Civil|");
		for(int c=0;c<Sub;c++)
			System.out.println(VDatos[c]+"siguiente = "+VDatos[c].Siguiente);

	}
}
