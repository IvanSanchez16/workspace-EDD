package colas;

public class ColaCircular <T> {
	private int Max,
				Frente,
				Fin;
	private T [] C;
	public T Dr;
	
	public ColaCircular() {
		this(10);
	}
	
	public ColaCircular(int Tamaño) {
		Max=Tamaño;
		Frente=
		Fin=-1;
		C= (T[]) new Object[Tamaño];
	}
	
	public boolean Inserta(T Dato) {
		if(Llena()) 
			return false;
		if(Fin==Max-1)
			Fin=0;
		else
			Fin++;
		C[Fin]=Dato;
		if(Frente==-1)
			Frente=0;
		return true;
	}
	
	public boolean Retira() {
		if(Vacia())
			return false;
		Dr=C[Frente];
		C[Frente]=null;
		if(Frente==Fin)
			Frente=Fin=-1;
		else
			if(Frente==Max-1)
				Frente=0;
			else
				Frente++;
		return true;
	}
	
	public boolean Vacia() {
		return Frente==-1;
	}
	
	public boolean Llena() {
		return (Frente==0 && Fin==Max-1) || Fin+1==Frente;
	}
}
