package zzGeneradordeEncuentros;

import java.util.Random;
import java.util.Scanner;

public class AppGeneradorDeEncuentros {
	Scanner S= new Scanner(System.in);
	Random R= new Random();
	Equipo Ae[];
	Actividad Aa[];
	Encuentro E[][];
	public AppGeneradorDeEncuentros() {
		Inicio();
ciclo1:	while(true) {
		for(int i=0;i<E.length;i++)
			for(int j=0;j<E[0].length;j++)
				if(!GenerarEncuentro(i,j))
					continue ciclo1;
		MostrarMatriz();
		break;
		}
	}
	
	public void Inicio() {
		int Ne,Na,Nh;
		System.out.println("Ingrese número de equipos");
		Ne=S.nextInt();
		System.out.println("Ingrese número de actividades");
		Na=S.nextInt();
		System.out.println("Ingrese número de horas");
		Nh=S.nextInt();
		Ae=new Equipo[Ne];
		Aa=new Actividad[Na];
		
		for(int i=0;i<Ne;i++)
			Ae[i]=new Equipo(i+1);
		
		for(int i=0;i<Na;i++) {
			System.out.println("Ingrese el nombre de la actividad");
			Aa[i]=new Actividad(i+1,S.next());
		}
		E=new Encuentro[Nh][Ne/2];
	}
	
	public boolean GenerarEncuentro(int f,int c) {
		int e1,e2,a,i=0;
		while(i<3000) {
		e1=R.nextInt(Ae.length)+1;
		e2=R.nextInt(Ae.length)+1;
		a=R.nextInt(Aa.length)+1;
		if(e1==e2) {
			i++;
			continue;
		}
		if(Ae[e1-1].ExisteEquipo(Ae[e2-1]) || Ae[e2-1].ExisteEquipo(Ae[e1-1])) {
			i++;
			continue;
		}
		if(Ae[e1-1].ExisteActividad(Aa[a-1]) || Ae[e2-1].ExisteActividad(Aa[a-1])) {
			i++;
			continue;
		}
		if(Ae[e1-1].ExisteHora(f) || Ae[e2-1].ExisteHora(f)) {
			i++;
			continue;
		}
		Encuentro e=new Encuentro(Ae[e1-1],Ae[e2-1],Aa[a-1]);
		Ae[e1-1].IngresarEquipo(Ae[e2-1]);
		Ae[e2-1].IngresarEquipo(Ae[e1-1]);
		Ae[e1-1].IngresarActividad(Aa[a-1]);
		Ae[e2-1].IngresarActividad(Aa[a-1]);
		Ae[e1-1].AgregarHora(f);
		Ae[e2-1].AgregarHora(f);
		E[f][c]=e;
		return true;
		}
		return false;
		
	}
	
	public void MostrarMatriz() {
		for(int i=0;i<E.length;i++) {
			System.out.println("Hora: "+(i+1));
			for(int j=0;j<E[0].length;j++)
				System.out.print(E[i][j]+"\t");
		System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new AppGeneradorDeEncuentros();
	}

}
