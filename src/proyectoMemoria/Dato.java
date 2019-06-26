package proyectoMemoria;

public class Dato {
	public int Clave;
	public String Nombre;
	public int Edad;
	public char EdoCivil;
	public int Siguiente;
	
	public Dato(int clave, String nombre, int edad, char edoCivil) {
		Clave = clave;
		Nombre = nombre;
		Edad = edad;
		EdoCivil = edoCivil;
	}
	
	public String toString() {
		return "|"+Clave+"\t|"+Nombre+(Nombre.length()>6?"\t|":"\t\t|")+Edad+"\t|"+EdoCivil+"\t|";
	}
}
