package pilas;

import java.util.Scanner;

public class AppInfijaPosfija {
	
	public AppInfijaPosfija() {
		String EI,EP="";
		Pila<Character> P=new Pila<Character>(10);
		EI=new Scanner(System.in).nextLine();
		while(EI.length()!=0){
			char c=EI.charAt(0); EI=EI.substring(1);
			if(c==' ') {
				EP+=" ";
				continue;
			}
			if(c=='(') {
				P.Inserta(c);
				continue;
			}
			if(c==')')
				while(true) {
					P.Retira();
					if(P.Dr!='(')
						EP+=P.Dr+" ";
					else
						break;
				}
			else
				if(c>47 && c<58) //c está entre 0-9
					while(c!=' ') {
						EP+=c;
						if(EI.length()==0) 
							EI=" ";
						c=EI.charAt(0); 
						EI=EI.substring(1);							
					}	
			else {
				while(P.Retira()) {
					if((P.Dr=='-' || P.Dr=='+') && (c=='*' || c=='/')) {
						P.Inserta(P.Dr);
						break;
					}
					if(P.Dr=='(') {
						P.Inserta(P.Dr);
						break;
					}
					EP+=P.Dr+" ";
					
				}
				P.Inserta(c);
			}
		}
		EP+=" ";
		while(P.Retira())
			EP+=P.Dr+" ";
		System.out.println(EP);
	}

	public static void main(String[] args) {
		new AppInfijaPosfija();
	}

}
