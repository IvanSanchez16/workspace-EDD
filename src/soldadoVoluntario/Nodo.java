package soldadoVoluntario;

public class Nodo<T> {
	public T Info;
	private Nodo<T> Sig;
	
	public Nodo(T d){
		Info=d;
		Sig=null;
	}
	
	public Nodo<T> getSig(){
		return Sig;
	}
	
	public void setSig(Nodo<T> Ap){
		Sig=Ap;
	}
}
