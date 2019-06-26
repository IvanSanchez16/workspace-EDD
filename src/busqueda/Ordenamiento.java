package busqueda;

class Ordenamiento<T>
{	
   public void burbuja (T [] v)
   { 
	 T temp;
	 
	 int superior, i;
     boolean bandera=true;
     superior=v.length;
     while (bandera) 
     {  
    	bandera=false;
        superior--;
        for(i=0 ; i < superior ; i ++)
        {  
        	if (v[i].toString().compareTo(v[i+1].toString()) > 0)
           {   
        		temp=v[i];
        		v[i]=v[i+1];
        		v[i+1]=temp;
        		bandera=true;
           } 
        }
     }
   }
   public  void Insercion(T [] v){
		int i,j;
		T aux;
		for( i=1; i< v.length ; i++){  //inicia considerando el elemento 0 ordenado
			j=i;  //para explorar los elementos v[j-1]..v[0] buscando la 
			//posición correcta del dato v[i]
			aux=v[i];
			while (j>0 && aux.toString().compareTo(v[j-1].toString()) < 0){
				//desplaza el elemento hacia arriba una posición
				v[j]=v[j-1];
				j--; 
			}
			v[j]=aux;
		}
	}
   public  void Intercambio(T [] V){
		T aux;
		for(int i=0;i<V.length-1;i++)
			for(int j=i+1;j<V.length;j++)
				if(V[i].toString().compareTo(V[j].toString())>0){
					aux=V[i];
					V[i]=V[j];
					V[j]=aux;
				}
	}
   public void quickSort(T[] v)
   {
	   quickSort(v,0,v.length-1);
   }
   public  void quickSort(T A[], int izq, int der) {
		T pivote=A[izq]; // tomamos primer elemento como pivote
		int i=izq; // i realiza la búsqueda de izquierda a derecha
		int j=der; // j realiza la búsqueda de derecha a izquierda
		T aux;

		while(i<j){            // mientras no se crucen las búsquedas
			while(A[i].toString().compareTo(pivote.toString())<=0 && i<j) i++; // busca elemento mayor que pivote
			while(A[j].toString().compareTo(pivote.toString())>0) j--;         // busca elemento menor que pivote
			if (i<j) {                      // si no se han cruzado                      
				aux= A[i];                  // los intercambia
				A[i]=A[j];
				A[j]=aux;
			}
		}
		A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
		A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
		if(izq<j-1)
			quickSort(A,izq,j-1); // ordenamos subarray izquierdo
		if(j+1 <der)
			quickSort(A,j+1,der); // ordenamos subarray derecho
	}
   
   public static void main(String a[]) {
	   
   }
}


