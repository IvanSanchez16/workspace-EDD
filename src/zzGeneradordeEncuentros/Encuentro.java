package zzGeneradordeEncuentros;

public class Encuentro {
	private Equipo E1,E2;
	private Actividad A;
	
	public Encuentro(Equipo e1,Equipo e2,Actividad a) {
		E1=e1;
		E2=e2;
		A=a;
	}
	
	public String toString() {
		return A+"\t"+E1+" v "+E2+"\n";
	}
}
