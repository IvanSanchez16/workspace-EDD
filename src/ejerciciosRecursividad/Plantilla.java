package ejerciciosRecursividad;

public class Plantilla {
	/**
	 * Calcula el mayor común denominador de 2 números
	 * @param a = Número entero 
	 * @param b = Número entero
	 * @return El MCD de dichos números
	 */
	public static int MCD(int a,int b){
		return MCD(a,b,a<b?a:b);
	}
	public static int MCD(int a,int b,int c){
		if(a%c==0 && b%c==0)
			return c;
		return MCD(a,b,c-1);
	}
	
	public static int MayorV(int V[],int Sub){
		if(Sub==V.length-1)
			return V[Sub];
		int M=MayorV(V,Sub+1);
		if(V[Sub]>M)	
			return V[Sub];
		return M;
	}
	
	public static String Transformar(String N, int base) {
		 String N1=String.valueOf(N.charAt(0));
		 switch (N1) {
		 	case "A":
		 		N1="10";
		 		break;
		 	case "B":
		 		N1="11";
		 		break;
		 	case "C":
		 		N1="12";
		 		break;
		 	case "D":
		 		N1="13";
		 		break;
		 	case "E":
		 		N1="14";
		 		break;
		 	case "F":
		 		N1="15";
		 		break;
 		 }
		 if(N.length()==1)
			 return N1;
		 return String.valueOf((int)Math.pow(base,N.length()-1)*Integer.parseInt(N1) + Integer.parseInt(Transformar(N.substring(1),base)));
	}
}
