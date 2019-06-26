package listas;

public class ListaCircular <T>{
	private Nodo<T> Frente,
					Fin;
	public T Dr;
	
	public ListaCircular(){
		Frente=
		Fin=null;
		Dr=null;
	}
	public boolean InsertaFrente(T dato){
		Nodo<T> nuevo;
		if(dato==null)
			return false;
		try{
			nuevo = new Nodo<T>(dato);
		}catch(Exception e){
			return false;
		}
		if(Frente==null){
			Frente=Fin=nuevo;
			nuevo.setSig(nuevo);
		}else{
			nuevo.setSig(Frente);
			Frente=nuevo;
			Fin.setSig(Frente);
		}
		return true;
	}
	
	public boolean InsertaOrdenado(T dato){
		Nodo<T> nuevo;
		if(dato==null)
			return false;
		try{
			nuevo = new Nodo<T>(dato);
		}catch(Exception e){
			return false;
		}
		if(Frente==null){
			Frente=Fin=nuevo;
			nuevo.setSig(nuevo);
			return true;
		}
		Nodo<T> Aux=Frente,Ant=null;
		while(Aux!=null && Aux.Info.toString().compareTo(dato.toString())<=0){
			Ant=Aux;
			if(Aux.getSig()==Frente){
				Aux=null;
				break;
			}
			Aux=Aux.getSig();
		}
		if(Ant==null){
			nuevo.setSig(Frente);
			Frente=nuevo;
			Fin.setSig(nuevo);
			return true;
		}
		if(Aux==null){
			Ant.setSig(nuevo);
			Fin=nuevo;
			Fin.setSig(Frente);
			return true;
		}
		nuevo.setSig(Ant.getSig());
		Ant.setSig(nuevo);
		return true;
	}
	
	public boolean Retira(int posicion){
		if(posicion>Length())
			return false;
		Nodo<T> Aux=Frente,Ant=null;
		for(int i=1 ; i<posicion ; i++)
			Ant=Aux;
			Aux=Aux.getSig();
		EliminaNodo(Aux,Ant);
		return true;
	}
	
	private void EliminaNodo(Nodo<T> Dato,Nodo<T> Ant){
		Dr=Dato.Info;
		if(Frente==Fin){
			Frente=Fin=null;
			return;
		}
		if(Dato==Frente){
			Fin.setSig(Frente.getSig());
			Frente=Dato.getSig();
			return;
		}
		if(Dato==Fin){
			Ant.setSig(Frente);
			Fin=Ant;
			return;
		}
		Ant.setSig(Dato.getSig());
	}
	
	public boolean Retira(T dato){
		String IdNodo=dato.toString();
		Nodo<T> Aux=Frente,Ant=null;
		boolean band=false;
		do{
			String IdNodoActual=Aux.Info.toString();
			if(IdNodo.compareToIgnoreCase(IdNodoActual)==0){
				band=true;
				break;
			}
			Ant=Aux;
			Aux=Aux.getSig();
		}while(Aux!=Frente);
		if(!band)
			return false;
		EliminaNodo(Aux,Ant);
		return true;
	}
	
	public int Length(){
		int c=0;
		Nodo<T> Aux=Frente;
		while(Aux!=null){
			c++;
			if(Aux.getSig()==Frente)
				break;
			Aux=Aux.getSig();
		}
		return c;
	}
	public boolean InsertaFin(T dato){
		Nodo<T> nuevo;
		if(dato==null)
			return false;
		try{
			nuevo = new Nodo<T>(dato);
		}catch(Exception e){
			return false;
		}
		if(Frente==null){
			Frente=Fin=null;
			nuevo.setSig(nuevo);
		}else{
			Fin.setSig(nuevo);
			Fin=nuevo;
			Fin.setSig(Frente);
		}
		return true;
	}
	
	public Nodo<T> getFrente(){
		return Frente;
	}
	
	public Nodo<T> getFin(){
		return Fin;
	}
}