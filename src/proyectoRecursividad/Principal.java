package proyectoRecursividad;

/**
 * @author Iv�n Humberto S�nchez Aispuro
 * Estructura de Datos
 *12 - 1 pm
 */

//El programa va avanzando inciso por inciso, no existe un men� para acceder cualquiera de ellos
import java.util.Random;
import java.util.Scanner;

public class Principal {
	static Scanner S=new Scanner(System.in);
	static Random R=new Random();
	static int M[][];
	static int V[];
	public static void main(String[] args) {
		CrearLlenarYMostrar1();
		int A=0;
		boolean ctrl=true;
		//Puntos 1 y 2 Sumas de renglones en una matriz
		while(ctrl) {
			Mostrarmenu1();
			A=S.nextInt();
			switch(A) {
			case 1:
				System.out.println("Que rengl�n desea mostrar");
				int r=S.nextInt();
				System.out.println("La suma de los elementos en el rengl�n "+r+" = "+M�todos.SumaRenglon(M,r,0)+"\n");
				break;
			case 2:
				V=M�todos.SumasRenglones(M,0,V);
				for(int i=0;i<V.length;i++) 
					System.out.println("La suma de los elementos en el rengl�n "+ i + " = "+V[i]+"\n");
				break;
			default:
				ctrl=false;
				break;
			}
		}
		//Punto 3 Problema Matriz cuadrada
		while(true) {
			System.out.println("Soluci�n al inciso 3");
			System.out.println("# de renglones y columnas de la matriz (ingrese 0 para salir)");
			int n=S.nextInt();
			if(n==0)
				break;
			M=new int[n][n];
			M�todos.LlenarMatriz(M,0);
			MostrarMatriz();
		}
		//Punto 4 Transformar n�mero
		System.out.println("Soluci�n al inciso 4");
		while(true) {
			System.out.println("Ingrese un n�mero");
			String N=S.next();
			System.out.println(M�todos.Transformar(N).trim()+"\n");
		}
	}
	
	static void CrearLlenarYMostrar1() {
		System.out.println("Soluci�n a incisos 1 y 2");
		System.out.println("# de renglones de la matriz");
		int m=S.nextInt();
		System.out.println("# de columnas de la matriz");
		int n=S.nextInt();
		M=new int[m][n];
		V=new int[m];
		for(int i=0;i<M.length;i++) {
			for(int j=0;j<M[i].length;j++) {
				M[i][j]=R.nextInt(21);
				System.out.print(M[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void Mostrarmenu1() {
		System.out.println("1-. Mostrar Suma de un rengl�n");
		System.out.println("2-. Mostrar Suma de todos los renglones");
		System.out.println("3-. Salir");
	}
	
	static void MostrarMatriz() {
		for(int i=0;i<M.length;i++) {
			for(int j=0;j<M[i].length;j++)
				System.out.print(M[i][j]+"\t");
			System.out.println("\n");
		}
		System.out.println();
	}


}
