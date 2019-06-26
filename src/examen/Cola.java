package examen;

public class Cola <T>{
	private int Max,Frente,Fin;
	private T[] C;
	public T Dr;
	
	public Cola() {
		this(10);
	}
	public Cola(int max) {
		Max=max;
		Frente=Fin=-1;
		C=(T[]) new Object[Max];
	}
	
	public boolean Inserta(T Dato) {
		if(Llena())
			return false;
		C[++Fin]=Dato;
		if(Frente==-1)
			Frente++;
		return true;
	}
	
	public boolean Retira() {
		if(Vacia())
			return false;
		Dr=C[Frente];
		if(Frente==Fin)
			Frente=Fin=-1;
		else
			Frente++;
		return true;
	}
	
	public boolean Llena() {
		return Fin==Max-1;
	}
	
	public boolean Vacia() {
		return Fin==-1;
	}
}
