package proyectoArboles;

import colas.Rutinas;

import java.text.DecimalFormat;
import java.util.*;
import arboles.ArbolBinarioBusqueda;
import arboles.NodoABB;

/*
 * 
 * Iván Humberto Sánchez Aispuro
 * Estructura de datos
 * 12-1pm
 * 
 */
class Producto {
	public int IdProducto; // valores de 100-5000
	public int Existencia;

	public Producto(int id) {
		IdProducto=id;
		Existencia=0;
	}

	public Producto(int id,int e) {
		IdProducto=id;
		Existencia=e;
	}

	public String toString () {
		return Rutinas.PonCeros(IdProducto,5);
	}   
}

public class AppProyectoArboles {

	ArbolBinarioBusqueda<Producto> A = new ArbolBinarioBusqueda<Producto>();
	Scanner S=new Scanner(System.in);

	public AppProyectoArboles() {
		boolean menu=true;
		while(menu) {
			switch( Menu() ) {
				case 1:
					if(InsertarProducto())
						System.out.println("Inserción realizada correctamente");
					else
						System.out.println("Error en el registro");
					break;
				case 2:
					if(RetirarProducto())
						System.out.println("Elemento retirado correctamente");
					else
						System.out.println("Error en el retiro");
					break;
				case 3:
					AumentarExistencia();
					break;
				case 4:
					AumenExistenciaMayorAX();
					break;
				case 5:
					RetirarExistencia();
					break;
				case 6:
					int n=RetirarExistencia100(A.getRaiz());
					System.out.println("Se retiraron: "+n+" nodos");
					break;
				case 7:
					PorcentajeProductos();
					break;
				case 8:
					System.out.println("Id\tExistencia");
					EstadoActualDescendente(A.getRaiz());
					break;
				case 9:
					ConsultaNodo();
					break;
				case 10:
					Niveles();
					break;
				case 11:
					menu=false;
					break;
			}
			System.out.println();  
		}
		System.out.println("Fin del programa");

	}
	
	public void Niveles() { //Punto 10
		if(A.getRaiz()==null) {
			System.out.println("El árbol está vacio");
			return;
		}
		System.out.println("Nivel 1 - Hijos: 1");
		Niveles(1,2);
	}
	
	private void Niveles(int nNodosAnt,int nivel) { //Punto 10.1
		if(nivel>A.Altura())
			return;
		int Nnodos = NumeroNodosNivel(nivel);
		System.out.println("Nivel "+nivel+" - Hijos: "+Nnodos);
		if(Nnodos < nNodosAnt) 
			System.out.println("En el nivel "+nivel+" existen menos nodos que en el nivel "+(nivel-1));
		Niveles(Nnodos,nivel+1);
	}
	
	private int NumeroNodosNivel(int n) { //Punto 10.2 
		if(A.Altura()<n)
			return 0;
		return NumeroNodosNivel(A.getRaiz(),n,1); 
	}
	
	private int NumeroNodosNivel(NodoABB<Producto> R,int n,int na) { //Punto 10.21 n es el nivel que calculamos y na es el actual
		if(R==null)
			return 0;
		int aux=0;
		aux+=NumeroNodosNivel(R.getSubIzq(),n,na+1);
		if(n==na)
			aux++;
		aux+=NumeroNodosNivel(R.getSubDer(),n,na+1);
		return aux;
	}
	
	public void ConsultaNodo() { //Punto 9
		Producto con;
		boolean band;
		do {
			System.out.print("Ingrese el Id a consultar (0 para salir): ");
			int id=S.nextInt();
			if(id==0)
				return; 
			con = new Producto(id);
			band=A.Buscar(con);
			if(!band)
				System.out.println("Id inexistente, intentelo de nuevo");
		}while(!band);
		System.out.print("Raiz ");
		System.out.println("\nEl nodo se encuentra en el nivel: "+ConsultaNodo(A.getRaiz(),con));
	}

	private int ConsultaNodo(NodoABB<Producto> R,Producto N) { //Punto 9.1
		if(R.Info.toString().compareTo( N.toString() )==0)
			return 1;
		if(N.toString().compareTo( R.Info.toString() )<0) {
			System.out.print("- SubÁrbol izquierdo ");
			return ConsultaNodo(R.getSubIzq(),N)+1;	
		}
		System.out.print("- SubÁrbol derecho ");
		return ConsultaNodo(R.getSubDer(),N)+1;
	}

	public void EstadoActualDescendente(NodoABB<Producto> R) { //Punto 8
		if(R==null)
			return;
		EstadoActualDescendente(R.getSubDer());
		System.out.println(R.Info.IdProducto+"\t"+R.Info.Existencia);
		EstadoActualDescendente(R.getSubIzq());
	}

	public void PorcentajeProductos() { //Punto 7
		double porcentaje = ((double)A.Length() / 4900)*100;
		 DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println("El porcentaje utilizado es igual a: "+df.format(porcentaje)+"%");
	}

	public int RetirarExistencia100(NodoABB<Producto> R) { //Punto 6
		if(R==null)
			return 0;
		int c=0;
		c+=RetirarExistencia100(R.getSubIzq());
		c+=RetirarExistencia100(R.getSubDer());
		if(R.Info.Existencia == 100) {
			A.Retirar(R.Info);
			c++;
		}
		return c;
	}

	public void RetirarExistencia() { //Punto 5
		int IdProducto;
		NodoABB<Producto> N;
		do {
			System.out.print("Ingrese el Id del Producto(Ingrese 0 para regresar al menú): ");
			IdProducto=S.nextInt();
			if(IdProducto==0)
				return;
			Producto nuevo=new Producto(IdProducto);
			N = A.BuscarNodo(nuevo);
			if(N==null) 
				System.out.println("Id no localizado.");
		}while(N==null);
		System.out.print("Número de existencia a decrementar: ");
		int existencia=S.nextInt();
		N.Info.Existencia-=existencia;
		if(N.Info.Existencia < 0)
			N.Info.Existencia = 0;
		System.out.println("Operación exitosa");
	}

	public void AumenExistenciaMayorAX() { //Punto 4
		System.out.print("Ingrese Id a aumentar existencia: ");
		int num=S.nextInt();
		int existencia = Rutinas.nextInt(1,50);
		AumenExistenciaRecu(A.getRaiz(),existencia,new Producto(num));
	}

	private void AumenExistenciaRecu(NodoABB<Producto> R,int e,Producto p) { //Punto 4.2
		if(R==null)
			return;
		AumenExistenciaRecu(R.getSubIzq(),e,p);
		if(p.toString().compareTo( R.Info.toString() )<0)
			R.Info.Existencia+=e;
		AumenExistenciaRecu(R.getSubDer(),e,p);
	}

	public void AumentarExistencia() { //Punto 3
		int IdProducto;
		NodoABB<Producto> N;
		do {
			System.out.print("Ingrese el Id del Producto(Ingrese 0 para regresar al menú): ");
			IdProducto=S.nextInt();
			if(IdProducto==0)
				return;
			Producto nuevo=new Producto(IdProducto);
			N = A.BuscarNodo(nuevo);
			if(N==null) 
				System.out.println("Id no localizado.");
		}while(N==null);
		System.out.print("Número de existencia a incrementar: ");
		int existencia=S.nextInt();
		N.Info.Existencia+=existencia;
		System.out.println("Operación exitosa");
	}

	public boolean RetirarProducto() { //Punto 2
		System.out.print("Ingrese el Id del Producto: ");
		int IdProducto=S.nextInt();
		Producto nuevo=new Producto(IdProducto);
		NodoABB<Producto> N = A.BuscarNodo(nuevo);
		if(N==null || N.Info.Existencia!=0)
			return false;
		return A.Retirar(nuevo);
	}

	public boolean InsertarProducto() { //Punto 1
		int IdProducto, Existencia;
		Producto nuevo;
		do {
			IdProducto=Rutinas.nextInt(100,5000);
			Existencia=Rutinas.nextInt(1,100);
			nuevo=new Producto(IdProducto,Existencia);
		}while(A.Buscar(nuevo));
		return A.Inserta(nuevo);
	}

	public static void main(String[] args) {
		new AppProyectoArboles();
	}

	public int Menu() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                                      M E N U");
		System.out.println("Seleccione la operación a realizar: ");
		System.out.println("\t1-. Insertar un producto (Valores generados aleatoriamente)");
		System.out.println("\t2-. Retirar un producto (Existencia debe ser igual a 0)");
		System.out.println("\t3-. Registrar entrada de un producto");
		System.out.println("\t4-. Registrar entrada a los productos con Id mayor a N");
		System.out.println("\t5-. Retirar existencia de un producto");
		System.out.println("\t6-. Retirar todos los productos con existencia igual a 100");
		System.out.println("Consultas:");
		System.out.println("\t7-. Porcentaje de productos registrados");
		System.out.println("\t8-. Productos registrados de forma decendente");
		System.out.println("\t9-. Ubicación en el árbol: Nivel y Secuencia de subárboles de un producto");
		System.out.println("\t10-. Niveles inferiores que tienen menos nodos que el nivel superior");
		System.out.println("\n\t11-. Finalizar Ejecución");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.print("Opción: ");
		return S.nextInt();
	}

}
