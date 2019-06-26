package hashTable1er;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

//Iv�n Humberto S�nchez Aispuro
//Estructura de datos


public class TFrecuencias {

	public static void main(String[] args) {
		Hashtable<Integer,Integer> tabla = new Hashtable<Integer,Integer>();
		Scanner S= new Scanner(System.in);
			while(true){
				System.out.println("Ingrese un n�mero (Si desea terminar, ingrese '*')");
				try{
					int Ed=S.nextInt();
					tabla.put(Ed,tabla.get(Ed)==null?1:tabla.get(Ed)+1);
				}catch(InputMismatchException e){
					break;
				}	
			}
		Enumeration<Integer> frecuencias = tabla.elements(),n�meros = tabla.keys();
		System.out.println("N�mero\t|  Frecuencia");
		while (frecuencias.hasMoreElements()) {
			System.out.println(n�meros.nextElement()+ "\t|  " + frecuencias.nextElement());
		}
		S.close();
		
	}
}
