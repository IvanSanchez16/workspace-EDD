package pilas;

import java.util.Scanner;

public class AppExpresionPosfija {
	
	private Pila<Float> P,D;
	private String Expresion;
	
	private AppExpresionPosfija(){
		P=new Pila<Float>(20);
		D=new Pila<Float>(20);
		Captura();
		Procesa();
	}

	private void Captura(){
		System.out.println("Ingrese una expresión aritmética");
		Expresion=new Scanner(System.in).nextLine();
	}
	
	private void Procesa(){
		char c;
		for(int i=0;i<Expresion.length();i++){
			c=Expresion.charAt(i);
			if(c>='0' && c<='9'){
				if(!P.Inserta((c-48f))){
					System.out.println("Error en la evaluación: Pila llena");
					return;
				}
			}
			if(c=='+' || c=='-' || c=='*' || c=='/'){
				if(!P.Retira()){
					System.out.println("Error en la evaluación: Pila vacia");
					return;
				}
				float D2=P.Dr;
				if(!P.Retira()){
					System.out.println("Error en la evaluación: Pila con elementos insuficientes");
					return;
				}
				float D1=P.Dr;	
				float Res=0;
				switch(c){
					case '+': Res=D1+D2;break;
					case '-': Res=D1-D2;break;
					case '*': Res=D1*D2;break;
					case '/': Res=D1/D2;break;
				}
				P.Inserta(Res);
			}
		}
		P.Retira();
		if(!P.Vacia()){
			System.out.println("Error en la evaluación: Expresión incorrecta");
			return;
		}
		System.out.println("Resultado = "+P.Dr);
	}
	
	public static void main(String[] args) {
		new AppExpresionPosfija();

	}

}
