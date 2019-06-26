package pilaAmortiguadores;

public class Disco {
	private int N;
	float VidaU;
	public int Vida;

	public Disco(int n,int vidai){
		N=n;
		Vida=vidai;
		VidaU=Vida*0.3f;	
	}
	
	public boolean Desgastado(){
		return Vida<VidaU;
	}
	
	public String toString(){
		return "Disco "+N+":\n- Vida útil actual: "+Vida;
	}
}