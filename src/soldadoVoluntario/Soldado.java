package soldadoVoluntario;

public class Soldado {
	private int NoSoldado,
				Edad;
	
	public Soldado(int ns,int e){
		NoSoldado=ns;
		Edad=e;
	}
	
	public String toString(){
		return Rutinas.PonCeros(NoSoldado,10)+Rutinas.PonCeros(Edad,4);
	}
	
	public int getNoSoldado(){
		return NoSoldado;
	}
	
}
