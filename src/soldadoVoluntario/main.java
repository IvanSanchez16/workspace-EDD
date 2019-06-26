package soldadoVoluntario;

public class main {

	public main(){
		ListaCircular<Soldado> L=new ListaCircular<Soldado>();
		int N=Rutinas.nextInt(20,50);
		int cont=1;
		LlenarLista(L,N);
		Nodo<Soldado> Aux=L.getFrente();
		MostrarLista(L);
		while(L.Length()>1){
			int NAleatorio=Rutinas.nextInt(1,50);
			int i=0;
			if(cont==1)
				i++;
			for(;i<NAleatorio;i++)
				Aux=Aux.getSig();
			L.Retira(Aux.Info);
			System.out.println("#"+cont++);
			System.out.println("Número generado aleatoriamente "+NAleatorio);
			System.out.println("Se salvo el soldado "+Aux.Info.getNoSoldado());
			MostrarLista(L);
		}
		System.out.println("El soldado "+L.getFrente().Info.getNoSoldado()+" se la pelo");
	}
	public void MostrarLista(ListaCircular<Soldado> L){
		Nodo<Soldado> Aux=L.getFrente();
		int n=1;
		do{
			System.out.println((n++)+"-"+Aux.Info.getNoSoldado());
			Aux=Aux.getSig();
		}while(Aux!=L.getFrente());
	}
	public void LlenarLista(ListaCircular<Soldado> L,int n){
		int ns,e;
		for(int i=0;i<n;i++){
			ns=Rutinas.nextInt(1,10000);
			if(Buscar(L,ns)){
				i--;
				continue;
			}
			e=Rutinas.nextInt(18,35);
			L.InsertaOrdenado(new Soldado(ns,e));
		}
	}
	public boolean Buscar(ListaCircular<Soldado> L,int ns){
		if(L.getFrente()==null)
			return false;
		Nodo<Soldado> Aux=L.getFrente();
		boolean band=false;
		do{
			if(Aux.Info.getNoSoldado()==ns){
				band=true;
				break;
			}
		Aux=Aux.getSig();	
		}while(Aux!=L.getFrente());
		return band;
	}
	public static void main(String[] args) {
		new main();
	}

}
