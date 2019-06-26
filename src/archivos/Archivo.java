package archivos;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import examen.Rutinas;

/*
 * 
 * Iván Humberto Sánchez Aispuro
 * Estructura de datos
 * 12-1pm
 * 
 */

class Alumno {
	String Nombre;
	int Edad;
	char Genero;
	static final int LARGO=58;

	public Alumno(String nombre, int edad, char genero) {
		Nombre = nombre;
		Edad = edad;
		Genero = genero;
	}
	
	public String toString() {
		return Rutinas.PonBlancos(Nombre,50);
	}
}
class Llaves {
	int NoControl;
	int Apuntador;
	static final int LARGO=8;

	public Llaves(int nc,int a) {
		NoControl=nc;
		Apuntador=a;
	}
}


public class Archivo {
	static RandomAccessFile archivo,archivo2;
	static Scanner S=new Scanner(System.in);
	
	public int MostrarMenu() {
		System.out.println();
		System.out.println(" * * * M E N U * * *");
		System.out.println("0-. Ingresar N registros aleatorios");
		System.out.println("1-. Ingresar un registro");
		System.out.println("2-. Consultar un registro");
		System.out.println("3-. Mostrar Todos los registros");
		System.out.println("4-. Ordenar el archivo (Intercambio)");
		System.out.println("5-. Ordenar el archivo (Quicksort)");
		System.out.println("6-. Salir");
		return S.nextInt();
	}
	
	public Archivo() {
		try {
			archivo=new RandomAccessFile("Llaves.dat","rw");
			archivo2=new RandomAccessFile("Alumnos.dat","rw");
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		boolean band=true;
		while(band) {
			switch( MostrarMenu() ) {
				case 0:
					try {
						System.out.print("Cuantos elementos desea ingresar: ");
						IngresarAleatorios( S.nextInt() );
					}catch(IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 1:
					try {
						IngresarRegistro();
					}catch(IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					ConsultarRegistro();
					break;
				case 3: 
					try {
						MostrarRegistros();
					}catch(IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					try { 
						OrdenarArchivoIntercambio();
						System.out.println("Ordenamiento terminado");
					}catch(IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					try { 
						OrdenarArchivoQuickSort();
						System.out.println("Ordenamiento terminado");
					}catch(IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					band=false;
					break;
			}
		}
		try {
			archivo.close();
			archivo2.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String a[]) {
		new Archivo();
	}
	
	public void IngresarAleatorios(int n) throws IOException{
		for(int i=0 ; i<n ; i++) {
			int nc=Rutinas.nextInt(10000000,19999999);
			Alumno Aux=BuscarRegistro(nc);
			if(Aux!=null) {
				i--;
				continue;
			}
			int gaux = Rutinas.nextInt(1,2);
			String no=Rutinas.nextNombre(1,gaux);
			int e=Rutinas.nextInt(17,25);
			char g=gaux==1?'H':'M';
			
			RegistrarLlave(new Llaves(nc, NumeroRegistrosAlumnos() ));
			RegistrarAlumno(new Alumno(no,e,g));
		}
	}
	
	public void IngresarRegistro() throws IOException {
		System.out.print("Ingrese Número de control: ");
		int nc=S.nextInt();
		Alumno Aux=BuscarRegistro(nc);
		if(Aux!=null){
			System.out.println("Número de control ya registrado");
			return;
		}
			
		System.out.print("Ingrese Nombre: ");
		S.nextLine();
		String n=S.nextLine();
		System.out.print("Ingrese Edad: ");
		int e=S.nextInt();
		System.out.print("Ingrese Género: ");
		char g=S.next().charAt(0);
		RegistrarLlave(new Llaves(nc, NumeroRegistrosAlumnos() ));
		RegistrarAlumno(new Alumno(n,e,g));
	}
	
	public void ConsultarRegistro() {
		Alumno r=null;
		try {
			System.out.print("Ingrese el Número de control: ");
			int nc=S.nextInt();
			r=BuscarRegistro(nc);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		if(r==null) {
			System.out.println("El alumno no fue encontrado");
			return;
		}
		System.out.println("Nombre del alumno: "+r.Nombre);
		System.out.println("Edad del alumno: "+r.Edad);
		System.out.println("Genero del alumno: "+r.Genero);
	}
	
	public void MostrarRegistros() throws IOException{
		archivo.seek(0);
		Alumno a;
		int nc;
		while(true) {
			try {
				nc=archivo.readInt();
				a=BuscarRegistro(nc);
				System.out.print("Número de control: "+ nc +"\t");
				System.out.print("Nombre: "+a.Nombre+"\t");
				System.out.print("Edad: "+a.Edad+"\t");
				System.out.println("Genero: "+a.Genero+"\t");
			}catch(EOFException | NullPointerException e) {
				break;
			}
			
		}
	}
	
	public Alumno BuscarRegistro(int nc) throws IOException {
		int aux;
		archivo.seek(0);
		while(true) {
			try {
				aux=archivo.readInt();
				if(aux==nc)
					break;
				archivo.readInt();
			}catch(EOFException e) {
				return null;
			}
		}
		long largo=archivo.readInt();
		archivo2.seek( largo * Alumno.LARGO );
		String nombre=archivo2.readUTF();
		int edad=archivo2.readInt();
		char genero=archivo2.readChar();
		return new Alumno(nombre,edad,genero);
	}
	
	public void RegistrarLlave(Llaves dato) throws IOException {
		archivo.seek( archivo.length() );
		archivo.writeInt(dato.NoControl);
		archivo.writeInt(dato.Apuntador);
	}
	
	public void RegistrarAlumno(Alumno dato) throws IOException {
		archivo2.seek( archivo2.length() );
		archivo2.writeUTF( Rutinas.PonBlancos(dato.Nombre,50) );
		archivo2.writeInt(dato.Edad);
		archivo2.writeChar(dato.Genero);
	}

	public int NumeroRegistrosLlaves() throws IOException {
		return (int) Math.ceil(archivo.length() / Llaves.LARGO);
	}
	
	public int NumeroRegistrosAlumnos() throws IOException {
		return (int) Math.ceil(archivo2.length() / Alumno.LARGO);
	}
	
	public void OrdenarArchivoIntercambio() throws IOException {
		int n=NumeroRegistrosLlaves();
		for(int i=0;i<n-1 ; i++) 
			for(int j=i; j<n ; j++) {
				if(ObtenerNumeroDeControl(i) > ObtenerNumeroDeControl(j)) {
					Intercambio(i,j);
				}
			}
	}
	
	public Llaves BuscarRegistroLlave(int pos) throws IOException {
		archivo.seek(0);	
		for(int i=0 ; i<pos ; i++) {
			archivo.readInt();
			archivo.readInt();
		}
		int aux=archivo.readInt();
		int ap=archivo.readInt();
		return new Llaves(aux,ap);
	}
	
	public int ObtenerNumeroDeControl(int pos) throws IOException{
		archivo.seek(0);
		int p;
		for(p=0; p < NumeroRegistrosLlaves() ; p++) {
			if(p==pos) 
				break;
			archivo.readInt();
			archivo.readInt();
		}
		return archivo.readInt();
	}
	
	public void Intercambio(int i,int j) throws IOException{
		Llaves l1=BuscarRegistroLlave(i);
		Llaves l2=BuscarRegistroLlave(j);
		
		archivo.seek(i*8);
		archivo.writeInt(l2.NoControl);
		archivo.writeInt(l2.Apuntador);
		
		archivo.seek(j*8);
		archivo.writeInt(l1.NoControl);
		archivo.writeInt(l1.Apuntador);
	}

	public void OrdenarArchivoQuickSort() throws IOException{
		QuickSort(0,NumeroRegistrosLlaves()-1);
	}

	public void QuickSort(int izq, int der) throws IOException{
		Llaves pivote=BuscarRegistroLlave(izq); 
		int i=izq;
		int j=der;
		
		while(i<j){      
			while(ObtenerNumeroDeControl(i) <= pivote.NoControl && i<j) i++; 
			while(ObtenerNumeroDeControl(j) > pivote.NoControl) j--;        
			if (i<j)                               
				Intercambio(i,j);
		}
		
		Intercambio(izq,j);
		
		if(izq<j-1)
			QuickSort(izq,j-1); 
		if(j+1 <der)
			QuickSort(j+1,der); 
	}
}
