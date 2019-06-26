package examenIvanSanchez;

import arboles.ArbolBinarioBusqueda;
import soldadoVoluntario.Rutinas;

/*
 * 
 * Iván Humeberto Sánchez Aispuro
 * Estructura de datos
 * 12-1pm 
 * 
 */
public class Punto1 {

	public static void main(String[] args) {
		//a)
		String[] Arreglo = new String[15];
		
		//b)
		for(int i=0;i<Arreglo.length;i++) 
			Arreglo[i]=Rutinas.nextNombre(1,2);
		
		ImprimirArreglo(Arreglo);
		System.out.println();
		OrdenarArreglo(Arreglo);
		ImprimirArreglo(Arreglo);
		
		ArbolBinarioBusqueda<String> A=new ArbolBinarioBusqueda<String>();
		GeneraArbol(A,Arreglo,0,Arreglo.length-1);
		
		System.out.println();
		A.InOrden(A.getRaiz());
		
	}
	
	public static void ImprimirArreglo(String[] a) {
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
	
	//c)
	public static void OrdenarArreglo(String []a) {
		String aux;
		for(int i=0;i<a.length-1;i++) {
			for(int j=i;j<a.length;j++) {
				if(a[i].compareToIgnoreCase(a[j])>0){
					aux=a[i];
					a[i]=a[j];
					a[j]=aux;
				}
			}
		}
			
	}
	
	//d)
	public static void GeneraArbol(ArbolBinarioBusqueda<String> A,String[] a,int izq,int der) {
		if(izq>der) 
			return;
		int datoMedio=(int)Math.ceil((der+izq)/2);//Obtenemos el dato central para definirlo como la raiz
		A.Inserta(a[datoMedio]);
		
		GeneraArbol(A,a,izq,datoMedio-1);
		GeneraArbol(A,a,datoMedio+1,der);
	}

}
