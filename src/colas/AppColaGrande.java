package colas;
import java.util.*;

import colaReportes.ColaCircular;
public class AppColaGrande {
	Scanner S;
	Random R;
	ColaCircular<Integer> CPor;
	public AppColaGrande() {
		S=new Scanner(System.in);
		R=new Random();
		CPor = new ColaCircular<Integer>(20);
		Genera();
		Trabaja();
	}
	
	private void Genera() {
		while(CPor.Inserta(R.nextInt(20)+1));
	}
	
	private void Trabaja() {
		float Cantidad;
		int Nd;
		while(true) {
			System.out.println("Cantidad: (0 fin de captura)");
			Cantidad=S.nextFloat();
			if(Cantidad==0)
				return;
			Nd=R.nextInt(4)+2;
			for(int i=0 ; i<Nd ; i++) {
				CPor.Retira();
				float Por=CPor.Dr/100f;
				System.out.println((i+1)+"\t"+Por+"\t"+Cantidad+"\t"+(Por*Cantidad)+"\t"+(Cantidad-(Por*Cantidad)));
				Cantidad-=Por*Cantidad;
				CPor.Inserta(CPor.Dr);

			}
		}
	}
	public static void main(String[] a) {
		new AppColaGrande();
	}
}
