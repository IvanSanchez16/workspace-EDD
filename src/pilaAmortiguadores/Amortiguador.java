package pilaAmortiguadores;
import java.util.*;
public class Amortiguador {
	private Pila<Disco> P,PAux;
	public int NDiscos;
	public Disco D1,D2;
	
	public Amortiguador(){
		int R=new Random().nextInt(36)+15;
		P=new Pila<Disco>(R);
		PAux=new Pila<Disco>(R);
		NDiscos=R;
		for(int i=0;P.Inserta(new Disco(i+1,new Random().nextInt(6)+95));i++);
	}
	
	public boolean Bache(){
		if(NDiscos<5)
			return false;
		P.Retira();
		D2=P.Dr;
		while(P.Retira() && PAux.Inserta(P.Dr));
		PAux.Retira();
		D1=PAux.Dr;
		D1.Vida=D1.Vida-(new Random().nextInt(3)+1);
		D2.Vida=D2.Vida-(new Random().nextInt(3)+1);
		for(int i=0;i<(NDiscos/2)-1;i++) {
			PAux.Retira();
			P.Inserta(PAux.Dr);
		}
		if(!D1.Desgastado())
			P.Inserta(D1);
		else
			NDiscos--;
		if(!D2.Desgastado())
			P.Inserta(D2);
		else
			NDiscos--;
		while(PAux.Retira() && P.Inserta(PAux.Dr));
		return true;
	}	

	public void ImprimePila(){
		while(P.Retira() && PAux.Inserta(P.Dr))
			System.out.println(P.Dr);	
		while(PAux.Retira() && P.Inserta(PAux.Dr));
		System.out.println();
	}

}
