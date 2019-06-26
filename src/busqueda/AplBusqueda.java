package busqueda;
import java.util.*;
import examen.Rutinas;

public class AplBusqueda {
	Busqueda2 <Integer> Obj=new Busqueda2<Integer>();
	public AplBusqueda(){
		Integer []V=new Integer[1000];
		for(int i=0;i<V.length;i++)
			V[i]= new Integer(Rutinas.nextInt(1,1000));
		while(true){
			Imprime(V);
			System.out.println("Dato a buscar");
			int E=new Scanner(System.in).nextInt();
			if(E==0)
				break;
			System.out.println("Binaria: "+Obj.binaria(V,E));
			System.out.println("Secuencial: "+Obj.Secuencial(V, E));
		}
	}

	
	
	public void Imprime(Integer [] V){
		for(int i=0;i<V.length;i++)
			System.out.println(V[i]);
		
	}
	
	public static void main(String[] args) {
		new AplBusqueda();
		
	}

}
