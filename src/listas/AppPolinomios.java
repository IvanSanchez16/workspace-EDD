package listas;

import java.util.Scanner;

import colas.Rutinas;

class Monomio{
	public int coheficiente;
	public int exponente;
	
	public Monomio(int c,int e){
		coheficiente=c;
		exponente=e;
	}
	
	public String toString(){
		return Rutinas.PonCeros(exponente,2)+Rutinas.PonCeros(coheficiente, 4);
	}
	
	public String toStringDe2peso(){
		return coheficiente+"x^"+exponente;
	}
}
public class AppPolinomios {
	
	public AppPolinomios(){
		Lista<Monomio> Pol1=new Lista<Monomio>();
		Lista<Monomio> Pol2=new Lista<Monomio>();
		Lista<Monomio> Pol3=new Lista<Monomio>();
		System.out.println("Primer Polinomio: ");
		CrearPolinomio(Pol1);
		System.out.println("\nSegundo Polinomio: ");
		CrearPolinomio(Pol2);
		
		MostrarPolinomio(Pol1);
		MostrarPolinomio(Pol2);
		
		SumarPolinomios(Pol1,Pol2,Pol3);
		MostrarPolinomio(Pol3);
	}
	
	public void CrearPolinomio(Lista<Monomio> P){
		Scanner S=new Scanner(System.in);
		int cohe,expo;
		while(true){
			System.out.print("\nIngrese la base(0 termina el polinomio): ");
			cohe=S.nextInt();
			if(cohe==0)
				break;
			System.out.print("Ingrese el exponente: ");
			expo=S.nextInt();
			Nodo<Monomio> Aux=P.getFrente();
			while(Aux!=null){
				if(Aux.Info.exponente==expo){
					Aux.Info.coheficiente+=cohe;
					break;
				}
				Aux=Aux.getSig();
			}
			if(Aux==null)
				P.InsertaOrdenado(new Monomio(cohe,expo));
		}
	}
	
	public void SumarPolinomios(Lista<Monomio> P1,Lista<Monomio> P2,Lista<Monomio> R){
		Nodo<Monomio> Aux=P1.getFrente(),Aux2;
		while(Aux!=null){
			R.InsertaOrdenado(Aux.Info);
			Aux=Aux.getSig();
		}
		Aux=P2.getFrente();
		while(Aux!=null){
			Aux2=R.getFrente();
			while(Aux2!=null){
				if(Aux.Info.exponente==Aux2.Info.exponente){
					Aux2.Info.coheficiente+=Aux.Info.coheficiente;
					break;
				}
				Aux2=Aux2.getSig();
			}
			if(Aux2==null)
				R.InsertaOrdenado(Aux.Info);
			Aux=Aux.getSig();
		}
	}
	
	public void MostrarPolinomio(Lista<Monomio> P){
		Nodo<Monomio> Aux=P.getFrente();
		while(Aux!=null){
			if(Aux!=P.getFrente() && Aux.Info.coheficiente>0)
				System.out.print("+ ");
			System.out.print(Aux.Info.toStringDe2peso()+" ");
			Aux=Aux.getSig();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new AppPolinomios();
	}

}
