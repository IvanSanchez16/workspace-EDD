package listas;

public class ListaCircularDBL<T> {
	private NodoDBL<T> Frente,
					   Fin;
	public T Dr;
	
	public ListaCircularDBL() {
		Frente=Fin=null;
		Dr=null;
	}
	
	public boolean InsertaFrente(T dato){
		if(dato==null)
			return false;
		NodoDBL<T> nuevo;
		try{
			nuevo = new NodoDBL<T>(dato);
		}catch(Exception e){
			return false;
		}
		if(Frente==null){
			Frente=Fin=nuevo;
			Frente.setAnt(Fin);
			Fin.setSig(Frente);
			return true;
		}
		nuevo.setSig(Frente);
		Frente.setAnt(nuevo);
		Frente=nuevo;
		Frente.setAnt(Fin);
		Fin.setSig(Frente);
		return true;
	}
	
	public boolean InsertaFin(T dato){
		if(dato==null)
			return false;
		NodoDBL<T> nuevo;
		try{
			nuevo = new NodoDBL<T>(dato);
		}catch(Exception e){
			return false;
		}
		if(Frente==null){
			Frente=Fin=nuevo;
			return true;
		}
		Fin.setSig(nuevo);
		nuevo.setAnt(Fin);
		Fin=nuevo;
		return true;
	}
	
	public boolean Retira(int pos){
		if(pos>Length() || pos<-1)
			return false;
		NodoDBL<T> Aux=Frente;
		for(byte i=1;i<pos;Aux=Aux.getSig(),i++);
		EliminaNodo(Aux);
		return true;
	}
	
	private void EliminaNodo(NodoDBL<T> Aux){
		Dr=Aux.Info;
		if(Frente==Fin){
			Fin=Frente=null;
			return;
		}
		if(Aux==Frente){
			Fin.setSig(Aux.getSig());
			Frente=Aux.getSig();
			Frente.setAnt(Fin);
			return;
		}
		if(Aux==Fin){
			Fin=Aux.getAnt();
			Fin.setSig(Frente);
			Fin.setSig(Frente);
			return;
		}
		Aux.getAnt().setSig(Aux.getSig());
		Aux.getSig().setAnt(Aux.getAnt());
	}
	
	public int Length(){
		int c=0;
		NodoDBL<T> Aux=Frente;
		while(Aux!=null){
			c++;
			if(Aux.getSig()==Frente)
				break;
			Aux=Aux.getSig();
		}
		return c;
	}
}
