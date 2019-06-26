package pilaAmortiguadores;
import java.util.*;
public class AppAmortiguador {
	/* 
	 *Iván Humberto Sánchez Aispuro
	 *Estructura de Datos 
	 */
	public static void main (String[] a){
		Amortiguador A=new Amortiguador();
		System.out.println("Amortiguador generado con: "+A.NDiscos+" discos");
		for(int i=0;A.Bache();i++) {
			System.out.println("Bache: "+(i+1));
			/*
			System.out.println(A.D1);
			System.out.println(A.D2);
			System.out.println();
			*/
			A.ImprimePila();
		}
	}
}
