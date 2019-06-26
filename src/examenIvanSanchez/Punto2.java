package examenIvanSanchez;

import java.util.Scanner;
import arboles.ArbolBinarioBusqueda;
import arboles.NodoABB;
import serpientesyescaleras.Rutinas;

/*
 * 
 * Iván Humeberto Sánchez Aispuro
 * Estructura de datos
 * 12-1pm 
 * 
 */
class Dato {
	int N;
	
	public Dato(int n) {
		N=n;
	}
	
	public String toString() {
		return Rutinas.PonCeros(N,5);
	}
}


public class Punto2 {
	

	public static void main(String[] args) {
		ArbolBinarioBusqueda<Dato> A=new ArbolBinarioBusqueda<Dato>();
		Scanner S = new Scanner(System.in);
		
		for(int i=0;i<10;i++) 
			A.Inserta(new Dato(S.nextInt()));
		
		System.out.println(EsBinarioBusqueda(A.getRaiz()));
		A.getRaiz().getSubIzq().getSubDer().Info=new Dato(30);
		System.out.println(EsBinarioBusqueda(A.getRaiz()));
		
		S.close();
	}

	
	public static boolean EsBinarioBusqueda(NodoABB<Dato> R) {
		if(R==null)
			return true;
		boolean band;
		band=EsBinarioBusqueda(R.getSubIzq());
		
		if(!band)
			return band;
		
		if(R.getSubDer()!=null && R.getSubIzq()!=null ) {
			String IdRaiz=R.Info.toString();
			String IdSubIzq=R.getSubIzq().Info.toString();
			String IdSubDer=R.getSubDer().Info.toString();
			if((IdRaiz.compareTo(IdSubIzq)<=0) || (IdRaiz.compareTo(IdSubDer)>=0)) 
				return false;
		}
		
		band=EsBinarioBusqueda(R.getSubDer());
		
		if(!band)
			return band;
		return true;
	}
}	
