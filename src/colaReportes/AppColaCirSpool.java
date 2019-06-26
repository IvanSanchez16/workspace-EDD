package colaReportes;

/* 
 *Iván Humberto Sánchez Aispuro
 *Estructura de Datos 
 */
public class AppColaCirSpool {
	//private int Ele;
	class Reporte {
		public int NoComp,
				   TotalPag,
				   Pag;
		
		public Reporte(int nocomp,int totalpag,int pag) {
			NoComp=nocomp;
			TotalPag=totalpag;
			Pag=pag;
		}
		
		public String toString() {
			return NoComp+"\t"+TotalPag+"\t"+Pag;
		}
	}
	
	public AppColaCirSpool() {
		//Ele=50;
		ColaCircular<Reporte> C=new ColaCircular<Reporte>(50);
		ColaCircular<Reporte> C2=new ColaCircular<Reporte>(50);
		ColaCircular<Reporte> CA=new ColaCircular<Reporte>(50);
		int NA=Rutinas.nextInt(10,20);
		int Accion,Total;
		for(int i=0;i<NA;i++) {
			Accion=Rutinas.nextInt(3)+1;
			System.out.println("\nAcción: "+Accion);
			switch(Accion) {
				case 1: //Inserta
					int PaginasT=Rutinas.nextInt(1,150);
					boolean band=true;
					Reporte Rep;
					int Comp=Rutinas.nextInt(1,5);
					for(int j=0;j<PaginasT/50;j++) {
						Rep=new Reporte(Comp,PaginasT,50);
						if(!C2.Inserta(Rep)) 
							band=false;
					}
					if(PaginasT % 50 > 0) {
						Rep=new Reporte(Comp,PaginasT,PaginasT%50);
						if(!C2.Inserta(Rep))
							band=false;
					}
					if(!band) {
						System.out.println("Insersión fallida : Espacio insuficiente");
						i--;
						while(C.Retira() && CA.Inserta(C.Dr));
						while(CA.Retira() && C.Inserta(CA.Dr) && C2.Inserta(CA.Dr));
						continue;
					}
					while(C2.Retira() && CA.Inserta(C2.Dr));
					while(CA.Retira() && C.Inserta(CA.Dr) && C2.Inserta(CA.Dr));
					System.out.println("Reporte insertado");
					break;
				case 2: //Elemento
					if(C.Vacia()) {
						i--;
						continue;
					}
				    Total=0;
					while(C.Retira() || C2.Retira()) {//Utilice un || porque si utilizaba el && cuando quedara la cola vacia, no retiraria el ultimo en c2
						Total+=C.Dr.Pag;
						if(Total==C.Dr.TotalPag) {
							System.out.println(C.Dr);
							break;
						}
					}	
					break;
				case 3: //Estado actual
					System.out.println("Estado Actual");
					Total=0;
					while(!C.Vacia()) {
						Total=0;
						while(C.Retira()) {
							CA.Inserta(C.Dr);
							Total+=C.Dr.Pag;
							if(Total==C.Dr.TotalPag) {
								System.out.println(C.Dr);
								break;
							}
						}
					}
					while(CA.Retira() && C.Inserta(CA.Dr));
					i--;
					break;
					
			}
		}
	}

	public static void main(String[] args) {
		new AppColaCirSpool();
	}

}
