package pilas;
import java.util.*;
public class AppPila {

	public static void main(String[] tony) {
		Scanner S=new Scanner(System.in);
		Pila<Integer> P=new Pila<Integer>(20);
		Pila<Integer> P2=new Pila<Integer>(20);
		Random R=new Random();
		
		while(P.Inserta(R.nextInt(20)));
		
		while(P.Retira() && P2.Inserta(P.Dr))
			System.out.println(P.Dr);
		while(P2.Retira() && P.Inserta(P2.Dr));

	}

}
