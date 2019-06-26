package proyectoRecursividad;

public class Métodos {
	
	public static int SumaRenglon(int M[][],int R,int Sub) {
		if(Sub==M[0].length-1)
			return M[R][Sub];
		return M[R][Sub] + SumaRenglon(M,R,Sub+1);
	}
	
	public static int[] SumasRenglones(int M[][],int R,int A[]) {
		A[R]=SumaRenglon(M,R,0);
		if(R<M.length-1)
			SumasRenglones(M,R+1,A);
		return A;
	}
	
	public static int[][] LlenarMatriz(int M[][],int R){
		if(R==M.length)
			return M;
		else
		for(int c=0;c<M.length;c++) {
			if(R==c) {
				M[R][c]=1;
				continue;
			} if(R+c == M.length-1) {
				M[R][c]=2;
				continue;
			} if(R>c && (R+c)<M.length-1) {
				M[R][c]=3;
				M[c][R]=4;
				continue;
			} if(R<c && (R+c)>M.length-1) {
				M[R][c]=5;
				M[c][R]=6;
				continue;
			}
		}
		return LlenarMatriz(M,R+1);
	}
	
	static String P[]= {"","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez","once","doce","trece","catroce","quince","dieciséis","diecisiete","dieciocho","diecinueve","veinte","veintiuno","veintidós","veintitres","veinticuatro","veinticinco","veintiséis","veintisiete","veintiocho","veintinueve"};
	static String D[]= {"","diez","veinte","treinta","cuarenta","cincuenta","sesenta","setenta","ochenta","noventa"};
	static String C[]= {"","cien","doscientos","trescientos","cuatrocientos","quinientos","seiscientos","setecientos","ochocientos","novecientos"};
	static String S[]= {"mil","millones","billones"};
	public static String Transformar(String N) {
		String f="";
		if(N.length()==0)
			return "";
		if(N.length()%3!=0)
			if(N.length()%3==2)
				N="0"+N;
			else
				N="00"+N;
		String p=N.substring(0,3);
		if(p.compareTo("000")!=0)
				f=C[ Integer.parseInt(String.valueOf(p.charAt(0))) ] 
				+((p.charAt(0)=='1')?(p.charAt(1)!='0' || p.charAt(2)!='0')?"to":"":"") 
				+((p.charAt(0)!='0')?" ":"")
				+((p.charAt(1)=='1' || p.charAt(1)=='2')?P[ Integer.parseInt(p.substring(1)) ]:
				D[ Integer.parseInt(String.valueOf(p.charAt(1))) ] 
				+((p.charAt(1)=='0' || (p.charAt(0)=='0' && p.charAt(1)=='0') || p.charAt(2)=='0')?"":" y ")
			    +P[ Integer.parseInt(String.valueOf(p.charAt(2))) ]);
		
		if(p.charAt(2)=='1' && N.length()>3)
			f=f.substring(0,f.length()-1);
			
		if(p.compareTo("001")==0 && (N.length()==6 || N.length()==12 || N.length()==18))
			f=""; 
		
		switch(N.length()) {
		case 6:
			f+=" "+S[0]+" ";
			break;
		case 9:
			f+=" "+S[1]+" ";
			break;
		case 12:
			f+=" "+S[0]+" ";
			break;
		case 15:
			f+=" "+S[2]+" ";
			break;
		case 18:
			f+=" "+S[0]+" ";
			break;
		}
		return f + Transformar(N.substring(3));
	}
	

}
