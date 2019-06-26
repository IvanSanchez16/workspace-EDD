package pilas;

import listas.Nodo;

public class PilaDinamica<T> {
	private Nodo<T> Tope;
	public T Dr;
	
	public PilaDinamica(){
		Tope=null;
	}
	
	public boolean Inserta(T dato){
		if(dato==null)
			return false;
		Nodo<T> nuevo;
		try{
			nuevo = new Nodo<T>(dato);
		}catch(Exception e){
			return false;
		}
		nuevo.setSig(Tope);
		Tope=nuevo;
		return true;
	}
	
	public boolean Retira(){
		if(Tope==null)
			return false;
		Dr=Tope.Info;
		Tope=Tope.getSig();
		return true;
	}
	
	public boolean Vacia(){
		return Tope==null;
	}
}
