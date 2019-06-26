package listas;

import listas.Nodo;

public class Lista <T>{
	private Nodo<T> Frente,
					Fin;
	public T Dr;
	
	public Lista(){
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
		if(Frente==null)
			Frente=Fin=nuevo;
		else{
			nuevo.setSig(Frente);
			Frente=nuevo;
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
			return true;
		}
		Nodo<T> Aux=Frente,Ant=null;
		while(Aux!=null && Aux.Info.toString().compareTo(dato.toString())<=0){
			Ant=Aux;
			Aux=Aux.getSig();
		}
		if(Ant==null){
			nuevo.setSig(Frente);
			Frente=nuevo;
			return true;
		}
		if(Aux==null){
			Ant.setSig(nuevo);
			Fin=nuevo;
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
			Frente=Dato.getSig();
			return;
		}
		if(Dato==Fin){
			Ant.setSig(null);
			Fin=Ant;
			return;
		}
		Ant.setSig(Dato.getSig());
	}
	
	public boolean Retira(T dato){
		String IdNodo=dato.toString();
		Nodo<T> Aux=Frente,Ant=null;
		while(Aux!=null){
			String IdNodoActual=Aux.Info.toString();
			if(IdNodo.compareToIgnoreCase(IdNodoActual)==0)
				break;
			Ant=Aux;
			Aux=Aux.getSig();
		}
		if(Aux==null)
			return false;
		EliminaNodo(Aux,Ant);
		return true;
	}
	
	public int Length(){
		int c=0;
		Nodo<T> Aux=Frente;
		while(Aux!=null){
			c++;
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
		if(Frente==null)
			Frente=Fin=null;
		else{
			Fin.setSig(nuevo);
			Fin=nuevo;
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
