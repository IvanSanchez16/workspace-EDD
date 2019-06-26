package busqueda;

public class Busqueda2 <T>{
	
	public int Secuencial (T [] v, T clave){  
		int i=v.length-1;
		while (i>=0 && v[i] != clave)
			i--;
		return i;
	}	
	
	public int binaria (T [] v, T clave){  
		int inferior=0,mitad,superior=v.length-1;
		while (inferior <= superior){ 
			mitad=(inferior+superior)/2;
			if (clave==v[mitad])
				return mitad;
			else
				if (clave.toString().compareTo(v[mitad].toString())>0)
					inferior=mitad+1;
				else
					superior=mitad-1; 
		}
		return -1;
	}
}


